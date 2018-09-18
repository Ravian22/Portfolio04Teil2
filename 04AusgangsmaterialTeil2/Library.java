import java.util.ArrayList;

public class Library {

    public ArrayList<Book> books = new ArrayList();

    public ArrayList<Client> clients = new ArrayList();

    public void addBook (Book book) {
        books.add (book);
    }

    public void printListOfBooks () {
        for (Book book : books) {
            if (!book.isCompactDisc()) {
                System.out.println (book.booktitle+" # "+book.category + book.author);
            } else {
                System.out.println (book.booktitle+" # CD");
            }
        }
    }
    
    public ArrayList<Client> bookBorrowedBy(Book book){
    	ArrayList<Client> borrowedBy = new ArrayList<>();
    	for (Client client : clients) {
    		if (client.borrowedBooks.contains(book)) {
    			borrowedBy.add(client);
    		}
    	}
    	return borrowedBy;
    }

}