package com.controller.be;

import com.entity.fe.CouponEntity;
import com.service.fe.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lzn
 */
@Controller
public class CouponServlet {

    @Autowired
    private CouponService couponService;

    @RequestMapping("/admin/coupon/list")
    protected ModelAndView couponList() {
        ModelAndView mav=new ModelAndView();
        List<CouponEntity> couponList=couponService.getAll();
        mav.addObject("couponList",couponList);
        mav.setViewName("be/couponList");

        return mav;
    }
}
