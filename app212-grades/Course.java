import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Maarten Vanderbeeken
 * @version 0.2 29/Oct/2020
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
     
    /**
     * This constructor will create a course object with set code and title.
     */
    public Course()
    {
        this("G400", "BSc (Hons) Computing");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module moduleCO452 = new Module("CO452", "Programming concepts:");
        addModule(moduleCO452);
        
        Module moduleCO450 = new Module("CO450", "Computer Architectures:");
        addModule(moduleCO450);
        
        Module moduleCO454 = new Module("CO454", "Digital Technologies And Professional Practice:");
        addModule(moduleCO454);
        
        Module moduleCO456 = new Module("CO456", "Web Development:");
        addModule(moduleCO456);

    }
    
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * 
     */
    public Grades convertToGrade(int mark)
    {
        Grades grade = Grades.NS;
        if(mark > Grades.B.getValue())
        {
            return Grades.A;
        }
        else if(mark > Grades.C.getValue()) 
        {
            return Grades.B;
        }
        else if(mark > Grades.D.getValue())
        {
            return Grades.C;
        }
        else if (mark > Grades.F.getValue())
        {
            return Grades.D;
        }
        else if (mark > Grades.NS.getValue())
        {
            return Grades.F;
        }
        return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int total = 0;
        for(ModuleMark mark: marks)
        {
            total=total + mark.getValue();
        }
        int finalMark = total/4;
        return convertToGrade(finalMark);
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {
        System.out.println("Course Module");
        System.out.println("--------------");
        System.out.println();
        
        for(Module module : modules)
        {
            System.out.println("\t" + module.getCode());
            System.out.println("\t" + module.getTitle());
        }
        
        System.out.println();
    }
}
