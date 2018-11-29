package A3;

public class Player {
	protected Utl utl=new Utl();
	protected String[] cardsStr;
	protected int[] cards;
	protected String[] extraCardsStr;
	protected int[] extraCards;
	protected int[] cardNumCount;
	
	public void redraw(int [] cards)
	{
		for(int i =0;i<cards.length;i++)
		{
			cards[cards[i]]=extraCards[i];
			//System.out.println("draw a "+getStringOfCard(extraCards[i]));
		}
		cards=utl.sortCards(cards);
		cardNumCount=utl.countNum(cards);
	}
	public void giveCard(String str)
	{
		cardsStr=str.split("\\s+");
		cards=utl.convertStringToInt(cardsStr);
		cards=utl.sortCards(cards);
		cardNumCount=utl.countNum(cards);
	}
	public void giveCard(String[] str)
	{
		cardsStr=str;
		cards=utl.convertStringToInt(cardsStr);
		cards=utl.sortCards(cards);
		cardNumCount=utl.countNum(cards);
	}
	public void giveExtraCard(String str)
	{
		extraCardsStr=str.split("\\s+");
		extraCards=utl.convertStringToInt(extraCardsStr);
	}
	public void giveExtraCard(String[] str)
	{
		extraCardsStr=str;
		extraCards=utl.convertStringToInt(extraCardsStr);
	}
	public String[] getCardsStrAry()
	{
		return cardsStr;
	}
	public int[] getCards()
	{
		return cards;
	}
	public int[] getCardsCount()
	{
		return cardNumCount;
	}
}
