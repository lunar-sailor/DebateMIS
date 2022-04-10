package edu.gdut.mis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/debater")
    public String Debater(){
        return "debater";
    }

    @RequestMapping("/List")
    public String toList(){
        return "list";
    }

    @RequestMapping("/new")
    public String toNew(){
        return "new";
    }

    @RequestMapping("/toUserCenter")
    public String toUserCenter(){
        return "userCenter";
    }

    @RequestMapping("/toTeam")
    public String toTeam(){
        return "redirect:getTeamById";
    }

    @RequestMapping("/toEssay")
    public String toEssay(){
        return "redirect:getEssayById";
    }

    @RequestMapping("/newEssay")
    public String newEssay(Model model, HttpServletRequest request){
        String username = CookieUtil.getCookieByName(request,"username").getValue();
        model.addAttribute("username",username);
        return "newEssay";
    }

    @RequestMapping("toEssayEdit")
    public String toEssayEdit(){
        return "essayEdit";
    }
}
