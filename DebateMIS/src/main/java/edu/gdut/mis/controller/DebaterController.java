package edu.gdut.mis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.gdut.mis.entity.Debater;
import edu.gdut.mis.service.DebaterService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DebaterController {

    /**
     * 新增一条辩手数据
     * 返回当前新增的数据
     *
     */
    @Autowired
    DebaterService debaterService;
    ModelAndView mav = new ModelAndView();

    @RequestMapping("/insertDebater")
    public ModelAndView insertDebater(String username,String password,String tel,String university,String department){
        Debater debater = new Debater(null,username,password,tel,null,university,department);
        int debateId =  debaterService.insertDebater(debater);
        debater = debaterService.getDebaterById(debateId);
        //System.out.println(debater);
        mav.addObject("debaterId",debater.getDebateId());
        mav.addObject("username",debater.getUsername());
        mav.addObject("tel",debater.getTel());
        mav.addObject("university",debater.getUniversity());
        mav.addObject("department",debater.getDepartment());
        mav.setViewName("debater");
        return mav;
    }

    @RequestMapping("/getDebaterById")
    public ModelAndView getDebaterById(Integer debateId){
        Debater debater = new Debater();
        debater = debaterService.getDebaterById(debateId);
        //System.out.println(debater);
        mav.addObject("debaterId",debater.getDebateId());
        mav.addObject("username",debater.getUsername());
        mav.addObject("tel",debater.getTel());
        mav.setViewName("debater");
        return mav;
    }

    @RequestMapping("/getAllDebater")
    public String getAllDebater(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
    Model model
    ){
        //对查询结果进行分页
        PageHelper.startPage(pn,5);

        List<Debater> list = debaterService.getAllDebater();
        //使用pageInfo包装查询后的结果
        //pageInfo封装了详细的分页信息，可以直接将pageInfo交给页面
        //navigatePages连续显示的页数
        PageInfo page = new PageInfo(list,5);
        model.addAttribute("pageInfo",page);
        return "list";
    }
}
