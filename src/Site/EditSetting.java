package Site;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.C_Setting;
import model.Ns_Setting;

/**
 * Servlet implementation class EditSetting
 */
@WebServlet("/EditSetting")
public class EditSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSetting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("setting_id"));
		Ns_Setting setting = new C_Setting().GetByID(id);
		
		String set_val= request.getParameter("set_val"+id); 
		
		setting.Value=set_val;
		
		new C_Setting().update_setting(setting);
		
		response.sendRedirect("Setting.jsp");
	}

}
