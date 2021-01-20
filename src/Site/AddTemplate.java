package Site;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.C_Template;
import Notification_Management.Notification_manage;
import Template_management.Template_manage;
import model.NotTemplate;
import model.Ns_Notification;
import model.Ns_Template_Privillege;
import model.Ns_User;

/**
 * Servlet implementation class AddTemplate
 */
@WebServlet("/AddTemplates")
public class AddTemplate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTemplate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("edit_id"); 
	
		if(id!=null&&id.length()>0)
		{
			try{
			NotTemplate template = new NotTemplate();
			NotTemplate oldtemplate = new C_Template().GetByID(Integer.parseInt(id));
			Ns_User cur =((Ns_User)request.getSession().getAttribute("user"));
			template.Send_Way= request.getParameter("SendWay");
			template.Escalation=request.getParameter("not_escal")==null?"F":"T";
			if(request.getParameter("not_end_date").length()>0)
			{
				SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm");
				
				try {
					template.End_Date= ft.parse(request.getParameter("not_end_date").replace('T',' '));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			template.T_Fields=request.getParameter("fieldsnew");
			template.T_TEXT=request.getParameter("not_txt");
			template.Tittle=request.getParameter("not_title");
			template.Duration=request.getParameter("duration");
			template=	Template_manage.update_template(oldtemplate, template.Tittle, cur, template.T_Fields, template.T_TEXT, oldtemplate.Start_Date, template.End_Date, template.Send_Way, template.Escalation, template.Duration);
			
			if(template == null || template.ID<=0)
				response.getWriter().write("<script> alert('Edit Template Failed!')</script>");
			else
				response.getWriter().write("<script> alert('Edit Template Succeeded!')</script>");
			}
			catch (Exception ex){
				response.getWriter().write("<script> alert('Edit Template Failed!')</script>");

			}
		
		}
		else
		{
		
			try{
					
		NotTemplate template = new NotTemplate();
	Ns_User cur =((Ns_User)request.getSession().getAttribute("user"));
	template.Owner=cur.ID;
	template.Send_Way= request.getParameter("SendWay");
	template.Escalation=request.getParameter("not_escal")==null?"F":"T";

	if(request.getParameter("not_end_date").length()>0)
	{
		
		SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {
			template.End_Date= ft.parse(request.getParameter("not_end_date").replace('T',' '));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	if(request.getParameter("not_start_date").length()>0)
	{
		SimpleDateFormat ft= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try {
			template.Start_Date= ft.parse(request.getParameter("not_start_date").replace('T',' '));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	template.T_Fields=request.getParameter("fieldsnew");
	template.T_TEXT=request.getParameter("not_txt");
	template.Tittle=request.getParameter("not_title");
	template.Duration=request.getParameter("duration");
	template=	Template_manage.Add_template(template.Tittle, cur, template.T_Fields, template.T_TEXT, template.Start_Date, template.End_Date, template.Send_Way, template.Escalation, template.Duration);
	
	if(template == null || template.ID<=0)
		response.getWriter().write("<script> alert('Add Template Failed!')</script>");
	else
		response.getWriter().write("<script> alert('Add Template Succeeded!')</script>");

	
	
	}
	catch (Exception ex){
		response.getWriter().write("<script> alert('Add Template Failed!')</script>");

	}
	}
	response.sendRedirect("default.jsp");
	}

}
