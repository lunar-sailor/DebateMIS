package edu.gdut.mis.service;

import edu.gdut.mis.entity.Comment;
import edu.gdut.mis.mappers.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public Integer insertComment(Comment comment){
        commentMapper.insertComment(comment);
        Integer commentId = comment.getCommentId();
        return commentId;
    }

    public void deleteComment(Integer essayId,String username){
        commentMapper.deleteComment(essayId,username);
    }

    public List<Comment> getAllCommentByUsername(String username){
        List<Comment> list = commentMapper.getAllcommentByUsername(username);
        return list;
    }

    public List<Comment> getAllCommentByEssayId(Integer essayId){
        List<Comment> list = commentMapper.getAllcommentByEssayId(essayId);
        return list;
    }

    public Comment getCommentById(Integer commentId) {
        Comment comment = commentMapper.getCommentById(commentId);
        return comment;
    }
}
