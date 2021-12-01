
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author by Maarten Vanderbeeken.
 * @version 14/11/2021.
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    private StockList stockList;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Apple Iphone 12"));
        stock.add(new Product(102, "Apple iPhone 12 Pro"));
        stock.add(new Product(103, "Apple Iphone 12 Pro Max"));
        stock.add(new Product(104, "Apple Iphone 13"));
        stock.add(new Product(105, "Apple Iphone 13 Pro"));
        stock.add(new Product(106, "Apple Iphone 13 Pro Max"));
        stock.add(new Product(107, "Google Pixel 3A"));
        stock.add(new Product(108, "Google Pixel 4A"));
        stock.add(new Product(109, "Samsung Galaxy S19"));
        stock.add(new Product(110, "Samsung Galaxy s20")); 
        
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    
    private void buyProducts()
    {
        stock.buyProduct(101, 300);
        stock.buyProduct(102, 250);
        stock.buyProduct(103, 55);
        stock.buyProduct(104, 120);
        stock.buyProduct(105, 205);
        stock.buyProduct(106, 50);
        stock.buyProduct(107, 85);
        stock.buyProduct(108, 120);
        stock.buyProduct(109, 200);
        stock.buyProduct(110, 15);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 30);
        stock.sellProduct(102, 100);
        stock.sellProduct(103, 20);
        stock.sellProduct(104, 80);
        stock.sellProduct(105, 40);
        stock.sellProduct(106, 50);
        stock.sellProduct(107, 85);
        stock.sellProduct(108, 130);
        stock.sellProduct(109, 100);
        stock.sellProduct(110, 10);
        
    }    
}