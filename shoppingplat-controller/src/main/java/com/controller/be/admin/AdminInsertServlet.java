package com.controller.be.admin;

import com.entity.be.AdminEntity;
import com.service.be.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lzn
 */
@Controller
public class AdminInsertServlet {
    @Autowired
    private AdminService adminService;

	@RequestMapping("/admin/user/insert")
	protected void service(String userName,String password,String roleId) {

		AdminEntity admin = new AdminEntity();
		admin.setAdmin_name(userName);
		admin.setAdmin_pwd(password);;

		adminService.addUser(admin);
		AdminEntity u = adminService.findUserByUsernameAndPassword(userName,password);
		adminService.updateUserRole(u, roleId);
		
	}
	
}
