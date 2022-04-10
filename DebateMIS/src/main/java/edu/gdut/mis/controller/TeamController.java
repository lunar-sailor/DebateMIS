package edu.gdut.mis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.gdut.mis.entity.DebateTeam;
import edu.gdut.mis.mappers.DebateTeamMapper;
import edu.gdut.mis.service.DebaterService;
import edu.gdut.mis.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TeamController {

    @Autowired
    TeamService teamService;
    DebaterService debaterService;
    ModelAndView mav;
    List<DebateTeam> list;

    @RequestMapping("/insertTeam")
    public String insertTeam(String teamName, String university, String department,@RequestParam(value = "pn",
            defaultValue = "1") Integer pn, Model model){
        DebateTeam debateTeam = new DebateTeam(null,teamName,null,university,department);
        int teamId = teamService.insertTeam(debateTeam);
        List<DebateTeam> list = teamService.getTeamById(teamId);

        this.list = list;

        return "redirect:/showTeamList";
    }

    @RequestMapping("/getTeamByName")
    public String getTeamByName(@RequestParam(value = "pn",
            defaultValue = "1") Integer pn, Model model,String teamName
    ){
        //对查询结果进行分页
        PageHelper.startPage(pn,5);
        List<DebateTeam> list = teamService.getTeamByName(teamName);

        this.list = list;

        return "redirect:/showTeamList";
    }

    @RequestMapping("/getTeamByUniversity")
    public String getTeamByUniversity(@RequestParam(value = "pn",
            defaultValue = "1") Integer pn, Model model,String university
    ){

        List<DebateTeam> list = teamService.getTeamByUniversity(university);

        this.list = list;

        return "redirect:/showTeamList";
    }

    @RequestMapping("/getTeamById")
    public String getTeamById(@RequestParam(value = "pn",
            defaultValue = "1") Integer pn, Model model, Integer teamId,
                              HttpServletRequest request){
        if (teamId == null){
            String cookie = CookieUtil.getCookieByName(request,"teamId").getValue();
            teamId = Integer.valueOf(cookie);
            //String cookie= CookieUtil.getCookieByName(request,"debateId").getValue();
            //String cookie = request.getCookies()[0].getValue();
            //Integer id = Integer.valueOf(cookie);
        }
        List<DebateTeam> list = teamService.getTeamById(teamId);
        this.list = list;
        return "redirect:/showTeamList";
    }

    @RequestMapping("/showTeamList")
    public String showTeamList(@RequestParam(value = "pn",
            defaultValue = "1") Integer pn, Model model){
        //对查询结果进行分页
        PageHelper.startPage(pn,5);
        PageInfo page = new PageInfo(this.list,5);
        model.addAttribute("pageInfo",page);
        return "teamList";
    }
}
