package com.tt.data2.service;

import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
*@ Author: Wang Yanzhao
*@ Time: 2018/11/21 14:55
*@ Describe: 学生业务，负责控制层请求
*/

public interface StudentService {
    void addGrade(Grade grade);

    void deleteGrade(Integer gradeID);

    List<Grade> findGrade();

    Optional<Grade> findGradeByID(Integer gradeID);

    int getCount();

    List<Grade> findGradeBySort(Sort sort);

    Page<Grade> findGradeByPage(Pageable pageable);

    List<Student> getStuByName(String studentName);

    List<Student> getStuByPwd(String loginPwd);

    List<Student> getStuByNoAndPwd(Integer studentNo, String studentPwd);

    List<Student> getStuByNameLike(String studentName);

    List<Student> getStuByNameLikeSort( String studentName);

    List<Student> getStudentAll();

    void updateStudent(Integer studentNo, String studentPwd, String userName);

    void deleteStudent(Integer studentNo);

    List<Student> getStudentByNoPwd(Integer studentNo, String studentPwd);
}
