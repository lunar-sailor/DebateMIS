package edu.gdut.mis.controller;

import com.github.pagehelper.PageInfo;
import edu.gdut.mis.entity.Comment;
import edu.gdut.mis.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;


    @RequestMapping("/insertComment")
    @ResponseBody
    public List<Comment>                                 insertComment(Integer essayId, Integer debateId, String username, String content, Model model,
                                       @RequestParam(value = "pn",defaultValue = "1") Integer pn){
        Comment comment = new Comment(null,essayId,debateId,username,content,null);
        commentService.insertComment(comment);
        List<Comment> list = commentService.getAllCommentByEssayId(essayId);
        PageInfo page = new PageInfo(list,5);
//        model.addAttribute("commentList",page);
        return list;
    }

    @RequestMapping("/deleteComment")
    public String deleteComment(Integer essayId,String username){
        commentService.deleteComment(essayId,username);
        return "";
    }

    @RequestMapping("/getAllCommentByUsername")
    public String getAllCommentByUsername(String username){
        commentService.getAllCommentByUsername(username);
        return "";
    }

    @RequestMapping("/getAllCommentByEssayId")
    public String getAllCommentByEssayId(Integer essayId){
        commentService.getAllCommentByEssayId(essayId);
        return "";
    }

}
