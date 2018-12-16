package com.tt.data2.controller;

import com.tt.data2.pojo.Grade;
import com.tt.data2.pojo.Student;
import com.tt.data2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

/**
*@ Author: Wang Yanzhao
*@ Time: 2018/11/21 15:09
*@ Describe: 学生的控制器，增删改查
*/
/**
 * @作者：Shilinzhi
 * @时间：2018/12/16 20:40
 * @描述：
 *
 */

@Controller
public class StudentController {
    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;


    //添加年级信息的方法
    @RequestMapping("/addGrade")
    public String addGrade() {
        Grade grade=new Grade();
        grade.setGradeName("第一学期");
        studentService.addGrade(grade);
        return "ok";
    }
    //删除年纪信息的方法
    //http://localhost:8080/deleteGrade?gradeID=8
    @RequestMapping("/deleteGrade")
    public String deleteGrade(@RequestParam Integer gradeID) {

        studentService.deleteGrade(gradeID);
        return "ok";
    }
    //查询年级信息的方法
    //http://localhost:8080/findGrade
    @RequestMapping("/findGrade")
    @ResponseBody
    public Object findGrade() {

        List<Grade>list=studentService.findGrade();
        return list;
    }
    //查询年级信息的方法
    //http://localhost:8080/findGradeByID?gradeID=7
    @RequestMapping("/findGradeByID")
    @ResponseBody
    public Object findGradeByID(@RequestParam Integer gradeID) {

        Optional<Grade> list=studentService.findGradeByID(gradeID);
        return list;
    }
    //获取个数
    //http://localhost:8080/getCount
    @RequestMapping("/getCount")
    @ResponseBody
    public Object getCount() {

        int count=studentService.getCount();
        return count;
    }
    //根据ID进行排序
    //http://localhost:8080/findGradeBySort
    @RequestMapping("/findGradeBySort")
    @ResponseBody
    public Object findGradeBySort() {
        // 你需要告诉我根据那个条件排序，2.描述一下怎么排
        //说白了，根据ID？升序还是降序？
        Sort sort=new Sort(Sort.Direction.DESC,"gradeID");
        List<Grade>list=studentService.findGradeBySort(sort);
        return list;
    }
    //7.分页
    //http://localhost:8080/findGradeByPage?pageIndex=1
    @RequestMapping("/findGradeByPage")
    @ResponseBody
    public Object findGradeByPage(@RequestParam Integer pageIndex) {
        Pageable pageable= PageRequest.of(pageIndex-1,2);
        Page<Grade> page=studentService.findGradeByPage(pageable);
        List<Grade> list=page.getContent();
        System.out.println("总页数"+page.getTotalPages());
        System.out.println("总条数"+page.getTotalElements());
        System.out.println("当前页数"+page.getNumber()+1);
        return list;
    }
    //8.根据名称查询学生信息,getStuByName
    //http://localhost:8080/getStuByName
    @RequestMapping("/getStuByName")
    @ResponseBody
    public Object getStuByName(@RequestParam String studentName){
        List<Student> list = studentService.getStuByName(studentName);
        return list;
    }
    //9.根据名称查询学生信息,getStuByName
    //http://localhost:8080/getStuByPwd
    @RequestMapping("/getStuByPwd")
    @ResponseBody
    public Object getStuByPwd(@RequestParam String loginPwd){
        List<Student> list = studentService.getStuByPwd(loginPwd);
        return list;
    }
    //10..根据名称查询学生信息,getStuByName
    //http://localhost:8080/getStuByNoAndPwd?studentNo=1&studentPwd=123
    @RequestMapping("/getStuByNoAndPwd")
    @ResponseBody
    public Object getStuByNoAndPwd(@RequestParam Integer studentNo,@RequestParam String studentPwd){
        List<Student> list = studentService.getStuByNoAndPwd(studentNo,studentPwd);
        return list;
    }
    //11.根据名称查询学生信息,getStuByName
    //http://localhost:8080/getStuByNameLike?studentName=王
    @RequestMapping("/getStuByNameLike")
    @ResponseBody
    public Object getStuByNameLike(@RequestParam String studentName){
        List<Student> list = studentService.getStuByNameLike(studentName);
        return list;
    }
    //12.根据名称查询学生信息,并且以学号降序，进行排序
    //http://localhost:8080/getStuByNameLike?studentName=王
    @RequestMapping("/getStuByNameLikeSort")
    @ResponseBody
    public Object getStuByNameLikeSort(@RequestParam String studentName){
        Sort sort=new Sort(Sort.Direction.DESC,"studentNo");
        List<Student> list = studentService.getStuByNameLikeSort(studentName);
        return list;
    }
//    13.查询所有学生信息》getStudentAll,返回json数据
//http://localhost:8080/getStudentAll
    @RequestMapping("/getStudentAll")
    @ResponseBody
    public Object getStudentAll() {
        List<Student> list=studentService.getStudentAll();
        return list;
    }
    //    14.修改学生信息》updateStudent
//http://localhost:8080/updateStudent
    @RequestMapping("/updateStudent")
    public String updateStudent() {
        Integer studentNo=1;
        String studentPwd="666";
        String userName="admin";
        studentService.updateStudent(studentNo,studentPwd,userName);
        return "ok";
    }
    //    15删除学生信息》deleteStudent
//http://localhost:8080/deleteStudent
    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam Integer studentNo) {
        studentService.deleteStudent(studentNo);
        return "ok";
    }

    //    16.根据学号和密码查询学生信息
//http://localhost:8080/getStudentByNoPwd
    @RequestMapping("/getStudentByNoPwd")
    @ResponseBody
    public Object getStudentByNoPwd(@RequestParam Integer studentNo,@RequestParam String studentPwd) {
        List<Student> list=studentService.getStudentByNoPwd(studentNo,studentPwd);
        return list;
    }
}
