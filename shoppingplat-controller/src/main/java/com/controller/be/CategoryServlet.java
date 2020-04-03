package com.controller.be;

import com.entity.fe.ChildCateEntity;
import com.entity.fe.FatherCateEntity;
import com.service.fe.ChildCateService;
import com.service.fe.FatherCateService;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author lzn
 */
@Controller
public class CategoryServlet {

    @Autowired
    private FatherCateService fatherCateService;
    @Autowired
    private ChildCateService childCateService;

    @RequestMapping("/admin/father/list")
    protected ModelAndView fatherCateList() {
        ModelAndView mav=new ModelAndView();
        List<FatherCateEntity> fatherCate=fatherCateService.getAll();
        mav.addObject("fatherCate",fatherCate);
        mav.setViewName("/be/fatherCateList");

        return mav;
    }

    @RequestMapping("/admin/child/list")
    @ResponseBody
    protected RequestVo childCateList(HttpServletRequest request) {
        Integer fatherId=Integer.valueOf(request.getParameter("fatherId"));
        List<ChildCateEntity> childCate=childCateService.getById(fatherId);

        return RequestVo.builder().code("200").data(childCate).build();
    }


//
//    @RequestMapping("/admin/father/add")
//    protected ModelAndView productAdd(){
//        ModelAndView mav=new ModelAndView();
//        List<ChildCateEntity> childCateList = childCateService.getAll();
//        mav.addObject("childCateList",childCateList);
//        mav.setViewName("be/fatherAdd");
//
//        return mav;
//    }
//
//    @RequestMapping("/admin/father/insert")
//    @ResponseBody
//    protected RequestVo productInsert(String pro_name, String pro_code,
//                                      String pro_num, String pro_discount, String pro_iPrice,
//                                      String pro_Desc, String child_id){
//        RequestVo vo =RequestVo.builder().code("200").data("ok").build();
//        Integer num=Integer.valueOf(pro_num);
//        Double discount=Double.valueOf(pro_discount);
//        double price=Double.valueOf(pro_iPrice);
//        BigDecimal iPrice=new BigDecimal(price);
//        Integer childId=Integer.valueOf(child_id);
//
//
//        ProductEntity products=new ProductEntity();
//        products.setPro_name(pro_name);
//        products.setPro_code(pro_code);
//        products.setPro_num(num);
//        products.setPro_discount(discount);
//        products.setPro_iPrice(iPrice);
//        products.setPro_Desc(pro_Desc);
//        products.setChild_id(childId);
//
//        productService.insert(products);
//
//        return vo;
//    }
}
