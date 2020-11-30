package service;


import java.util.List;

import excel.DB;
import excel.Student;


public class TestExcelToDb {
    public static void main(String[] args) {
        //得到表格中所有的数据
        List<Student> listExcel=StudentService.getAllByExcel("F:\\student.xls");



        DB db=new DB();

        for (Student student : listExcel) {
            int id=student.getId();
            System.out.println(id);
            if (!StudentService.isExist(id)) {
                //不存在就添加
                String sql="insert into student (id,s_name,age,address) values(?,?,?,?)";
                String[] str=new String[]{id+"",student.getS_name(),student.getAge(),student.getAddress()+""};
                db.AddU(sql, str);
            }else {
                //存在就更新
                String sql="update student set s_name=?,age=?,address=? where id=?";
                String[] str=new String[]{student.getS_name(),student.getAge(),student.getAddress()+"",id+""};
                db.AddU(sql, str);
            }
        }
    }
}