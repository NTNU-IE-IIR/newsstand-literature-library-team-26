/*
 * @author: Sigurdur Hallur Jonsson
 */
package kiosk;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author siggi
 */
public class Register implements RegisterInterface, SearchInterface
{
    private HashMap<String, ReadingMaterial> readingMaterial;
    
    public Register()
    {
        this.readingMaterial = new HashMap<>();
    }
    
    @Override
    public void addToCollection(ReadingMaterial readingMaterial)
    {
        this.readingMaterial.put(readingMaterial.getTitle(), readingMaterial);
    }
    
    @Override
    public void removeFromCollection(ReadingMaterial readingMaterial)
    {
        this.readingMaterial.remove(readingMaterial);
    }
    
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
    public void printOutAllTitles()
    {
        Iterator<ReadingMaterial> it = this.readingMaterial.values().iterator();
        while(it.hasNext())
        {
            ReadingMaterial rm = it.next();
            System.out.println(rm.getTitle());
        }
    }

    @Override
    public ReadingMaterial searchMaterial(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void searchByName(String title)
    {
        
    }
    
} // END OF CLASS

