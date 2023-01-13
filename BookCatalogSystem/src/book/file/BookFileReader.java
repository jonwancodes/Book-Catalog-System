
package book.file;

import java.io.*;
import java.util.*;

/**
 * Manages the loading of book files.
 * @author Jonathan Wan
 *
 */
public class BookFileReader {

	/**
	 * Loads the given filename and adds each line to a list.
	 * Ignores lines with only whitespace.
	 * @param fileName to load
	 * @return list of lines from the file
	 */
	public static List<String> parseFile(String fileName) {
		
		//create an array list to store the the lines of each given book file
		ArrayList<String> lineList = new ArrayList<String>();
		
		//create file object
		File file = new File(fileName);
		
		//create file reader
		FileReader fileReader = null;
		
		//define buffered reader
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			
			//read each line of book
			while ((line = bufferedReader.readLine()) != null) {
				
				//strip leading and trailing white space from each line
				line = line.strip();
				
				//adds non-whitespace lines to the list of lines
				if (line != "") {
					lineList.add(line);
				}
			}
			
		} catch (FileNotFoundException e) {
			//gets and prints filename
			System.out.println("Sorry, " + file.getName() + " not found.");
		} catch (IOException e) {
			//prints the error message and info about which line
			e.printStackTrace();
		} finally {
			
			//regardless, close file objects
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return lineList;
	}
	
	///// DO NOT CHANGE CODE IN MAIN METHOD! /////
	public static void main(String[] args) {
		
		//load and parse book file cat in the hat
		List<String> catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		
		//get first 10 lines of cat in the hat
		System.out.println("GET FIRST 10 LINES FROM CAT IN THE HAT\n");
		int count = 0;
		for (String line : catInTheHat) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
		
		//load and parse book file war and peace
		List<String> warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		
		//get first 10 lines of war and peace
		System.out.println("\n\nGET FIRST 10 LINES FROM WAR AND PEACE\n");
		count = 0;
		for (String line : warAndPeace) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
		//load and parse book file siddhartha
		List<String> siddhartha = BookFileReader.parseFile("siddhartha.txt");
		
		//get first 10 lines of siddhartha
		System.out.println("\n\nGET FIRST 10 LINES FROM SIDDHARTHA\n");
		count = 0;
		for (String line : siddhartha) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
	}
}