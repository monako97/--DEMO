package blog.monako.impl;

import blog.monako.dao.StudentDao;
import blog.monako.domain.Student;
import blog.monako.util.JDBCUtil;
import blog.monako.util.TextUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 这是StudentDao的实现，针对前面定义的规范，做出具体的实现
 * @author monako
 **/
public class StudentDaoImpl implements StudentDao {
    /**
     * 添加学生
     * @param student 需要添加到数据库的学生对象
     * @throws SQLException
     **/
    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        queryRunner.update(
                "INSERT INTO student VALUES (null,?,?,?,?,?,?)",
                student.getName(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
        );
    }
    /**
     * 修改学生
     * @param student 需要修改的学生对象
     * @throws SQLException
     **/
    @Override
    public void update(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        queryRunner.update(
                "UPDATE student SET name = ?, gender = ?, phone = ?, birthday = ?,hobby = ?,info = ? WHERE id = ?",
                student.getName(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getId()
        );
    }
    /**
     * 删除学生
     * @param id 需要删除的学生
     * @throws SQLException
     **/
    @Override
    public void delete(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        queryRunner.update("DELETE FROM student where id = ?",id);
    }

    /**
     * 查询所有学生
     * @author monako
     **/
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM student";
        return queryRunner.query(sql,new BeanListHandler<Student>(Student.class));
    }
    /**
     * 获取学生信息
     * @param id 需要获取信息的学生
     * @throws SQLException
     **/
    @Override
    public Student userInfo(int id)throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM student WHERE id = ?";
        return queryRunner.query(sql,new BeanHandler<Student>(Student.class),id);
    }
    /**
     * 模糊查询
     * @param name 按姓名搜索
     * @param gender 按性别搜索
     * @throws SQLException
     **/
    @Override
    public List<Student> searchStudent(String name, String gender) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM student WHERE 1 = 1";
        List<String> list = new ArrayList<String>();
        if (!TextUtils.isEmpty(name)){
            sql = sql + " AND name like ?";
            list.add("%" + name + "%");
        }

        if (!TextUtils.isEmpty(gender)){
            sql = sql + " AND gender = ?";
            list.add(gender);
        }
        System.out.println(name+" - "+gender);
        return queryRunner.query(sql,new BeanListHandler<Student>(Student.class),list.toArray());
    }
}
