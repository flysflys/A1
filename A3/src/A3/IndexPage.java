package A3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class IndexPage
 */
@WebServlet("/SecondPage")
public class IndexPage extends HttpServlet {
	App app;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public IndexPage() {
        super();
        app=new App();
        // TODO Auto-generated constructor stub
        
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String numOfPlayersStr=request.getParameter("numOfPlayer");
		int numOfPlayers;
		String numOfAIStr=request.getParameter("numOfAI");
		int numOfAI;
		try
		{
			numOfAI=Integer.parseInt(numOfAIStr);
			numOfPlayers=Integer.parseInt(numOfPlayersStr);
			if(!(numOfPlayers==2||numOfPlayers==3))
			{
				htmlStart(out);
				out.println("Error! please enter a number that is 2 or 3!");
				htmlEnd(out);
				return;
			}
			if(numOfAI>numOfPlayers||numOfAI<0)
			{
				htmlStart(out);
				out.println("Error! please enter correct AI number!");
				htmlEnd(out);
				return;
			}

		} 
		catch (NumberFormatException ex)
		{
			htmlStart(out);
			out.println("Error! please enter a number!");
			htmlEnd(out);
			return;
		}
		if(numOfPlayers==3)
		{
			app.threePlayersGame();
		}
		app.setNumberOfPlayers(numOfPlayers);
		htmlStart(out);
		out.println("<h4 id=\"numP\">Players number: "+app.getPlayerNumber()+"</h4>");
		out.println("<h4 id=\"numAI\">AI number: "+numOfAI+"</h4>");
		out.println("<h3 id=\"hand\">you have a "+app.getHands(app.convertStringToInt(app.getPlayerHands(1)))+"</h3>");
		out.println("<h3>you have the cards below, click on the card you want to exchange and "
				+ "submit button");
		
		/*<form action="/result">
		 <input type="checkbox" name="card1" value="1"> S1<br>
		<input type="checkbox" name="card2" value="1"> S2<br>
		<input type="checkbox" name="card3" value="1" > S3<br>
		<input type="checkbox" name="card4" value="1" > S4<br>
		<input type="checkbox" name="card5" value="1" > S5<br>
		<input type="submit" value="Submit">
		</form>*/

		String[] temp=app.getPlayerHands(1);
		out.println("<form action=\"Result\">");
		out.println("<input type=\"checkbox\" name=\"card1\" value=\"1\"> "+temp[0]+"<br>");
		out.println("<input type=\"checkbox\" name=\"card2\" value=\"1\"> "+temp[1]+"<br>");
		out.println("<input type=\"checkbox\" name=\"card3\" value=\"1\" >"+temp[2]+"<br>");
		out.println("<input type=\"checkbox\" name=\"card4\" value=\"1\" >"+temp[3]+"<br>");
		out.println("<input type=\"checkbox\" name=\"card5\" value=\"1\" >"+temp[4]+"<br>");
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
		
		out.println("</html></body>");
		htmlEnd(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void htmlStart(PrintWriter out)
	{
		out.println("<html><body>");
	}
	private void htmlEnd(PrintWriter out)
	{
		out.println("</html></body>");
	}

}



