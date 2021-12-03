
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Maarten Vanderbeeken
 * @version 0.1 (2021.01.11)
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
            runBuy();
        }
        else if(choice.equals("sell"))
        {
            runSell();
        }
        else if(choice.equals("search"))
        {
            runSearch();
        }
        else if(choice.equals("low stock"))
        {
            runLowStock();
        }
        
        return false;
    }
    
    /**
     * Method to view list of low stock.
     */
    private void runLowStock()
    {
        System.out.println("Show a list of low stock > ");
        System.out.println(); 
         
        stock.listLowStock(); 
    }
    
    /**
     * Method to search for item by name.
     */
    private void runSearch()
    {
         System.out.println("Search for a product by name > ");
         System.out.println(); 
         
         String name = reader.getString("Please enter a product name > ");
         
         stock.searchProduct(name);
    }
    
    /**
     * Method to buy new stock.
     */
    private void runBuy() 
    {
         System.out.println("Buying more products");
         System.out.println();
             
         int id = reader.getInt("Please enter a product id > ");
         int amount = reader.getInt("Please enter the amount you want to buy > ");

         stock.buyProduct(id, amount);
         stock.print();
         
         System.out.println("You have just added some new stock > ");
    }
    
    /**
     * Method to sell existing products.
     */
    private void runSell()
    {
        System.out.println("Selling products");
        System.out.println();
        
        int id = reader.getInt("Please enter a product id > ");
        int amount = reader.getInt("Please enter the amount you want to sell > ");
        
        stock.sellProduct(id, amount);
        stock.print();
    }
    
     /** 
     * Method to remove an old product.
     */
    private void removeProduct() 
    {
         System.out.println("Removing a Product");
         System.out.println();
             
         int id = reader.getInt("Please enter a product id > ");
         String name = reader.getString("Please enter the product name > ");
         
         Product product = stock.findProduct(id);
         
         if(product != null)
         {
             stock.remove(product);
             System.out.println("Successfully removed item");
         }
         else
         {
             System.out.println();
             System.out.println("Item not found");
             
             stock.remove(product);
             stock.print(); 
         }
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
             
         Product checkproduct = stock.findProduct(id);
         
         if(checkproduct != null)
         {
             System.out.println("Error - Item already exists");
         }
         else
         {
             Product product = new Product(id, name);
         
             stock.add(product);
             System.out.println("Item added successfully");
         }
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
        System.out.println("    Sell:       Sell  old products"); 
        System.out.println("    Search:     Search for products by name");
        System.out.println("    Low stock:  View products with low stock");
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