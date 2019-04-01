/*
 * @author: Sigurdur Hallur Jonsson
 */
package kiosk;

/**
 *
 * @author siggi
 */
public abstract class ReadingMaterial 
{
    private String title;
    private String publisher;
    private String published;
    
    public ReadingMaterial(String title, String publisher, String published)
    {
        if(title == null)
        {
            title = "";
        }
        if(publisher == null)
        {
            publisher = "";
        }
        if(published == null)
        {
            published = "";
        }
        
        this.title = title;
        this.publisher = publisher;
        this.published = published;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public String getPublisher()
    {
        return this.publisher;
    }
    
    public String getPublished()
    {
        return this.published;
    }
}
