
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Maarten Vanderbeeken
 * @version 0.1
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    private StockDemo demo;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("print"))
        {
            stock.print();
        }
        else if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("remove"))
        {
            removeProduct();
        }
        else if(choice.equals("buy"))
        {
            buyProduct();
        }
        
        return false;
    }
    
    private void buyProduct(int productID, int amount) 
    {
         System.out.println("Buying more products");
         System.out.println();
             
         int id = reader.getInt("Please enter a product id > ");
         
         Product product = stock.findProduct(id);
         if(product != null) 
        {
            if(product.getQuantity() < 1000)
            {
                product.increaseQuantity(amount);
                System.out.println("Bought " + amount + " of " + product.getName());
            }
            else
            {
                System.out.println("Not enough shelf space for" + product.getName() + 
                                    ". Please sell the exsisting stock ");
            }
        }
        else
        {
            System.out.println("couldn't find product");
        }

         stock.buyProduct(id);
         stock.print();
         
    }
    
     /** 
     * Method to remove an old product.
     */
    private void removeProduct() 
    {
         System.out.println("Removing a old Product");
         System.out.println();
             
         int id = reader.getInt("Please enter a product id > ");
         
         Product product = stock.findProduct(id);
         
         if(product != null)
             stock.remove(product);
         else
             System.out.println("Not found");
             
         stock.remove(product);
         stock.print(); 
    }
    
    /**
     * Method to add a new product.
     */
    private void addProduct()
    {
         System.out.println("Adding a new Product");
         System.out.println();
             
         int id = reader.getInt("Please enter a product id > ");
         String name = reader.getString("Please enter the product name > ");
             
         Product product = new Product(id, name);
             
         stock.add(product);
         stock.print();
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println("    Buy:        Buy more products"); 
        System.out.println(); 
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Maarten Vanderbeeken");
        System.out.println("********************************");
    }
}