package com.tt.data2.dao;

import com.tt.data2.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
public interface StudentDao2 extends JpaRepository<Student,Integer> {

    List<Student> findStudentByUserName(String studentName);

    List<Student> findStudentByStudentPwd(String loginPwd);

    List<Student> findStudentByStudentNoAndStudentPwd(Integer studentNo, String studentPwd);

    List<Student> findStudentByUserNameLike(String studentName);

    List<Student> findStudentByUserNameLikeOrderByStudentNoDesc(String studentName);
    @Query( "select s from Student as s")
    List<Student> getStudentAll();

    /**
   增删改查需要进行事务处理
    */

    @Modifying
    @Query("update Student set studentPwd=?2,userName=?3 where studentNo=?1")
    void updateStudent(Integer studentNo, String studentPwd, String userName);

    @Modifying
    @Query("delete from Student where studentNo=?1")
    void deleteStudent(Integer studentNo);

    @Query("select s from Student as s where s.studentNo=?1 and s.studentPwd=?2")
    List<Student> getStudentByNoPwd(Integer studentNo, String studentPwd);



}
