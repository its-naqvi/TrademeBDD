@UI
Feature: Search Listing
  As a Web UI test: Query any existing Used Car listing and confirm that the following details
  are shown for that car and that the values always match
    o Number plate
    o Kilometres
    o Body
    o Seats

    @UI @Regression
    Scenario Outline: Search used motor listing and validate details
      Given User is on trademe Homepage
      And User open listing category type
        |Motors|
      When User search for ListingType "<ListingType>" Keywords "<Keywords>" Make "<Make>" Model "<Model>" YearFrom "<YearFrom>" YearTo "<YearTo>" PriceFrom "<PriceFrom>" PriceTo "<PriceTo>" BodyStyle "<BodyStyle>" listing
      And User open the desired listing from the result set based on kilometer "<kilometer>"
      Then Verify the listing numberPlate "<numberPlate>" kilometer "<kilometer>" BodyStyle "<BodyStyle>" seats "<seats>" details

      @STAGE @UI @REGRESSION
      Examples:
        |  ListingType  |  Keywords                         | Make  | Model   | YearFrom  | YearTo  | PriceFrom | PriceTo | BodyStyle         | numberPlate   | kilometer | seats |
        |  Used         |  2011 Honda Insight S             | Honda | Insight | 2011      | 2012    |    $5K    | $7.5K   |  Hatchback        | GBK395        | 138,000km  | 5     |
        |  All          |  2013 Toyota Aqua S- Package      |Toyota | Aqua    | 2013      | 2014    |    $5K    | $15K    |  Hatchback        | NGY965        | 148,992km  | 5     |


      @PROD @UI @REGRESSION
      Examples:
        |  ListingType  |  Keywords                         | Make  | Model   | YearFrom  | YearTo  | PriceFrom | PriceTo | BodyStyle         | numberPlate   | kilometer | seats |
        |  Used         |  2011 Honda Insight S             | Honda | Insight | 2011      | 2012    |    $5K    | $7.5K   |  Hatchback        | FUA149        | 115,000km  | 5     |
        |  All          |  2013 Toyota Aqua S- Package      |Toyota | Aqua    | 2013      | 2014    |    $5K    | $15K    |  Hatchback        | NGY965        | 148,992km  | 5     |
