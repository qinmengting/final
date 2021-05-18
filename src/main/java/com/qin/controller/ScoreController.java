package com.qin.controller;

import com.qin.domain.ArtMember;
import com.qin.domain.ScoreProportion;
import com.qin.service.ArtMemberService;
import com.qin.service.ScoreService;
import com.qin.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ArtMemberService artMemberService;

    @RequestMapping("/score/addprop")
    public Object addProp( ScoreProportion scoreProportion) {
        //保存各项分数占比
        int i = scoreService.addScoreBySubgroup(scoreProportion);

        //计算考勤分
        artMemberService.countAttendanceScore(scoreProportion);

        if (i != 0) {
            return ResponseUtil.general_response("设置成功");
        }else{
            return ResponseUtil.general_response("设置失败");
        }
    }

    // 更新成绩
    @PutMapping("/score/updatesocre/{id}")
    public Object updateScore(@PathVariable("id") Long id, @RequestBody ArtMember artMember) {
        artMember.setId(id);
        int i = artMemberService.updateScore(id, artMember);
        int i1 = artMemberService.countTotalScore(id,artMember);
        if (i != 0) {
            return ResponseUtil.general_response("保存成功!");
        } else
            return ResponseUtil.general_response("保存失败！");
    }

}
