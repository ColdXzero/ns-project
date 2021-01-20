package Site;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ns_User;
import model.Ns_User_Contacts;

/**
 * Servlet implementation class SignInUser
 */
@WebServlet("/SignInUser")
public class SignInUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInUser() {
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

		String val = request.getParameter("signin");

		if(val.equals("signin")){
		String UserName=request.getParameter("username");
		String Password=request.getParameter("pwd1");


		Ns_User user=UserManagement.ManageUsers.Login(UserName.toUpperCase(), Password);
		if(user!=null && user.ID>0){
		request.getSession().setAttribute("logged", "Logged"); 
		request.getSession().setAttribute("user_type",user.User_Type);
		request.getSession().setAttribute("user", user);
		 PrintWriter wr= response.getWriter();
		 wr.write("<script>alert('Log in Succeed!');window.location.replace('default.jsp');</script>");
	}
		else {
			 PrintWriter wr= response.getWriter();
			 wr.write("<script>alert('Log in Failed!');window.location.replace('default.jsp');</script>");
		}
		
		}
		else if(val.equals("signup")){	
			Ns_User user= new Ns_User();
			user.User_Name=request.getParameter("name");
			user.User_Password=request.getParameter("pwd");
			user.User_Type=request.getParameter("user_type").toUpperCase();
			
			
			Ns_User_Contacts main_mail = new Ns_User_Contacts();
			main_mail.OrderId=1;
			main_mail.Contact_Type="email";
			main_mail.Contact_Val=request.getParameter("email");
			main_mail.Status="TRUE";
			user.Contacts.add(main_mail);
			
			user=UserManagement.ManageUsers.AddUser(user);	
if(user!=null ){
			PrintWriter wr= response.getWriter();
			 wr.write("<script>alert('Signup Succeed!');window.location.replace('default.jsp');</script>");
}
else
{
	PrintWriter wr= response.getWriter();
	 wr.write("<script>alert('Signup Failed!');window.location.replace('default.jsp');</script>");

	}

		}
		
		
		}
	}


