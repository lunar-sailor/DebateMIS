package edu.gdut.mis.entity;

public class Debater {
    //需要符合驼峰命名规则
    private Integer debateId;
    private String username;
    private String password;
    private String tel;
    private Integer teamId;
    private String university;
    private String department;
    private String img;

    public Debater(Integer debateId, String username, String password,
                   String tel, Integer teamId, String university, String department,String img) {
        this.debateId = debateId;
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.teamId = teamId;
        this.university = university;
        this.department = department;
        this.img = img;
    }

    //补充一个无参构造器
    public Debater() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Debater{" +
                "debateId=" + debateId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", teamId=" + teamId +
                ", university='" + university + '\'' +
                ", department='" + department + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
