import com.mysql.jdbc.Driver;
import com.opensymphony.xwork2.Action;

public class Landing implements Action {
	@Override
	public String execute() throws Exception {
		Driver driver = new Driver();
		return "success";
	}
}
