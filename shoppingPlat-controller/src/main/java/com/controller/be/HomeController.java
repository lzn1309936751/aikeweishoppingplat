package com.controller.be;

import com.dao.UserDao;
import com.entity.*;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

}
