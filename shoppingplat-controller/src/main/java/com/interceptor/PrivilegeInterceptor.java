package com.interceptor;

import com.entity.be.AdminEntity;
import com.entity.be.MenuEntity;
import com.entity.be.RoleEntity;
import com.service.be.AdminService;
import com.service.be.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author lzn
 */
@Component
public class PrivilegeInterceptor implements HandlerInterceptor {
    @Autowired
    private AdminService adminService ;

    @Autowired
    private RoleService roleService ;

    private String loginUrl = "/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();

        AdminEntity admin= (AdminEntity) session.getAttribute("admin");
        if(admin==null){
            response.sendRedirect(loginUrl);
            return false;
        }

        RoleEntity role=adminService.getUserRoles(admin.getAdmin_id());
        List<MenuEntity> privileges=roleService.getMenusByRoleId(role.getId());

        String requestUri=getRequestUrl(request);
        List<String> list=getprivilege(privileges);

        if(isAllowd(list,requestUri)){
            return true;
        }else {
            response.sendRedirect("be/unauthorized");
            return false;
        }
    }

    public List<String> getprivilege(List<MenuEntity> privileges){
        Set<String> set = new TreeSet<String>();
        for(MenuEntity privilege:privileges) {
            String[] uris = privilege.getUri().trim().split(",");
            if(uris!=null) {
                for(String uri:uris) {
                    set.add(uri);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public String getRequestUrl(HttpServletRequest request) {
        String context = request.getContextPath();
        String requestUri =  request.getRequestURI();
        String result = requestUri.substring(context.length());
        return result;
    }

    public boolean isAllowd(List<String> list,String requestUri) {
        boolean isAllowd = false;
        for(String allowList:list) {
            if(allowList.equals(requestUri)) {
                isAllowd=true;
                break;
            }
        }
        return isAllowd;
    }

}
