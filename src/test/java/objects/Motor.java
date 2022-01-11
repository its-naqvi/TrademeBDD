package objects;

public class Motor {

    public Motor(String make, String model, String yearFrom, String yearTo,
                 String priceFrom, String priceTo, String bodyStyle,
                 String numberPlate, String kilometer, String seats) {
        this.Make = make;
        this.Model = model;
        this.YearFrom = yearFrom;
        this.YearTo = yearTo;
        this.PriceFrom = priceFrom;
        this.PriceTo = priceTo;
        this.BodyStyle = bodyStyle;
        this.numberPlate = numberPlate;
        this.kilometer = kilometer;
        this.seats = seats;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getYearFrom() {
        return YearFrom;
    }

    public void setYearFrom(String yearFrom) {
        YearFrom = yearFrom;
    }

    public String getYearTo() {
        return YearTo;
    }

    public void setYearTo(String yearTo) {
        YearTo = yearTo;
    }

    public String getPriceFrom() {
        return PriceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        PriceFrom = priceFrom;
    }

    public String getPriceTo() {
        return PriceTo;
    }

    public void setPriceTo(String priceTo) {
        PriceTo = priceTo;
    }

    public String getBodyStyle() {
        return BodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        BodyStyle = bodyStyle;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getKilometer() {
        return kilometer;
    }

    public void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    private String Make;
    private String Model;
    private String YearFrom;
    private String YearTo;
    private String PriceFrom;
    private String PriceTo;
    private String BodyStyle;
    private String numberPlate;
    private String kilometer;
    private String seats;

}
