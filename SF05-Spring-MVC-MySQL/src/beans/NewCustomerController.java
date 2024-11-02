package beans;


//mysql :
//create table customer_mvc(cid int primary key,cname char(100),emil char(100),mobile char(20));

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class NewCustomerController implements Controller {
	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	  // @RequestMapping("/nc.htm")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		int cid = jt.queryForInt("SELECT MAX(CID) FROM CUSTOMER_MVC");
	
		String cname = req.getParameter("cname").trim();
		String email = req.getParameter("email").trim();
		String mobile = req.getParameter("mobile").trim();
		// Primary key increment
		cid++;
	jt.execute("INSERT INTO CUSTOMER_MVC VALUES(" + cid + ",'" + cname + "','" + email + "','" + mobile + "')");
		
		return new ModelAndView("/Success.jsp", "cid", new Integer(cid));
	}
}
