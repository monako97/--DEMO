package blog.monako.student;

import blog.monako.domain.Student;
import blog.monako.service.StudentService;
import blog.monako.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 负责查询所有的学生信息，然后呈现到页面上
 * @author monako
 **/
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            // 1. 查询出来所有的学生
            StudentService studentService = new StudentServiceImpl();
            List<Student> studentList = studentService.findAll();
            // 2. 先把数据存储到作用域中
            request.setAttribute("studentList",studentList);
            // 3. 跳转页面
            request.getRequestDispatcher("list.jsp").forward(request,response);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
