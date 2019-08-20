package blog.monako.service;

import blog.monako.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * 这是学生的业务处理规则
 * @author monako
 **/
public interface StudentService {
    /**
     * 查询所有学生
     * @return List<Student>
     **/
    List<Student> findAll() throws SQLException;
    /**
     * 添加学生
     * @param student 需要添加到数据库的学生对象
     * @throws SQLException
     **/
    void insert(Student student)throws SQLException;
    /**
     * 修改学生
     * @param student 需要修改的学生对象
     * @throws SQLException
     **/
    void update(Student student)throws SQLException;
    /**
     * 删除学生
     * @param id 需要删除的学生
     * @throws SQLException
     **/
    void delete(int id)throws SQLException;
    /**
     * 获取学生信息
     * @param id 需要获取信息的学生
     * @throws SQLException
     **/
    Student userInfo(int id)throws SQLException;
}
