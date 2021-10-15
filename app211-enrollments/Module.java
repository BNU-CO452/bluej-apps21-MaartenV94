
/**
 * This Module class represents the code, title and credit value of a 
 * given module
 *
 * @author Maarten Vanderbeeken
 * @version 13/08/2021
 */
public class Module
{
    // instance variables - replace the example below with your own
    private String code;
    private String title;
    private int credit;

    /**
     * Module constructor assigns the code and title for a module 
     * It also initalises the credit value to 0
     */
    public Module(String code, String title)
    {
        this.code = code;
        this.title = title;
        this.credit = 0;
    }

    /**
     * This method returns the code for the module
     * @return code represents the module code
     */
    public String getCode()
    {
        return code;
    }
    
    /**
     * This method returns the title for the module
     * @return title represents the module title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * This module returns the credit for the module
     * @return credit represents the module credit value
     */
    public int getCredit()
    {
        return credit;
    }
    
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    /**
     * Print the details of the module which includes 
     * the code, title and credits
     */
    public void print()
    {
        System.out.println(" Module Code: " + code + ": " + title);
        System.out.println(" Credit: " + credit);
        System.out.println();
    }
}
