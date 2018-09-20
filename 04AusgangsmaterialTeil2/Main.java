
public class Main {
	
	public static void main(String[] args) {
		Library testL= new Library();
		Client testC = new Client("Name","Adresse");
		Book testB1 = new Book("Titel","Categor","Autor");
		
		testL.addToLibrary(testC);
		testL.addMedia(testB1);
		testB1.addKeyword("Wort1");
		testB1.addKeyword("Wort2");
		testB1.addKeyword("Wort3");
		testB1.addKeyword("Wort4");
		testB1.addKeyword("Wort5");
		testL.printListOfBooks();
	}

}
