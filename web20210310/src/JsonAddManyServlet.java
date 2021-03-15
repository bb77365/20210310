

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Student;
import java.sql.*;
/**
 * Servlet implementation class JsonAddManyServlet
 */
@WebServlet("/JsonAddManyServlet")
public class JsonAddManyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonAddManyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String js=request.getParameter("data");
		Student[] student = gson.fromJson(js, Student[].class);
		insert(student);
		request.setAttribute("sts", student);
		request.getRequestDispatcher("stuMany.jsp").forward(request, response);
	}
    boolean insert(Student[] sts) {
    	String sql="INSERT INTO coffeedb.student "
    			+ "(Name,Age)"
    			+ "VALUES";
    	for(int i=0;i<sts.length-1;i++) {
    		String n=sts[i].getName();
    		int a=sts[i].getAge();
    		sql +="('"+n+"' ,"+a+"),";
    	}
    	sql+="('"+sts[sts.length-1].getName()+"' ,"+sts[sts.length-1].getAge()+");";
    	String user="root";
    	String pass="1234";
    	String url="jdbc:mysql://localhost:3306/coffeedb";
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection cn=DriverManager.getConnection(url, user, pass);
    		Statement st=cn.createStatement();
    		int r=st.executeUpdate(sql);
    		if(r>0)
    			return true;
    		else
    			return false;
    	}catch(SQLException | ClassNotFoundException ex) {
    		System.out.println("SQL Error:"+ex.getMessage());
    	}
    	return false;
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
