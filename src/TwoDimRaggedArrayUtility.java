/*
 * Class: CMSC203 
 * Instructor:Farnaz Eivazi
 * Description:This class is only for methods consisting of ragged arrays
 * Due: 11/14/2025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Dinesh Kolla
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class TwoDimRaggedArrayUtility {

	public static double[][] readFile(File file) throws FileNotFoundException{
		String[][] temp = new String[10][10];
		Scanner input = new Scanner(file);
		int row = 0;

      while (input.hasNextLine() && row < 10) {
			String temporary = input.nextLine();
			int col = 0;
			while (!temporary.equals("") && col < 10) {
			    int spaceIndex = temporary.indexOf(" ");
			    String number;
			    if (spaceIndex == -1) {
			        number = temporary;
			        temporary = "";
			    } else {
			        number = temporary.substring(0, spaceIndex);
			        temporary = temporary.substring(spaceIndex + 1);
			    }
			    temp[row][col] = number;
			    col++;
			}
			row++;		
      }
      input.close();

      double[][]array = new double[row][];
      
      for (int r = 0; r < row; r++) {
          int colCount = 0;
          for (int c = 0; c < 10; c++) {
              if (temp[r][c] != null) {
                  colCount++;
              } else {
                  break;
              }
          }
          array[r] = new double[colCount];
          for (int c = 0; c < colCount; c++) {
              array[r][c] = Double.parseDouble(temp[r][c]);
          }
      }
      return array;
      
	}
	
	public static void writeToFile(double[][] data,File outputFile) throws FileNotFoundException {
		PrintWriter printer = new PrintWriter(outputFile);
		for(int r = 0;r<data.length;r++) {
			for(int c = 0;c<data[r].length;c++) {
				printer.print(data[r][c]+" ");
			}
			printer.println(); 
		}
		printer.close();
	}
	
	public static double getTotal(double[][] data) {
		double total = 0;
		for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                total+=data[r][c];
            }
        }
		return total;
		
	}
	
	public static double getAverage(double[][] data) {
		double average = 0;
		int nums= 0;
		for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                average+=data[r][c];
                nums++;
            }
        }
		average/=nums;
		return average;
	}
	
	public static double getRowTotal(double[][] data,int row) {
		double total=0;
		for(int c = 0;c<data[row].length;c++) {
			total+=data[row][c];
		}
		return total;
	}

	public static double getColumnTotal(double[][] data,int col) {
		double total = 0;
		for(int r = 0;r<data.length;r++) {
			if (col < data[r].length)
			total+=data[r][col];
		}
		return total;
	}
	
	public static double getHighestInRow(double[][] data,int row) {
	    double highest = data[row][0]; 
		for(int c = 1;c<data[row].length;c++) {
			if(data[row][c]>highest) {
				highest = data[row][c];
			}
		}
		return highest;
	}
	
	public static int getHighestInRowIndex(double[][] data,int row) {
		double highest = data[row][0]; 
		int index = 0;
		for(int c = 1;c<data[row].length;c++) {
			if(data[row][c]>highest) {
				highest = data[row][c];
				index = c;
			}
		}
		return index;
	}
	
	public static double getLowestInRow(double[][] data,int row) {
		double lowest = data[row][0]; 
		for(int c = 1;c<data[row].length;c++) {
			if(lowest>data[row][c]) {
				lowest = data[row][c];
			}
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data,int row) {
		double lowest = data[row][0]; 
		int index = 0;
		for(int c = 1;c<data[row].length;c++) {
			if(lowest>data[row][c]) {
				lowest = data[row][c];
				index = c;
			}
		}
		return index;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
	    double highest = 0;
	    for (int r = 0; r < data.length; r++) {
	        if (col < data[r].length) {
	            highest = data[r][col];
	            break;
	        }
	    }
	    for (int r = 0; r < data.length; r++) {
	        if (col < data[r].length) {
	            if (data[r][col] > highest) {
	                highest = data[r][col];
	            }
	        }
	    }

	    return highest;
	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
	    double highest = 0;
		int index = 0;
		for (int r = 0; r < data.length; r++) {
	        if (col < data[r].length) {
	            highest = data[r][col];
	            index = r;
	            break;
	        }
	    }

	    for (int r = index + 1; r < data.length; r++) {
	        if (col < data[r].length) {
	            if (data[r][col] > highest) {
	                highest = data[r][col];
	                index = r;
	            }
	        }
	    }

	    return index;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
	    double lowest = 0;
	    for (int r = 0; r < data.length; r++) {
	        if (col < data[r].length) {
	            lowest = data[r][col];
	            break;
	        }
	    }
	    for (int r = 0; r < data.length; r++) {
	        if (col < data[r].length) {
	            if (data[r][col] < lowest) {
	                lowest = data[r][col];
	            }
	        }
	    }

	    return lowest;
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {
	    double lowest = 0;
	    int index = 0;
	    for (int r = 0; r < data.length; r++) {
	        if (col < data[r].length) {
	            lowest = data[r][col];
	            index = r;
	            break;
	        }
	    }

	    for (int r = index + 1; r < data.length; r++) {
	        if (col < data[r].length) {
	            if (data[r][col] < lowest) {
	                lowest = data[r][col];
	                index = r;
	            }
	        }
	    }

	    return index;
	}

	public static double getHighestInArray(double[][] data) {
	    double highest = data[0][0];
	    for (int r = 0; r < data.length; r++) {
	        for (int c = 0; c < data[r].length; c++) {
	            if (data[r][c] > highest) {
	                highest = data[r][c];
	            }
	        }
	    }
	    return highest;
	}

	public static double getLowestInArray(double[][] data) {
	    double lowest = data[0][0];
	    for (int r = 0; r < data.length; r++) {
	        for (int c = 0; c < data[r].length; c++) {
	            if (data[r][c] < lowest) {
	                lowest = data[r][c];
	            }
	        }
	    }
	    return lowest;
	}



}
