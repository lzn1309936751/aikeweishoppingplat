package com.controller.be;

import com.entity.fe.InformationEntity;
import com.github.pagehelper.PageInfo;
import com.service.be.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lzn
 */
@Controller
public class ProductInfoServlet {

    @Autowired
    private InformationService informationService;

    @RequestMapping("/admin/productInfo/list")
    protected ModelAndView productInfoList(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize) {
        ModelAndView mav=new ModelAndView();
        List<InformationEntity> infoEntities=informationService.getAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(infoEntities);
        mav.addObject("infoEntities",infoEntities);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("/be/productInfoList");

        return mav;
    }
}
