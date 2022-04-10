package edu.gdut.mis.entity;

public class DebateTeam{
    private Integer teamId;
    private String teamName;
    private String teamNums;
    private String university;
    private String department;

    public DebateTeam() {
    }

    public DebateTeam(Integer teamId, String teamName, String teamNums, String university, String department) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamNums = teamNums;
        this.university = university;
        this.department = department;
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

    public String getTeamNums() {
        return teamNums;
    }

    public void setTeamNums(String teamNums) {
        this.teamNums = teamNums;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "DebateTeam{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamNums='" + teamNums + '\'' +
                ", university='" + university + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
