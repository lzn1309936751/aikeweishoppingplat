package com.controller.be;

import com.entity.fe.ChildCateEntity;
import com.entity.fe.ImageEntity;
import com.entity.fe.ProductEntity;
import com.github.pagehelper.PageInfo;
import com.service.be.ImageService;
import com.service.fe.ChildCateService;
import com.service.fe.ProductService;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author lzn
 */
@Controller
public class ImagesServlet {
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/admin/image/list")
    protected ModelAndView imageList(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize) {
        ModelAndView mav=new ModelAndView();
        List<ImageEntity> imageList=imageService.getAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(imageList);
        mav.addObject("imageList",imageList);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("/be/imageList");

        return mav;
    }

    /**
     * 上传图片
     */
    @RequestMapping("/upload")
    @ResponseBody
    public RequestVo uploadImg(@RequestParam("file") MultipartFile file,@RequestParam("proId")  Integer proId){
        RequestVo requestVo;
        //得到名字
        String name = file.getOriginalFilename();
        //获取后缀名
        String suffixName = name.substring(name.lastIndexOf("."));
        //自定义随机数（字母+数字）作为文件名
        String hash = Integer.toHexString(new Random().nextInt());
        String fileName = hash + suffixName;
        String path  = "/home/lzn/Documents/java/wordspace/aikeweishopingplat/shoppingplat-controller/src/main/resources/static/images/cate"+ File.separator + fileName;
        File file1 = new File(path);
        try {
            //判断文件夹是否存在，没有就创建一个
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            //判断文件是否存在
            if(!file1.exists()){
                file.transferTo(file1);
            }
            String imgPath ="/static/images/cate"+ File.separator + fileName;
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImg_path(imgPath);
            imageEntity.setPro_id(proId);
            imageService.insertImg(imageEntity);
            requestVo=RequestVo.builder().code("200").msg("上传成功").data("ok").build();
        } catch (IOException e) {
            requestVo=RequestVo.builder().code("400").msg("上传失败").data("no").build();
        }
        return requestVo;
    }
}
