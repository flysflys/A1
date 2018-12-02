package A3;
import java.io.*;

public class App {
	Utl utl=new Utl();
	Player[] players=new Player[3];
	int humanPlayers=0,aiPlayers=0;
	int[] totolCards=new int[30];

	int numberOfPlayers=0;
	String path="C:\\Users\\michael\\eclipse-workspace\\A3\\src\\A3\\input.txt";
	public void setNumberOfPlayers(int i,int p)
	{		
		numberOfPlayers=i;
		humanPlayers=i-p;
		aiPlayers=p;
		if(aiPlayers==3)
		{
			players[0]=new AI();
			players[1]=new AI();
			players[2]=new AI();
		}
		if(aiPlayers==2)
		{
			players[0]=new Human();
			players[1]=new AI();
			players[2]=new AI();
		}
		if(aiPlayers==1)
		{
			players[0]=new Human();
			players[1]=new Human();
			players[2]=new AI();
		}
		if(aiPlayers==0)
		{
			players[0]=new Human();
			players[1]=new Human();
			players[2]=new Human();
		}

	}
	
	public void readFile()
	{
		
		File file = new File(path);  
		
		String str; 
		try
		{
					
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			str = br.readLine();
			
			br.close();
			//System.out.println("reading done!  "+str);
			String[] tempAry=str.split("\\s+");
			String[] tempAry1=new String[5];
			String[] tempAry2=new String[5];
			String[] tempAry3=new String[5];
			String[] tempAry4=new String[5];
			String[] tempAry5=new String[5];
			String[] tempAry6=new String[5];
			for(int i =0;i<5;i++)
			{				
				tempAry1[i]=tempAry[i];
			}

			for(int i =0;i<5;i++)
			{
				tempAry2[i]=tempAry[i+5];
			}
			for(int i =0;i<5;i++)
			{
				tempAry3[i]=tempAry[i+10];
			}
			
			//System.out.println("reading done!  "+players[0].toString());
			players[0].giveCard(tempAry1);
			players[1].giveCard(tempAry2);
			players[2].giveCard(tempAry3);
			//System.out.println("reading done!!!!!!  ");
			for(int i =0;i<5;i++)
			{				
				tempAry4[i]=tempAry[i+15];
			}

			for(int i =0;i<5;i++)
			{
				tempAry5[i]=tempAry[i+20];
			}
			for(int i =0;i<5;i++)
			{
				tempAry6[i]=tempAry[i+25];
			}
			players[0].giveExtraCard(tempAry4);
			players[1].giveExtraCard(tempAry5);
			players[2].giveExtraCard(tempAry6);

		}
		catch (Exception e)
		{
			System.out.println("ERROR!!!!!"+e.toString());
		}
	}
	public String[] getPlayerHands(int p)
	{
		
		return players[p].getCardsStrAry();
	}
	public int getWinner()
	{
		int temp=winner(0,1);
		return winner(temp,2);
	}
	public int winner(int i,int i2)
	{
		Hands card1=utl.getHands(players[i].getCards());
		Hands card2=utl.getHands(players[i2].getCards());
		int result;
		//System.out.println("AIP has a "+aipC.toString()+", OPPONENT has a " +opC.toString() );
		if(card1.compareTo(card2)<0)
		{
			//System.out.println("AIP wins!");
			return 1;
		}
		if(card1.compareTo(card2)>0)
		{
			//System.out.println("opponent wins!");
			return 2;
		}
		
		if(card1==Hands.RF)
		{
			//System.out.println("both have RF, comparing the Suit");
			result=compareResult(utl.getSuit(players[i].getCards()[0]),utl.getSuit(players[i2].getCards()[0]));
			if(result==0)				
				System.out.println("ERROR");
			return result;
		}
		
		if(card1==Hands.SF)
		{
			//System.out.println("both have SF, comparing the highest Card");
			int p1HighC=utl.isStraight(players[i].getCardsCount()),p2HighC=utl.isStraight(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);
			if(result==0)
			{
				//System.out.println("both have same highest card, comparing the Suit");
				result=compareResult(utl.getSuit(players[i].getCards()[0]),utl.getSuit(players[i2].getCards()[0]));
			}
			if(result==0)
				System.out.println("ERROR");
			return result;

		}
		if(card1==Hands.FOAK)
		{
			//System.out.println("both have a four of a kind, comparing the highest Card");
			int p1HighC=utl.isFOAK(players[i].getCardsCount()),p2HighC=utl.isFOAK(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);
			if(result==0)
				System.out.println("Tie!");
			return result;
			
		}
		if(card1==Hands.FH)
		{
			//System.out.println("both have a FH, comparing the highest Card");
			int p1HighC=utl.isFH(players[i].getCardsCount()),p2HighC=utl.isFH(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);
			if(result==0)
				System.out.println("Tie!");
			return result;
		}
		if(card1==Hands.FLUSH)
		{
			//System.out.println("both have a FLUSH, comparing the highest Card");

			int p1HighC=utl.getHigh(players[i].getCardsCount()),p2HighC=utl.getHigh(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);

			if(result==0)
			{
				System.out.println("both have same highest card, comparing the Suit");
				result=compareResult(utl.getSuit(players[i].getCards()[0]),utl.getSuit(players[i2].getCards()[0]));
			}
			if(result==0)
				System.out.println("Tie!");
			return result;
		}
		if(card1==Hands.STRAIGHT)
		{
			//System.out.println("both have a STRAIGHT, comparing the highest Card");

			int p1HighC=utl.getHigh(players[i].getCardsCount()),p2HighC=utl.getHigh(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);

			if(result==0)
			{
				//System.out.println("both have same highest card, comparing the Suit of highest card");
				//System.out.println(getHighCardIndex(aipHighC)+"  "+getStringOfCard(opCards[getHighCardIndex(opHighC)]));
				//System.out.println(getHighCardIndexOP(opHighC));				
				result=compareResult(utl.getSuit(players[i].getCards()[utl.getHighCardIndex(p1HighC,players[i].getCards())])
						,utl.getSuit(players[i2].getCards()[utl.getHighCardIndex(p2HighC,players[i2].getCards())]));
			}
			if(result==0)
				System.out.println("Tie!");
			return result;
		}
		if(card1==Hands.TOAK)
		{
			//System.out.println("both have a three of a kind, comparing the highest Card");
			
			int p1HighC=utl.isTOAK(players[i].getCardsCount()),p2HighC=utl.isTOAK(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);
			
			if(result==0)
				System.out.println("Tie!");
			return result;
		}
		if(card1==Hands.TP)
		{
			//System.out.println("both have a two pairs, comparing the highest Card");
			
			int p1HighC=utl.isTP(players[i].getCardsCount()),p2HighC=utl.isTP(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);

			if(result==0)
			{
				//System.out.println("both have same highest cards, comparing the suit");
				int suit=0,suit2=0;
				for(int x=0;x<5;x++)
				{
					if(players[i].getCards()[x]%13==p1HighC)
					{
						suit=utl.getSuit(players[i].getCards()[x]);
					}
				}
				for(int x=0;x<5;x++)
				{
					if(players[i2].getCards()[x]%13==p2HighC)
					{
						suit2=utl.getSuit(players[i2].getCards()[x]);
					}
				}
				result=compareResult(suit,suit2);
			}
			if(result==0)
				System.out.println("Tie!");
			return result;
		}
		if(card1==Hands.PAIR)
		{
			//System.out.println("both have a pair, comparing the highest Card");

			int p1HighC=utl.isPair(players[i].getCardsCount()),p2HighC=utl.isPair(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);

			if(result==0)
			{
				//System.out.println("both have same highest cards, comparing the suit");
				int suit=0,suit2=0;
				for(int x=0;x<5;x++)
				{
					if(players[i].getCards()[x]%13==p1HighC)
					{
						suit=utl.getSuit(players[i].getCards()[x]);
					}
				}
				for(int x=0;x<5;x++)
				{
					if(players[i2].getCards()[x]%13==p2HighC)
					{
						suit2=utl.getSuit(players[i2].getCards()[x]);
					}
				}
				result=compareResult(suit,suit2);
			}
			if(result==0)
				System.out.println("Tie!");
			return result;
		}
		if(card1==Hands.NONE)
		{
			//System.out.println("both have no hands, comparing the highest Card");

			int p1HighC=utl.getHigh(players[i].getCardsCount()),p2HighC=utl.getHigh(players[i2].getCardsCount());
			result=compareResult(p1HighC,p2HighC);

			if(result==0)
			{
				//System.out.println("both have same highest cards, comparing the suit");
				result=compareResult(players[i].getCards()[4],players[i2].getCards()[4]);
			}
			if(result==0)
				System.out.println("Tie!");
			return result;
		}
		
		System.out.println("error");
		return 0;
	}

	public int compareResult(int p1,int p2)
	{
		if(p1>p2)
		{
			//System.out.println("AIP wins!");
			return 1;
		}
		if(p1<p2)
		{
			//System.out.println("opponent wins!");
			return 2;
		}
		return 0;
	}
	
	public void redraw(String str,int p)
	{
		if(str.length()==0)
			return;
		if(str.length()==1)
		{
			players[p].redraw(new int[] {Integer.parseInt(str)});
			return;
		}
		String[] temp=str.split("");
		int [] tempInt=new int [temp.length];
		
		for(int i=0;i<temp.length;i++)
		{
			tempInt[i]=Integer.parseInt(temp[i]);
		}
		players[p].redraw(tempInt);
	}
	public Player getPlayer(int i)
	{return players[i];}
	public int getPlayerNumber()
	{
		return numberOfPlayers;
	}
	public String getBeforeCards(int p)
	{
		return players[p].getBeforeCards();
	}
	public String getAfterCards(int p)
	{
		return players[p].getAfterCards();
	}
	public String[] getAIredrawNum(int i)
	{

		if(i==1)
		{
			players[2].exchange();
			return new String[] {players[2].getredrawNum()};
		}
		if(i==2)
		{
			players[1].exchange();
			players[2].exchange();
			return new String[] {players[1].getredrawNum(),players[2].getredrawNum()};
			
		}
		if(i==3)
		{
			players[1].exchange();
			players[2].exchange();
			players[0].exchange();
			return new String[] {players[0].getredrawNum(),players[1].getredrawNum(),players[2].getredrawNum()};
		}
		
		return null;
	}
}
