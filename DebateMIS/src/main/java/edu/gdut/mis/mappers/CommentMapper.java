package edu.gdut.mis.mappers;

import edu.gdut.mis.entity.Comment;

import java.util.List;

public interface CommentMapper {
    //插入评论
    Integer insertComment(Comment comment);
    //删除评论
    void deleteComment(Integer essayId,String username);
    //通过用户名获取所有评论
    List<Comment> getAllcommentByUsername(String username);
    //通过文章编号获取所有评论
    List<Comment> getAllcommentByEssayId(Integer essayId);

    Comment getCommentById(Integer commentId);
}
