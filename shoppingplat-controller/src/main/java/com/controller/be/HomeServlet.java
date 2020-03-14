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
public class HomeServlet {

	@RequestMapping("/beHome")
	protected String home() {
        return "be/home";
	}

	@RequestMapping("/beLogin")
	protected String login() {
		return "be/login";
	}


}
