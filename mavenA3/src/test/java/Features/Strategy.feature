Feature:AI is Playing Poker and using its Strategies againest opponent

Scenario: AI has one card away from royal flush and it does exchange it and opponent gets a straight flush and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|HA S7 HQ HJ HK C5 C9 C8 C7 C6 H10|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game
	
Scenario: AI has one card away from royal flush and it does exchange it and opponent gets a straight flush and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|HA S7 HQ HJ HK C5 C9 C8 C7 C6 D3|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game


Scenario: AI has one card away from straight flush and it does exchange it and opponent gets a four of a kinds and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|H10 C7 HQ HJ H9 C5 D5 H5 S5 S2 H8|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game
	
Scenario: AI has one card away from straight flush and it does exchange it and opponent gets a four of a kinds and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|H10 C7 HQ HJ H9 C5 D5 H5 S5 S2 H3|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

Scenario: AI has a three of a kinds and it does exchange it and opponent gets straight and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|D5 S5 C5 C3 S2 H5 C9 D8 C7 C6 H3|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game	
	
Scenario: AI has a three of a kinds and it does exchange it and opponent gets straight and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|D5 S5 C5 C3 S2 H5 C9 D8 C7 C6 H9|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

Scenario: AI has a two pairs and it does exchange it and opponent gets straight and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|D5 S7 C5 C3 S3 H5 C9 D8 C7 C6 H3|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game	
	
	
Scenario: AI has a two pairs and it does exchange it and opponent gets straight and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|D5 S7 C5 C3 S3 H5 C9 D8 C7 C6 H9|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

Scenario: AI has a one card away from flush and it does exchange it and opponent gets straight and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|H7 D7 HA H6 H2 H5 C9 D8 C7 C6 H9|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game	
	
	
Scenario: AI has a one card away from flush and it does exchange it and opponent gets straight and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|H7 D7 HA H6 H2 H5 C9 D8 C7 C6 D3|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

Scenario: AI has a one card away from Straight and it does exchange it and opponent gets three of a kinds and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|D2 C3 H4 C9 DA C5 D5 H2 S5 SA D5|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game	
	
	
Scenario: AI has a one card away from Straight and it does exchange it and opponent gets three of a kinds and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|D2 C3 H5 C6 D9 C5 D5 H2 S5 SA C7|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

Scenario: AI has a 3 cards of the same suit and it does exchange it and opponent gets three of a kinds and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|S2 C3 DJ D6 D9 C5 D5 H2 S5 SA D10 D4|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game	
	
	
Scenario: AI has a 3 cards of the same suit and it does exchange it and opponent gets three of a kinds and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|S2 C3 DJ D6 D9 C5 D5 H2 S5 SA D10 C4|
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

Scenario: AI has a 3 cards in sequence and it does exchange it and opponent gets three of a kinds and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|HK S3 HQ DJ DK C5 D5 H2 S5 SA D9 C10 |
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game	
	
	
Scenario: AI has a 3 cards in sequence and it does exchange it and opponent gets three of a kinds and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|HK S3 HQ DJ DK C5 D5 H2 S5 SA D2 C10 |
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

Scenario: AI has a pair and it does exchange it and opponent gets three of a kinds and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|S5 D7 D2 S4 H4 C5 D5 H2 S5 SA D10 C10 S10 |
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game	
	
	
Scenario: AI has a 3 pair and it does exchange it and opponent gets three of a kinds and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|S5 D7 D2 S4 H4 C5 D5 H2 S5 SA DA C10 S10 |
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

Scenario: AI has no hands it exchange lowest 3 it and opponent gets three of a kinds and AI wins
	Given AI drawing following cards and opponent also draw the cards
	|C3 S9 D7 DQ HJ C5 D5 H2 S5 SA C10 S9 CK |
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then AI wins the game	
	
	
Scenario: AI has no hands it exchange lowest 3 it and opponent gets three of a kinds and opponent wins
	Given AI drawing following cards and opponent also draw the cards
	|C3 S9 D7 DQ HJ C5 D5 H2 S5 SA CA S9 CK |
	When AI decides to exchange or not
	Then AI exchange it	
	When program decide who is the winner
	Then opponent wins the game

	