@API
Feature: Used motors search
	Performs a filtered keyword search in the Used cars section of Trade Me Motors.

	URL:	https://api.trademe.co.nz/v1/Search/Motors/Used.{file_format}
	HTTP Method:	GET
	Requires Authentication?	Yes
	Permission Required:	None
	Supported Formats:	XML, JSON
	Rate Limited?	Yes
	
  As a API test: Query any existing Used Car listing and confirm that the following details
  are shown for that car and that the values always match
    o Number plate
    o Kilometres
    o Body
    o Seats

  Rule: Authentication required
    Background: TradeMe sandbox API is up and running

    @API @Regression
    Scenario Outline: Search listing and validate details
      Given TradeMe API connection up
      When User search Keywords "<Keywords>" Make "<Make>" Model "<Model>" YearFrom "<YearFrom>" YearTo "<YearTo>" PriceFrom "<PriceFrom>" PriceTo "<PriceTo>" BodyStyle "<BodyStyle>" listing
      Then Verify the details numberPlate "<numberPlate>" kilometer "<kilometer>" body "<body>" seats "<seats>"

      @STAGE @API @REGRESSION
      Examples:
        |  Keywords                           | Make  | Model   | YearFrom  | YearTo  | PriceFrom | PriceTo | BodyStyle      | numberPlate    | kilometer | body          | seats |
        |  2012 Honda Insight ** G            | Honda | Insight | 2011      | 2012    |    5000    | 7500   |  Sedan        | LTW123          | 48803     | sedan         | 5     |
        |  2014 Toyota Aqua G, Push Start     |Toyota | Aqua    | 2013      | 2014    |    10000   | 15000  |  Hatchback    | LTW321          | 91565     | Hatchback     | 5     |