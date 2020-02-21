package com.controller.fe;

import com.entity.fe.*;
import com.service.fe.CouponService;
import com.service.fe.OrderService;
import com.service.fe.ReceiptService;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lzn
 */
@Controller
public class PayController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private OrderService orderService;


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

        mav.addObject("receiptAll",receiptAll);
        mav.addObject("proInfos",proInfos);
        mav.addObject("photo",photo);
        mav.addObject("num",num);
        mav.addObject("total",total1);
        mav.addObject("result",result1);
        mav.addObject("couponEntity",couponEntity);
        mav.setViewName("/fe/pay");
        session.setAttribute("result",result1);
        session.setAttribute("num",num);

        return mav;
    }



    @RequestMapping("/getReceiptUser")
    @ResponseBody
    public RequestVo getReceiptUser(HttpServletRequest request,HttpSession session){
        Integer id=Integer.valueOf(request.getParameter("id"));
        UserEntity user = (UserEntity) session.getAttribute("userinfo");
        ReceiptEntity receiptEntity=receiptService.getById(id,user.getUser_id());
        session.setAttribute("receiptEntity",receiptEntity);
        RequestVo requestVo = RequestVo.builder().code("200").data(receiptEntity).build();
        return requestVo;
    }

//    @RequestMapping("/commitPay")
//    @ResponseBody
//    public RequestVo commitPay(HttpServletRequest request,HttpSession session){
//        RequestVo requestVo = RequestVo.builder().code("200").data("ok").build();
////        if(){
////            requestVo = RequestVo.builder().code("200").data("no").build();
////        }
//        return requestVo;
//    }

    @RequestMapping("/successPay")
    public ModelAndView successPay(HttpServletRequest request,HttpSession session){
        ModelAndView mav=new ModelAndView();
        ReceiptEntity receiptEntity = (ReceiptEntity) session.getAttribute("receiptEntity");
        Double result= (Double) session.getAttribute("result");
        ProductEntity proInfos= (ProductEntity) session.getAttribute("proInfos");
        UserEntity users = (UserEntity) session.getAttribute("userinfo");
        Integer num= (Integer) session.getAttribute("num");
        String status="支付成功";
        /**
         * 添加订单信息
         */
        OrderEntity orders=new OrderEntity();
        orders.setOrder_time(new Date());
        orders.setOrder_amount(num);
        orders.setOrder_money(result);
        orders.setOrder_status(status);
        orders.setApprise_status(0);
        orders.setPro_id(proInfos.getPro_id());
        orders.setUser_id(users.getUser_id());
        orderService.insert(orders);

        mav.addObject("receiptEntity",receiptEntity);
        mav.setViewName("/fe/success");

        return mav;
    }

    @RequestMapping("/failPay")
    public ModelAndView failPay(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "3") int pageSize,
            HttpServletRequest request,HttpSession session){
        ModelAndView mav=new ModelAndView();
        ProductEntity proInfos= (ProductEntity) session.getAttribute("proInfos");
        Double result= (Double) session.getAttribute("result");
        UserEntity users = (UserEntity) session.getAttribute("userinfo");
        Integer num= (Integer) session.getAttribute("num");
        String status="待付款";

        OrderEntity orders=new OrderEntity();
        orders.setOrder_time(new Date());
        orders.setOrder_amount(num);
        orders.setOrder_money(result);
        orders.setOrder_status(status);
        orders.setApprise_status(0);
        orders.setPro_id(proInfos.getPro_id());
        orders.setUser_id(users.getUser_id());
        orderService.insert(orders);

        mav.setViewName("redirect:/myOrders");

        return mav;
    }

    /**
     * 查询订单信息
     */
    @RequestMapping("/myOrders")
    public ModelAndView myOrders(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "3") int pageSize,
            HttpServletRequest request,HttpSession session){
        ModelAndView mav=new ModelAndView();
        UserEntity users = (UserEntity) session.getAttribute("userinfo");

        List<OrderEntity> orderList=orderService.getAll(pageNum,pageSize,users.getUser_id());
        List<OrderEntity> failList=null;
        List<OrderEntity> successList=null;
        List<OrderEntity> noAppriseList=null;
        String status="待付款";
        for (OrderEntity order : orderList) {
            if(status.equals(order.getOrder_status())){
                failList=orderService
                        .getByOrderStatus(pageNum,pageSize,status,users.getUser_id());
            }else{
                status="支付成功";
                successList=orderService
                        .getByOrderStatus(pageNum,pageSize,status,users.getUser_id());
                noAppriseList=orderService
                        .getByAppriseStatus(pageNum,pageSize,status,0,users.getUser_id());
            }
        }

        mav.addObject("orderList",orderList);
        mav.addObject("failList",failList);
        mav.addObject("successList",successList);
        mav.addObject("noAppriseList",noAppriseList);
        session.setAttribute("noAppriseList",noAppriseList);
        mav.setViewName("/fe/order");

        return mav;
    }

    @RequestMapping("/getAppriseInfo")
    @ResponseBody
    public ModelAndView getAppriseInfo(HttpServletRequest request){
        String pro_img= (String) request.getAttribute("image");
        String pro_name=request.getParameter("name");
        String pro_price=request.getParameter("price");

        ModelAndView mav=new ModelAndView();
        mav.addObject("pro_img",pro_img);
        mav.addObject("pro_name",pro_name);
        mav.addObject("pro_price",pro_price);
        mav.setViewName("/fe/commentlist");

        return mav;
    }

}
