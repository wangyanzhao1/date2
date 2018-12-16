package com.tt.data2.service.impl;

import com.tt.data2.dao.StudentDao;
import com.tt.data2.dao.StudentDao2;
import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import com.tt.data2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
*@ Author: Wang Yanzhao
*@ Time: 2018/11/21 15:10
*@ Describe: 学生业务，负责控制层请求
*/
@Service("studentService")
@Transactional
public class StudentSericeImpl implements StudentService {
    @Autowired
    @Qualifier("studentDao")
    private StudentDao studentDao;
    @Autowired
    @Qualifier("studentDao2")
    private StudentDao2 studentDao2;

    @Override
    public void addGrade(Grade grade) {
        studentDao.save(grade);
    }
    @Override
    public void deleteGrade(Integer gradeID) {
        studentDao.deleteById(gradeID);
    }

    @Override
    public List<Grade> findGrade() {
        return (List<Grade>) studentDao.findAll();
    }

    @Override
    public Optional<Grade> findGradeByID(Integer gradeID) {
        return studentDao.findById(gradeID);
    }

    @Override
    public int getCount() {
        return (int) studentDao.count();
    }

    @Override
    public List<Grade> findGradeBySort(Sort sort) {
        return (List<Grade>) studentDao.findAll(sort);
    }

    @Override
    public Page<Grade> findGradeByPage(Pageable pageable) {
        return (Page<Grade>) studentDao.findAll(pageable);
    }

    @Override
    public List<Student> getStuByName(String studentName) {
        return studentDao2.findStudentByUserName(studentName);
    }

    @Override
    public List<Student> getStuByPwd(String loginPwd) {
        return studentDao2.findStudentByStudentPwd(loginPwd);
    }

    @Override
    public List<Student> getStuByNoAndPwd(Integer studentNo, String studentPwd) {
        return studentDao2.findStudentByStudentNoAndStudentPwd(studentNo,studentPwd);
    }

    @Override
    public List<Student> getStuByNameLike(String studentName) {
        return studentDao2.findStudentByUserNameLike("%"+studentName+"%");
    }

    @Override
    public List<Student> getStuByNameLikeSort(String studentName) {
        return studentDao2.findStudentByUserNameLikeOrderByStudentNoDesc("%"+studentName+"%");
    }

    @Override
    public List<Student> getStudentAll() {
        return studentDao2.getStudentAll();
    }

    @Override
    @Transactional
    public void updateStudent(Integer studentNo, String studentPwd, String userName) {
        studentDao2.updateStudent(studentNo,studentPwd,userName);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer studentNo) {
        studentDao2.deleteStudent(studentNo);
    }

    @Override
    public List<Student> getStudentByNoPwd(Integer studentNo, String studentPwd) {
        return studentDao2.getStudentByNoPwd(studentNo,studentPwd);
    }
}
