package SQL;

import SQL.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.io.IOUtils;

import javax.annotation.Resource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
    private static final long serialVersionUID =  1L;

    private StudentDbUtil studentDbUtil;
    @Resource(name="jdbc/jspdemosql")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException{
        super.init();

        try {
            studentDbUtil = new StudentDbUtil(dataSource);
        }catch (Exception exc){
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null){
                theCommand = "list";
            }
            switch (theCommand){
                case "ADD":
                    addStudent(request, response);
                    break;
                case "LOAD":
                    loadStudent(request, response);
                    break;
                case "UPDATE":
                    updateStudent(request, response);
                    break;
                case "DELETE":
                    deleteStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
            }
        }
        catch (Exception exc){
            throw new ServletException(exc);
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Student> students = studentDbUtil.getStudents();

        request.setAttribute("STUDENT_LIST", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-students.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theStudentId = request.getParameter("studentId");

        studentDbUtil.deleteStudent(theStudentId);

        listStudents(request, response);
    }

    public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String img = request.getParameter("img");


        Student theStudent = new Student(id, firstName, lastName, email,img);

        studentDbUtil.updateStudent(theStudent);
        listStudents(request, response);
    }

    public void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theStudentId = request.getParameter("studentId");

        Student theStudent = studentDbUtil.getStudent(theStudentId);

        request.setAttribute("THE_STUDENT", theStudent);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Lấy thông tin học sinh từ request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String img = request.getParameter("img");
        // Đọc dữ liệu hình ảnh từ request
//        Part imagePart = request.getPart("image");
//        InputStream imageInputStream = imagePart.getInputStream();
//        byte[] imageData = IOUtils.toByteArray(imageInputStream);

        // Tạo đối tượng Student với thông tin và dữ liệu hình ảnh vừa lấy
        Student student = new Student(firstName, lastName, email,img);
//        student.setImage(imageData);

        // Gọi phương thức addStudent trong StudentDbUtil để thêm học sinh vào cơ sở dữ liệu
        studentDbUtil.addStudent(student);

        // Chuyển hướng về trang danh sách học sinh sau khi thêm thành công
        response.sendRedirect(request.getContextPath() + "/StudentControllerServlet");
    }

}