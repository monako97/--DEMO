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

public class StudentUserInfoServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            StudentService studentService = new StudentServiceImpl();
            Student student = studentService.userInfo(id);
            req.setAttribute("student",student);
            req.getRequestDispatcher("edit.jsp").forward(req,resp);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
