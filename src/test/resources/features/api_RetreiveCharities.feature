@API
Feature: Retrieve list of charities
	Retrieves a collection of charities available to donate to when listing.
	
	URL:	https://api.trademe.co.nz/v1/Charities.{file_format}
	HTTP Method:	GET
	Requires Authentication?	No
	Permission Required:	Public
	Supported Formats:	XML, JSON
	Rate Limited?	No

  Rule: No authentication required
    Background: TradeMe sandbox API is up and running

    @API @Regression
    Scenario Outline: Retrieve list of charities and validate details
      Given TradeMe API connection up
      When User retrieve list of charities
      Then Verify the charityDescription "<charityDescription>" Tagline "<Tagline>" CharityType <CharityType> details

      @STAGE @API @REGRESSION
      Examples:
        |  charityDescription  	|  Tagline																			| CharityType |
        |  St John  			|  To support St John Christchurch in the work they do in our community.  			| 3 		  |

      @PROD @API @REGRESSION
      Examples:
        |  charityDescription  	|  Tagline																			| CharityType |
        |  St John  			|  To support St John Christchurch in the work they do in our community.  			| 3 		  |
