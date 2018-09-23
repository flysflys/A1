import java.util.Scanner;

public class App {
	int[] opCards=new int[] {0,0,0,0,0};
	int[] aipCards=new int[] {0,0,0,0,0};

	public int[] getOpCards()
	{
		Scanner scanner = new Scanner(System.in);
		String[] tempAry=new String[] {"","","","",""};
		for(int i=0;i<5;i++)
		{
			System.out.println("the "+i+" card you want to give to opponent");
			tempAry[i]=scanner.next();
		}
		opCards=convertStringToInt(tempAry);
		return opCards;
		
	}
	public int[] getAIPCards()
	{
		Scanner scanner = new Scanner(System.in);
		String[] tempAry=new String[] {"","","","",""};
		for(int i=0;i<5;i++)
		{
			System.out.println("the "+i+" card you want to give to aip");
			tempAry[i]=scanner.next();
		}
		aipCards=convertStringToInt(tempAry);
		return aipCards;
		
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
