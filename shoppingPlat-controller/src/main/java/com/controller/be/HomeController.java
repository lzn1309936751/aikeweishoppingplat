package com.controller.be;

import com.dao.UserDao;
import com.entity.*;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author lzn
 */
@Controller
public class HomeController {
    @Autowired
    private FatherCateService fatherCateService;

    @Autowired
    private ChildCateService childCateService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private ReceiptService receiptService;



    /**
     * 主页面
     */
    @GetMapping("/home")
    public ModelAndView home(HttpSession session){
        ModelAndView mav=new ModelAndView();
        List<FatherCateEntity> fatherList=fatherCateService.getAll();
        mav.addObject("fatherList",fatherList);
        session.getAttribute("username");
        mav.setViewName("/be/home");
        return mav;
    }

    @PostMapping(value = "/home")
    @ResponseBody
    public List<ChildCateEntity> getCate(HttpServletRequest request){
        Integer id=Integer.valueOf(request.getParameter("father_id"));
        List<ChildCateEntity> childList= childCateService.getById(id);
        return childList;
    }

    /**
     * 根据子类型获取的商品页面
     */
    @RequestMapping("/products")
    public ModelAndView getByCateId(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "50")int pageSize,
             HttpServletRequest request,HttpSession session){
        Integer cid=Integer.valueOf(request.getParameter("child_id"));
        List<ProductEntity> productList= productService.getByCateId(pageNum,pageSize,cid);
        PageInfo pageInfo = new PageInfo(productList);
        Set<ProductEntity> set = new HashSet<>();
        for (ProductEntity p : productList) {
            set.add(p);
        }
        ProductImageVO vo=new ProductImageVO(set,cid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("productVO",vo);
        session.setAttribute("productVO",vo);
        session.getAttribute("username");

        modelAndView.setViewName("/be/product");
        return modelAndView;
    }

    /**
     * 通过搜索获取的商品页面
     */








    /**
     *商品详情页面
     */
    @RequestMapping("/introduction")
    public ModelAndView getByProductId(HttpServletRequest request,HttpSession session){
        Integer pid=Integer.valueOf(request.getParameter("pro_id"));
        ProductEntity productInfos =productService.getByMyId(pid);
        List<ImageEntity> imageEntity = productService.getByImg(pid);
        ModelAndView mav=new ModelAndView();

        mav.addObject("proInfos",productInfos);
        mav.addObject("photo",imageEntity);
        mav.addObject("length",imageEntity.size());
        session.setAttribute("proInfos",productInfos);
        session.setAttribute("photo",imageEntity);
        session.getAttribute("productVO");

        mav.setViewName("/be/introduction");
        return mav;
    }

    /**
     * 用户注册
     */
//    @RequestMapping("/register")
//    public ModelAndView register(){
//        ModelAndView mav=new ModelAndView();
//        List<AddressEntity> addressList = addressService.getAddress();
//
//        UserEntity users=new UserEntity();
//        users.setUser_name();
//        users.getUser_pwd();
//        userDao.insert(users);
//
//        mav.addObject("addressList",addressList);
//        mav.setViewName("");
//        return mav;
//    }

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public String login(){
        return "/be/login";
    }

    @RequestMapping("/getUserAndPwd")
    @ResponseBody
    public RequestVo getUserAndPwd(@RequestParam(name = "pageNum",defaultValue = "1",required = false) int pageNum,
                                      @RequestParam(name = "pageSize",defaultValue = "10",required = false) int pageSize,
                                      HttpServletRequest request,HttpSession session){
        RequestVo requestVo= RequestVo.builder().code("200").data("ok").build();
        List<UserEntity> userList=userService.getAll(pageNum,pageSize);
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        for (UserEntity userEntity : userList) {
            if(username.equals(userEntity.getUser_name())&&password.equals(userEntity.getUser_pwd())){
                session.setAttribute("username",username);
                session.setAttribute("userinfo",userEntity);
            }else {
                requestVo = RequestVo.builder().code("400").data("no").build();
            }
        }
        session.setAttribute("userList",userList);
        return requestVo;
    }

    /**
     * 加入购物车
     */
    @RequestMapping("/insertMyCart")
    @ResponseBody
    public RequestVo insertMyCart(HttpServletRequest request, HttpServletResponse response,
                               HttpSession session) throws IOException {

        RequestVo requestVo = RequestVo.builder().code("200").data("ok").build();
        String username= (String) session.getAttribute("username");
        if(username==null){
            requestVo = RequestVo.builder().code("400").data("no").build();
        }else {
            UserEntity users=userService.getUserId(username);
            ProductEntity proInfos= (ProductEntity) session.getAttribute("proInfos");
            Integer pid=proInfos.getPro_id();
            Double compute=proInfos.getCompute();
            Integer num=Integer.valueOf(request.getParameter("num"));

            CartEntity carts=new CartEntity();
            carts.setCart_time(new Date());
            carts.setCart_num(num);
            carts.setCart_subTotal(BigDecimal.valueOf(compute*num));
            carts.setPro_id(pid);
            carts.setUser_id(users.getUser_id());
            cartService.insert(carts);
        }
        return requestVo;
    }

    /**
     * 显示购物车
     */
    @RequestMapping("/showMyCart")
    public ModelAndView showMyCart(HttpServletRequest request,HttpSession session){
        ModelAndView mav = new ModelAndView();
        UserEntity user = (UserEntity) session.getAttribute("userinfo");
        if(user.getUser_name()==null){
            mav.setViewName("be/login");
        }else {
            List<CartEntity> cartList = cartService.getAll(user.getUser_id());
            System.out.println("cartList.size() = " + cartList.size());
            Set<CartEntity> set=new HashSet<>(16);
            double total=0;
            for (CartEntity c : cartList) {
                set.add(c);
                Double s=c.getCart_subTotal().doubleValue();
                total=total+s;
            }
            CartProductVO cartProductVO=new CartProductVO(set,user.getUser_id());
            mav.addObject("cartProductVO", cartProductVO);
            mav.addObject("total",total);
            mav.setViewName("/be/cart");
        }
        return mav;
    }

    /**
     * 根据数量加减修改商品的价格
     */
    @RequestMapping("/updateCartNum")
    @ResponseBody
    public RequestVo updateCartNum(HttpServletRequest request,HttpSession session){
        RequestVo requestVo = RequestVo.builder().code("200").data("ok").build();
        Integer num=Integer.valueOf(request.getParameter("num"));
        Integer pid=Integer.valueOf(request.getParameter("pid"));
        UserEntity user = (UserEntity) session.getAttribute("userinfo");
        CartEntity money=cartService.getCartPrice(pid,user.getUser_id());
        System.out.println("------------------"+money.getPro_iPrice());
        double price=money.getPro_iPrice().doubleValue();
        double compute=money.getPro_discount()*price;
        double subTotal=num*compute;
        BigDecimal bg=new BigDecimal(subTotal);
        double subTotal1=bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        cartService.update(num,subTotal1,pid,user.getUser_id());
        return requestVo;
    }

    /**
     * 统计选中复选框的数量
     */
    @RequestMapping("getShopNum")
    public String getShopNum(HttpServletRequest request,HttpSession session){
        Integer number=Integer.valueOf(request.getParameter("number"));
        session.setAttribute("number",number);
        return "redirect:showMyCart";
    }

    /**
     * 结算功能
     */
    @RequestMapping("/fastBuy")
    @ResponseBody
    public RequestVo fastBuy(HttpSession session){
        RequestVo requestVo = RequestVo.builder().code("200").data("ok").build();
        String username= (String) session.getAttribute("username");
        if(username==null){
            requestVo = RequestVo.builder().code("400").data("no").build();
        }
        return requestVo;
    }

    @RequestMapping("/pay")
    public ModelAndView pay(HttpServletRequest request, HttpSession session){
        ModelAndView mav=new ModelAndView();
        UserEntity user = (UserEntity) session.getAttribute("userinfo");
        /**
         * 新增地址
         */
        List<AddressEntity> address = addressService.getAddress();
//        ReceiptEntity receipts=new ReceiptEntity();



//        receipts.setReceipt_name();
//        receipts.setReceipt_phone();
//        receipts.setProvince_id();
//        receipts.setCity_id();
//        receipts.setCounty_id();
//        receipts.setReceipt_detail();
//        receipts.setReceipt_bit();
//        receipts.setUser_id(user.getUser_id());
//        receiptService.insert(receipts);

        /**
         * 显示所有的收货地址
         */
        List<ReceiptEntity> receiptAll=receiptService.getAll(user.getUser_id());
        /**
         * 显示商品信息
         */
        ProductEntity proInfos= (ProductEntity) session.getAttribute("proInfos");
        List<ImageEntity> photo= (List<ImageEntity>) session.getAttribute("photo");
        Double compute=proInfos.getCompute();
        Integer num=Integer.valueOf(request.getParameter("num"));

        /**
         * 显示红包
         */
        Double total=compute*num;
        BigDecimal bg=new BigDecimal(total);
        Double total1=bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        CouponEntity couponEntity=couponService.getByMoney(total1);

        Double result=total-couponEntity.getCoupon_name();
        BigDecimal bg2=new BigDecimal(result);
        Double result1=bg2.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();


        mav.addObject("address",address);
        mav.addObject("receiptAll",receiptAll);
        mav.addObject("proInfos",proInfos);
        mav.addObject("photo",photo);
        mav.addObject("num",num);
        mav.addObject("total",total1);
        mav.addObject("result",result1);
        mav.addObject("couponEntity",couponEntity);
        mav.setViewName("/be/pay");

        return mav;
    }

    @RequestMapping("/getReceiptUser")
    @ResponseBody
    public RequestVo getReceiptUser(HttpServletRequest request,HttpSession session){
        Integer id=Integer.valueOf(request.getParameter("id"));
        System.out.println("----------------------------"+id);
        UserEntity user = (UserEntity) session.getAttribute("userinfo");
        ReceiptEntity receiptEntity=receiptService.getById(id,user.getUser_id());
        RequestVo requestVo = RequestVo.builder().code("200").data(receiptEntity).build();
        return requestVo;
    }

}
