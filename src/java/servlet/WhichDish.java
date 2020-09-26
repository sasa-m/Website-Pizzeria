
package servlet;

import entity.Dish;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Session;


@WebServlet(name = "WhichDish", urlPatterns = {"/WhichDish"})
public class WhichDish extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int requestedId = 0;
        
        String name = "No meal selected";
        String description = "---";
        String picture = "";
        String price = "";
        
        String idParam = request.getParameter("id");
        
        if(idParam!=null) {
            
            try{ 
                requestedId = Integer.valueOf(idParam);
                
            }catch(Exception ex){} 
            
        }
        
        if(requestedId!=0) {
            Session s = HibernateUtil.getSessionFactory().openSession();
        
            Dish requested = (Dish) s.get(Dish.class, requestedId);
            
            if(requested!=null){ 
            name = requested.getName();
            description = requested.getDescription();
            picture = requested.getPicture();
            price = String.valueOf(requested.getPrice());
            }

            s.close();            
        }

        request.setAttribute("name", name);
        request.setAttribute("description", description);
        request.setAttribute("picture", picture);
        request.setAttribute("price", price);
        
        RequestDispatcher disp = request.getRequestDispatcher("details.jsp");
        disp.forward(request, response);
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
