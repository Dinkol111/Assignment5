import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestSudent {

	private double[][] testData = {
	        {12, 26},
	        {34, 10, 45},
	        {31, 59, 3, 7}
	    };

	    @Test
	    void testCalculateHolidayBonus() {
	        double[] bonuses = HolidayBonus.calculateHolidayBonus(testData);

	        double[] expected = new double[3];
	        expected[0] = 1000 + 2000;
	        expected[1] = 5000 + 1000 + 5000;
	        expected[2] = 2000 + 5000 + 1000 + 5000;

	        for (int i = 0; i < bonuses.length; i++) {
	            assertEquals(expected[i], bonuses[i], 0.001);
	        }
	    }

	    @Test
	    void testCalculateTotalHolidayBonus() {
	        double total = HolidayBonus.calculateTotalHolidayBonus(testData);

	        double expectedTotal = 27000;
	        assertEquals(expectedTotal, total, 0.001);
	    }
}