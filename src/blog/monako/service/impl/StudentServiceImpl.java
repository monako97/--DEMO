package blog.monako.service.impl;

import blog.monako.dao.StudentDao;
import blog.monako.domain.Student;
import blog.monako.impl.StudentDaoImpl;
import blog.monako.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * 这是学生业务的实现 返回所有的学生
 * @author monako
 **/
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.insert(student);
    }

    @Override
    public void delete(int id) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.delete(id);
    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.update(student);
    }

    @Override
    public Student userInfo(int id) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.userInfo(id);
    }
}
