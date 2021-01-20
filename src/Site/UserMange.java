package Site;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserManagement.ManageUsers;
import Controller.C_User;
import model.Ns_User;

/**
 * Servlet implementation class UserMange
 */
@WebServlet("/UserMange")
public class UserMange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMange() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String confirm_id = request.getParameter("user_confirm_id");
		String user_id =request.getParameter("user_id");
		String send_rate=request.getParameter("usr_val"+user_id);
		if(confirm_id.length()>0)
		{
		Ns_User user= new C_User().GetByID(Integer.parseInt(confirm_id));
		ManageUsers.UpdateAccountStatus(user, "TRUE");
		}
		else
			if(user_id.length()>0){
				Ns_User user= new C_User().GetByID(Integer.parseInt(user_id));
				user.Send_rate=send_rate;
				new C_User().update(user, " ID ="+user.ID);
			}
	
		response.sendRedirect("ManageUsers.jsp");
	}

}
