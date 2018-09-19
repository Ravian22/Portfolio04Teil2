import java.util.ArrayList;

public class Client {

	private ArrayList<Book> borrowedBooks = new ArrayList();

	private String name;
	private String address;
	private ArrayList<String> favoriteCategories = new ArrayList();

	public Client (String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	
	public void removeBorrowedBook(Book book) {
		borrowedBooks.remove(book);
	}
	
	public void addBorrowedBook(Book book) {
		borrowedBooks.add(book);
	}
	
	public void addFavoriteCategory(String category) {
		favoriteCategories.add(category);
	}


	public void returnBook (String title) {
		Book bookToReturn = null;
		for (Book book : borrowedBooks) {
			if (book.getTitle().equals (title)) {
				bookToReturn = book;
				break;
			}
		}
		borrowedBooks.remove (bookToReturn);
	}
	
	public boolean isFavoriteCategory (String category) {
	    return favoriteCategories.contains (category);
	}

}