package com.controller.be;

import com.entity.UserEntity;
import com.service.UserService;
import com.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lzn
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


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
                                   HttpServletRequest request, HttpSession session){
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
}
