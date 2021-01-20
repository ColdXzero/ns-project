package Site;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NotTemplate;
import model.Ns_Template_Privillege;
import model.Ns_User;
import Controller.C_Template;
import Controller.C_User;
import Template_management.Template_manage;

/**
 * Servlet implementation class GrantAccess
 */
@WebServlet("/GrantAccess")
public class GrantAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrantAccess() {
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

		try
		{
			String tempid=request.getParameter("edit_id_sender"); 
			String senderid=request.getParameter("senders"); 
			Ns_User u = new C_User().GetByID(Integer.parseInt(senderid));
			NotTemplate t = new C_Template().GetByID(Integer.parseInt(tempid));
			
			Ns_Template_Privillege tp =Template_manage.grant_priviege_template(t, u);
			if(tp==null)
			{
				response.getWriter().write("<script> alert('Grant Access Failed!')</script>");
	
			}
			else
			{
				response.getWriter().write("<script> alert('Grant Access Succeeded!')</script>");

			}
		}
		catch(Exception ex)
		
		{
		}
		
		response.sendRedirect("Admin.jsp");
	
	
	}

}
