/*
 * @author: Sigurdur Hallur Jonsson
 */
package kiosk;

/**
 *
 * @author siggi
 */
public interface RegisterInterface 
{
    public abstract void addToCollection(ReadingMaterial rm);
    public abstract void removeFromCollection(ReadingMaterial rm);
    public abstract void printOutAllTitles();
    public abstract ReadingMaterial searchMaterial(String title);
}