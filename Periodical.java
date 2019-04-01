/*
 * @author: Sigurdur Hallur Jonsson
 */
package kiosk;

/**
 *
 * @author siggi
 */
public abstract class Periodical extends ReadingMaterial
{
    private int issue;
    
    public Periodical(String title, String publisher, String published, int issue)
    {
        super(title, publisher, published);
        if(issue < 0)
        {
            // throw exception
            this.issue = 0;
        }
        this.issue = issue;
    }
    
    public int getIssue()
    {
        return this.issue;
    }
    
}
