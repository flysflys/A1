package A3;

public  class Utl {
	
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
	
	public int isPair(int[] cards)
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
	public int isTP(int[] cards)
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
	public int isFH(int[] cards)
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
	public int isFOAK(int[] cards)
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
	public int isTOAK(int[] cards)
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
	public int isStraight(int[] cards)
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
	public int isRFlush(int[] cards)
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
	public int getHigh(int[] cards)
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
	public int getHighCardIndex(int num,int [] cards)
	{
		for(int i=0;i<5;i++)
		{
			if(num==14&&cards[i]%13==1)
				return i;
			if(num==13&&cards[i]%13==0)
			{
				return i;
			}
			if(cards[i]%13==(num))
			{
				return i;
			}
		}
		return -1;
	}
	
	public int getIndexFromNumToCard(int num,int [] cards)
	{
		for(int i=0;i<5;i++)
		{
			if(num==12&&cards[i]%13==0)
			{
				return i;
			}
			if(cards[i]%13==(num+1))
			{
				return i;
			}
		}
		return -1;
	}
	public int isSameSuit(int[] cards)
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
	public int getSuit(int card)
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
	public String getStringOfCard(int card)
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
		if(card%13>=2&&card%13<=10)
		{
			result=result+(card%13);
		}
		else
		{
			if(card%13==1)
				result=result+"A";
			if(card%13==11)
				result=result+"J";
			if(card%13==12)
				result=result+"Q";
			if(card%13==0)
				result=result+"K";
		}
		return result;
	}
	public int[] countNum(int[] cards)
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
	
	public int[] sortCards(int[] card)
	{
		if(card[0]==0||card[1]==0||card[2]==0||card[3]==0||card[4]==0)
			return null;
		int[] temp=new int[52];
		temp[card[0]-1]=1;
		temp[card[1]-1]=1;
		temp[card[2]-1]=1;
		temp[card[3]-1]=1;
		temp[card[4]-1]=1;
		int c=0;
		for(int i=0;i<52;i++)
		{
			if(temp[i]==1)
			{
				card[c]=i+1;
				c++;
			}
		}
		//printAIPCards();
		return card;
	}
}
