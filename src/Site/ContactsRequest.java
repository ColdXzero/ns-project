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
 * Servlet implementation class ContactsRequest
 */
@WebServlet("/ContactsRequest")
public class ContactsRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactsRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int con_id= Integer.parseInt(request.getParameter("con_id"));
	String con_status= request.getParameter("con_status");
	int order =Integer.parseInt(request.getParameter("con_order"));
	Ns_User user =(Ns_User) request.getSession().getAttribute("user");
	boolean res=false;
	for (Ns_User_Contacts x : user.Contacts) {
		if(x.ID==con_id)
		{
			x.OrderId=order;
			x.Status=con_status;
			if( new C_User_Contacts().updateWhere(x, "ID", x.ID)>0) {res=true ; break;}	
			
		}
	}
	
	response.getWriter().write(res==true?"Update Done":"Update Failed!");
	}

}
