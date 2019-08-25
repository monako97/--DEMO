package blog.monako.student;

import blog.monako.domain.Student;
import blog.monako.service.StudentService;
import blog.monako.service.impl.StudentServiceImpl;
import blog.monako.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            // 1. 取到要查询的关键数据 姓名、性别
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            // 2. 找 Service 去查询
            StudentService studentService = new StudentServiceImpl();
            List<Student> studentList = studentService.searchStudent(name,gender);
            System.out.println(studentList.toString());
            // 3. 跳转界面
            // 2. 先把数据存储到作用域中
            req.setAttribute("studentList",studentList);
            // 3. 跳转页面
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
