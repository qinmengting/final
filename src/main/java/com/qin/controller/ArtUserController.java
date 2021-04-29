package com.qin.controller;

import com.qin.domain.ArtUser;
import com.qin.service.ArtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArtUserController {
    @Autowired
    private ArtUserService artUserService;

    @PostMapping("/user/login")
    public String userLogin(String username,String password) {
        ArtUser artUser = null;
        artUser.setUsername(username);
        artUser.setPassword(password);
        ArtUser user = artUserService.userLogin(artUser);
        if (user==null){
            return "login";
        }
        else {
            return "index";
        }
    }
}
