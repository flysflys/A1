

import static org.junit.Assert.assertEquals;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RFSteps {
	App test = new App();
	Hands temp=null;
	Winner winner=null;
	@When("^AI decides to exchange or not$")
	public void AIturntodecidetoexchangeornot() throws Throwable
	{		
		test.aipHas();
		test.exchange();		
	}
	
	
	@Then("^AI holds$")
	public void AIholds() throws Throwable
	{
		assertEquals(temp,test.getHands());
	}
	
	@Then("^AI exchange it$")
	public void AIexchangeit() throws Throwable
	{
		test.aipHas();
		
	}
	
	
	@Given("^AI drawing following cards and opponent also draw the cards$")
	public void AIdrawingfollowingcards(DataTable table) {		
		System.out.println("-----------------------");
		List<List<String>> data=table.raw();
		test.inputOP(data.get(0).get(0));
		temp=test.getHands();
	}
	
	@Given("^AI drawing following cards which is few card away case$")
	public void AIdrawingfollowingcardswhichisfewcardawaycase(DataTable table) {		
		List<List<String>> data=table.raw();
		test.input(data.get(0).get(0));
		temp=test.getHands();
	}
	@Given("^AI drawing following cards which is only have a pair$")
	public void AIdrawingfollowingcardswhichisonlyhaveapair(DataTable table) {		
		List<List<String>> data=table.raw();
		test.input(data.get(0).get(0));
		temp=test.getHands();
	}
	@Given("^AI drawing following cards which has no hands$")
	public void AIdrawingfollowingcardswhichhasnohands(DataTable table) {		
		List<List<String>> data=table.raw();
		test.input(data.get(0).get(0));
		temp=test.getHands();
	}
	
	@When("^program decide who is the winner$")
	public void programcheckforthewinner() throws Throwable
	{		
		winner=test.winner();	
	}
	
	@Then("^AI wins the game$")
	public void AIwins() throws Throwable
	{
		
		assertEquals(Winner.AIP,winner);
	}
	@Then("^opponent wins the game$")
	public void opponentwins() throws Throwable
	{
		
		assertEquals(Winner.OPPONENT,winner);
	}
	
	
	
	
	
	

}
