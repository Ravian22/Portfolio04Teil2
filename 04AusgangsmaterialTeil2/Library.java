import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList();

    private ArrayList<Client> clients = new ArrayList();
    
    public ArrayList<Book> getBooks() {
    	return books;
    }
    
    public ArrayList<Client> getClients() {
    	return clients;
    }
    
    public void addBook (Book book) {
        books.add (book);
    }
    
	public void addToLibrary (Client client) {
		clients.add(client);
	}
	
    public void deleteBook (Book book) {
        books.remove(book);
        for (Client client : clients) {
            client.removeBorrowedBook(book);
        }
    }
    
    public void addAndBorrowBook (Book book,Client client) {
        if (!books.contains(book)) {
            addBook(book);
        }
        if (!book.isCompactDisc()) {
            client.addBorrowedBook(book);
        }
    }
    
    public void addAndBorrowCD (Book book, Client CLIENT) {
        if (!books.contains(book) && book.isCompactDisc()) {
            addBook(book);
        }
        if (book.isCompactDisc()) {
            CLIENT.addBorrowedBook(book);
        }
    }

    public void printListOfBooks () {
        for (Book book : books) {
            if (!book.isCompactDisc()) {
                System.out.println (book.getTitle() +" # "+book.getCategory() + book.getAuthor());
            } else {
                System.out.println (book.getTitle()+" # CD");
            }
        }
    }
    
    public ArrayList<Client> bookBorrowedBy(Book book){
    	ArrayList<Client> borrowedBy = new ArrayList<>();
    	for (Client client : clients) {
    		if (client.getBorrowedBooks().contains(book)) {
    			borrowedBy.add(client);
    		}
    	}
    	return borrowedBy;
    }
}