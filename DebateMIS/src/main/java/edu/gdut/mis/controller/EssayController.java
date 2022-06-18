package edu.gdut.mis.controller;

import com.github.pagehelper.PageInfo;
import edu.gdut.mis.entity.Comment;
import edu.gdut.mis.entity.Essay;
import edu.gdut.mis.service.CommentService;
import edu.gdut.mis.service.EssayService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class EssayController {
    @Autowired
    EssayService essayService;
    @Autowired
    CommentService commentService;


    @RequestMapping("/submit")
    public String submit(String content, Integer debateId, String username, String title, HttpServletRequest request){
        username = CookieUtil.getCookieByName(request,"username").getValue();
        debateId = Integer.valueOf(CookieUtil.getCookieByName(request,"debateId").getValue());
        Essay essay = new Essay(null,debateId,content,null,0,username,title);
        essayService.insertEssay(essay);
        return "redirect:getEssayByDebateId";
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

    @RequestMapping("/getEssayByEssayId")//essayID
    public String getEssayByEssayId(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                    HttpServletRequest request, Integer essayId, Model model){
        Essay essay =  essayService.getEssayByEssayId(essayId);
        //加载对应的评论
        List<Comment> list = commentService.getAllCommentByEssayId(essayId);
        PageInfo page = new PageInfo(list,5);

        model.addAttribute("username",essay.getUsername());
        model.addAttribute("title",essay.getTitle());
        model.addAttribute("content",essay.getContent());
        model.addAttribute("nol",essay.getNol());
        model.addAttribute("date",essay.getDate());
        model.addAttribute("essayId",essay.getEssayId());
        model.addAttribute("commentList",page);

        return "essay";
    }

    @RequestMapping("/updateNol")
    @ResponseBody
    public Integer like(HttpServletRequest request,@Param("essayId") Integer essayId){
        Integer debateId = Integer.valueOf(CookieUtil.getCookieByName(request,"debateId").getValue());
        Integer nol;
        if(essayService.hasLiked(essayId,debateId)){
            nol = essayService.getNol(essayId);
        }else {
            essayService.updateNol(essayId);
            essayService.insertLike_Record(essayId,debateId);
            nol = essayService.getNol(essayId);
        }
        return nol;
    }

//    @RequestMapping("/showHotEssay")
//    public List<Essay> showHotEssay(){
//        List<Essay> list = essayService.showHotEssay();
//        return list;
//    }
}
