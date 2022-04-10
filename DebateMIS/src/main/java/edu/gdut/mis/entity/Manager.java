package edu.gdut.mis.entity;

public class Manager {

    private Integer manId;
    private String debateId;
    private String password;
    private String relname;
    private String tel;

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public String getDebateId() {
        return debateId;
    }

    public void setDebateId(String debateId) {
        this.debateId = debateId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manId=" + manId +
                ", debateId='" + debateId + '\'' +
                ", password='" + password + '\'' +
                ", relname='" + relname + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
