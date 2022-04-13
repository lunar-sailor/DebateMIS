package edu.gdut.mis.controller;

import com.github.pagehelper.PageInfo;
import edu.gdut.mis.entity.Essay;
import edu.gdut.mis.service.EssayService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class EssayController {
    @Autowired
    EssayService essayService;


    @RequestMapping("/submit")
    public String submit(String content, Integer debateId, String username, String title, HttpServletRequest request){
        username = CookieUtil.getCookieByName(request,"username").getValue();
        debateId = Integer.valueOf(CookieUtil.getCookieByName(request,"debateId").getValue());
        Essay essay = new Essay(null,debateId,content,null,null,username,title);
        essayService.insertEssay(essay);
        return "redirect:getEssayById";
    }

    @RequestMapping("/getEssayByDebateId")//debateID
    public String getEssayById(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                               Model model, HttpServletRequest request){
        Integer debateId = Integer.valueOf(CookieUtil.getCookieByName(request,"debateId").getValue());
        List<Essay> list =  essayService.getEssayByDebateId(debateId);
        PageInfo page = new PageInfo(list,5);
        model.addAttribute("pageInfo",page);
        return "essayList";
    }

    @RequestMapping("/getEssayByEssayId")//debateID
    public String getEssayByEssayId(HttpServletRequest request,Integer essayId,Model model){
        Integer debateId = Integer.valueOf(CookieUtil.getCookieByName(request,"debateId").getValue());
        Essay essay =  essayService.getEssayByEssayId(essayId);
        model.addAttribute("username",essay.getUsername());
        model.addAttribute("title",essay.getTitle());
        model.addAttribute("content",essay.getContent());
        model.addAttribute("nol",essay.getNol());
        model.addAttribute("date",essay.getDate());
        model.addAttribute("essayId",essay.getEssayId());
        return "essay";
    }

    @RequestMapping("/getNol")
    @ResponseBody
    public Integer like(HttpServletRequest request,Integer essayId){
        Integer nol = essayService.updateNol(essayId);
        return nol;
    }

//    @RequestMapping("/showHotEssay")
//    public List<Essay> showHotEssay(){
//        List<Essay> list = essayService.showHotEssay();
//        return list;
//    }
}
