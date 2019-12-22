package com.controller.be;

import com.entity.CartEntity;
import com.entity.CartProductVO;
import com.entity.ProductEntity;
import com.entity.UserEntity;
import com.service.CartService;
import com.service.UserService;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lzn
 */
@Controller
public class CartController {
    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;


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
    public ModelAndView showMyCart(HttpServletRequest request, HttpSession session){
        ModelAndView mav = new ModelAndView();
        UserEntity user = (UserEntity) session.getAttribute("userinfo");
        if(user.getUser_name()==null){
            mav.setViewName("be/login");
        }else {
            List<CartEntity> cartList = cartService.getAll(user.getUser_id());
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
}
