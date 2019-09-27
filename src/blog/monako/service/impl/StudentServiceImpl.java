package blog.monako.service.impl;

import blog.monako.dao.StudentDao;
import blog.monako.domain.PageBean;
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
    public PageBean findStudentByPage(int currentPage) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        // 封装分页的该页数组
        PageBean<Student> pageBean = new PageBean<Student>();
        pageBean.setCurrentPage(currentPage);//设置当前页
        int pageSize = studentDao.PAGE_SIZE;
        pageBean.setPageSize(pageSize);//设置每页显示的页数
        List<Student> list = studentDao.findStudentByPage(currentPage);
        pageBean.setList(list);//设置当前页显示的数据
        // 总的记录数，页数
        int count = studentDao.findCount();
        pageBean.setTotalSize(count);//设置总记录数
        pageBean.setTotalPage(count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1);//设置总页数
        return pageBean;
    }

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

    @Override
    public List<Student> searchStudent(String name, String gender) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.searchStudent(name,gender);
    }
}
