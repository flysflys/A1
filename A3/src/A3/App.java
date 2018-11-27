package A3;
import java.io.*;

public class App {
	String[] p1Cards;
	String[] p2Cards;
	String[] p3Cards;
	Human human=new Human();
	int[] opCards=new int[] {0,0,0,0,0};
	int[] opCardsNum=new int[13];
	int[] aipCards=new int[] {0,0,0,0,0};
	int[] aipCardsNum=new int[13];
	int[] extraCards=null;
	String[] games=null;
	int gameCount=0;
	int numberOfPlayers=0;
	String path="C:\\Users\\michael\\eclipse-workspace\\A3\\src\\A3\\input.txt";
	public App()
	{				
	}
	public void setNumberOfPlayers(int i)
	{		
		numberOfPlayers=i;
	}
	public void readFile()
	{
		File file = new File(path);  
		
		String str; 
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while (reader.readLine() != null) lines++;
			reader.close();
			System.out.println("file contain "+lines+" games");
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			str = br.readLine();
			games=new String[lines];
			int j=0;
			while(str!=null)
			{
				games[j]=str;
				str = br.readLine();
				j++;
			}
			br.close();
		}
		catch (Exception e)
		{
			System.out.print("ERROR!");
		}
	}
	public void newGame()
	{
		String[] tempAry=games[gameCount].split("\\s+");
		String[] tempAry1=new String[5];
		String[] tempAry2=new String[5];
		String[] tempAry3=null;
		System.out.print("AIP has ");
		for(int i =0;i<5;i++)
		{
			System.out.print(tempAry[i]+ " ");
			tempAry1[i]=tempAry[i];
		}
		System.out.println();
		System.out.print("OP has ");
		for(int i =0;i<5;i++)
		{
			System.out.print(tempAry[i+5]+ " ");
			tempAry2[i]=tempAry[i+5];
		}
		System.out.println();
		if(tempAry.length>10)
		{
			tempAry3=new String[tempAry.length-10];
			for(int i =0;i<tempAry3.length;i++)
			{
				tempAry3[i]=tempAry[i+10];
			}
			extraCards=convertStringToInt(tempAry3);
		}
			
	
		opCards=convertStringToInt(tempAry2);
		opCardsNum=countNum(opCards);
		aipCards=convertStringToInt(tempAry1);
		aipCardsNum=countNum(aipCards);
		sortAIPCards();
		gameCount++;
	}
	public void threePlayersGame()
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
			String[] tempAry4=null;
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

			if(tempAry.length>15)
			{
				tempAry4=new String[tempAry.length-15];
				for(int i =0;i<tempAry3.length;i++)
				{
					tempAry4[i]=tempAry[i+10];
				}
				extraCards=convertStringToInt(tempAry4);
			}
			p1Cards=tempAry1;
			p2Cards=tempAry2;
			p3Cards=tempAry3;
			//human.giveCards(tempAry1);
			/*opCards=convertStringToInt(tempAry2);
			opCardsNum=countNum(opCards);
			aipCards=convertStringToInt(tempAry1);
			aipCardsNum=countNum(aipCards);
			sortAIPCards();
			gameCount++;*/

		}
		catch (Exception e)
		{
			System.out.print("ERROR!");
		}
	}
	public String[] getPlayerHands(int p)
	{
		if(p==1)
			return p1Cards;
		if(p==2)
			return p2Cards;
		if(p==3)
			return p3Cards;
		return null;
	}
	public void aipHas()
	{
		System.out.println( "AI has a "+getHands().name());
	}
	public void input(String str)
	{
		String[] tempAry=null;
		String[] tempAry1=new String[5];
		String[] tempAry3=null;
		tempAry=str.split("\\s+");
		System.out.print("AIP has ");
		
		for(int i =0;i<5;i++)
		{
			System.out.print(tempAry[i]+ " ");
			tempAry1[i]=tempAry[i];
		}
		System.out.println();
		System.out.print("extra cards are ");
		if(tempAry.length>5)
		{
			tempAry3=new String[tempAry.length-5];
			for(int i =0;i<tempAry3.length;i++)
			{
				tempAry3[i]=tempAry[i+5];
				System.out.print(tempAry3[i]+ " ");
			}
			extraCards=convertStringToInt(tempAry3);
		}
		else 
			System.out.print("none");
		System.out.println();
		
		aipCards=convertStringToInt(tempAry1);
		aipCardsNum=countNum(aipCards);
		sortAIPCards();
	}
	public void inputOP(String str)
	{
		String[] tempAry=null;
		String[] tempAry1=new String[5];
		String[] tempAry2=new String[5];
		String[] tempAry3=null;
		tempAry=str.split("\\s+");
		System.out.print("AIP has ");
		
		for(int i =0;i<5;i++)
		{
			System.out.print(tempAry[i]+ " ");
			tempAry1[i]=tempAry[i];
		}
		System.out.println();
		
		System.out.print("OP has ");
		for(int i =0;i<5;i++)
		{
			System.out.print(tempAry[i+5]+ " ");
			tempAry2[i]=tempAry[i+5];
		}
		System.out.println();
		
		System.out.print("extra cards are ");
		if(tempAry.length>10)
		{
			tempAry3=new String[tempAry.length-10];
			for(int i =0;i<tempAry3.length;i++)
			{
				tempAry3[i]=tempAry[i+10];
				System.out.print(tempAry3[i]+ " ");
			}
			extraCards=convertStringToInt(tempAry3);
		}
		else
			System.out.print("none");
		System.out.println();
		
		aipCards=convertStringToInt(tempAry1);
		aipCardsNum=countNum(aipCards);
		opCards=convertStringToInt(tempAry2);
		opCardsNum=countNum(opCards);
		sortAIPCards();
	}
	
	public Winner winner()
	{
		Hands aipC=getHands(), opC=getOpHands();
		Winner result;
		System.out.println("AIP has a "+aipC.toString()+", OPPONENT has a " +opC.toString() );
		if(aipC.compareTo(opC)<0)
		{
			System.out.println("AIP wins!");
			return Winner.AIP;
		}
		if(aipC.compareTo(opC)>0)
		{
			System.out.println("opponent wins!");
			return Winner.OPPONENT;
		}
		
		if(aipC==Hands.RF)
		{
			System.out.println("both have RF, comparing the Suit");
			result=compareResult(getSuit(aipCards[0]),getSuit(opCards[0]));
			if(result==Winner.TIE)				
				System.out.println("ERROR");
			return result;
		}
		
		if(aipC==Hands.SF)
		{
			System.out.println("both have SF, comparing the highest Card");
			int aipHighC=isStraight(aipCardsNum),opHighC=isStraight(opCardsNum);
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
			{
				System.out.println("both have same highest card, comparing the Suit");
				result=compareResult(getSuit(aipCards[0]),getSuit(opCards[0]));
			}
			if(result==Winner.TIE)
				System.out.println("ERROR");
			return result;

		}
		if(aipC==Hands.FOAK)
		{
			System.out.println("both have a four of a kind, comparing the highest Card");
			int aipHighC=isFOAK(aipCardsNum),opHighC=isFOAK(opCardsNum);
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
				System.out.println("Tie!");
			return result;
			
		}
		if(aipC==Hands.FH)
		{
			System.out.println("both have a FH, comparing the highest Card");
			int aipHighC=isFH(aipCardsNum),opHighC=isFH(opCardsNum);
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
				System.out.println("Tie!");
			return result;
		}
		if(aipC==Hands.FLUSH)
		{
			System.out.println("both have a FLUSH, comparing the highest Card");
			int aipHighC=getHigh(aipCardsNum),opHighC=getHigh(opCardsNum);			
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
			{
				System.out.println("both have same highest card, comparing the Suit");
				result=compareResult(getSuit(aipCards[0]),getSuit(opCards[0]));
			}
			if(result==Winner.TIE)
				System.out.println("Tie!");
			return result;
		}
		if(aipC==Hands.STRAIGHT)
		{
			System.out.println("both have a STRAIGHT, comparing the highest Card");
			int aipHighC=getHigh(aipCardsNum),opHighC=getHigh(opCardsNum);			
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
			{
				System.out.println("both have same highest card, comparing the Suit of highest card");
				//System.out.println(getHighCardIndex(aipHighC)+"  "+getStringOfCard(opCards[getHighCardIndex(opHighC)]));
				//System.out.println(getHighCardIndexOP(opHighC));				
				result=compareResult(getSuit(aipCards[getHighCardIndex(aipHighC)])
						,getSuit(opCards[getHighCardIndexOP(opHighC)]));
			}
			if(result==Winner.TIE)
				System.out.println("Tie!");
			return result;
		}
		if(aipC==Hands.TOAK)
		{
			System.out.println("both have a three of a kind, comparing the highest Card");
			int aipHighC=isTOAK(aipCardsNum),opHighC=isTOAK(opCardsNum);
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
				System.out.println("Tie!");
			return result;
		}
		if(aipC==Hands.TP)
		{
			System.out.println("both have a two pairs, comparing the highest Card");
			int aipHighC=isTP(aipCardsNum),opHighC=isTP(opCardsNum);
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
			{
				System.out.println("both have same highest cards, comparing the suit");
				int suit=0,suit2=0;
				for(int i=0;i<5;i++)
				{
					if(aipCards[i]%13==aipHighC)
					{
						suit=getSuit(aipCards[i]);
					}
				}
				for(int i=0;i<5;i++)
				{
					if(opCards[i]%13==opHighC)
					{
						suit2=getSuit(opCards[i]);
					}
				}
				result=compareResult(suit,suit2);
			}
			if(result==Winner.TIE)
				System.out.println("Tie!");
			return result;
		}
		if(aipC==Hands.PAIR)
		{
			System.out.println("both have a pair, comparing the highest Card");
			int aipHighC=isPair(aipCardsNum),opHighC=isPair(opCardsNum);
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
			{
				System.out.println("both have same highest cards, comparing the suit");
				int suit=0,suit2=0;
				for(int i=0;i<5;i++)
				{
					if(aipCards[i]%13==aipHighC)
					{
						suit=getSuit(aipCards[i]);
					}
				}
				for(int i=0;i<5;i++)
				{
					if(opCards[i]%13==opHighC)
					{
						suit2=getSuit(opCards[i]);
					}
				}
				result=compareResult(suit,suit2);
			}
			if(result==Winner.TIE)
				System.out.println("Tie!");
			return result;
		}
		if(aipC==Hands.NONE)
		{
			System.out.println("both have no hands, comparing the highest Card");
			int aipHighC=getHigh(aipCardsNum),opHighC=getHigh(opCardsNum);
			result=compareResult(aipHighC,opHighC);
			if(result==Winner.TIE)
			{
				System.out.println("both have same highest cards, comparing the suit");
				result=compareResult(aipCards[4],opCards[4]);
			}
			if(result==Winner.TIE)
				System.out.println("Tie!");
			return result;
		}
		
		System.out.println("error");
		return Winner.TIE;
	}
	public Winner compareResult(int aip,int op)
	{
		if(aip>op)
		{
			System.out.println("AIP wins!");
			return Winner.AIP;
		}
		if(aip<op)
		{
			System.out.println("opponent wins!");
			return Winner.OPPONENT;
		}
		return Winner.TIE;
	}
	public int[] getOpCards()
	{
		
		return opCards;
		
	}
	public int[] getAIPCards()
	{
		
		return aipCards;
		
	}
	public void exchange()
	{
		Hands oldHands=getHands(); 
		if(oldHands==Hands.RF||oldHands==Hands.SF||oldHands==Hands.FH||oldHands==Hands.FOAK||oldHands==Hands.FLUSH||oldHands==Hands.STRAIGHT)
		{
			System.out.println("no need for exchange");
			return;
		}
		else if(cardsFromRF()!=-1)
		{
			System.out.println("1 card away from RF");
			int[] temp= {cardsFromRF()};
			redraw(temp);
			printAIPCards();
			
		}
		else if(cardsFromSF()!=-1)
		{
			System.out.println("1 card away from SF");
			int[] temp= {cardsFromSF()};
			redraw(temp);
			printAIPCards();
			
		}
		else if(cardsFromFOAK()!=-1)
		{
			System.out.println("1 card away from FH");
			int[] temp= {cardsFromFOAK()};
			redraw(temp);
			printAIPCards();
			
		}
		/*else if(cardsFromFH()!=-1)
		{
			System.out.println("1 card away from FH");
			int[] temp= {cardsFromFH()};
			redraw(temp);
			printAIPCards();
			
		}*/
		else if(cardsFromFLUSH()!=-1)
		{
			System.out.println("1 card away from FLUSH");
			int[] temp= {cardsFromFLUSH()};
			redraw(temp);
			printAIPCards();			
		}
		else if(cardsFromSTRAIGHT()!=-1)
		{
			System.out.println("1 card away from STRAIGHT");
			int[] temp= {cardsFromSTRAIGHT()};
			redraw(temp);
			printAIPCards();			
		}
		else if(cardsFromS7()!=null)
		{
			System.out.println("3 cards are in same suit, exchange other 2");
			int[] temp= cardsFromS7();
			redraw(temp);
			printAIPCards();			
		}
		else if(threeInSuits()!=null)
		{
			System.out.println("3 cards are in same rank, exchange other 2");
			int[] temp= threeInSuits();
			redraw(temp);
			printAIPCards();			
		}
		else if(cardsFromS8()!=null)
		{
			System.out.println("3 cards are in sequence, exchange other 2");
			int[] temp= cardsFromS8();
			redraw(temp);
			printAIPCards();			
		}
		else if(twoPair()!=-1)
		{
			System.out.println("2 pairs, exchange other card");
			int[] temp= new int[] {twoPair()};
			redraw(temp);
			printAIPCards();			
		}
		else if(cardsFromS9()!=null)
		{
			System.out.println("1 pair, exchange other 3");
			int[] temp= cardsFromS9();
			redraw(temp);
			printAIPCards();			
		}
		else
		{
			System.out.println("keep the highest 2, exchange other 3");
			int[] temp= cardsFromS10();
			redraw(temp);
			printAIPCards();	
		}
		
		
	}
	public Hands getHands(int[] pc)
	{
		int[] temp=countNum(pc);
		if(isSameSuit(pc)!=-1)
		{
			
			if(isRFlush(temp)==1)
			{
				
				return Hands.RF;
			}
			else if(isStraight(temp)!=-1)
			{
				return Hands.SF;
			}			
		}
		if(isFH(countNum(pc))!=-1)
		{
			return Hands.FH;
		}
		else if(isFOAK(temp)!=-1)
		{
			return Hands.FOAK;
		}
	
		else if(isSameSuit(pc)!=-1)
		{

			return Hands.FLUSH;
		}
		else if(isStraight(temp)!=-1)
		{
			return Hands.STRAIGHT;
		}
		else if(isTOAK(temp)!=-1)
		{
			return Hands.TOAK;
		}
		else if(isTP(temp)!=-1)
		{
			return Hands.TP;
		}
		else if(isPair(temp)!=-1)
		{
			return Hands.PAIR;
		}
		return Hands.NONE;
	}
	public Hands getHands()
	{
		if(isSameSuit(aipCards)!=-1)
		{
			
			if(isRFlush(aipCardsNum)==1)
			{
				
				return Hands.RF;
			}
			else if(isStraight(aipCardsNum)!=-1)
			{
				return Hands.SF;
			}			
		}
		if(isFH(aipCardsNum)!=-1)
		{
			return Hands.FH;
		}
		else if(isFOAK(aipCardsNum)!=-1)
		{
			return Hands.FOAK;
		}
	
		else if(isSameSuit(aipCards)!=-1)
		{

			return Hands.FLUSH;
		}
		else if(isStraight(aipCardsNum)!=-1)
		{
			return Hands.STRAIGHT;
		}
		else if(isTOAK(aipCardsNum)!=-1)
		{
			return Hands.TOAK;
		}
		else if(isTP(aipCardsNum)!=-1)
		{
			return Hands.TP;
		}
		else if(isPair(aipCardsNum)!=-1)
		{
			return Hands.PAIR;
		}
		return Hands.NONE;
	}
	public Hands getOpHands()
	{
		if(isSameSuit(opCards)!=-1)
		{
			
			if(isRFlush(opCardsNum)==1)
			{
				
				return Hands.RF;
			}
			else if(isStraight(opCardsNum)!=-1)
			{
				return Hands.SF;
			}			
		}
		if(isFH(opCardsNum)!=-1)
		{
			return Hands.FH;
		}
		else if(isFOAK(opCardsNum)!=-1)
		{
			return Hands.FOAK;
		}
	
		else if(isSameSuit(opCards)!=-1)
		{

			return Hands.FLUSH;
		}
		else if(isStraight(opCardsNum)!=-1)
		{
			return Hands.STRAIGHT;
		}
		else if(isTOAK(opCardsNum)!=-1)
		{
			return Hands.TOAK;
		}
		else if(isTP(opCardsNum)!=-1)
		{
			return Hands.TP;
		}
		else if(isPair(opCardsNum)!=-1)
		{
			return Hands.PAIR;
		}
		return Hands.NONE;
	}
	private void redraw(int [] cards)
	{
		for(int i =0;i<cards.length;i++)
		{
			System.out.println("discarding "+getStringOfCard(aipCards[cards[i]])+" card");
			
		}
		for(int i =0;i<cards.length;i++)
		{
			//System.out.println("discarding "+(i+1)+" card");
			aipCards[cards[i]]=extraCards[i];
			System.out.println("draw a "+getStringOfCard(extraCards[i]));
		}
		aipCardsNum=countNum(aipCards);
		sortAIPCards();
	}
	private int numOfSuit()
	{
		int[] suits=getSuitAry();
		
		int count=0;
		for(int i=0;i<4;i++)
		{
			if(suits[i]>=1)
			{
				count++;
			}
		}

		return count;
	}
	private int wrongSuitRF()
	{
		if(getSuit(aipCards[0])==getSuit(aipCards[1]))
		{
			for(int i=2;i<5;i++)
			{
				if(getSuit(aipCards[0])!=getSuit(aipCards[i]))
				{
					return i;
				}
			}
		}
		else
		{
			if(getSuit(aipCards[0])==getSuit(aipCards[2]))
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		return -1;			
	}
	private int wrongRankRF()
	{
		int count=0;
		for(int i=0;i<13;i++)
		{
			if(i!=0&&i!=9&&i!=10&&i!=11&&i!=12&&aipCardsNum[i]==1)
			{
				count++;
			}
		}
		if(count>=2)
			return -1;		
		count=0;
		for(int i=0;i<5;i++)
		{
			
			if(aipCards[i]%13!=1&&aipCards[i]%13!=10&&aipCards[i]%13!=11&&aipCards[i]%13!=12&&aipCards[i]%13!=0)
			{
				return i;
			}
		}
		return -1;
	}
	private int cardsFromRF()
	{
		if(numOfSuit()==2)
		{		
			int wrongSuit=wrongSuitRF();
			int wrongRank=wrongRankRF();

			if(wrongRank==wrongSuit&&wrongSuit!=-1)
			{

				return wrongRank;
			}
			else
				return -1;
		}
		else
			return -1;
		
	}
	private boolean wrongRankSF(int index)
	{
		
		int count=0;

		for(int i=0;i<10;i++)
		{
			
			if(aipCardsNum[i]==1&&i!=index)
			{

				count=0;
				for(int x=1;x<=4;x++)
				{
					if(aipCardsNum[i+x]==1&&i!=index)
					{
						count++;
					}
				}
				

				if(count==3)
				{
					return true;
				}

			}
		}
		return false;
	}
	private int cardsFromSF()
	{
		if(numOfSuit()==2)
		{		
			int wrongSuit=wrongSuitRF();
			
			if(wrongSuit==-1)
				return -1;
			boolean wrongRank=wrongRankSF(wrongSuit);
			if(wrongRank)
			{

				return wrongSuit;
			}
			else
				return -1;
		}
		else
			return -1;
		
	}
	private int cardsFromFOAK()
	{
		int singleIndex=-1;
		boolean check=false;
		
		for(int i=0;i<13;i++)
		{
			if(aipCardsNum[i]==1)
			{
				if(singleIndex==-1)
				{
					singleIndex=i;
				}
			}
			if(aipCardsNum[i]==3)
			{

				check=true;
			}			
		}
		if(!check)
			return -1;
		
		return getIndexFromNumToCard(singleIndex);
		
	}
	private int[] threeInSuits()
	{
		int singleIndex=-1,singleIndex2=-1;
		boolean check=false;
		
		for(int i=0;i<13;i++)
		{
			if(aipCardsNum[i]==1)
			{
				if(singleIndex==-1)
				{
					singleIndex=i;
				}
				else
					singleIndex2=i;
			}
			
			if(aipCardsNum[i]==3)
			{

				check=true;
			}			
		}
		if(!check)
			return null;
		
		return new int[] {getIndexFromNumToCard(singleIndex),getIndexFromNumToCard(singleIndex2)};	
	}
	
	private int twoPair()
	{
		int singleIndex=-1;
		boolean check=false,twoCheck=false;
		
		for(int i=0;i<13;i++)
		{
			if(aipCardsNum[i]==1)
			{
				if(singleIndex==-1)
				{
					singleIndex=i;
				}
			}
			if(!twoCheck&&aipCardsNum[i]==2)
			{

				twoCheck=true;
				continue;
			}
			if(twoCheck&&aipCardsNum[i]==2)
			{

				check=true;
			}
					
		}
		if(!check)
			return -1;
		
		return getIndexFromNumToCard(singleIndex);
		
	}
	
	private int cardsFromFH()
	{
		int singleIndex=-1;
		boolean check=false,twoCheck=false;
		
		for(int i=0;i<13;i++)
		{
			if(aipCardsNum[i]==1)
			{
				if(singleIndex==-1)
				{
					singleIndex=i;
				}
			}
			if(!twoCheck&&aipCardsNum[i]==2)
			{

				twoCheck=true;
				continue;
			}
			if(twoCheck&&aipCardsNum[i]==2)
			{

				check=true;
			}
			if(aipCardsNum[i]==3)
			{

				check=true;
			}			
		}
		if(!check)
			return -1;
		
		return getIndexFromNumToCard(singleIndex);
		
	}
	private int cardsFromFLUSH()
	{
		int[] suits=getSuitAry();

		int color=-1;
		int singleColor=-1;
		for(int i=0;i<4;i++)
		{
			if(suits[i]>=4)
			{
				color=i;
			}
			if(suits[i]==1)
			{
				singleColor=i;
			}
		}
		
		if(color==-1||singleColor==-1)
			return -1;

		return wrongSuitRF();
	}
	private int cardsFromSTRAIGHT()
	{
		int indexWrong=-1;
		int count=0;
		int check=-1;
		for(int i=0;i<9;i++)
		{			
			if(aipCardsNum[i]==1||aipCardsNum[i]==2)
			{
				count=0;
				for(int x=1;x<=4;x++)
				{
					if(aipCardsNum[i+x]==1||aipCardsNum[i+x]==2)
					{
						
						count++;
					}
				}
				
				if(count==3) 
				{
					
					check=i;
					break;
				}				
			}
		}
		if(check==-1)
		{
			count=0;
			for(int i=9;i<13;i++)
			{
				if(aipCardsNum[i]==1||aipCardsNum[i]==2)
				{
					count++;
				}
			}
			if(count==4)
			{
				check=9;
			}
		}
		if(check==-1)
			return -1;
		for(int i=0;i<13;i++)
		{
			if(aipCardsNum[i]==1)
			{
				if(i<check||i>check+3)
				{
					indexWrong=i;
					break;
				}
			}
			if(aipCardsNum[i]==2)
			{				
				indexWrong=i;
				break;				
			}
		}
			
		return getIndexFromNumToCard(indexWrong);							
	}
 	private int[] cardsFromS7()
	{
		int[] suits=getSuitAry();
		int color=-1;
		int wrongColor=-1, wrongColor2=-1;
		for(int i=0;i<4;i++)
		{
			if(suits[i]==3)
			{
				color=i;
			}
			else if(suits[i]==2)
			{
				wrongColor=i;
				wrongColor2=i;
			}
			else if(suits[i]==1&&wrongColor!=-1)
			{
				wrongColor2=i;
			}
			else if(suits[i]==1&&wrongColor==-1)
			{
				wrongColor=i;
			}
		}
		
		if(color==-1||wrongColor2==-1)
			return null;
		
		int[]  wrongIndex=new int[] {-1,-1};
		if(wrongColor!=wrongColor2)
		{
			for(int i=0;i<5;i++)
			{
				if(getSuit(aipCards[i])==(wrongColor+1))
				{
					wrongIndex[0]=i;
				}
				if(getSuit(aipCards[i])==(wrongColor2+1))
				{	
					wrongIndex[1]=i;
				}
			}
		}
		else
		{
			
			for(int i=0;i<5;i++)
			{
				if(wrongIndex[0]==-1&&getSuit(aipCards[i])==(wrongColor+1))
				{
					wrongIndex[0]=i;
				}
				if(wrongIndex[0]!=-1&&getSuit(aipCards[i])==(wrongColor+1))
				{
					wrongIndex[1]=i;
				}
			}
		}
		return wrongIndex;
	}
	private int[] cardsFromS8()
	{
		int indexWrong=-1;
		int indexWrong2=-1;
		int count=0;
		int check=-1;
		for(int i=0;i<11;i++)
		{			
			if(aipCardsNum[i]==1||aipCardsNum[i]==2)
			{
				count=0;
				for(int x=1;x<=2;x++)
				{
					if(aipCardsNum[i+x]==1||aipCardsNum[i+x]==2)
					{						
						count++;
					}
				}
				if(count==2)
				{
					check=i;
					break;
				}				
			}
		}
		if(check==-1)
			return null;
		for(int i=0;i<13;i++)
		{
			if(aipCardsNum[i]==1)
			{
				if(i<check||i>check+3)
				{
					if(indexWrong==-1)
						indexWrong=i;
					else if(indexWrong!=-1)
					{
						indexWrong2=i;
						break;
					}
				}
			}
			if(aipCardsNum[i]==2)
			{				
				if(i<check||i>check+3)
				{					
					indexWrong=i;
					indexWrong2=i;
					break;					
				}
				else
				{
					if(indexWrong==-1)
						indexWrong=i;
					else if(indexWrong!=-1)
					{
						indexWrong2=i;
						break;
					}
				}
			}
		}
		int[] result=new int[] {-1,-1};
		if(indexWrong==indexWrong2)
		{
			for(int i=0;i<5;i++)
			{
				if(result[0]==-1)
				{
					if(indexWrong==12&&aipCards[i]%13==0)
					{
						result[0]=i;
					}				
					if(aipCards[i]%13==(indexWrong+1))
					{
						result[0]=i;
					}
				}
				else
				{
					if(indexWrong==12&&aipCards[i]%13==0)
					{
						result[1]=i;
					}				
					if(aipCards[i]%13==(indexWrong+1))
					{
						result[1]=i;
					}
				}
			}
		}
		else
		{
			result[0]=getIndexFromNumToCard(indexWrong);
			result[1]=getIndexFromNumToCard(indexWrong2);
		}
		return result;
	}
	private int[] cardsFromS9()
	{
		boolean check=false;
		for(int i=0;i<13;i++)
		{
			if(aipCardsNum[i]==2)
			{
				check=true;
				break;
			}
		}
		if(!check)
			return null;
		int[] result=new int[3];
		int c=0;
		for(int i=0;i<13;i++)
		{
			if(aipCardsNum[i]==1)
			{
				result[c]=getIndexFromNumToCard(i);
				c++;
			}
			if(c==3)
				return result;
		}
		return null;
	}
	private int[] cardsFromS10()
	{
		int[] result=new int[3];
		int count=0;
		int j=0;
		for(int i=12;i>=0;i--)
		{
			if(count==2&&aipCardsNum[i]==1)
			{
				result[j]=getIndexFromNumToCard(i);
				j++;
			}
			if(j==3)
				return result;
			if(count<2&&aipCardsNum[i]==1)
			{
				count++;
			}
			
		}
		return null;
	}
		
	private int getIndexFromNumToCard(int num)
	{
		for(int i=0;i<5;i++)
		{
			if(num==12&&aipCards[i]%13==0)
			{
				return i;
			}
			if(aipCards[i]%13==(num+1))
			{
				return i;
			}
		}
		return -1;
	}
	private int[] getSuitAry()
	{
		int[] suits=new int [4];
		for(int i=0;i<5;i++)
		{
			if(getSuit(aipCards[i])==1)
			{
				suits[0]++;
			}
			else if(getSuit(aipCards[i])==2)
			{
				suits[1]++;
			}
			else if(getSuit(aipCards[i])==3)
			{
				suits[2]++;
			}
			else
			{
				suits[3]++;
			}
		}
		return suits;	
	}
	private void sortAIPCards()
	{
		if(aipCards[0]==0||aipCards[1]==0||aipCards[2]==0||aipCards[3]==0||aipCards[4]==0)
			return;
		int[] temp=new int[52];
		temp[aipCards[0]-1]=1;
		temp[aipCards[1]-1]=1;
		temp[aipCards[2]-1]=1;
		temp[aipCards[3]-1]=1;
		temp[aipCards[4]-1]=1;
		int c=0;
		for(int i=0;i<52;i++)
		{
			if(temp[i]==1)
			{
				aipCards[c]=i+1;
				c++;
			}
		}
		printAIPCards();
		return;
	}
	private int isPair(int[] cards)
	{
		if(cards[0]==2)
		{
			return 14;
		}
		for(int i=0; i<13;i++)
		{
			if(cards[i]==2)
			{
				return i+1;
			}
		}

		return -1;

		
	}
	private int isTP(int[] cards)
	{
		int temp=-1;
		int temp2=-1;
		for(int i=0; i<13;i++)
		{
			if(cards[i]==2)
			{
				if(temp!=-1)
				{
					temp2=i+1;
				}
				else
				{
					temp=i;
				}
			}
		}
		if(temp2==-1)
			return -1;
		if(temp2>temp)
			return temp2;
		else
			return temp;
		
	}
	private int isFH(int[] cards)
	{
		
		int temp=-1;
		boolean havePair=false;
		for(int i=0; i<13;i++)
		{
			if(cards[i]==3)
				temp=i+1;
			if(cards[i]==2)
				havePair=true;
		}
		if(havePair)
		{
			if(cards[0]==3)
				return 14;
			return temp;
		}
		else
			return -1;
	}
	private int isFOAK(int[] cards)
	{
		if(cards[0]==4)
			return 14;
		for(int i=0; i<13;i++)
		{
			if(cards[i]==4)
				return i+1;
		}
		return -1;
	}
	private int isTOAK(int[] cards)
	{
		int temp=-1;
		if(cards[0]==3)
			return 14;
		for(int i=0; i<13;i++)
		{
			if(cards[i]==3)
			{
				return i+1;
			}
		}
		
		return temp;

	}
	private int isStraight(int[] cards)
	{
		for(int i =0;i<9;i++)
		{
			if(cards[i]==1)
			{
				if(cards[i+1]==1&&cards[i+2]==1&&cards[i+3]==1&&cards[i+4]==1)
				{
					return i+5;
				}
			}
		}
		if(cards[0]==1)
		{
			if(cards[9]==1&&cards[10]==1&&cards[11]==1&&cards[12]==1)
			{
				return 14;
			}
		}
		return -1;
	}
	private int isRFlush(int[] cards)
	{
		
		if(cards[0]==1)
		{
			if(cards[9]==1&&cards[10]==1&&cards[11]==1&&cards[12]==1)
			{
				return 1;
			}
		}
		return -1;
	}
	private int isSameSuit(int[] cards)
	{
		if(getSuit(cards[0])==1 && getSuit(cards[1])==1 && getSuit(cards[2])==1 && getSuit(cards[3])==1 && getSuit(cards[4])==1)
		{
			return 1;
		}
		if(getSuit(cards[0])==2 && getSuit(cards[1])==2 && getSuit(cards[2])==2 && getSuit(cards[3])==2 && getSuit(cards[4])==2)
		{
			return 2;
		}
		if(getSuit(cards[0])==3 && getSuit(cards[1])==3 && getSuit(cards[2])==3 && getSuit(cards[3])==3 && getSuit(cards[4])==3)
		{
			return 3;
		}
		if(getSuit(cards[0])==4 && getSuit(cards[1])==4 && getSuit(cards[2])==4 && getSuit(cards[3])==4 && getSuit(cards[4])==4)
		{
			return 4;
		}
		else
			return -1;
	}
	private void printAIPCards()
	{
		/*System.out.println("AIP has "+aipCards[0]+" "+aipCards[1]+" "+aipCards[2]+" "+aipCards[3]+" "+aipCards[4]);
		System.out.println("1 2 3 4 5 6 7 8 9 0 J Q K");
		for(int i=0;i<13;i++)
			System.out.print(aipCardsNum[i]+" ");
		System.out.println("");*/
	}
	private void printOPCards()
	{
		System.out.print("opponent has "+opCards[0]+" "+opCards[1]+" "+opCards[2]+" "+opCards[3]+" "+opCards[4]);
	}
	private int getSuit(int card)
	{
		if(card<14)
			return 1;   //club
		else if(card<27)
			return 2;   //diamond
		else if(card<40)
			return 3;   //heart
		else
			return 4;   //spade
					
	}
	private int[] countNum(int[] cards)
	{
		int[] temp=new int[13];
		for(int i=0;i<5;i++)
		{			
			if(cards[i]%13==1)
			{
				
				temp[0]++;
			}
			else if(cards[i]%13==2)
			{
				temp[1]++;
			}
			else if(cards[i]%13==3)
			{
				temp[2]++;
			}
			else if(cards[i]%13==4)
			{
				temp[3]++;
			}
			else if(cards[i]%13==5)
			{
				temp[4]++;
			}
			else if(cards[i]%13==6)
			{
				temp[5]++;
			}
			else if(cards[i]%13==7)
			{
				temp[6]++;
			}
			else if(cards[i]%13==8)
			{
				temp[7]++;
			}
			else if(cards[i]%13==9)
			{
				temp[8]++;
			}
			else if(cards[i]%13==10)
			{
				temp[9]++;
			}
			else if(cards[i]%13==11)
			{
				temp[10]++;
			}
			else if(cards[i]%13==12)
			{
				temp[11]++;
			}
			else
				temp[12]++;
			
			
		}
		return temp;
	}
	public int[] convertStringToInt(String[] strAry)
	{
		int[] tempAry = new int[strAry.length];
		
		for(int i =0;i<strAry.length;i++)
		{
			
				if (strAry[i].compareTo( "CA")==0)
					tempAry[i]=1;
				 
				if (strAry[i].compareTo(  "C2")==0)
					tempAry[i]=2;
				 
				if (strAry[i].compareTo(  "C3")==0)
					tempAry[i]=3;
				 
				if (strAry[i].compareTo(  "C4")==0)
					tempAry[i]=4;
				 
				if (strAry[i].compareTo(  "C5")==0)
					tempAry[i]=5;
				 
				if (strAry[i].compareTo(  "C6")==0)
					tempAry[i]=6;
				 
				if (strAry[i].compareTo(  "C7")==0)
					tempAry[i]=7;
				 
				if (strAry[i].compareTo(  "C8")==0)
					tempAry[i]=8;
				 
				if (strAry[i].compareTo(  "C9")==0)
					tempAry[i]=9;
				 
				if (strAry[i].compareTo(  "C10")==0)
					tempAry[i]=10;
				 
				if (strAry[i].compareTo(  "CJ")==0)
					tempAry[i]=11;
				 
				if (strAry[i].compareTo(  "CQ")==0)
					tempAry[i]=12;
				 
				if (strAry[i].compareTo(  "CK")==0)
					tempAry[i]=13;
				 
				if (strAry[i].compareTo(  "DA")==0)
					tempAry[i]=14;
				 
				if (strAry[i].compareTo(  "D2")==0)
					tempAry[i]=15;
				
				if (strAry[i].compareTo(  "D3")==0)
					tempAry[i]=16;
				 
				if (strAry[i].compareTo(  "D4")==0)
					tempAry[i]=17;
				 
				if (strAry[i].compareTo(  "D5")==0)
					tempAry[i]=18;
				 
				if (strAry[i].compareTo(  "D6")==0)
					tempAry[i]=19;
				 
				if (strAry[i].compareTo(  "D7")==0)
					tempAry[i]=20;
				 
				if (strAry[i].compareTo(  "D8")==0)
					tempAry[i]=21;
				 
				if (strAry[i].compareTo(  "D9")==0)
					tempAry[i]=22;
				 
				if (strAry[i].compareTo(  "D10")==0)
					tempAry[i]=23;
				 
				if (strAry[i].compareTo(  "DJ")==0)
					tempAry[i]=24;
				 
				if (strAry[i].compareTo(  "DQ")==0)
					tempAry[i]=25;
				 
				if (strAry[i].compareTo(  "DK")==0)
					tempAry[i]=26;
				 
				if (strAry[i].compareTo(  "HA")==0)
					tempAry[i]=27;
				 
				if (strAry[i].compareTo(  "H2")==0)
					tempAry[i]=28;
				 
				if (strAry[i].compareTo(  "H3")==0)
					tempAry[i]=29;
				 
				if (strAry[i].compareTo(  "H4")==0)
					tempAry[i]=30;
				 
				if (strAry[i].compareTo(  "H5")==0)
					tempAry[i]=31;
				 
				if (strAry[i].compareTo(  "H6")==0)
					tempAry[i]=32;
				 
				if (strAry[i].compareTo(  "H7")==0)
					tempAry[i]=33;
				 
				if (strAry[i].compareTo(  "H8")==0)
					tempAry[i]=34;
				 
				if (strAry[i].compareTo(  "H9")==0)
					tempAry[i]=35;
				 
				if (strAry[i].compareTo(  "H10")==0)
					tempAry[i]=36;
				 
				if (strAry[i].compareTo(  "HJ")==0)
					tempAry[i]=37;
				 
				if (strAry[i].compareTo(  "HQ")==0)
					tempAry[i]=38;
				 
				if (strAry[i].compareTo(  "HK")==0)
					tempAry[i]=39;
				 
				
				if (strAry[i].compareTo(  "SA")==0)
					tempAry[i]=40;
				 
				if (strAry[i].compareTo(  "S2")==0)
					tempAry[i]=41;
				 
				if (strAry[i].compareTo(  "S3")==0)
					tempAry[i]=42;
				 
				if (strAry[i].compareTo(  "S4")==0)
					tempAry[i]=43;
				 
				if (strAry[i].compareTo(  "S5")==0)
					tempAry[i]=44;
				 
				if (strAry[i].compareTo(  "S6")==0)
					tempAry[i]=45;
				 
				if (strAry[i].compareTo(  "S7")==0)
					tempAry[i]=46;
				 
				if (strAry[i].compareTo(  "S8")==0)
					tempAry[i]=47;
				 
				if (strAry[i].compareTo(  "S9")==0)
					tempAry[i]=48;
				 
				if (strAry[i].compareTo(  "S10")==0)
					tempAry[i]=49;
				 
				if (strAry[i].compareTo(  "SJ")==0)
					tempAry[i]=50;
				 
				if (strAry[i].compareTo(  "SQ")==0)
					tempAry[i]=51;
				 
				if (strAry[i].compareTo(  "SK")==0)
					tempAry[i]=52;
				 
				  
					
				
				
			
		}
		return tempAry;
	}
	private String getStringOfCard(int card)
	{
		String result="";
		if(getSuit(card)==1)
		{
			result="C";
		}
		if(getSuit(card)==2)
		{
			result="D";
		}
		if(getSuit(card)==3)
		{
			result="H";
		}
		if(getSuit(card)==4)
		{
			result="S";
		}
		if(card%13>=1&&card%13<=10)
		{
			result=result+(card%13);
		}
		else
		{
			if(card%13==11)
				result=result+"J";
			if(card%13==12)
				result=result+"Q";
			if(card%13==0)
				result=result+"K";
		}
		return result;
	}
	private int getHigh(int[] cards)
	{
		if(cards[0]!=0)
			return 14;
		for(int i=12;i>0;i--)
		{
			if(cards[i]!=0)
				return i+1;
		}
		return -1;
	}
	private int getHighCardIndex(int num)
	{
		for(int i=0;i<5;i++)
		{
			if(num==14&&aipCards[i]%13==1)
				return i;
			if(num==13&&aipCards[i]%13==0)
			{
				return i;
			}
			if(aipCards[i]%13==(num))
			{
				return i;
			}
		}
		return -1;
	}
	private int getHighCardIndexOP(int num)
	{
		for(int i=0;i<5;i++)
		{
			if(num==14&&opCards[i]%13==1)
				return i;
			if(num==13&&opCards[i]%13==0)
			{
				return i;
			}
			if(opCards[i]%13==(num))
			{
				return i;
			}
		}
		return -1;
	}
	private void printCards(int[] cards)
	{
		System.out.println(getStringOfCard(cards[0]));
		System.out.println(getStringOfCard(cards[1]));
		System.out.println(getStringOfCard(cards[2]));
		System.out.println(getStringOfCard(cards[3]));
		System.out.println(getStringOfCard(cards[4]));
	}
	public int getPlayerNumber()
	{
		return numberOfPlayers;
	}
}
