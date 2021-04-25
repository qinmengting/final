package com.qin.controller;

import com.qin.domain.Department;
import com.qin.domain.Position;
import com.qin.domain.UserAuth;
import com.qin.service.IDepartmentService;
import com.qin.service.IPositionService;
import com.qin.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 页面转发控制器
 */
@Controller
public class RedirectController {
    @Autowired
    IPositionService positionService;

    @Autowired
    IDepartmentService departmentService;

    @GetMapping("/login")
    public String toLogin() {
        return "user/login";
    }

    @GetMapping("/register")
    public String toRegister() {
        return "user/register";
    }

    @GetMapping("/employee")
    public String toEmployee(Model model) {
        List<Position> positionList = positionService.listAll();
        List<Department> departmentList = departmentService.listAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("departmentList", departmentList);
        return "employee_view";
    }

    @GetMapping("/layers/employee/insert")
    public String toEmployeeInsert(Model model) {
        List<Position> positionList = positionService.listAll();
        List<Department> departmentList = departmentService.listAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("departmentList", departmentList);
        return "layers/employee_insert";
    }

    @GetMapping("/post")
    public String toPost(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        return "post_view";
    }

    @GetMapping("/download")
    public String toDownload(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        return "download_view";
    }

    @GetMapping("/department")
    public String toDepartment() {
        return "department_view";
    }


    @GetMapping("/auth")
    public String toAuth() {
        return "auth_view";
    }

    @GetMapping("/position")
    public String toPosition() {
        return "position_view";
    }

    @GetMapping("/index")
    public String toIndex(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        return "index_view";
    }

    @GetMapping("/")
    public String toMain(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        return "index_view";
    }
}
