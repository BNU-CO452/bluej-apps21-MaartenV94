
/**
 * The program class can be used to run the application 
 * outside of BlueJ and without having to create objects first.
 * 
 *
 * @author Maarten Vanderbeeken
 * @version 0.1 (2021.01.11)
 */
public class Program
{
    private static StockApp app;
    
    public static void main(String[] args)
    {
        app = new StockApp();
        app.run();
    }
}
