
public class Main {
	
	public static void main(String[] args) {
		Client testClient = new Client("Name","Adresse");
		Client testClient2 = new Client("Name2","Adresse2");
		Book testBook1 = new Book("Title1");
		Book testBook2 = new Book("Title2");
		Library testLibrary = new Library();
		
		testClient.addToLibrary(testLibrary);
		testBook1.addAndBorrowBook(testLibrary, testClient);
		testClient2.addToLibrary(testLibrary);
		testBook1.addAndBorrowBook(testLibrary, testClient2);
		
		for (Client client :testLibrary.bookBorrowedBy(testBook1)) {
			System.out.println(client.name);
		}

	}

}
