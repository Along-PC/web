package com.weimo.fighting.one2one.model;

public class Employee {
    private String emp_no;
    private String emp_name;
    private String dept_id;
    private String emp_gender;
    private String emp_email;
    private EmployeeSchool employeeSchool;

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public EmployeeSchool getEmployeeSchool() {
        return employeeSchool;
    }

    public void setEmployeeSchool(EmployeeSchool employeeSchool) {
        this.employeeSchool = employeeSchool;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_no='" + emp_no + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", dept_id='" + dept_id + '\'' +
                ", emp_gender='" + emp_gender + '\'' +
                ", emp_email='" + emp_email + '\'' +
                ", employeeSchool=" + employeeSchool +
                '}';
    }
}
