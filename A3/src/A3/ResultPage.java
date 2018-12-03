package A3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultPage
 */
@WebServlet("/Result")
public class ResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private App app=new App();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String p1Redraw,p2Redraw,p3Redraw;
		
		String numOfPlayersStr=request.getParameter("Players");
		int numOfPlayers;
		String numOfAIStr=request.getParameter("AI");
		int numOfAI;		
		numOfAI=Integer.parseInt(numOfAIStr);
		numOfPlayers=Integer.parseInt(numOfPlayersStr);	
		
		app.setNumberOfPlayers(numOfPlayers,numOfAI);
		app.readFile();
		//if(request.getParameter("Ai1cards")!=null)
		
		
		
		out.println("<html><body>");
		out.println("");
		
		if(numOfAI>0)
		{
			if(request.getParameter("Ai3cards").compareTo("null")!=0)
			{
				p3Redraw=request.getParameter("Ai3cards");
				out.println("Players3(AI) redraw the "+p3Redraw+" cards."+"<br>");
				app.redraw(p3Redraw, 2);
				out.println("before: "+app.getBeforeCards(2));
				out.println("<br>");
				out.println("after: "+app.getAfterCards(2));
				out.println("<br>");
			}
			else
			{
				p3Redraw="";
				out.println("Players3(AI) does not redraw any cards"+"<br>");
				out.println("after: "+app.getAfterCards(2));
				out.println("<br>");
			}
		}
		if(numOfAI>1)
		{
			if(request.getParameter("Ai2cards").compareTo("null")!=0)
			{
				p2Redraw=request.getParameter("Ai2cards");
				out.println("Players2(AI) redraw the "+p2Redraw+" cards"+"<br>");
				app.redraw(p2Redraw, 1);
				out.println("before: "+app.getBeforeCards(1));
				out.println("<br>");
				out.println("before: "+app.getAfterCards(1));
				out.println("<br>");
			}
			else
			{
				p2Redraw="";
				out.println("Players2(AI) does not redraw any cards"+"<br>");
				out.println("after: "+app.getAfterCards(1));
				out.println("<br>");
			}
		}
		if(numOfAI>2)
		{
			if(request.getParameter("Ai1cards").compareTo("null")!=0)
			{
				p1Redraw=request.getParameter("Ai1cards");
				out.println("Players1(AI) redraw the "+p1Redraw+" cards"+"<br>");
				app.redraw(p1Redraw, 0);
				out.println("before: "+app.getBeforeCards(0));
				out.println("<br>");
				out.println("before: "+app.getAfterCards(0));
				out.println("<br>");
			}
			else
			{
				p1Redraw="";
				out.println("Players1(AI) does not redraw any cards"+"<br>");
				out.println("after: "+app.getAfterCards(0));
				out.println("<br>");
			}
		}
		
		if(numOfPlayers-numOfAI>0)
		{
			humanRedraw(1,request,out);
		}
		if(numOfPlayers-numOfAI>1)
		{
			humanRedraw(2,request,out);
		}
		if(numOfPlayers-numOfAI>2)
		{
			humanRedraw(3,request,out);
		}
		
		out.println("<h4 id=\"p1Hand\">Player1 has a "+app.getPlayer(0).getHands()+"</h4><br>");
		out.println("<h4 id=\"p2Hand\">Player2 has a "+app.getPlayer(1).getHands()+"</h4><br>");
		out.println("<h4 id=\"p3Hand\">Player3 has a "+app.getPlayer(2).getHands()+"</h4><br>");
		
		out.println("<h2 id=\"Winner\">The Winner is Player"+app.getWinner()+"</h4><br>");
		
		out.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void humanRedraw(int x,HttpServletRequest request,PrintWriter out)
	{
		String p="";
		String card1="card1",card2="card2",card3="card3",card4="card4",card5="card5";
		if(x==1)
			p="p1";
		else if (x==2)
			p="p2";
		else if (x==3)
			p="p3";
		
		String redrawCard="";
		out.print("Players"+x+" redraw the ");
		if(request.getParameter(p+card1)!=null)
		{
			out.print(" 1");
			redrawCard+="1";
		}
		if(request.getParameter(p+card2)!=null)
		{
			out.print(" 2");
			redrawCard+="2";
		}
		if(request.getParameter(p+card3)!=null)
		{
			out.print(" 3");
			redrawCard+="3";
		}
		if(request.getParameter(p+card4)!=null)
		{
			out.print(" 4");
			redrawCard+="4";
		}
		if(request.getParameter(p+card5)!=null)
		{
			out.print(" 5");
			redrawCard+="5";
		}
		out.println(" cards"+"<br>");
		
		app.redraw(redrawCard, x-1);
		
		out.println("before: "+app.getBeforeCards(x-1));
		out.println("<br>");
		out.println("before: "+app.getAfterCards(x-1));
		out.println("<br>");
		
	}

}
