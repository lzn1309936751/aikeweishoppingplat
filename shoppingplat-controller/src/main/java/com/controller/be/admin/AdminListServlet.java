package com.controller.be.admin;

import com.entity.be.AdminEntity;
import com.entity.be.RoleEntity;
import com.service.be.AdminService;
import com.service.be.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lzn
 */
@Controller
public class AdminListServlet {
    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

	@RequestMapping("/admin/user/list")
	protected String service(Model model){

		List<AdminEntity> allAdmin = adminService.getAllUser();
		List<RoleEntity> roles = roleService.getAll();

        model.addAttribute("roles", roles);
        model.addAttribute("allAdmin", allAdmin);
		return "be/adminList";
	}
}
