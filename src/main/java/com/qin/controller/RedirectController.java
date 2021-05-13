package com.qin.controller;

import com.qin.common.DTO.ArtMemberDTO;
import com.qin.dal.mapper.ActivityMapper;
import com.qin.dal.mapper.ArtMemberMapper;
import com.qin.domain.*;
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

    @Autowired
    private ArtMemberMapper artMemberMapper;

    @Autowired
    private ActivityMapper activityMapper;

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
        if (user.isAdmin()==true&&user.getId()==1){
            return "index_view";
        }
        else if (user.isAdmin()==true){
            ArtMemberExample ex = new ArtMemberExample();
            ArtMemberExample.Criteria cr = ex.createCriteria();
            cr.andStudentIdEqualTo(user.getUsername());
            List<ArtMember> members = artMemberMapper.selectByExample(ex);
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/subadminindex_view";
        }
        else{
            return "general/generalindex_view";
        }
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



    //普通用户重定向界面
    @GetMapping("/generalpost")
    public String togeneralPost_view(Model model) {
        return "general/generalpost_view";
    }

    @GetMapping("/generaldownload")
    public String togeneralDownload_view(Model model) {
        return "general/generaldownload_view";
    }

    @GetMapping("/information")
    public String toinformation_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()) {
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "general/information_view";
        }
       else  return "general/generaledit_view";
    }

    @GetMapping("/generaledit")
    public String togeneralEdit_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        return "general/generaledit_view";
    }

    @GetMapping("/generalupdate")
    public String togeneralUpdate_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
        }
        return "general/generalupdate_view";
    }

    @GetMapping("/generalupdate/{id}")
    public String toupdategeneral(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        ArtMember member = artMemberMapper.selectByPrimaryKey(id);
        model.addAttribute("member",member);
        return "general/generalupdate_view";
    }

    @GetMapping("/generalattendance")
    public String togeneralAttendance_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "general/generalattendance_view";
        }
       else return "general/generalnull_view";
    }

    @GetMapping("/attendancecount")
    public String toattendancecount_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "general/attendancecount_view";
        }
        else return "general/generalnull_view";
    }

    @GetMapping("/generalsocre")
    public String togeneralsocre_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "general/generalsocre_view";
        }
        else return "general/generalnull_view";
    }

    //以下为分团管理员重定向

    @GetMapping("/subadminmember")
    public String tosubadminmember_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/subadminmember_view";
        }
        else return "subadmin/subadminmember_view";
    }

    @GetMapping("/subadminaddattendance")
    public String tosubadminaddattendance_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/attendance/subadminaddattendance_view";
        }
        else return "subadmin/attendance/subadminaddattendance_view";
    }

    @GetMapping("/subadmincountattendance")
    public String tosubadmincountattendance_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/attendance/subadmincountattendance_view";
        }
        else return "subadmin/attendance/subadmincountattendance_view";
    }

    @GetMapping("/subadminqueryattendance")
    public String tosubadminqueryattendance_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/attendance/subadminqueryattendance_view";
        }
        else return "subadmin/attendance/subadminqueryattendance_view";
    }

    @GetMapping("/subadminaddscore")
    public String tosubadminaddscore_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/score/subadminaddscore_view";
        }
        else return "subadmin/score/subadminaddscore_view";
    }

    @GetMapping("/subadminscoreindex")
    public String tosubadminscoreindex_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/score/subadminscoreindex_view";
        }
        else return "subadmin/score/subadminscoreindex_view";
    }

    @GetMapping("/subadminactivity")
    public String tosubadminactivity_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/activity/subadminactivity_view";
        }
        else return "subadmin/activity/subadminactivity_view";
    }

    @GetMapping("/addactivity")
    public String toaddactivity_view(Model model) {
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/activity/addactivity_view";
        }
        else return "subadmin/activity/addactivity_view";
    }

    @GetMapping("/updateactivity/{id}")
    public String toupdateactivity(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        Activity activity = activityMapper.selectByPrimaryKey(id);
        request.setAttribute("activity",activity);
        UserAuth user = UserContext.getCurrentUser();
        model.addAttribute("user", user);
        String username = user.getUsername();
        ArtMemberExample ex = new ArtMemberExample();
        ArtMemberExample.Criteria cr = ex.createCriteria();
        cr.andUsernameEqualTo(username);
        List<ArtMember> members = artMemberMapper.selectByExample(ex);
        if (!members.isEmpty()){
            ArtMember member = members.get(0);
            model.addAttribute("member",member);
            return "subadmin/activity/addactivity_view";
        }
        else
            return "subadmin/activity/addactivity_view";
    }
}
