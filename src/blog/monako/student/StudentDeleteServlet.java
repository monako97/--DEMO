package blog.monako.student;

import blog.monako.service.StudentService;
import blog.monako.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            StudentService studentService = new StudentServiceImpl();
            studentService.delete(id);
            req.getRequestDispatcher("StudentListServlet").forward(req,resp);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
