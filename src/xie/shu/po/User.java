package xie.shu.po;

public class User {
    private Integer userId;

    private String name;

    private String password;

    private String department;

    private Integer allowflag;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getAllowflag() {
        return allowflag;
    }

    public void setAllowflag(Integer allowflag) {
        this.allowflag = allowflag;
    }
}