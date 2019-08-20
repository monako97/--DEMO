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

/**
 * 用于处理学生的添加请求
 * @author monako
 **/
public class StudentAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 客户端提交上来的数据
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
            Student student = new Student(name,gender,phone,hobby,info,date);
            StudentService studentService = new StudentServiceImpl();
            studentService.insert(student);
            // 3. 跳转到列表页
            // 再查一次数据库，然后再装到作用域中,然后再跳转
            // 这里是直接跳到页面上，那么这个页面会重新翻译一次，上面那个request的请求的数据是没有了
            // request.getRequestDispatcher("list.jsp").forward(request,response);
            // servlet除了可以跳jsp之外，还能跳servlet
            request.getRequestDispatcher("StudentListServlet").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
