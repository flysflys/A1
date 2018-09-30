import java.io.*;

public class App {
	int[] opCards=new int[] {0,0,0,0,0};
	int[] opCardsNum=new int[13];
	int[] aipCards=new int[] {0,0,0,0,0};
	int[] aipCardsNum=new int[13];
	int[] extraCards=null;
	String path="C:\\Users\\michael\\eclipse-workspace\\maven-A1\\src\\main\\java\\input.txt";
	public App()
	{		
		String[] tempAry=null;
		String[] tempAry1=new String[5];
		String[] tempAry2=new String[5];
		String[] tempAry3=null;
		File file = new File(path);  
			  
		String str; 
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			str = br.readLine();

			tempAry=str.split("\\s+");

			for(int i =0;i<5;i++)
			{
				tempAry1[i]=tempAry[i];
			}

			for(int i =0;i<5;i++)
			{
				tempAry2[i]=tempAry[i+5];
			}

			if(tempAry.length>10)
			{
				tempAry3=new String[tempAry.length-10];
				for(int i =0;i<tempAry3.length;i++)
				{
					tempAry3[i]=tempAry[i+10];
				}
				extraCards=convertStringToInt(tempAry3);
			}

			br.close();
		}
		catch (Exception e)
		{
			System.out.print("ERROR!");
		}
		opCards=convertStringToInt(tempAry2);
		aipCards=convertStringToInt(tempAry1);
		aipCardsNum=countNum(aipCards);
		sortAIPCards();

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
		else
			System.out.println("error");
		
		
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
	private void redraw(int [] cards)
	{
		for(int i =0;i<cards.length;i++)
		{
			System.out.println("discarding "+(i+1)+" card");
			aipCards[cards[i]]=extraCards[i];
			System.out.println("draw a "+extraCards[i]);
		}
		aipCardsNum=countNum(aipCards);
		sortAIPCards();
	}
	private int numOfSuit()
	{
		int[] suits=new int [4];
		for(int i=0;i<5;i++)
		{
			if(aipCards[i]<=13)
			{
				suits[0]++;
			}
			else if(aipCards[i]<=26)
			{
				suits[1]++;
			}
			else if(aipCards[i]<=39)
			{
				suits[2]++;
			}
			else
			{
				suits[3]++;
			}
		}
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
		return temp2;
		
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
			return temp;
		else
			return -1;
	}
	private int isFOAK(int[] cards)
	{
		
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
		
		for(int i=0; i<13;i++)
		{
			if(cards[i]==3)
			{
				temp=i+1;
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
				return 1;
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
		System.out.println("AIP has "+aipCards[0]+" "+aipCards[1]+" "+aipCards[2]+" "+aipCards[3]+" "+aipCards[4]);
		System.out.println("1 2 3 4 5 6 7 8 9 0 J Q K");
		for(int i=0;i<13;i++)
			System.out.print(aipCardsNum[i]+" ");
		System.out.println("");
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
			else if(cards[i]%13==0)
			{
				temp[11]++;
			}
			else
				temp[12]++;
			
			
		}
		return temp;
	}
	private int[] convertStringToInt(String[] strAry)
	{
		int[] tempAry = new int[strAry.length];
		
		for(int i =0;i<strAry.length;i++)
		{
			switch(strAry[i])
			{
				case "C1":
					tempAry[i]=1;
				break;
				case "C2":
					tempAry[i]=2;
				break;
				case "C3":
					tempAry[i]=3;
				break;
				case "C4":
					tempAry[i]=4;
				break;
				case "C5":
					tempAry[i]=5;
				break;
				case "C6":
					tempAry[i]=6;
				break;
				case "C7":
					tempAry[i]=7;
				break;
				case "C8":
					tempAry[i]=8;
				break;
				case "C9":
					tempAry[i]=9;
				break;
				case "C10":
					tempAry[i]=10;
				break;
				case "CJ":
					tempAry[i]=11;
				break;
				case "CQ":
					tempAry[i]=12;
				break;
				case "CK":
					tempAry[i]=13;
				break;
				case "D1":
					tempAry[i]=14;
				break;
				case "D2":
					tempAry[i]=15;
				break;
				case "D3":
					tempAry[i]=16;
				break;
				case "D4":
					tempAry[i]=17;
				break;
				case "D5":
					tempAry[i]=18;
				break;
				case "D6":
					tempAry[i]=19;
				break;
				case "D7":
					tempAry[i]=20;
				break;
				case "D8":
					tempAry[i]=21;
				break;
				case "D9":
					tempAry[i]=22;
				break;
				case "D10":
					tempAry[i]=23;
				break;
				case "DJ":
					tempAry[i]=24;
				break;
				case "DQ":
					tempAry[i]=25;
				break;
				case "DK":
					tempAry[i]=26;
				break;
				case "H1":
					tempAry[i]=27;
				break;
				case "H2":
					tempAry[i]=28;
				break;
				case "H3":
					tempAry[i]=29;
				break;
				case "H4":
					tempAry[i]=30;
				break;
				case "H5":
					tempAry[i]=31;
				break;
				case "H6":
					tempAry[i]=32;
				break;
				case "H7":
					tempAry[i]=33;
				break;
				case "H8":
					tempAry[i]=34;
				break;
				case "H9":
					tempAry[i]=35;
				break;
				case "H10":
					tempAry[i]=36;
				break;
				case "HJ":
					tempAry[i]=37;
				break;
				case "HQ":
					tempAry[i]=38;
				break;
				case "HK":
					tempAry[i]=39;
				break;
				
				case "S1":
					tempAry[i]=40;
				break;
				case "S2":
					tempAry[i]=41;
				break;
				case "S3":
					tempAry[i]=42;
				break;
				case "S4":
					tempAry[i]=43;
				break;
				case "S5":
					tempAry[i]=44;
				break;
				case "S6":
					tempAry[i]=45;
				break;
				case "S7":
					tempAry[i]=46;
				break;
				case "S8":
					tempAry[i]=47;
				break;
				case "S9":
					tempAry[i]=48;
				break;
				case "S10":
					tempAry[i]=49;
				break;
				case "SJ":
					tempAry[i]=50;
				break;
				case "SQ":
					tempAry[i]=51;
				break;
				case "SK":
					tempAry[i]=52;
				break;
				 default:
					 tempAry[i]=0;
				
				
			}
		}
		return tempAry;
	}
	
}
