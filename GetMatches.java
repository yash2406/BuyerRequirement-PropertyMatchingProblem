import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetMatches {

    private final int EARTH_RADIUS = 3959;

    /*
    allProperties is a list of all the Properties of the Seller.
    It is a static member of the Main Class therefore accessed using Class Name.
    */
    public List<Matches> getMatches(Requirement req) {
        List<Matches> matchedList = new ArrayList<>();
        if (!req.validateRequirements()) {
            return matchedList;
        } else {
            for (Property prop : Main.allProperties) {
                double radiusPercent = getRadiusPercent(req.getLatitude(), req.getLongitude(), prop.getLatitude(), prop.getLatitude());
                double budgetDiffPercent = getBudgetDiffPercent(req.getMinBudget(), req.getMaxBudget(), prop.getPrice());
                double bedroomDiffPercent = getRoomDiffPercent(req.getMinBedroomsRequired(), req.getMaxBedroomsRequired(), prop.getNumberOfBedrooms());
                double bathroomDiffPercent = getRoomDiffPercent(req.getMinBathroomsRequired(), req.getMaxBathroomsRequired(), prop.getNumberOfBathrooms());
                double matchPercent = radiusPercent + budgetDiffPercent + bedroomDiffPercent + bathroomDiffPercent;

                if (matchPercent <= 40.0 && radiusPercent != -1 && budgetDiffPercent != -1 && bedroomDiffPercent != -1 && bathroomDiffPercent != -1) {
                    matchedList.add(new Matches(matchPercent, radiusPercent, budgetDiffPercent, bedroomDiffPercent, bathroomDiffPercent, prop));
                }
            }
            Collections.sort(matchedList, new MatchComp());
            return matchedList;
        }
    }

    /*
    Computes Match Radius Percentage
     */

    public double getRadiusPercent(double reqLat, double reqLong, double propLat, double propLong) {
        double x, y, z;
        x = Math.sin((propLat - reqLat) / 2);
        y = Math.sin((propLong - reqLong) / 2);
        z = Math.cos(reqLat) * Math.cos(propLat);
        double distance = 2.0 * EARTH_RADIUS * Math.asin(Math.sqrt(x * x + y * y * z));
        if (distance < 0 || distance > 10.0) {
            return -1;
        } else if (distance <= 2.0) {
            return 30.0;
        } else {
            return (30.0 * (11 - distance)) / 10.0;
        }
    }

    /*
    Computes Matched Budget Percentage
     */

    public double getBudgetDiffPercent(double reqMinBudget, double reqMaxBudget, double propPrice) {
        double diff = 1000000;
        if (reqMaxBudget > 0) {
            diff = 100.0 * (Math.abs(propPrice - reqMaxBudget) / reqMaxBudget);
        }
        if (reqMinBudget > 0) {
            diff = Math.min(diff, 100.0 * (Math.abs(propPrice - reqMinBudget) / reqMinBudget));
        }
        if (diff > 25.0) {
            return -1;
        }
        if (diff == 0) {
            return 30.0;
        }
        if (reqMinBudget > 0 && reqMaxBudget > 0) {
            if (propPrice >= reqMinBudget && propPrice <= reqMaxBudget) {
                return 30.0;
            } else {
                return (30.0 * (26 - diff)) / 25.0;
            }
        } else {
            if (diff == 10) {
                return 30.0;
            } else if (diff <= 10) {
                return (30.0 * (11 - diff)) / 10.0;
            } else {
                return -1;
            }
        }

    }

    /*
    Computes Match percentage for both Bedrooms and Bathrooms as per the parameter passed.
     */

    public double getRoomDiffPercent(int reqMinRoom, int reqMaxRoom, int propRoom) {
        if (reqMaxRoom > 0 && reqMinRoom > 0) {
            if (propRoom >= reqMinRoom && propRoom <= reqMaxRoom) {
                return 20.0;
            } else {
                int diff = 10;
                diff = Math.min(diff, Math.abs(propRoom - reqMinRoom));
                diff = Math.min(diff, Math.abs(propRoom - reqMaxRoom));
                if (diff > 2) {
                    return -1;
                } else if (diff == 0) {
                    return 20.0;
                } else if (diff == 1) {
                    return 13.0;
                } else {
                    return 6.0;
                }
            }
        } else {
            int diff = 10;
            if (reqMinRoom > 0) {
                diff = Math.min(diff, Math.abs(propRoom - reqMinRoom));
            }
            if (reqMaxRoom > 0) {
                diff = Math.min(diff, Math.abs(propRoom - reqMaxRoom));
            }
            if (diff == 0) {
                return 20.0;
            }
            return (20.0 * (11 - diff)) / 10.0;
        }
    }


}

/*
Comparator Logic for sorting all the Matched Items according to
1.) Match Percentage in Decreasing Order
2.) Matched Percentage of Radius in Descending Order
3.) Matched Percentage of Budget-Price Difference in Descending Order
4.) Sum of Matched Percentage of Bedrooms and Bathrooms in Decreasing Order
 */
class MatchComp implements Comparator<Matches> {

    @Override
    public int compare(Matches m1, Matches m2) {
        if (m1.getMatchPercent() != m2.getMatchBathroom()) {
            if (m1.getMatchPercent() < m2.getMatchPercent()) {
                return 1;
            } else {
                return -1;
            }
        }
        if (m1.getMatchRadius() != m2.getMatchRadius()) {
            if (m1.getMatchRadius() < m2.getMatchRadius()) {
                return 1;
            } else {
                return -1;
            }
        }
        if (m1.getMatchBudget() != m2.getMatchBudget()) {
            if (m1.getMatchBudget() < m2.getMatchBudget()) {
                return 1;
            } else {
                return -1;
            }
        }
        if ((m1.getMatchBedroom() + m1.getMatchBathroom()) <= (m2.getMatchBedroom() + m2.getMatchBathroom())) {
            return 1;
        }
        return -1;
    }
}
