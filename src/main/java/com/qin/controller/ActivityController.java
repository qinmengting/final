package com.qin.controller;

import com.qin.common.VO.DataVO;
import com.qin.common.query.ActivityQuery;
import com.qin.domain.Activity;
import com.qin.service.ActivityService;
import com.qin.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/activity/add")
    public Object addActivity(Activity activity){
        int i = activityService.addActivity(activity);
        if (i != 0) {
            return ResponseUtil.general_response("提交成功");
        }
        else
            return ResponseUtil.general_response("提交失败");
    }

    @GetMapping("/activity/queryByParams/{subgroup}")
    public Object queryByParams(@PathVariable("subgroup")String subgroup, ActivityQuery activityQuery){
        activityQuery.setSubgroup(subgroup);
        DataVO<Activity> vo = activityService.queryByParams(activityQuery);
        return vo;
    }

    @DeleteMapping("/activity/delete/{id}")
    public Object deleteActivity(@PathVariable("id")Long id,Activity activity){
        int i = activityService.deleteById(id, activity);
        if (i !=0 ) {
            return ResponseUtil.general_response("删除成功");
        }
        else
            return ResponseUtil.general_response("删除失败");
    }

    @PostMapping("/activity/update/{id}")
    public Object updateActivityById(@PathVariable("id")Long id, Activity activity) {
        int i = activityService.updateById(id, activity);
        if (i != 0) {
            return ResponseUtil.general_response("编辑成功");
        }
        else
            return ResponseUtil.general_response("编辑失败");
    }

    @GetMapping("/activity/queryByParams")
    public Object queryByParams( ActivityQuery activityQuery){
        activityQuery.setSubgroup(activityQuery.getSubgroup());
        DataVO<Activity> vo = activityService.queryByParams(activityQuery);
        return vo;
    }

    @PutMapping("/activity/refuse/{id}")
    public Object refuse(@PathVariable("id")Long id) {
        int i = activityService.refuse(id);
        if (i != 0) {
            return ResponseUtil.general_response("操作成功");
        }
        else
            return ResponseUtil.general_response("操作失败");
    }

    @PutMapping("/activity/approve/{id}")
    public Object approve(@PathVariable("id")Long id) {
        int i = activityService.approve(id);
        if (i != 0) {
            return ResponseUtil.general_response("操作成功");
        }
        else
            return ResponseUtil.general_response("操作失败");
    }
}
