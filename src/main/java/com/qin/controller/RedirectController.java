package com.qin.controller;

import com.qin.common.DTO.ArtMemberDTO;
import com.qin.domain.Department;
import com.qin.domain.Position;
import com.qin.domain.UserAuth;
import com.qin.service.ArtMemberService;
import com.qin.service.IDepartmentService;
import com.qin.service.IPositionService;
import com.qin.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private ArtMemberService artMemberService;

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

    @GetMapping("/performance")
    public String toPerformance(Model model) {
        return "performance_view";
    }

    @GetMapping("/allmembers")
    public String toAllMembers(Model model) {
        return "members/allmembers_view";
    }

    @GetMapping("/addmember")
    public String toAddMembers(Model model) {
        return "members/addmember_view";
    }

    @GetMapping("/updatemember/{id}")
    public String toupdate(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        ArtMemberDTO dto = artMemberService.selectById(id);
        request.setAttribute("dto",dto);
        return "members/updatemember_view";
    }

    @GetMapping("/querymember")
    public String toquery(Model model) {
        return "members/querymember_view";
    }

    @GetMapping("/addattendance")
    public String toAddAttendance(Model model) {
        return "attendance/addattendance_view";
    }

    @GetMapping("/queryattendance")
    public String toQueryAttendance(Model model) {
        return "attendance/queryattendance_view";
    }

    @GetMapping("/countattendance")
    public String toCountAttendance(Model model) {
        return "attendance/countattendance_view";
    }

    @GetMapping("/scoreindex")
    public String toScoreIndex_view(Model model) {
        return "score/scoreindex_view";
    }

    @GetMapping("/addscore")
    public String toAddScore_view(Model model) {
        return "score/addscore_view";
    }
}
