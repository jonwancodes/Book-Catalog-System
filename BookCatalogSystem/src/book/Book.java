package book;

import java.util.*;
import java.util.regex.*;
import book.file.BookFileReader;

/**
 * Represents a book to be cataloged.
 * @author Jonathan Wan
 * 
 */
public class Book {

	/**
	 * Title of book.
	 */
	private String title;
	
	/**
	 * Author of book.
	 */
	private String author;
	
	/**
	 * Lines in book.
	 */
	private List<String> lines;
	
	/**
	 * Count of words in book.
	 */
	private int wordCount;
	
	/**
	 * Count of each word in book.
	 */
	private Map<String, Integer> wordCounts;
	
	/**
	 * Creates a book with the given list of lines.
	 * Parses the title and author of the book.
	 * Sets the total count of words, and the count of each word in the book.
	 * @param lines of text
	 */
	public Book(List<String> lines) {
		this.lines = lines;
		this.setTitleAndAuthor();
		this.countWords();
	}
	
	/**
	 * Parses the title and author of the book in the list of lines.
	 * 
	 * To get the title of the book, looks for "Title:" at the beginning of a line, and gets the text after it.
	 * Example: 
	 * - Title: Catcher in the Rye
	 * - "Catcher in the Rye" becomes the book title
	 * 
	 * To get the author of the book, looks for "Author:" at the beginning of a line, and gets the text after it.
	 * Example:
	 * - Author: J.D. Salinger
	 * - "J.D. Salinger" becomes the author
	 * 
	 * Note, there should only be, at most, one title and/or author of the book in the list of lines.
	 * i.e. "Title:" and/or "Author:" will never show up more than once in the list of lines.
	 */
	private void setTitleAndAuthor() {
		
		//Iterate over each line in the book and look for lines starting with "Title:" and "Author:"
		for (String line:lines) {
			
			// If a line starts with "Title:", get the text after it, and set this.title.
			if (line.contains("Title:")){
				String[] titleList = line.split(":");
				title = titleList[1].strip();
			}
			
			// If a line starts with "Author:", get the text after it, and set this.author.
			if (line.contains("Author:")){
				String[] authorList = line.split(":");
				author = authorList[1].strip();
			}
		}
	}
	
	/**
	 * Gets the book title.
	 * Returns null if title doesn't exist.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the book author.
	 * Returns null if author doesn't exist.
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * 
	 * Splits the given string based on the given regex patter
	 * @param str to split
	 * @param regex pattern to match
	 * @return String array of tokens (strings)
	 */
	public static String[] splitString(String str, String regex) {
		//split given string based on given regex
		
		return str.split(regex);
	}
	
	/**
	 * Takes a given array of strings and returns a map with a key for each different string
	 * and a value for the count of the number of times that string appears in the array
	 * @param strings to count
	 * @return map of word counts, where key is word and value is count
	 */
	public static Map<String, Integer> wordCount(ArrayList<String> strings){
		
		//Creates Hash Map
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//iterate over array of strings
		for (String s : strings) {
			
			//if map doesn't contain a key for string, add it
			if (!map.containsKey(s)) {
				
				//adds key with default count 1
				map.put(s, 1);
			}else {
				
				//replace old count with incremented count
				map.replace(s, map.get(s)+1);
			}
		}
		return map;
	}
	
	/**
	 * Counts the total number of words in the list of lines.
	 * Also counts the number of times each word appears in the list of lines.  
	 * Does not consider case when comparing words.  e.g. "Love" is the same word as "love".
	 * 
	 * For consistency, words should include a sequence of any of the following characters:
	 * a-z, A-Z, 0-9, _, %, +, -
	 * 
	 * Examples of valid words:
	 *  "Hello" would be considered "hello"
	 *  "HI" would be considered "hi"
	 *  "two-fold" would be considered "two-fold"
	 *  "34%" would be considered "34%"
	 *  "very_good" would be considered "very_good"
	 *  "678" would be considered "678"
	 *  "EdWaRd" would be considered "edward"
	 *  "1+2" would be considered "1+2"
	 *  "away--you" would be considered "away--you"
	 *  
	 * Strings with valid and invalid characters:
	 *  "Sit!" would be considered "sit" because "!" is not a valid character
	 *  "One." would be considered "one" because "." is not a valid character
	 *  "1.F.4" would be considered "1" and "f" and "4" because "." is not a valid character
	 *  "$5,000" would be considered "5" and "000" because "$" and "," are not a valid characters
	 *  "Stand!Stand%Stand*" would be considered "stand" and "stand%stand" because "!" and "*" are not a valid characters, but "%" is
	 *  "*hello" would be considered "hello" because "*" is not a valid character
	 */
	private void countWords() {

		//[^a-zA-Z0-9_%+-] indicates a character class
		//negates any values that are a-z, A-Z, 0-9, _, %, +, and -
		String regex = "[^a-zA-Z0-9_%+-]";
		
		//An array list to store all the valid words of a book
		ArrayList<String> allValidWords = new ArrayList<String>();
		
		//iterate over lines
		for (String line : lines) {
			//strip white space and set strings to lower case
			line = line.strip().toLowerCase();
			//split the line by single space
			String[] words = Book.splitString(line, "\\s+");
			
			//iterate over the words and split by invalid words with regex pattern
			for (String word : words) {
				String[] validWords = Book.splitString(word, regex);
				for (String validWord : validWords) {
					//only look for non-empty space words
					if (validWord != "") {
						
						//an array list of all valid words
						allValidWords.add(validWord);
					}
				}
			}
		}
		//store word count
		this.wordCounts = Book.wordCount(allValidWords);
		
		int count = 0;
		for (String key : this.wordCounts.keySet()) {
			count += this.wordCounts.get(key);
		}
		this.wordCount = count;
	}
	
	/**
	 * Gets total count of all words.
	 * @return count of all words
	 */
	public int getTotalWordCount() {
		return this.wordCount;
	}

	/**
	 * Gets unique count of words.
	 * Does not consider case when counting words.  e.g. "Love" is the same word as "love".
	 * 
	 * Example: "One Two two Three three three" has only 3 unique words.
	 * 
	 * @return count of unique words
	 */
	public int getUniqueWordCount() {
		return this.wordCounts.size();
	}
	
	/**
	 * Gets the count of the given word.
	 * Does not consider case when counting words.  e.g. "Love" is the same word as "love".
	 * Returns 0 if the given word doesn't exist.
	 * 
	 * @param word to count
	 * @return count of given word
	 */
	public int getSpecificWordCount(String word) {
		
		//if word exists in the the dictionary
		if (this.wordCounts.containsKey(word)) {
			
			//return the count of given word
			return this.wordCounts.get(word);
		}
		//else return 0
		return 0;
	}
	
	/**
	 * Gets the book lines.
	 * @return lines in book
	 */
	public List<String> getLines() {
		return this.lines;
	}
	
	///// DO NOT CHANGE CODE IN MAIN METHOD! /////
	public static void main(String[] args) {
	    
		//load and parse book files
		List<String> catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		List<String> warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		List<String> siddhartha = BookFileReader.parseFile("siddhartha.txt");
		
		//create instances of book with lists above
		Book catInTheHatBook = new Book(catInTheHat);
		Book warAndPeaceBook = new Book(warAndPeace);
		Book siddharthaBook = new Book(siddhartha);
			
		//get lines from books
		System.out.println("\nGET FIRST 3 LINES");
		System.out.println(catInTheHatBook.getLines().subList(0, 3));
		System.out.println(warAndPeaceBook.getLines().subList(0, 3));
		System.out.println(siddharthaBook.getLines().subList(0, 3));
				
		//get titles of books
		System.out.println("\nGET TITLES");
		String catInTheHatBookTitle = catInTheHatBook.getTitle();
		System.out.println(catInTheHatBookTitle);
		String warAndPeaceBookTitle = warAndPeaceBook.getTitle();
		System.out.println(warAndPeaceBookTitle);
		String siddharthaBookTitle = siddharthaBook.getTitle();
		System.out.println(siddharthaBookTitle);
		
		//get authors of books
		System.out.println("\nGET AUTHORS");
		String catInTheHatBookAuthor = catInTheHatBook.getAuthor();
		System.out.println(catInTheHatBookAuthor);
		String warAndPeaceBookAuthor = warAndPeaceBook.getAuthor();
		System.out.println(warAndPeaceBookAuthor);
		String siddharthaBookAuthor = siddharthaBook.getAuthor();
		System.out.println(siddharthaBookAuthor);
		
		
		//get total word counts from books
		System.out.println("\nGET TOTAL WORD COUNTS");
		System.out.println(catInTheHatBook.getTotalWordCount());
		System.out.println(warAndPeaceBook.getTotalWordCount());
		System.out.println(siddharthaBook.getTotalWordCount());
		
		//get total word counts from books
		System.out.println("\nGET UNIQUE WORD COUNTS");
		System.out.println(catInTheHatBook.getUniqueWordCount());
		System.out.println(warAndPeaceBook.getUniqueWordCount());
		System.out.println(siddharthaBook.getUniqueWordCount());
		
		//get specific word counts from books
		System.out.println("\nGET SPECIFIC WORD COUNTS");
		System.out.println(catInTheHatBook.getSpecificWordCount("sit"));
		System.out.println(warAndPeaceBook.getSpecificWordCount("love"));
		System.out.println(siddharthaBook.getSpecificWordCount("hate"));
	}
	
}
