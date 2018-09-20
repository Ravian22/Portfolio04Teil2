import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private ArrayList<Media> medias = new ArrayList();
    private ArrayList<Client> clients = new ArrayList();
    
    public ArrayList<Media> getBooks() {
    	return medias;
    }
    
    public ArrayList<Client> getClients() {
    	return clients;
    }
    
    public void addMedia (Media media) {
        medias.add(media);
    }
    
	public void addToLibrary (Client client) {
		clients.add(client);
	}
	
    public void deleteBook (Book book) {
        medias.remove(book);
        for (Client client : clients) {
            client.removeBorrowedBook(book);
        }
    }
    
    public void addAndBorrowBook (Book book,Client client) {
        if (!medias.contains(book)) {
            addMedia(book);
        }
        if (!book.isCompactDisc()) {
            client.addBorrowedBook(book);
        }
    }
    
    public void addAndBorrowCD (Book book, Client CLIENT) {
        if (!medias.contains(book) && book.isCompactDisc()) {
            addMedia(book);
        }
        if (book.isCompactDisc()) {
            CLIENT.addBorrowedBook(book);
        }
    }

    public void printListOfBooks () {
    	String information = new String();
        for (Media media : medias) {
            if (!media.isCompactDisc()) {
                information = (media.getTitle() +" # "+media.getCategory() + " " + media.getAuthor());
                for (String keyword : media.getKeywords()) {
                	information += " " + keyword;
                }
                System.out.println(information);
            } else {
                System.out.println (media.getTitle()+" # CD");
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
    
    public Map<Client, Integer> clientMostBorrowedBooks() {
    	Map<Client,Integer> mostBorrowedBooks = new HashMap<>();
    	for (Client client : clients) {
    		if (client.getBorrowedBooks().size() > 0) {
    			mostBorrowedBooks.put(client, client.getBorrowedBooks().size());
    		}
    	}
    	return mostBorrowedBooks;
    }
}