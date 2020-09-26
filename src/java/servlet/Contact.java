
package servlet;

import entity.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


@WebServlet(name = "Contact", urlPatterns = {"/contact"})
public class Contact extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String formName = request.getParameter("name");
        String formEmail = request.getParameter("email");
        String formSubject = request.getParameter("subject");
        String formMessage = request.getParameter("message");
        
        
        if ("".equals(formName) || "".equals(formEmail) || "".equals(formSubject) || "".equals(formMessage)){
            RequestDispatcher rd = request.getRequestDispatcher("errorPage.html");
            rd.forward(request, response);

        } else {

            User u = new User();
            u.setUserName(formName);
            u.setUserEmail(formEmail);
            u.setUserSubject(formSubject);
            u.setUserMessage(formMessage);

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            s.save(u);
            tr.commit();

            RequestDispatcher rd = request.getRequestDispatcher("contact.html");
            rd.forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
