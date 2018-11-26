

import static org.junit.Assert.assertEquals;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompareSteps {
	App test = new App();
	Hands temp=null;
	Winner winner=null;
	@And("^AI decides to exchange the cards or not$")
	public void AIturntodecidetoexchangeornot2() throws Throwable
	{		
		test.aipHas();
		test.exchange();		
	}
	
	@When("^program check for the winner$")
	public void programcheckforthewinner() throws Throwable
	{		
		winner=test.winner();	
	}
	
	
	
	@Then("^AI wins$")
	public void AIwins() throws Throwable
	{
		
		assertEquals(Winner.AIP,winner);
	}
	@Then("^opponent wins$")
	public void opponentwins() throws Throwable
	{
		
		assertEquals(Winner.OPPONENT,winner);
	}
	
	@Given("^AI and opponent drawing following cards$")
	public void AIandopponentdrawingfollowingcards(DataTable table) {		
		List<List<String>> data=table.raw();
		System.out.println("-------------------");
		test.inputOP(data.get(0).get(0));
		temp=test.getHands();
	}


}
