import com.mysql.jdbc.Driver;
import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Landing implements Action {
	@Override
	public String execute() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write("Hello! Jenison!");
		String name=request.getParameter("name");
		Integer age=Integer.parseInt(request.getParameter("age"));

		if(name!=null && age!=null) {
			System.out.println("wrote1");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simon20120#");
			if (connection == null) {
				System.out.print("connection null");
			} else {
				System.out.print("connection not null");
			}
			Statement statement = connection.createStatement();
			System.out.println("wrote3");
			String query="INSERT INTO jenison (name,age) VALUES "+"('"+name+"',"+age+")";
			System.out.println("wrote4");
			long l = statement.executeLargeUpdate(query);
			System.out.println("wrote"+" "+l);
		}else {
			System.out.println("wrote2"+name+" "+age);
		}
		return "success";
	}
}
