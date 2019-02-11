package com.example.demo.SpringTest.user;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 15:45 2018/12/21/021
 * @Modify By:
 **/
public class PartTUser {
    private String employee_id;
    private String employee;
    private String dept_id;

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
