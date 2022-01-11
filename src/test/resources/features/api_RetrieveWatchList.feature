@API
Feature: Retrieves a list of items on the authenticated user's watchlist.
  URL:	https://api.trademe.co.nz/v1/MyTradeMe/Watchlist/{filter}.{file_format}
	HTTP Method:	GET
	Requires Authentication?	Yes
	Permission Required:	MyTradeMeRead: Read your membership & listing data.
	Supported Formats:	XML, JSON
	Rate Limited?	Yes

  Rule: Authentication required
    Background: TradeMe sandbox API is up and running

    @API @Regression
    Scenario Outline: Retrieve watchlist and validate details
      Given TradeMe API connection up
      When User retrieve the watchlist
      Then Verify the details Title "<title>" Region "<Region>" Suburb "<Suburb>" StartPrice "<StartPrice>" CategoryName "<CategoryName>"

      @STAGE  @API  @REGRESSION
      Examples:
        |  listingType  |  title  																	|  Region 		| Suburb 	| StartPrice  | CategoryName 	|
        |  Books  			|  Title - Book Listing Test Do not Delete  |  Auckland  	| Manukau | 1.0		  		| Author A-C 		|    