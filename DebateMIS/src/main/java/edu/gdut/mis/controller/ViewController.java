package edu.gdut.mis.controller;

import com.github.pagehelper.PageInfo;
import edu.gdut.mis.entity.Essay;
import edu.gdut.mis.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    EssayService essayService;

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
    public String toUserCenter(HttpServletRequest request, Model model,
                               @RequestParam(value = "pn",defaultValue = "1") Integer pn){

        Integer debateId = Integer.valueOf(CookieUtil.getCookieByName(request,"debateId").getValue());
        String username = CookieUtil.getCookieByName(request,"username").getValue();
        List<Essay> list = essayService.getEssayByDebateId(debateId);

        model.addAttribute("username",username);
        model.addAttribute("essayList",list);

        return "userCenter";
    }

    @RequestMapping("/toTeam")
    public String toTeam(){
        return "redirect:getTeamById";
    }

    /**
     * toEssay有两个应用
     * 1.是从debater的文章展示页面，点击跳转到指定文章（文章详细页面）
     * 2.是打开“我的文章”页面（essayList）页面，根据debateId展示所有所有文章
     *
     */
    @RequestMapping("/toEssay")
    public String toEssay(HttpServletRequest request,Integer essayId){
        //判断请求中是否带参，带参则跳转文章详情页，不带参跳转文章列表
        try{
            if(essayId.equals(null)){   //实测，如果传参，可以获取essayId

            }
        }catch (NullPointerException e){
            return "redirect:getEssayByDebateId";

        }
//        if(essayId.equals(null)){
//            return "redirect:getEssayByDebateId";
//        }
        return "redirect:getEssayByEssayId";
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
