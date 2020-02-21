package com.controller.be.role;

import com.entity.be.RoleEntity;
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
public class RoleListServlet {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/admin/role/list")
	protected String service(Model model) {

		List<RoleEntity> role = roleService.getAll();

		model.addAttribute("role", role);
		return "be/roleList";
	}

}
