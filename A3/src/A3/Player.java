package A3;

public abstract class Player {
	protected Utl utl=new Utl();
	protected String[] cardStr;
	protected int[] cards;
	protected String[] extraCardsStr;
	protected int[] extraCards;
	protected int[] cardNumCount;
	protected String beforeCards;
	public Hands getHands()
	{
		cards=utl.sortCards(cards);
		return utl.getHands(cards);
	}
	public String getBeforeCards()
	{
		return beforeCards;
	}
	public String getAfterCards()
	{
		String temp="";
		for(int i=0;i<5;i++)
		{
			temp+=utl.getStringOfCard(cards[i])+" ";
		}
		return temp;
	}
	public void redraw(int [] cardsR)
	{
		
		if(cardsR.length==5)
		{
			cards=extraCards;
		}
		else
		{
			
			for(int i =0;i<cardsR.length;i++)
			{
				//System.out.println(cardsR[i]);
				cards[cardsR[i]-1]=extraCards[i];
				//System.out.println("draw a "+getStringOfCard(extraCards[i]));
			}
		}
		//cards=utl.sortCards(cards);
		cardNumCount=utl.countNum(cards);
	}
	
	public void giveCard(String[] str)
	{
		
		cardStr=str;
		System.out.println();
		cards=utl.convertStringToInt(cardStr);
		//cards=utl.sortCards(cards);
		cardNumCount=utl.countNum(cards);
		beforeCards=cardStr[0]+" "+cardStr[1]+" "+cardStr[2]+" "+cardStr[3]+" "+cardStr[4];
	}
	
	public void giveExtraCard(String[] stry)
	{
		
		extraCardsStr=stry;
		extraCards=utl.convertStringToInt(extraCardsStr);
		
	}
	public String[] getCardsStrAry()
	{
		
		return cardStr;
	}
	public int[] getCards()
	{
		return cards;
	}
	public int[] getCardsCount()
	{
		return cardNumCount;
	}
	public abstract String getredrawNum(); 
	public abstract void exchange();
}
