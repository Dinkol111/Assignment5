import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] testData;

    @BeforeEach
    void setUp() {
        testData = new double[][] {
            {12, 26},
            {34, 10, 45},
            {31, 59, 3, 7}
        };
    }

    @AfterEach
    void tearDown() {
        testData = null;
    }

    @Test
    void testGetTotal() {
        double total = TwoDimRaggedArrayUtility.getTotal(testData);
        assertEquals(227, total, 0.001);
    }

    @Test
    void testGetAverage() {
        double average = TwoDimRaggedArrayUtility.getAverage(testData);
        assertEquals(227.0 / 9, average, 0.001);
    }

    @Test
    void testGetRowTotal() {
        double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(testData, 1);
        assertEquals(34 + 10 + 45, rowTotal, 0.001);
    }

    @Test
    void testGetColumnTotal() {
        double colTotal = TwoDimRaggedArrayUtility.getColumnTotal(testData, 1);
        assertEquals(26 + 10 + 59, colTotal, 0.001);
    }

    @Test
    void testGetHighestInRow() {
        double highest = TwoDimRaggedArrayUtility.getHighestInRow(testData, 2);
        assertEquals(59, highest, 0.001);
    }

    @Test
    void testGetHighestInRowIndex() {
        int index = TwoDimRaggedArrayUtility.getHighestInRowIndex(testData, 2);
        assertEquals(1, index);
    }

    @Test
    void testGetLowestInRow() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInRow(testData, 2);
        assertEquals(3, lowest, 0.001);
    }

    @Test
    void testGetLowestInRowIndex() {
        int index = TwoDimRaggedArrayUtility.getLowestInRowIndex(testData, 2);
        assertEquals(2, index);
    }

    @Test
    void testGetHighestInColumn() {
        double highest = TwoDimRaggedArrayUtility.getHighestInColumn(testData, 0);
        assertEquals(34, highest, 0.001);
    }

    @Test
    void testGetHighestInColumnIndex() {
        int index = TwoDimRaggedArrayUtility.getHighestInColumnIndex(testData, 0);
        assertEquals(1, index);
    }

    @Test
    void testGetLowestInColumn() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(testData, 2);
        assertEquals(3, lowest, 0.001);
    }

    @Test
    void testGetLowestInColumnIndex() {
        int index = TwoDimRaggedArrayUtility.getLowestInColumnIndex(testData, 2);
        assertEquals(2, index);
    }

    @Test
    void testGetHighestInArray() {
        double highest = TwoDimRaggedArrayUtility.getHighestInArray(testData);
        assertEquals(59, highest, 0.001);
    }

    @Test
    void testGetLowestInArray() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInArray(testData);
        assertEquals(3, lowest, 0.001);
    }
}