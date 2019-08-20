package blog.monako.student;

import blog.monako.domain.Student;
import blog.monako.service.StudentService;
import blog.monako.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class StudentEditServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 客户端提交上来的数据
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String hobby = Arrays.toString(request.getParameterValues("hobby"));
        hobby = hobby.substring(1,hobby.length()-1);
        String info = request.getParameter("info");
        // 2. 添加到数据库
        // String --> Date
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            Student student = new Student(name,gender,phone,hobby,info,date,id);
            StudentService studentService = new StudentServiceImpl();
            studentService.update(student);
            // 3. 跳转到列表页
            request.getRequestDispatcher("StudentListServlet").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
