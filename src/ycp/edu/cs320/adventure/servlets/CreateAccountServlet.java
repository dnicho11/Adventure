package ycp.edu.cs320.adventure.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.edu.cs320.adventure.database.FakeDatabase;

public class CreateAccountServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        System.out.println("CreateAccount Servlet: doGet");
        
        req.getRequestDispatcher("/_view/createAccount.jsp").forward(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        System.out.println("CreateAccount Servlet: doPost");
        String errorMessage = null;
        String successMessage = "Account created.";
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        FakeDatabase database = new FakeDatabase();
        int accountId = database.accountExists(username);
        
        // username and password match
        if(accountId >= 0) {
        	System.out.println(successMessage);
    		// redirect to /titleScreen page
        	resp.sendRedirect(req.getContextPath() + "/_view/index.jsp");
        	return;
        }
    }
        
}