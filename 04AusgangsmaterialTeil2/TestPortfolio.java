import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPortfolio {

	private static String DEFAULT_CATEGORY = "Test Category";
	private static String DEFAULT_AUTHOR = "Authot";
	private static String DEFAULT_TITLE = "Title";
	private Book testBook;
	private Library testLibrary;
	private Client testClient;

	void test() {
		
	}

	@Test
	void compactDisc() {
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		testBook.setCompactDisc(true);
		assertTrue(testBook.isCompactDisc());
		testBook.setCompactDisc(false);
		assertFalse(testBook.isCompactDisc());
	}

	@Test
	void deleteBook() {
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		testLibrary = new Library();
		testLibrary.addBook(testBook);
		assertEquals(1, testLibrary.getBooks().size());
		testLibrary.deleteBook(testBook);;
		assertEquals(0, testLibrary.getBooks().size());
	}

	@Test
	void addAndBorrowBook() {
		testLibrary = new Library();
		testClient = new Client("Test Name", "Test Adresse");
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		Book secondBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		// Pr�fen, ob ein Buch dem Clienten und der Library hinzugef�gt wird.
		assertEquals(0, testLibrary.getBooks().size());
		testLibrary.addAndBorrowBook(testBook, testClient);
		assertEquals(1, testLibrary.getBooks().size());
		assertEquals(1, testClient.getBorrowedBooks().size());
		// Pr�fen, ob ein Buch nicht zweimal hinzugef�gt wird.
		testLibrary.addBook(secondBook);
		assertEquals(2, testLibrary.getBooks().size());
		testLibrary.addAndBorrowBook(secondBook, testClient);
		assertEquals(2, testLibrary.getBooks().size());
		// Pr�fen, ob das Buch aber trotzdem dem Clienten zugeordnet wird.
		assertEquals(2, testClient.getBorrowedBooks().size());
	}
	
	@Test
	void borrowDublicateBook() {
		testLibrary = new Library();
		testClient = new Client("Test Name", "Test Adresse");
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		testLibrary.addAndBorrowBook(testBook, testClient);
		testLibrary.addAndBorrowBook(testBook, testClient);
		assertEquals(1,testLibrary.getBooks().size());
		assertEquals(2, testClient.getBorrowedBooks().size());
	}

	@Test
	void hasCategory() {
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		assertTrue(testBook.hasCategory("Roman"));
		assertFalse(testBook.hasCategory("irdendwas"));
	}

	@Test
	void addPage() {
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		assertEquals(0, testBook.getPageContent().size());
		testBook.addPage("Eine Seite Text. Mit vielleicht " + "ein bisschen mehr Text");
		assertEquals(1, testBook.getPageContent().size());
	}

	@Test
	void contains() {
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		testBook.addPage("Test Text");
		assertTrue(testBook.contains("Test Text"));
		assertFalse(testBook.contains("irgendwas"));
	}

	/**
	 * Test der Library Klasse
	 */
	@Test
	void addBook() {
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		testLibrary = new Library();
		testLibrary.addBook(testBook);
		assertEquals(1, testLibrary.getBooks().size());
	}
	
	/**
	 * Test der Client Klasse.
	 */
	@Test
	void addToLibrary() {
		testLibrary = new Library();
		testClient = new Client("Testname","Adresse");
		assertEquals(0, testLibrary.getClients().size());
		testLibrary.addToLibrary(testClient);
		assertEquals(testClient, testLibrary.getClients().get(0));
		assertEquals(1,testLibrary.getClients().size());		
	}
	
	@Test
	void returnBook() {
		testLibrary = new Library();
		testClient = new Client("Testname","Adresse");
		testBook = new Book(DEFAULT_TITLE, DEFAULT_CATEGORY, DEFAULT_AUTHOR);
		
		assertEquals(0,testLibrary.getBooks().size());		
		testLibrary.addAndBorrowBook(testBook, testClient);
		assertEquals(1,testLibrary.getBooks().size());	
		assertEquals(testBook,testClient.getBorrowedBooks().get(0));
		assertEquals(1,testClient.getBorrowedBooks().size());
		testClient.returnBook("Falscher Titel");
		assertEquals(1, testClient.getBorrowedBooks().size());
		testClient.returnBook("Testbuch");
		assertEquals(0,testClient.getBorrowedBooks().size());		
	}
	
	@Test
	void isFavoriteCategory() {
		testClient = new Client("Name","Adresse");
		testClient.addFavoriteCategory("Test1");
		assertTrue(testClient.isFavoriteCategory("Test1"));
		assertFalse(testClient.isFavoriteCategory("Test2"));
	}
}
