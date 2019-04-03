/*
 * @author: Groupe 26 (Erik, Sigurd og Sigurður)
 */
package kiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *  Register that is responsible for all types of Reading material
 */
public class Register implements RegisterInterface
{
    private ArrayList<ReadingMaterial> readingMaterial;
    private ArrayList<ReadingMaterial> materialFound;
    
    /**
     * Constructor, makes map for Reading Material
     */
    public Register()
    {
        this.readingMaterial = new ArrayList<>();
    }
    
    @Override
    /**
     * Adds reading material to collection of reading material.
     * @param readingMaterial the reading material to add.
     */
    public void addToCollection(ReadingMaterial readingMaterial)
    {
        this.readingMaterial.add(readingMaterial);
    }
    
    @Override
    /**
     * Removes from collection
     * @param readingMaterial to remove from collection.
     */
    public void removeFromCollection(ReadingMaterial readingMaterial)
    {
        this.readingMaterial.remove(readingMaterial);
    }
    
    /**
     * finds out if collection is empty or not
     * @return boolean true if there is item in collection
     */
    public boolean isCollectionEmpty()
    {
        boolean empty = true;
        if(this.readingMaterial.size() > 0)
        {
            empty = false;
        }
        return empty;
    }
    
    @Override
    /**
     * prints out all titles from collection 
     * 
     */
    public void printOutAllTitles()
    {
        Iterator<ReadingMaterial> it = this.readingMaterial.iterator();
        while(it.hasNext())
        {
            ReadingMaterial rm = it.next();
            System.out.println(rm.getTitle());
        }
    }

    @Override
    /**
     * loops through collection and return all relevant reading material with given title.
     * @param title to look for
     */
    public ReadingMaterial searchMaterial(String title) 
    {
        this.materialFound = new ArrayList<>();
        ReadingMaterial rm = null;
        
        
        
        return rm;
    }
    
    public ArrayList<ReadingMaterial> findMaterial(String title)
    {
        this.materialFound = new ArrayList<>();
        
        Iterator<ReadingMaterial> it = this.readingMaterial.iterator();
        
        while(it.hasNext())
        {
            ReadingMaterial rm = it.next();
            if(rm.getTitle().equals(title))
            {
                this.materialFound.add(rm);
            }
        }
        
        return this.materialFound;
    } // end of method
    

    
} // END OF CLASS

