package blog.monako.student;

import blog.monako.domain.PageBean;
import blog.monako.service.StudentService;
import blog.monako.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 这是用于分页显示学生列表的servlet
 * @author monako
 **/
public class StudentListPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean pageBean;
        StudentService studentService;
        int currentPage;

        try{
            //1. 获取需要显示的page
            currentPage = Integer.parseInt(req.getParameter("currentPage"));
            //2. 根据指定的页数获取该页的数据回来
            studentService = new StudentServiceImpl();
            pageBean = studentService.findStudentByPage(currentPage);
            req.setAttribute("pageBean",pageBean);
            //3. 跳转界面
            req.getRequestDispatcher("listPage.jsp").forward(req,resp);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
