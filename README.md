# BuyerRequirement-Property Matching Problem

Algorithm for the priority based matching of a particular buyer's requirement to list of properties.

Assumptions Used:

1.) Main Class is assumed to be present by default and it contains a main function which fetches the list of properties from the SQL database and it stores it in a Static ArrayList named as "allProperties".
<br>
2.) Match Percentage computation for different attributes has been carried out uniformly over the acceptable range.
<br>
3.) If either of the min/max bedrooms or bathrooms are not there then 0 is passed.
<br>
4.) Latitutde and Longitude are considered to be in Radians and budgets and prices are assumed to be integers.

<ul>
<li> For each of the requirement, Method getMatches() of GetMatches Class will be called which will then take the requirements Object as a parameter.</li>

<li> ArrayList matchedList contains the user matched properties list based on certain attributes i.e. matched percentage should be >=40% etc. </li>

<li> Then ValidateRequirements() Method will be called using that Object to check the validity of different parameters of user requirements. </li>

<li> If the Method returns false, an empty ArrayList will be returned which indicates that there is no matching as per user requirements. </li>

<li> Otherwise the match percentage using different attributes will be computed and it will be checked based on the functional requirements defined in the problem statement. </li>

</ul>

Methods Used:

Whenever a new requirement comes to our system then the following methods are called for each property.

getRadiusPercent() - Used to calculate the match percentage using latitude and longitude of the requirements and the property.

getBudgetDiffPercent() - Used to calculate the match percentage using minBudget and maxBudget of the requirements and the price of the property.

getRoomDiffPercent() - Used to calculate the match percentage of Bedrooms and Bathrooms of requirements and property.

For each of the above method, uniform distribution is used for calculating the match percentage for each attribute A.
e.g Let A represent Radius. Now, if value of A is <=2 then 30 is returned, if it is >10 then -1 is returned, otherwise if it is between 3 and 10 then match percentage is assigned uniformly as (30*((10+1)-A))/10 and returned.

Uniform Computation similar to above is done for other attributes also.
