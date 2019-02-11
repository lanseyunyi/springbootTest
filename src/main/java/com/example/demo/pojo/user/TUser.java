package com.example.demo.pojo.user;

import javax.validation.constraints.NotNull;

public class TUser {

    private Integer id;

    @NotNull
    private String employee_id;

    private String password;

    private String employee;

    private String dept_id;

    private Integer is_state;

    private String job;

    private Integer is_delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id == null ? null : employee_id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee == null ? null : employee.trim();
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id == null ? null : dept_id.trim();
    }

    public Integer getIs_state() {
        return is_state;
    }

    public void setIs_state(Integer is_state) {
        this.is_state = is_state;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }
}