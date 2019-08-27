/*
Class Containing the attributes for the requirements of a buyer
 */

public class Requirement {
    private int id;
    private double latitude;
    private double longitude;
    private int minBudget;
    private int maxBudget;
    private int maxBedroomsRequired;
    private int minBathroomsRequired;
    private int maxBathroomsRequired;

    public Requirement(int id, double latitude, double longitude, int minBudget, int maxBudget, int minBedroomsRequired, int maxBedroomsRequired, int minBathroomsRequired, int maxBathroomsRequired) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.minBudget = minBudget;
        this.maxBudget = maxBudget;
        this.minBedroomsRequired = minBedroomsRequired;
        this.maxBedroomsRequired = maxBedroomsRequired;
        this.minBathroomsRequired = minBathroomsRequired;
        this.maxBathroomsRequired = maxBathroomsRequired;
    }

    private int minBedroomsRequired;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getMinBudget() {
        return minBudget;
    }

    public void setMinBudget(int minBudget) {
        this.minBudget = minBudget;
    }

    public int getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(int maxBudget) {
        this.maxBudget = maxBudget;
    }

    public int getMinBedroomsRequired() {
        return minBedroomsRequired;
    }

    public void setMinBedroomsRequired(int minBedroomsRequired) {
        this.minBedroomsRequired = minBedroomsRequired;
    }

    public int getMaxBedroomsRequired() {
        return maxBedroomsRequired;
    }

    public void setMaxBedroomsRequired(int maxBedroomsRequired) {
        this.maxBedroomsRequired = maxBedroomsRequired;
    }

    public int getMinBathroomsRequired() {
        return minBathroomsRequired;
    }

    public void setMinBathroomsRequired(int minBathroomsRequired) {
        this.minBathroomsRequired = minBathroomsRequired;
    }

    public int getMaxBathroomsRequired() {
        return maxBathroomsRequired;
    }

    public void setMaxBathroomsRequired(int maxBathroomsRequired) {
        this.maxBathroomsRequired = maxBathroomsRequired;
    }

    boolean validateRequirements(){
        if(id>0 && Math.min(minBathroomsRequired,maxBathroomsRequired)==minBathroomsRequired && Math.max(minBathroomsRequired,maxBathroomsRequired)>0 && Math.min(minBedroomsRequired,maxBedroomsRequired)==minBedroomsRequired && Math.max(minBedroomsRequired,maxBedroomsRequired)>0){
            return true;
        }
        return false;
    }

}
