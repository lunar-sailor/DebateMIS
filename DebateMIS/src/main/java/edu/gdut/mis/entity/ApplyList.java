package edu.gdut.mis.entity;

public class ApplyList {
    private Integer debateId;
    private String username;
    private Integer teamId;
    private String teamName;

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

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "ApplyList{" +
                "debateId=" + debateId +
                ", username='" + username + '\'' +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
