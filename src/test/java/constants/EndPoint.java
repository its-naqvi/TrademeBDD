package constants;

public enum EndPoint {
    HOME("/"),
    RESULT("/result"),
    ApiRetreiveCharities("/Charities.json"),
    ApiRetreiveWatchList("/MyTradeMe/Watchlist/All.json"),
    ApiUsedMotorSearch("/Search/Motors/Used.json")
    ;

    public final String url;

    EndPoint(String url) {
        this.url = url;
    }
}
