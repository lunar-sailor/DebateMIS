package edu.gdut.mis.controller;


import edu.gdut.mis.entity.Debater;
import edu.gdut.mis.entity.Essay;
import edu.gdut.mis.service.EssayService;
import edu.gdut.mis.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import utils.CookieUtil;
import utils.Equals;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Controller
public class LogController {

    @Autowired
    LogService logService;
    @Autowired
    EssayService essayService;
    ModelAndView mav = new ModelAndView();

    @RequestMapping("/Login")
    public String Login(Integer debateId, String password, Model model,
                        HttpServletResponse response, HttpServletRequest request){
        Debater debater = logService.getDebaterById(debateId);
        if (Equals.equals(password,debater.getPassword())){
            //在登录成功后，页面跳转前加载热门文章
            Log(model,response,debater);
            return "debater";
        }else {
            return "index";
        }
    }

    /**
     *在登录中涉及到对用户输入的密码和数据库的密码进行比对
     *密码-->password是String类型，是对象 不能直接用==作比较
     *重写equals方法用于比较input password和 real password
     */


    private void Log(Model model,HttpServletResponse response,Debater debater){
        List<Essay> list =  essayService.showHotEssay();
        model.addAttribute("hotEssayList",list);
        model.addAttribute("username",debater.getUsername());
        CookieUtil.setCookie(response,"debateId",debater.getDebateId().toString(),86400);
        CookieUtil.setCookie(response,"username",debater.getUsername(),86400);
        try{
            CookieUtil.setCookie(response,"teamId",debater.getTeamId().toString(),86400);
        }catch (NullPointerException e){
            CookieUtil.setCookie(response,"teamId","0",86400);
        }
    }
}
