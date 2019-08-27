/*
Class for Overall Match Percentage, Match Percentage by Distance, Budget, Bedrooms and Bathrooms b/w a requirement and a property.
 */

public class Matches {
    private double matchPercent;
    private double matchRadius;
    private double matchBudget;
    private double matchBathroom;
    private double matchBedroom;
    private Property property;

    public double getMatchPercent() {
        return matchPercent;
    }

    public void setMatchPercent(double matchPercent) {
        this.matchPercent = matchPercent;
    }

    public double getMatchRadius() {
        return matchRadius;
    }

    public void setMatchRadius(double matchRadius) {
        this.matchRadius = matchRadius;
    }

    public double getMatchBudget() {
        return matchBudget;
    }

    public void setMatchBudget(double matchBudget) {
        this.matchBudget = matchBudget;
    }

    public double getMatchBathroom() {
        return matchBathroom;
    }

    public void setMatchBathroom(double matchBathroom) {
        this.matchBathroom = matchBathroom;
    }

    public double getMatchBedroom() {
        return matchBedroom;
    }

    public void setMatchBedroom(double matchBedroom) {
        this.matchBedroom = matchBedroom;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Matches(double matchPercent, double matchRadius, double matchBudget, double matchBathroom, double matchBedroom, Property property) {
        this.matchPercent = matchPercent;
        this.matchRadius = matchRadius;
        this.matchBudget = matchBudget;
        this.matchBathroom = matchBathroom;
        this.matchBedroom = matchBedroom;
        this.property = property;
    }


}
