package com.controller.fe;

import com.entity.fe.AppriseEntity;
import com.entity.fe.UserEntity;
import com.service.fe.AppriseService;
import com.service.fe.OrderService;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author lzn
 */
@Controller
public class CommentListController {
    @Autowired
    private AppriseService appriseService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/insertToApprise")
    @ResponseBody
    public RequestVo doComment(HttpServletRequest request, HttpSession session){
        RequestVo requestVo=RequestVo.builder().code("200").data("ok").build();
        UserEntity users = (UserEntity) session.getAttribute("userinfo");
        Integer pro_id=Integer.valueOf(request.getParameter("id"));
        String pro_content=request.getParameter("content");
//        String pro_img=request.getParameter("img");
        String pro_grade=request.getParameter("grade");

        //添加到评论表
        AppriseEntity apprise=new AppriseEntity();
        apprise.setApprise_context(pro_content);
        apprise.setApprise_grade(pro_grade);
        apprise.setApprise_time(new Date());
        apprise.setPro_id(pro_id);
        apprise.setUser_id(users.getUser_id());
        appriseService.insert(apprise);
//        orderService.deleteByAid(pro_id,users.getUser_id());

        return requestVo;
    }
}
