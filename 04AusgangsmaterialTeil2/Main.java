
public class Main {

	public static void main(String[] args) {
		Library testLibrary = new Library();
		Book testBook = new Book("Test");
		Client client1 = new Client("Name1","Adresse");
		Client client2 = new Client("Name2","Adresse");
		Client client3 = new Client("Name3","Adresse");
		
		testLibrary.addToLibrary(client1);
		testLibrary.addToLibrary(client2);
		testLibrary.addToLibrary(client3);
		
		testLibrary.addAndBorrowBook(testBook, client1);
		testLibrary.addAndBorrowBook(testBook, client1);
		testLibrary.addAndBorrowBook(testBook, client1);
		testLibrary.addAndBorrowBook(testBook, client1);
		testLibrary.addAndBorrowBook(testBook, client2);
		for (Client client : testLibrary.clientMostBorrowedBooks()) {
			System.out.println(client.getName());
		}
	}

}
