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
		app.setNumberOfPlayers(numOfPlayers,numOfAI);
		app.readFile();
		
		
		htmlStart(out);
		out.println("<h4 id=\"numP\">Players number: "+app.getPlayerNumber()+"</h4>");
		out.println("<h4 id=\"numAI\">AI number: "+numOfAI+"</h4>");
		
		
		/*<form action="/result">
		 <input type="checkbox" name="card1" value="1"> S1<br>
		<input type="checkbox" name="card2" value="1"> S2<br>
		<input type="checkbox" name="card3" value="1" > S3<br>
		<input type="checkbox" name="card4" value="1" > S4<br>
		<input type="checkbox" name="card5" value="1" > S5<br>
		<input type="submit" value="Submit">
		</form>*/

		String[] temp=app.getPlayerHands(0);
		String[] temp2=app.getPlayerHands(1);
		String[] temp3=app.getPlayerHands(2);
		
		out.println("<form action=\"Result\">");
		
		if(numOfAI==3)
		{
			out.println("<h3>All 3 players are AI, just click submit to see the result.</h3>");
			out.println("<input type=\"hidden\" name=\"Ai1cards\" value=\""+temp3[4]+"\" >");
			out.println("<input type=\"hidden\" name=\"Ai2cards\" value=\""+temp3[4]+"\" >");
			out.println("<input type=\"hidden\" name=\"Ai3cards\" value=\""+temp3[4]+"\" >");
		}
		else
		{
		out.println("<h3>player1 has the cards below, click on the card you want to exchange</h3>");
		out.println("<h4 id=\"p1Hand\">you already have a "+app.getPlayer(0).getHands()+"</h4><br>");
		out.println("<input type=\"checkbox\" name=\"p1card1\" value=\"1\"> "+temp[0]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p1card2\" value=\"1\"> "+temp[1]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p1card3\" value=\"1\" >"+temp[2]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p1card4\" value=\"1\" >"+temp[3]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p1card5\" value=\"1\" >"+temp[4]+"<br>");
		}
		
		if(numOfAI==2)
		{
			out.println("<h3>Reset of 2 players are AI, just click submit to see the result.</h3>");
			
			out.println("<input type=\"hidden\" name=\"Ai2cards\" value=\""+temp3[4]+"\" >");
			out.println("<input type=\"hidden\" name=\"Ai3cards\" value=\""+temp3[4]+"\" >");
		}
		
		else if(numOfAI!=3)
		{
		out.println("<h3>player2 has the cards below, click on the card you want to exchange</h3>");
		out.println("<h4 id=\"p2Hand\">you already have a "+app.getPlayer(1).getHands()+"</h4><br>");
		out.println("<input type=\"checkbox\" name=\"p2card1\" value=\"1\"> "+temp2[0]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p2card2\" value=\"1\"> "+temp2[1]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p2card3\" value=\"1\" >"+temp2[2]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p2card4\" value=\"1\" >"+temp2[3]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p2card5\" value=\"1\" >"+temp2[4]+"<br>");
		}
		
		if(numOfAI==1)
		{
			out.println("<h3>The last player is AI, just click submit to see the result.</h3>");
			out.println("<input type=\"hidden\" name=\"Ai3cards\" value=\""+temp3[4]+"\" >");
		}
		if(numOfAI==0)
		{
		out.println("<h3>player3 has the cards below, click on the card you want to exchange</h3>");
		out.println("<h4 id=\"p3Hand\">you already have a "+app.getPlayer(2).getHands()+"</h4><br>");
		out.println("<input type=\"checkbox\" name=\"p3card1\" value=\"1\"> "+temp3[0]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p3card2\" value=\"1\"> "+temp3[1]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p3card3\" value=\"1\" >"+temp3[2]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p3card4\" value=\"1\" >"+temp3[3]+"<br>");
		out.println("<input type=\"checkbox\" name=\"p3card5\" value=\"1\" >"+temp3[4]+"<br>");
		}
		
		
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



