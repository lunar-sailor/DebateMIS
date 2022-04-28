package edu.gdut.mis.entity;

public class Comment {
    private Integer commentId;
    private Integer essayId;
    private Integer debateId;
    private String username;
    private String content;
    private Integer nol;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public Integer getDebateId() {
        return debateId;
    }

    public void setDebateId(Integer debateId) {
        this.debateId = debateId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNol() {
        return nol;
    }

    public void setNol(Integer nol) {
        this.nol = nol;
    }

    public Comment(Integer commentId, Integer essayId, Integer debateId, String username, String content, Integer nol) {
        this.commentId = commentId;
        this.essayId = essayId;
        this.debateId = debateId;
        this.username = username;
        this.content = content;
        this.nol = nol;
    }

    public Comment() {
    }
}
