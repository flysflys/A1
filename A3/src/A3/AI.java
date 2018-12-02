package A3;

public class AI extends Player{
	int[] cardsRedraw;
	public void exchange()
	{
		Hands oldHands=utl.getHands(cards); 
		if(oldHands==Hands.RF||oldHands==Hands.SF||oldHands==Hands.FH||oldHands==Hands.FOAK||oldHands==Hands.FLUSH||oldHands==Hands.STRAIGHT)
		{
			//System.out.println("no need for exchange");
			return;
		}
		else if(cardsFromRF()!=-1)
		{
			//System.out.println("1 card away from RF");
			int[] temp= {cardsFromRF()};
			cardsRedraw=(temp);
			
		}
		else if(cardsFromSF()!=-1)
		{
			//System.out.println("1 card away from SF");
			int[] temp= {cardsFromSF()};
			cardsRedraw=(temp);
			
			
		}
		else if(cardsFromFOAK()!=-1)
		{
			//System.out.println("1 card away from FH");
			int[] temp= {cardsFromFOAK()};
			cardsRedraw=(temp);
			
			
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
			//System.out.println("1 card away from FLUSH");
			int[] temp= {cardsFromFLUSH()};
			cardsRedraw=(temp);
						
		}
		else if(cardsFromSTRAIGHT()!=-1)
		{
			//System.out.println("1 card away from STRAIGHT");
			int[] temp= {cardsFromSTRAIGHT()};
			cardsRedraw=(temp);
						
		}
		else if(cardsFromS7()!=null)
		{
			//System.out.println("3 cards are in same suit, exchange other 2");
			int[] temp= cardsFromS7();
			cardsRedraw=(temp);
						
		}
		else if(threeInSuits()!=null)
		{
			//System.out.println("3 cards are in same rank, exchange other 2");
			int[] temp= threeInSuits();
			cardsRedraw=(temp);
						
		}
		else if(cardsFromS8()!=null)
		{
			//System.out.println("3 cards are in sequence, exchange other 2");
			int[] temp= cardsFromS8();
			cardsRedraw=(temp);
						
		}
		else if(twoPair()!=-1)
		{
			//System.out.println("2 pairs, exchange other card");
			int[] temp= new int[] {twoPair()};
			cardsRedraw=(temp);
						
		}
		else if(cardsFromS9()!=null)
		{
			//System.out.println("1 pair, exchange other 3");
			int[] temp= cardsFromS9();
			cardsRedraw=(temp);
						
		}
		else
		{
			//System.out.println("keep the highest 2, exchange other 3");
			int[] temp= cardsFromS10();
			cardsRedraw=(temp);
				
		}		
	}
	private int[] getSuitAry()
	{
		int[] suits=new int [4];
		for(int i=0;i<5;i++)
		{
			if(utl.getSuit(cards[i])==1)
			{
				suits[0]++;
			}
			else if(utl.getSuit(cards[i])==2)
			{
				suits[1]++;
			}
			else if(utl.getSuit(cards[i])==3)
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
		if(utl.getSuit(cards[0])==utl.getSuit(cards[1]))
		{
			for(int i=2;i<5;i++)
			{
				if(utl.getSuit(cards[0])!=utl.getSuit(cards[i]))
				{
					return i;
				}
			}
		}
		else
		{
			if(utl.getSuit(cards[0])==utl.getSuit(cards[2]))
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
			if(i!=0&&i!=9&&i!=10&&i!=11&&i!=12&&cardNumCount[i]==1)
			{
				count++;
			}
		}
		if(count>=2)
			return -1;		
		count=0;
		for(int i=0;i<5;i++)
		{
			
			if(cards[i]%13!=1&&cards[i]%13!=10&&cards[i]%13!=11&&cards[i]%13!=12&&cards[i]%13!=0)
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
			
			if(cardNumCount[i]==1&&i!=index)
			{

				count=0;
				for(int x=1;x<=4;x++)
				{
					if(cardNumCount[i+x]==1&&i!=index)
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
			if(cardNumCount[i]==1)
			{
				if(singleIndex==-1)
				{
					singleIndex=i;
				}
			}
			if(cardNumCount[i]==3)
			{

				check=true;
			}			
		}
		if(!check)
			return -1;
		
		return utl.getIndexFromNumToCard(singleIndex,cards);
		
	}
	private int[] threeInSuits()
	{
		int singleIndex=-1,singleIndex2=-1;
		boolean check=false;
		
		for(int i=0;i<13;i++)
		{
			if(cardNumCount[i]==1)
			{
				if(singleIndex==-1)
				{
					singleIndex=i;
				}
				else
					singleIndex2=i;
			}
			
			if(cardNumCount[i]==3)
			{

				check=true;
			}			
		}
		if(!check)
			return null;
		
		return new int[] {utl.getIndexFromNumToCard(singleIndex,cards),utl.getIndexFromNumToCard(singleIndex2,cards)};	
	}
	
	private int twoPair()
	{
		int singleIndex=-1;
		boolean check=false,twoCheck=false;
		
		for(int i=0;i<13;i++)
		{
			if(cardNumCount[i]==1)
			{
				if(singleIndex==-1)
				{
					singleIndex=i;
				}
			}
			if(!twoCheck&&cardNumCount[i]==2)
			{

				twoCheck=true;
				continue;
			}
			if(twoCheck&&cardNumCount[i]==2)
			{

				check=true;
			}
					
		}
		if(!check)
			return -1;
		
		return utl.getIndexFromNumToCard(singleIndex,cards);
		
	}
	
	private int cardsFromFH()
	{
		int singleIndex=-1;
		boolean check=false,twoCheck=false;
		
		for(int i=0;i<13;i++)
		{
			if(cardNumCount[i]==1)
			{
				if(singleIndex==-1)
				{
					singleIndex=i;
				}
			}
			if(!twoCheck&&cardNumCount[i]==2)
			{

				twoCheck=true;
				continue;
			}
			if(twoCheck&&cardNumCount[i]==2)
			{

				check=true;
			}
			if(cardNumCount[i]==3)
			{

				check=true;
			}			
		}
		if(!check)
			return -1;
		
		return utl.getIndexFromNumToCard(singleIndex,cards);
		
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
			if(cardNumCount[i]==1||cardNumCount[i]==2)
			{
				count=0;
				for(int x=1;x<=4;x++)
				{
					if(cardNumCount[i+x]==1||cardNumCount[i+x]==2)
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
				if(cardNumCount[i]==1||cardNumCount[i]==2)
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
			if(cardNumCount[i]==1)
			{
				if(i<check||i>check+3)
				{
					indexWrong=i;
					break;
				}
			}
			if(cardNumCount[i]==2)
			{				
				indexWrong=i;
				break;				
			}
		}
			
		return utl.getIndexFromNumToCard(indexWrong,cards);							
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
				if(utl.getSuit(cards[i])==(wrongColor+1))
				{
					wrongIndex[0]=i;
				}
				if(utl.getSuit(cards[i])==(wrongColor2+1))
				{	
					wrongIndex[1]=i;
				}
			}
		}
		else
		{
			
			for(int i=0;i<5;i++)
			{
				if(wrongIndex[0]==-1&&utl.getSuit(cards[i])==(wrongColor+1))
				{
					wrongIndex[0]=i;
				}
				if(wrongIndex[0]!=-1&&utl.getSuit(cards[i])==(wrongColor+1))
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
			if(cardNumCount[i]==1||cardNumCount[i]==2)
			{
				count=0;
				for(int x=1;x<=2;x++)
				{
					if(cardNumCount[i+x]==1||cardNumCount[i+x]==2)
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
			if(cardNumCount[i]==1)
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
			if(cardNumCount[i]==2)
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
					if(indexWrong==12&&cards[i]%13==0)
					{
						result[0]=i;
					}				
					if(cards[i]%13==(indexWrong+1))
					{
						result[0]=i;
					}
				}
				else
				{
					if(indexWrong==12&&cards[i]%13==0)
					{
						result[1]=i;
					}				
					if(cards[i]%13==(indexWrong+1))
					{
						result[1]=i;
					}
				}
			}
		}
		else
		{
			result[0]=utl.getIndexFromNumToCard(indexWrong,cards);
			result[1]=utl.getIndexFromNumToCard(indexWrong2,cards);
		}
		return result;
	}
	private int[] cardsFromS9()
	{
		boolean check=false;
		for(int i=0;i<13;i++)
		{
			if(cardNumCount[i]==2)
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
			if(cardNumCount[i]==1)
			{
				result[c]=utl.getIndexFromNumToCard(i,cards);
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
			if(count==2&&cardNumCount[i]==1)
			{
				result[j]=utl.getIndexFromNumToCard(i,cards);
				j++;
			}
			if(j==3)
				return result;
			if(count<2&&cardNumCount[i]==1)
			{
				count++;
			}
			
		}
		return null;
	}
	public String getredrawNum() {
		String temp="";
		if(cardsRedraw==null)
			return null;
		for (int x=0;x<cardsRedraw.length;x++)
			temp+=Integer.toString(cardsRedraw[x]);
		return temp;
	}
}
