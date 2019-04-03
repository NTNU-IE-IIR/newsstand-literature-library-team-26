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
        validateIssue(issue);
    }
    
    public int getIssue()
    {
        return this.issue;
    }
    
    private boolean validateIssue(int issue)
    {
        boolean validateIssue = true;
        this.issue = issue;
        if(issue < 0)
        {
            validateIssue = false;
            this.issue = 0;
        }
        return validateIssue;
    }
}
