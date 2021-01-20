package Site;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.C_Group;
import Controller.C_MemberShip;
import Group_Management.Group_manage;
import Group_Management.membership_manage;
import model.Ns_Group;
import model.Ns_MemberShip;
import model.Ns_User;

/**
 * Servlet implementation class group_request
 */
@WebServlet("/group_request")
public class group_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public group_request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String val = request.getParameter("req_type");
		String gid=request.getParameter("group_id");
		Ns_Group group= new C_Group().GetByID(Integer.parseInt(gid));
		Ns_User u=((Ns_User)request.getSession().getAttribute("user"));
     	
		if(val.equals("L")|| val.equals("C"))
		{
			
			membership_manage.unsubscripe_from_Group(group, u);
			
		}
		else if(val.equals("J"))
		{
				membership_manage.Request_join_to_Group(group, u);
			
		}
		response.sendRedirect("default.jsp");
		
		
	}

}
