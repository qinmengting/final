package com.qin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qin.common.VO.DataVO;
import com.qin.common.query.ActivityQuery;
import com.qin.dal.mapper.ActivityMapper;
import com.qin.domain.Activity;
import com.qin.domain.ActivityExample;
import com.qin.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public DataVO<Activity> queryByParams(ActivityQuery activityQuery) {
        PageHelper.startPage(activityQuery.getPage(),activityQuery.getLimit());

        ActivityExample ex = new ActivityExample();
        ActivityExample.Criteria cr = ex.createCriteria();
        cr.andSubgroupEqualTo(activityQuery.getSubgroup());
        List<Activity> activities = activityMapper.selectByExample(ex);

        PageInfo pageInfo = new PageInfo(activities, activityQuery.getLimit());

        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(activityMapper.countByExample(ex));
        dataVO.setData(pageInfo.getList());
        return dataVO;
    }

    @Override
    public int addActivity(Activity activity) {
        int i = activityMapper.insert(activity);
        return i;
    }

    @Override
    public int deleteById(Long id, Activity activity) {
        int i = activityMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int updateById(Long id, Activity activity) {
        activity.setId(id);
        Activity select = activityMapper.selectByPrimaryKey(id);
        if (activity.getActivityName() != null && activity.getActivityName() != "") {
            select.setActivityName(activity.getActivityName());
        }
        if (activity.getApplicant() != null && activity.getApplicant() != "") {
            select.setApplicant(activity.getApplicant());
        }
        if (activity.getLocation() != null && activity.getLocation() != "") {
            select.setLocation(activity.getLocation());
        }
        if (activity.getActivityTime() != null) {
            select.setActivityTime(activity.getActivityTime());
        }
        if (activity.getSubgroup() != null && activity.getSubgroup() != "") {
            select.setSubgroup(activity.getSubgroup());
        }
        if (activity.getSubgroupAdmin() != null && activity.getSubgroupAdmin() != "") {
            select.setSubgroupAdmin(activity.getSubgroupAdmin());
        }
        if (activity.getSubgroupAdmin() != null && activity.getSubgroupAdmin() != "") {
            select.setSubgroupAdmin(activity.getSubgroupAdmin());
        }
        if (activity.getApplicantName() != null && activity.getApplicantName() != "") {
            select.setApplicantName(activity.getApplicantName());
        }
        if (activity.getApplicantPhone() != null && activity.getApplicantPhone() != "") {
            select.setApplicantPhone(activity.getApplicantPhone());
        }
        if (activity.getActivityInformation() != null && activity.getActivityInformation() != "") {
            select.setActivityInformation(activity.getActivityInformation());
        }
        select.setStatus((byte) 0);
        int i = activityMapper.updateByPrimaryKey(select);
        return i;
    }
}
