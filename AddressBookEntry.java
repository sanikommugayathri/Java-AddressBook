
//class AddressBookEntry
public class AddressBookEntry
{
    //initializing the instance variable name of type string
    private String name;
    
    //initializing the instance variable email of type string
    private String email;
    
    //initializing the instance variable cellNumber of type string
    private String cellNumber;

    //constructor to initialize the instance variables
    public AddressBookEntry(String name, String email, String cellNumber)
    {
        this.name = name;
        this.email = email;
        this.cellNumber = cellNumber;
    }

    //get method for name
    public String getName()
    {
        return name;
    }

    //get method for email
    public String getEmail() 
    {
        return email;
    }

    //get method for cellnumber
    public String getCellNumber()
    {
        return cellNumber;
    }

    //set method for name
    public void setName(String name)
    {
        this.name = name;
    }

    //set method for email
    public void setEmail(String email) 
    {
        this.email = email;
    }

    //set method for cellNumber
    public void setCellNumber(String cellNumber) 
    {
        this.cellNumber = cellNumber;
    }
    
}

    

