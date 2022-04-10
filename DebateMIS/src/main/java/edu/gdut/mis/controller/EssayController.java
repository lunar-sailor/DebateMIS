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

    @RequestMapping("/getEssayById")//debateID
    public String getEssayById(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                               Model model, HttpServletRequest request){
        Integer debateId = Integer.valueOf(CookieUtil.getCookieByName(request,"debateId").getValue());
        List<Essay> list =  essayService.getEssayById(debateId);
        PageInfo page = new PageInfo(list,5);
        model.addAttribute("pageInfo",page);
        return "essayList";
    }
}
