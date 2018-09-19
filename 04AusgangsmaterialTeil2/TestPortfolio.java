import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPortfolio {

	private Book testBook;
	private Library testLibrary;
	private Client testClient;

	void test() {
	}

	@Test
	void compactDisc() {
		testBook = new Book("Mein erstes Testbuch");
		testBook.setCompactDisc(true);
		assertTrue(testBook.isCompactDisc());
		testBook.setCompactDisc(false);
		assertFalse(testBook.isCompactDisc());
	}

	@Test
	void deleteBook() {
		testBook = new Book("Mein erstes Testbuch");
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
		testBook = new Book("Mein erstes Testbuch");
		Book secondBook = new Book("Mein zweites Testbuch");
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
	void hasCategory() {
		testBook = new Book("Mein erstes Testbuch");
		assertTrue(testBook.hasCategory("Roman"));
		assertFalse(testBook.hasCategory("irdendwas"));
	}

	@Test
	void addPage() {
		testBook = new Book("Noch ein Testbuch");
		assertEquals(0, testBook.getPageContent().size());
		testBook.addPage("Eine Seite Text. Mit vielleicht " + "ein bisschen mehr Text");
		assertEquals(1, testBook.getPageContent().size());
	}

	@Test
	void contains() {
		testBook = new Book("Testbuch");
		testBook.addPage("Test Text");
		assertTrue(testBook.contains("Test Text"));
		assertFalse(testBook.contains("irgendwas"));
	}

	/**
	 * Test der Library Klasse
	 */
	@Test
	void addBook() {
		testBook = new Book("Mein erstes Testbuch");
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
		testBook = new Book("Testbuch");
		
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
