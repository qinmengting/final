package com.qin.service;

import com.qin.common.VO.DataVO;
import com.qin.common.query.ActivityQuery;
import com.qin.domain.Activity;
import org.springframework.stereotype.Service;

@Service
public interface ActivityService {
    /**
     * 按分团查询
     * @param activityQuery
     * @return
     */
    public DataVO<Activity> queryByParams(ActivityQuery activityQuery);

    /**
     * 添加活动申请
     * @param activity
     * @return
     */
    public int addActivity(Activity activity);

    /**
     * 根据id删除
     * @param id
     * @param activity
     * @return
     */
    public int deleteById(Long id,Activity activity);

    public int updateById(Long id, Activity activity);

    /**
     * 拒绝申请
     * @param id
     * @return
     */
    public int refuse(Long id);

    /**
     * 同意申请
     * @param id
     * @return
     */
    public int approve(Long id);
}
