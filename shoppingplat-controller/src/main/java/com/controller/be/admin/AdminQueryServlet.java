package com.controller.be.admin;

import com.entity.be.AdminEntity;
import com.service.be.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author lzn
 */
@Controller
public class AdminQueryServlet {
    @Autowired
    private AdminService userService;

    @RequestMapping("/login/query")
    @ResponseBody
    protected Object service(String userName, String password, HttpSession session)  {

        AdminEntity admin = userService.findUserByUsernameAndPassword(userName, password);

        if (admin != null) {
            session.setAttribute("admin", admin);
            return true;
        } else {
            return false;
        }
    }
}
