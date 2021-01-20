package Site;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.C_User_Contacts;
import model.Ns_User;
import model.Ns_User_Contacts;

/**
 * Servlet implementation class ContactRequestAdd
 */
@WebServlet("/ContactRequestAdd")
public class ContactRequestAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactRequestAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		Ns_User user=(Ns_User) request.getSession().getAttribute("user");
		
		Ns_User_Contacts con= new Ns_User_Contacts();
		con.User_ID=user.ID;
		con.Contact_Type=request.getParameter("con_type_new");
		con.Contact_Val=request.getParameter("con_val_new");
		con.OrderId=Integer.parseInt(request.getParameter("con_order_new"));
		con.Status=request.getParameter("con_status_new");
		
		if(new C_User_Contacts().insert(con)>0)
		{
			response.getWriter().write("Contacts Added!");
		}
		else
		{
			response.getWriter().write("Add contacts failed!");
		}
		}
		catch(Exception es)
		{
			response.getWriter().write("Add contacts failed!");			
		}
		
	  
	}

}
