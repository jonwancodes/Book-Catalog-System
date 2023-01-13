// 20220418
package book;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import book.file.BookFileReader;

class BookTest {
	
	// lists to store lines from different loaded book files
	List<String> catInTheHat;
	List<String> warAndPeace;
	List<String> siddhartha;
	
	// book objects to be created from lines 
	Book catInTheHatBook;
	Book warAndPeaceBook;
	Book siddharthaBook;
		
	@BeforeEach
	void setUp() throws Exception {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//load and parse cat in the hat snippet book file
		this.catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		
		//create book object from list of lines from cat in the hat snippet
		this.catInTheHatBook = new Book(this.catInTheHat);
		
		//load and parse war and peace book file
		this.warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		
		//create book object from list of lines from war and peace
		this.warAndPeaceBook = new Book(this.warAndPeace);
		
		//load and parse siddhartha book file
		this.siddhartha = BookFileReader.parseFile("siddhartha.txt");
		
		//create book object from list of lines from siddhartha
		this.siddharthaBook = new Book(this.siddhartha);
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
	}
	
	@Test
	void testBook() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create empty list and book
		List<String> bookLines = new ArrayList<String>();
		Book book = new Book(bookLines);
		
		//confirm book lines is empty
		assertEquals(0, book.getLines().size(), "The number of book lines should be 0.");
		
		//create list with 2 lines and book
		String[] actualLinesArr = {"My book's first line.", "My book's second line."};
		bookLines = new ArrayList<String>(Arrays.asList(actualLinesArr));
		book = new Book(bookLines);
				
		//create array with 2 expected lines 
		String[] expectedLinesArr = {"My book's first line.", "My book's second line."};
		List<String> expectedLines = new ArrayList<String>(Arrays.asList(expectedLinesArr));
						
		//compare to 2 actual lines 
		assertEquals(expectedLines, book.getLines(), "The expected lines do not match the actual book lines.");
		
		//create array with first 3 expected lines of cat in the hat snippet
		String[] expectedLines1Array = {
			"Title: The Cat in the Hat",
			"Author: Dr. Seuss",
			"The sun did not shine."
		};
		List<String> expectedLines1 = new ArrayList<String>(Arrays.asList(expectedLines1Array));
				
		//compare to first 3 actual lines from cat in the hat
		assertEquals(expectedLines1, this.catInTheHatBook.getLines().subList(0, 3), "The expected 3 lines do not match the actual first 3 'The Cat in the Hat' book lines.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
	
		
		//Compare lines for siddhartha book object
		
		//create array with first 3 expected lines of siddhartha snippet
		String [] expectedLines2Array = {
				"Title: Siddhartha",
				"Author: Hermann Hesse",
				"Translator: Gunther Olesch, Anke Dreher, Amy Coulter, Stefan Langer and Semyon Chaichenets"
			};
		List<String> expectedLines2 = new ArrayList<String>(Arrays.asList(expectedLines2Array));
					
		//compare to first 3 actual lines from siddhartha
		assertEquals(expectedLines2, this.siddharthaBook.getLines().subList(0, 3), "The expected 3 lines do not match the actual first 3 'Siddhartha' book lines.");
		
		
		//Compare lines for war and peace book object
		
		String [] expectedLines3Array = {
				"Title: War and Peace",
				"Author: Leo Tolstoy",
				"Translators: Louise and Aylmer Maude"
			};
		List<String> expectedLines3 = new ArrayList<String>(Arrays.asList(expectedLines3Array));
					
		//compare to first 3 actual lines from siddhartha
		assertEquals(expectedLines3, this.warAndPeaceBook.getLines().subList(0, 3), "The expected 3 lines do not match the actual first 3 'War and Peace' book lines.");
		
	}

	@Test
	void testGetTitle() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		//with book title
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Title: Test Book Title");
		Book book = new Book(bookLines);
		
		//confirm book title
		assertEquals("Test Book Title", book.getTitle(), "The expected title does not match the actual book title.");
		
		//create list and book
		//with book title with whitespace before it
		bookLines = new ArrayList<String>();
		bookLines.add("Title:    A Different Book Title");
		book = new Book(bookLines);
		
		//confirm book title
		assertEquals("A Different Book Title", book.getTitle(), "The expected title does not match the actual book title.");
		
		//confirm book title for cat in the hat
		assertEquals("The Cat in the Hat", this.catInTheHatBook.getTitle(), "The expected title does not match the actual 'The Cat in the Hat' book title.");

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		//confirm book title for War and Peace
		assertEquals("War and Peace", this.warAndPeaceBook.getTitle(), "The expected title does not match the actual 'War and Peace' book title.");
		
		//confirm book title for Siddhartha
		assertEquals("Siddhartha", this.siddharthaBook.getTitle(), "The expected title does not match the actual 'Siddhartha' book title.");
		
	}

	@Test
	void testGetAuthor() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		//with book author
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Author: Joseph Berry");
		Book book = new Book(bookLines);
		
		//confirm book author
		assertEquals("Joseph Berry", book.getAuthor(), "The expected author does not match the actual book author.");
		
		//create list and book
		//with book author with whitespace before it
		bookLines = new ArrayList<String>();
		bookLines.add("Author:    Rhonda Fierri");
		book = new Book(bookLines);
		
		//confirm book author
		assertEquals("Rhonda Fierri", book.getAuthor(), "The expected author does not match the actual book author.");
		
		//confirm book author for cat in the hat
		assertEquals("Dr. Seuss", this.catInTheHatBook.getAuthor(), "The expected author does not match the actual 'The Cat in the Hat' book author.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		//confirm book author for cat in the hat
		assertEquals("Leo Tolstoy", this.warAndPeaceBook.getAuthor(), "The expected author does not match the actual 'The Cat in the Hat' book author.");
		
		//confirm book author for cat in the hat
		assertEquals("Hermann Hesse", this.siddharthaBook.getAuthor(), "The expected author does not match the actual 'The Cat in the Hat' book author.");
	}
	
	@Test
	void testGetTotalWordCount() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("one two three");
		Book book = new Book(bookLines);
		
		//confirm total word count
		assertEquals(3, book.getTotalWordCount(), "The total word count is incorrect. The expected answer is 3.");
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("one two three.  four five six.");
		book = new Book(bookLines);
		
		//confirm total word count
		assertEquals(6, book.getTotalWordCount(), "The total word count is incorrect. The expected answer is 6.");

		// create list and book
    	bookLines = new ArrayList<String>();
    	bookLines.add("*hello");
    	book = new Book(bookLines);

    	//confirm total word count
    	assertEquals(1, book.getTotalWordCount(), "The total word count is incorrect. The expected answer is 1.");
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("Title: My Book Title");
		bookLines.add("Author: My Book Author");
		bookLines.add("one, two, three.  four, five, six.");
		book = new Book(bookLines);
		
		//confirm total word count
		assertEquals(14, book.getTotalWordCount(), "The total word count is incorrect. The expected answer is 14.");
		
		//confirm approximate total word count for cat in the hat
		assertTrue(this.catInTheHatBook.getTotalWordCount() >= 100 && this.catInTheHatBook.getTotalWordCount() <= 120, "The approximate total word count for 'The Cat in the Hat' is incorrect. It should be greater than or equal to 100 and less than or equal to 120.");

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////


		//create list and book
		List<String> bookLines2 = new ArrayList<String>();
		bookLines2.add("abc!123,xyz");
		Book book2 = new Book(bookLines2);
		
		//confirm total word count
		assertEquals(3, book2.getTotalWordCount(), "The total word count is incorrect. The expected answer is 3.");
		
		//create list and book of Siddhartha
		List<String> bookLines3 = new ArrayList<String>();
		bookLines3.add("Title: Siddhartha");
		bookLines3.add("Author: Hermann Hesse");
		bookLines3.add("Translator: Gunther Olesch, Anke Dreher, Amy Coulter, Stefan Langer and Semyon Chaichenets");
		Book siddhartha = new Book(bookLines3);
		
		//confirm total word count
		assertEquals(17, siddhartha.getTotalWordCount(), "The total word count is incorrect. The expected answer is 17.");
		
	}

	@Test
	void testGetUniqueWordCount() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("one two three");
		Book book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(3, book.getUniqueWordCount(), "The unique word count is incorrect. The expected answer is 3.");
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("one two three.  four five six.  ONE.");
		book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(6, book.getUniqueWordCount(), "The unique word count is incorrect. The expected answer is 6.");
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("Title: My Book title");
		bookLines.add("Author: My book author");
		bookLines.add("one, two, three.  four, five, six.");
		book = new Book(bookLines);
		
		//confirm unique word count
		assertEquals(10, book.getUniqueWordCount(), "The unique word count is incorrect. The expected answer is 10.");
		
		//confirm approximate unique word count for cat in the hat
		assertTrue(this.catInTheHatBook.getUniqueWordCount() >= 50 && this.catInTheHatBook.getUniqueWordCount() <= 60, "The approximate unique word count for 'The Cat in the Hat' is incorrect. It should be greater than or equal to 50 and less than or equal to 60.");

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		//create list and book
		List<String> bookLines2 = new ArrayList<String>();
		bookLines2.add("ONE PART part one one!part one@part one#part");
		Book book2 = new Book(bookLines2);
		
		//confirm unique word count
		assertEquals(2, book2.getUniqueWordCount(), "The unique word count is incorrect. The expected answer is 2.");
		
		//create list and book from Siddhartha snippet
		List<String> bookLines3 = new ArrayList<String>();
		bookLines3.add("Title: Siddhartha");
		bookLines3.add("SIDDHARTHA");
		bookLines3.add("In the shade of the house, in the sunshine");
		
		Book book3 = new Book(bookLines3);
		
		//confirm unique word count
		assertEquals(8, book3.getUniqueWordCount(), "The unique word count is incorrect. The expected answer is 8.");
		
	}

	@Test
	void testGetSpecificWordCount() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create list and book
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("one two three");
		Book book = new Book(bookLines);
		
		//confirm specific word count
		assertEquals(1, book.getSpecificWordCount("three"), "The specific word count is incorrect. The expected answer is 1.");
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("one two three.  four five six. ONE.");
		book = new Book(bookLines);
		
		//confirm specific word count
		assertEquals(2, book.getSpecificWordCount("one"), "The specific word count is incorrect. The expected answer is 2.");
		
		//create list and book
		bookLines = new ArrayList<String>();
		bookLines.add("Title: My Book title");
		bookLines.add("Author: My book author");
		bookLines.add("Review: GREAT BOOK!");
		book = new Book(bookLines);
		
		//confirm specific word count
		assertEquals(3, book.getSpecificWordCount("book"), "The specific word count is incorrect. The expected answer is 3.");
		
		//confirm approximate specific word count for cat in the hat
		assertTrue(this.catInTheHatBook.getSpecificWordCount("sit") >= 3 && this.catInTheHatBook.getSpecificWordCount("sit") <= 5, "The approximate specific word count of the word 'sit' in 'The Cat in the Hat' is incorrect. It should be greater than or equal to 3 and less than or equal to 5.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		//create list and book from Siddhartha snippet
		List<String> bookLines3 = new ArrayList<String>();
		bookLines3.add("Title: Siddhartha");
		bookLines3.add("SIDDHARTHA");
		bookLines3.add("In the shade of the house, in the sunshine");
		
		Book book3 = new Book(bookLines3);
		
		//confirm specific word count
		assertEquals(2, book3.getSpecificWordCount("siddhartha"), "The specific word count is incorrect. The expected answer is 2.");
		assertEquals(3, book3.getSpecificWordCount("the"), "The specific word count is incorrect. The expected answer is 3.");
		
		//create list and book
		List<String> bookLines2 = new ArrayList<String>();
		bookLines2.add("ONE PART part one one!part one@part one#part");
		Book book2 = new Book(bookLines2);
		
		//confirm unique word count
		assertEquals(5, book2.getSpecificWordCount("one"), "The specific word count is incorrect. The expected answer is 3.");
		assertEquals(5, book2.getSpecificWordCount("part"), "The specific word count is incorrect. The expected answer is 3.");
	}

}
