package rzk;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CardServlet
 */
@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @EJB CardsBeanRemote cbr;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String posiljalac=request.getParameter("posiljalac");
		String primalac=request.getParameter("primalac");
		String email=request.getParameter("email");
		String type=request.getParameter("tip");
		
		if(cbr == null)
			System.out.println("null je");
		else
			System.out.println("nije");
		
		System.out.println(posiljalac);
		System.out.println(primalac);
		System.out.println(email);
		System.out.println(type);
		
		
		cbr.sendQueueMessage(posiljalac, primalac, email,type);
		
		request.getRequestDispatcher("card.jsp").forward(request, response);
		
	}

}
