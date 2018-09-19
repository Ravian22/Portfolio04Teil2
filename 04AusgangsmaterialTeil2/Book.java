import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> pageContent;
    
    public Book (String title,String category, String author) {
    	super(title,category,author);
        this.pageContent = new ArrayList<>();
    }
     
    public ArrayList<String> getPageContent() {
    	return pageContent;
    }
    
    public void addPage (String text_of_page) {
        pageContent.add (text_of_page);
    }
    
    public boolean contains (String text) {
        boolean found = false;
        int page = 0;
        while (!found && page < pageContent.size()) {
            found = pageContent.contains (text);
            page++;
        }
        return found;
    }

}