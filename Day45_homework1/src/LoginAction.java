import com.bean.Employee;
import com.hibernate.EmployeeDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginAction extends ActionSupport implements ModelDriven<Employee> {
    EmployeeDao employeeDao = new EmployeeDao();
    private  String username;
    private  String password;
    private  Employee employee;
    private Employee employee1=new Employee();

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(){
        System.out.println(username);
        System.out.println(password);

        if (!username.equals("zhangSan")){
            return "login";
        }
        if (!password.equals("123")){
            return "login";
        }
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("username",username);
        return SUCCESS;
    }


    public String queryAll(){
        List<Employee> query = employeeDao.query();
//        System.out.println(query);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("employee",query);
//        ActionContext.getContext().put("employee",query);
        return SUCCESS;
    }

    public String amend(){
        employeeDao.amend(employee1);
        return SUCCESS;
    }

    public String add(){
        employeeDao.add(employee);
        return SUCCESS;
    }


    public String find(){
        String texts = ServletActionContext.getRequest().getParameter("texts");
        Employee employee = employeeDao.find(Integer.parseInt(texts));
        ActionContext.getContext().put("find",employee);
        return SUCCESS;

    }

    @Override
    public Employee getModel() {
        return employee;
    }
}
