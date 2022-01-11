package objects;

public class Charity {

    public Charity(String charityOrgName) {
        this.charityOrgName = charityOrgName;
    }

    public String getCharityOrgName() {
        return charityOrgName;
    }

    public void setCharityOrgName(String charityOrgName) {
        this.charityOrgName = charityOrgName;
    }

    private String charityOrgName;
}
