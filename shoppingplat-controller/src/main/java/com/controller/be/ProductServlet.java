package com.controller.be;

import com.entity.fe.ChildCateEntity;
import com.entity.fe.ProductEntity;
import com.github.pagehelper.PageInfo;
import com.service.fe.ChildCateService;
import com.service.fe.ProductService;
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
import java.util.List;

/**
 * @author lzn
 */
@Controller
public class ProductServlet {

    @Autowired
    private ProductService productService;
    @Autowired
    private ChildCateService childCateService;

    @RequestMapping("/admin/product/list")
    protected ModelAndView productList(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize) {
        ModelAndView mav=new ModelAndView();
        List<ProductEntity> productList=productService.getAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(productList);
        mav.addObject("productList",productList);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("/be/productList");

        return mav;
    }

    @RequestMapping("/admin/product/add")
    protected ModelAndView productAdd(){
        ModelAndView mav=new ModelAndView();
        List<ChildCateEntity> childCateList = childCateService.getAll();
        mav.addObject("childCateList",childCateList);
        mav.setViewName("be/productAdd");

        return mav;
    }

    @RequestMapping("/admin/product/insert")
    @ResponseBody
    protected RequestVo productInsert(String pro_name, String pro_code,
                                      String pro_num, String pro_discount, String pro_iPrice,
                                      String pro_Desc, String child_id){
        RequestVo vo =RequestVo.builder().code("200").data("ok").build();
        Integer num=Integer.valueOf(pro_num);
        Double discount=Double.valueOf(pro_discount);
        double price=Double.valueOf(pro_iPrice);
        BigDecimal iPrice=new BigDecimal(price);
        Integer childId=Integer.valueOf(child_id);


        ProductEntity products=new ProductEntity();
        products.setPro_name(pro_name);
        products.setPro_code(pro_code);
        products.setPro_num(num);
        products.setPro_discount(discount);
        products.setPro_iPrice(iPrice);
        products.setPro_Desc(pro_Desc);
        products.setChild_id(childId);

        productService.insert(products);

        return vo;
    }

    @RequestMapping("/admin/product/edit")
    protected ModelAndView productEdit(HttpServletRequest request, HttpSession session){
        Integer pid=Integer.valueOf(request.getParameter("pid"));
        session.setAttribute("pid",pid);
        ProductEntity products=productService.getByMyId(pid);
        ModelAndView mav=new ModelAndView();
        mav.addObject("products",products);
        List<ChildCateEntity> childCateList = childCateService.getAll();
        mav.addObject("childCateList",childCateList);
        mav.setViewName("be/productEdit");

        return mav;
    }

    @RequestMapping("/admin/product/update")
    @ResponseBody
    protected RequestVo productUpdate(String pro_name, String pro_code,String pro_num,
                                      String pro_discount, String pro_iPrice,String pro_Desc, String child_id,
                                      HttpSession session){
        RequestVo vo =RequestVo.builder().code("200").data("ok").build();
        Integer num=Integer.valueOf(pro_num);
        Double discount=Double.valueOf(pro_discount);
        double price=Double.valueOf(pro_iPrice);
        BigDecimal iPrice=new BigDecimal(price);
        Integer childId=Integer.valueOf(child_id);
        Integer pid = (Integer) session.getAttribute("pid");

        ProductEntity products=new ProductEntity();
        products.setPro_name(pro_name);
        products.setPro_code(pro_code);
        products.setPro_num(num);
        products.setPro_discount(discount);
        products.setPro_iPrice(iPrice);
        products.setPro_Desc(pro_Desc);
        products.setChild_id(childId);

        productService.update(products,pid);

        return vo;
    }
}
