package edu.gdut.mis.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.gdut.mis.entity.Debater;
import edu.gdut.mis.entity.Essay;
import edu.gdut.mis.service.DebaterService;
import edu.gdut.mis.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    EssayService essayService;
    @Autowired
    DebaterService debaterService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response){
//        if (!CookieUtil.ifEmpty(response,request)){
//            return "redirect:Login";
//        }
//        return "redirect:debater";
        return "index";
    }


    @RequestMapping("/debater")
    public String Debater(Model model){

        List<Essay> list = essayService.showHotEssay();
        model.addAttribute("hotEssayList",list);

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
     * toEssay???????????????
     * 1.??????debater???????????????????????????????????????????????????????????????????????????
     * 2.????????????????????????????????????essayList??????????????????debateId????????????????????????
     *
     */
    @RequestMapping("/toEssay")
    public String toEssay(HttpServletRequest request,Integer essayId){
        //??????????????????????????????????????????????????????????????????????????????????????????
        try{
            if(essayId.equals(null)){   //????????????????????????????????????essayId

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

    @RequestMapping("toDebaterUserCenter")
    public String toDebaterUserCenter(Integer debateId,Model model){
        Debater debater = debaterService.getDebaterById(debateId);
        model.addAttribute("username",debater.getUsername());
        model.addAttribute("university",debater.getUniversity());
        model.addAttribute("department",debater.getDepartment());
        model.addAttribute("Img",debater.getImg());
        List<Essay> list = essayService.getEssayByDebateId(debateId);
        model.addAttribute("essayList",list);
        return "userCenter";
    }
}
