import java.util.ArrayList;

public class Book {
    private String title;
    private String category;
    private ArrayList<String> pageContent;
    private String author;
    private boolean compactDisc;

    public Book (String title) {
        this.title = title;
        this.author = "Autor";
        this.category = "Roman";
        this.pageContent = new ArrayList<>();
    }
    
    public String getTitle() {
    	return title;
    }
    
    public String getCategory() {
    	return category;
    }
    
    public String getAuthor() {
    	return author;
    }

    public void setCompactDisc (boolean compactDisc) {
        this.compactDisc = compactDisc;
    }

    public boolean isCompactDisc () {
        return compactDisc;
    }
    
    public boolean hasCategory (String category) {
        return this.category.equals (category);
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