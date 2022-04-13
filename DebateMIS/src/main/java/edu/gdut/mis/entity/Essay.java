package edu.gdut.mis.entity;

public class Essay {
    private Integer essayId;
    private Integer debateId;
    private String content;
    private String date;
    private Integer nol;//number of like
    private String username;
    private String title;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNol() {
        return nol;
    }

    public void setNol(Integer nol) {
        this.nol = nol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Essay(Integer essayId, Integer debateId, String content, String date, Integer nol, String username, String title) {
        this.essayId = essayId;
        this.debateId = debateId;
        this.content = content;
        this.date = date;
        this.nol = nol;
        this.username = username;
        this.title = title;
    }

    public Essay() {
    }
}
