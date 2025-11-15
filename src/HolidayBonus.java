/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi
 * Description: This class makes the bonuses for all store data from files
 * Due: 11/14/12025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Dinesh Kolla
*/

public class HolidayBonus {
	public static final double HIGH_BONUS = 5000;    
    public static final double LOW_BONUS = 1000;     
    public static final double OTHER_BONUS = 2000;
    
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                
                    double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
                    double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
                    if (data[row][col] == highest) {
                        bonuses[row] += HIGH_BONUS;
                    } else if (data[row][col] == lowest) {
                        bonuses[row] += LOW_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
            }
        }
        return bonuses;
    }
    
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (int i = 0; i < bonuses.length; i++) {
            total += bonuses[i];
        }
        return total;
    }

}
