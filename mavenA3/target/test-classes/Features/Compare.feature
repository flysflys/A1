Feature:AI is Playing Poker against the opponent

Scenario: opponent gets a Royal flush and AI has a Straight flush and opponent wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 SA S10 SQ SJ SK |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Royal flush and AI has a Four of a kinds and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 SA S10 SQ SJ SK |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Royal flush and AI has Full house and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 SA S10 SQ SJ SK |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Royal flush and AI has Flush and opponent wins
	Given AI and opponent drawing following cards
	|H10 H5 HJ HK H2 SA S10 SQ SJ SK |
	
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Royal flush and AI has straight and opponent wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 SA S10 SQ SJ SK |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Royal flush and AI has Three of a kinds and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 SA SA S10 SQ SJ SK |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Royal flush and AI has two pairs and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H2 S5 S2 SA S10 SQ SJ SK |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Royal flush and AI has a pair and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 S5 S2 SA S10 SQ SJ SK |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Royal flush and AI has no hands and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 SA S2 SA S10 SQ SJ SK |
	When program check for the winner
	Then opponent wins
	
	
Scenario: opponent gets a Straight flush and AI has a Four of a kinds and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 C5 C9 C8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Straight flush and AI has Full house and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 C5 C9 C8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Straight flush and AI has Flush and opponent wins
	Given AI and opponent drawing following cards
	|H10 H5 HJ HK H2 C5 C9 C8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Straight flush and AI has straight and opponent wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 C5 C9 C8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Straight flush and AI has Three of a kinds and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 SA C5 C9 C8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Straight flush and AI has two pairs and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H2 S5 S2 C5 C9 C8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Straight flush and AI has a pair and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 S5 S2 C5 C9 C8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a Straight flush and AI has no hands and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 SA S2 C5 C9 C8 C7 C6 |
	When program check for the winner
	Then opponent wins	
	

Scenario: opponent gets a four of a kind and AI has Full house and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 C5 D5 H5 S5 S2|
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a a four of a kind and AI has Flush and opponent wins
	Given AI and opponent drawing following cards
	|H10 H5 HJ HK H2 C5 D5 H5 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a a four of a kind and AI has straight and opponent wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 C5 D5 H5 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a a four of a kind and AI has Three of a kinds and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 SA C5 D5 H5 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a a four of a kind and AI has two pairs and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H2 S5 S2 C5 D5 H5 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a a four of a kind and AI has a pair and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 S5 S2 C5 D5 H5 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a a four of a kind and AI has no hands and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 SA S2 C5 D5 H5 S5 S2 |
	When program check for the winner
	Then opponent wins


Scenario: opponent gets a full house and AI has Flush and opponent wins
	Given AI and opponent drawing following cards
	|H10 H5 HJ HK H2 C5 D5 H2 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a full house and AI has straight and opponent wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 C5 D5 H2 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a full house and AI has Three of a kinds and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 SA C5 D5 H2 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a full house and AI has two pairs and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H2 S5 S2 C5 D5 H2 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a full house and AI has a pair and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 S5 S2 C5 D5 H2 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a full house and AI has no hands and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 SA S2 C5 D5 H2 S5 S2 |
	When program check for the winner
	Then opponent wins


Scenario: opponent gets a flush and AI has straight and opponent wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 C5 D5 H2 S5 S2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a flush and AI has Three of a kinds and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 SA H10 H5 HJ HK H2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a flush and AI has two pairs and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H2 S5 S2 H10 H5 HJ HK H2|
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a flush and AI has a pair and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 S5 S2 H10 H5 HJ HK H2 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a flush and AI has no hands and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 SA S2 H10 H5 HJ HK H2 |
	When program check for the winner
	Then opponent wins


Scenario: opponent gets a straight and AI has Three of a kinds and opponent wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 SA H5 C9 D8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a straight and AI has two pairs and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H2 S5 S2 H5 C9 D8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a straight and AI has a pair and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 S5 S2 H5 C9 D8 C7 C6 |
	When program check for the winner
	Then opponent wins
	
Scenario: opponent gets a straight and AI has no hands and opponent wins
	Given AI and opponent drawing following cards
	|C5 D6 H3 SA S2 H5 C9 D8 C7 C6 |
	When program check for the winner
	Then opponent wins








Scenario: AI gets a Royal flush and opponent has a Straight flush and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK C5 C9 C8 C7 C6|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Royal flush and opponent has a Four of a kinds and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK C5 D5 H5 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Royal flush and opponent has Full house and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK C5 D5 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Royal flush and opponent has Flush and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK H10 H5 HJ HK H2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Royal flush and opponent has straight and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK H5 C9 D8 C7 C6|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Royal flush and opponent has Three of a kinds and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK C5 D5 H2 S5 SA |
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Royal flush and opponent has two pairs and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK C5 D6 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Royal flush and opponent has a pair and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK C5 D6 H3 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Royal flush and opponent has no hands and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK C5 D6 H3 SA S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
	
Scenario: AI gets a Straight flush and opponent has a Four of a kinds and AI wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 C5 D5 H5 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Straight flush and opponent has Full house and AI wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 C5 D5 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Straight flush and opponent has Flush and AI wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 H10 H5 HJ HK H2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Straight flush and opponent has straight and AI wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 H5 C9 D8 C7 C6|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Straight flush and opponent has Three of a kinds and AI wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 C5 D5 H2 S5 SA |
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Straight flush and opponent has two pairs and AI wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 C5 D6 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Straight flush and opponent has a pair and AI wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 C5 D6 H3 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Straight flush and opponent has no hands and AI wins
	Given AI and opponent drawing following cards
	|C5 C9 C8 C7 C6 C5 D6 H3 SA S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins	
	

Scenario: AI gets a four of a kind and opponent has Full house and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 C5 D5 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a a four of a kind and opponent has Flush and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 H10 H5 HJ HK H2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a a four of a kind and opponent has straight and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 H5 C9 D8 C7 C6|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a a four of a kind and opponent has Three of a kinds and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 C5 D5 H2 S5 SA |
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a a four of a kind and opponent has two pairs and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 C5 D6 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a a four of a kind and opponent has a pair and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 C5 D6 H3 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a a four of a kind and opponent has no hands and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H5 S5 S2 C5 D6 H3 SA S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins


Scenario: AI gets a full house and opponent has Flush and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 H10 H5 HJ HK H2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a full house and opponent has straight and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 H5 C9 D8 C7 C6|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a full house and opponent has Three of a kinds and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 C5 D5 H2 S5 SA |
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a full house and opponent has two pairs and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 C5 D6 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a full house and opponent has a pair and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 C5 D6 H3 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a full house and opponent has no hands and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 C5 D6 H3 SA S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins


Scenario: AI gets a flush and opponent has straight and AI wins
	Given AI and opponent drawing following cards
	|C5 D5 H2 S5 S2 H5 C9 D8 C7 C6|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a flush and opponent has Three of a kinds and AI wins
	Given AI and opponent drawing following cards
	|H10 H5 HJ HK H2 C5 D5 H2 S5 SA |
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a flush and opponent has two pairs and AI wins
	Given AI and opponent drawing following cards
	|H10 H5 HJ HK H2 C5 D6 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a flush and opponent has a pair and AI wins
	Given AI and opponent drawing following cards
	|H10 H5 HJ HK H2 C5 D6 H3 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a flush and opponent has no hands and AI wins
	Given AI and opponent drawing following cards
	|H10 H5 HJ HK H2 C5 D6 H3 SA S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins


Scenario: AI gets a straight and opponent has Three of a kinds and AI wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 C5 D5 H2 S5 SA |
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a straight and opponent has two pairs and AI wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 C5 D6 H2 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a straight and opponent has a pair and AI wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 C5 D6 H3 S5 S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a straight and opponent has no hands and AI wins
	Given AI and opponent drawing following cards
	|H5 C9 D8 C7 C6 C5 D6 H3 SA S2|
	And AI decides to exchange the cards or not          
	When program check for the winner
	Then AI wins

	
	
	
	
	
	
	
Scenario: AI gets a spades Royal flush and opponent has a cube Royal flush and AI wins
	Given AI and opponent drawing following cards
	|SA S10 SQ SJ SK CA C10 CJ CK CQ|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a Straight flush with highest 10 and opponent has a Straight flush with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|S7 S8 S9 S6 S10 C3 C7 C6 C5 C4|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a spades Straight flush with highest 10 and opponent has a cube Straight flush with highest 10 and AI wins
	Given AI and opponent drawing following cards
	|S7 S8 S9 S6 S10 C7 C8 C9 C6 C10|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a 4 of a kind with highest 10 and opponent has a 4 of a kind with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|S10 C10 D10 H10 C5 C7 S7 H7 D7 CJ|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a full house with highest 10 and opponent has a full house with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|S10 C10 D10 H5 C5 C7 S7 H7 DJ CJ|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a 3 of a kind with highest 10 and opponent has a 3 of a kind with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|S10 C10 D10 H2 C5 C7 S7 H7 D3 CJ H6|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a flush with highest 10 and opponent has a flush with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|H3 H4 H9 H10 H5 C3 C2 C4 C5 C7|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a spade flush with highest 10 and opponent has a cube flush with highest 10 and AI wins
	Given AI and opponent drawing following cards
	|H3 H4 H9 H10 H5 C3 C4 C9 C10 C5|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a straight with highest 10 and opponent has a straight with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|H7 H8 H9 H10 D6 C3 C4 S6 C7 C5|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a straight with highest spades 10 and opponent has a straight with highest cube 10 and AI wins
	Given AI and opponent drawing following cards
	|H7 H8 H9 S10 D6 C7 C8 C9 H10 S6|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a two pairs with highest 10 and opponent has a two pairs with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|C10 S10 S5 H5 H6 S7 C7 D2 D10 S2|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a two pairs with highest spades 10 and opponent has a two pairs with highest hearts 10 and AI wins
	Given AI and opponent drawing following cards
	|C10 S10 S5 H5 H6 S7 C7 D2 D10 H10|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a pair with highest 10 and opponent has a pair with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|C10 S10 S4 H5 H6 S7 C7 D8 D10 S2|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets a pair with highest 10 and opponent has a pair with highest hearts 10 and AI wins
	Given AI and opponent drawing following cards
	|C10 S10 S4 H5 H6 S3 C7 D8 D10 H10|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets no hand but with highest 10 and opponent has no hands but with highest 7 and AI wins
	Given AI and opponent drawing following cards
	|C10 S3 S4 H5 H6 S3 C7 D8 D2 H5|
	When program check for the winner
	Then AI wins
	
Scenario: AI gets no hand but with highest spades 10 and opponent has no hands but with highest cube 10 and AI wins
	Given AI and opponent drawing following cards
	|S10 S3 S4 H5 H6 S3 C10 D8 D2 H5|
	When program check for the winner
	Then AI wins