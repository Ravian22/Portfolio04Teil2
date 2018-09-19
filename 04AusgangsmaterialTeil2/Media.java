import java.util.ArrayList;

public class Media {
    private String title;
    private String category;
    private String author;
    private ArrayList<String> keywords;
    private boolean compactDisc;
    
    public Media(String title, String category, String author) {
    	this.title = title;
    	this.category = category;
    	this.author = author;
    	keywords = new ArrayList<>();
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
    
    public void addKeyword(String word) {
    	keywords.add(word);
    }

    public boolean isCompactDisc () {
        return compactDisc;
    }
    
    public boolean hasCategory (String category) {
        return this.category.equals (category);
    }
}