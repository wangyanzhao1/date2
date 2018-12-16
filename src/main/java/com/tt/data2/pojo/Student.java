package com.tt.data2.pojo;

import javax.persistence.*;
import java.io.Serializable;
/**
*@ Author: Wang Yanzhao
*@ Time: 2018/11/21 14:54
*@ Describe:
*/

@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentNo;
    private  String userName;
    private  String studentPwd;

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public Student(String userName) {
        this.userName = userName;
    }

    public Student() {
    }
}
