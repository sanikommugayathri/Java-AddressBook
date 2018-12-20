import java.io.IOException;
import java.util.Scanner;

//public class AddressBookEntryApp
public class AddressBookEntryApp 
{
    
    public static void main(String[] args) throws IOException
    {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        
        //while loop to select the option
        while(choice != 3)
        {
            System.out.println("Welcome to the Address Book Application");
            System.out.println("1 - List entries");
            System.out.println("2 - Add entry");
            System.out.println("3 - Exit");
            System.out.print("\nEnter Menu Number: ");
         
            choice = sc.nextInt();          
         
            if(choice == 1)//if choice is 1 it prints the values in the text file
            {
                System.out.println(AddressBookIO.getEntriesString());
            }
            else if(choice == 2)//if choice is 2 asks the user to enter name, email and phone number with validations
            {  
                String name = "", email ="", cellNumber = "";
                Boolean validName = false;
                Boolean validEmail = false;
                Boolean validCellNumber = false;
                
                //while loop to check whether the name is valid or not
                while( validName != true)
                {
                    System.out.print("Enter Name: ");
                    name = input.nextLine();
                    validName = Validator.nameValidator(name);
                    if(validName == false)
                        System.out.println("Input Valid Name");
                }
                
                //while loop to check whether the email is valid or not
                while( validEmail != true)
                {
                    System.out.print("Enter Email Address: ");
                    email = input.nextLine();
                    validEmail = Validator.emailValidator(email);                    
                    if(validEmail == false)
                        System.out.println("Input Valid Email");
                }
                
                //while loop to check the cell number is valid or not
                while( validCellNumber != true)
                {
                    System.out.print("Enter Phone Number: ");
                    cellNumber = input.nextLine();
                    validCellNumber = Validator.cellNumberValidator(cellNumber);
                    if(validCellNumber == false)
                        System.out.println("Input Valid Phone Number");
                }
                
                //creating a new object for the addressbookentry
                AddressBookEntry entry = new AddressBookEntry(name,email,cellNumber);
                
                if(AddressBookIO.saveEntry(entry))
                    System.out.println("\nThis Entry has been saved");
            }
            else if( choice == 3)//if choice is 3 it should exist and print goodbye
            {
                System.out.println("\nGood Bye");
            }
            else
                System.out.println("\n*Enter a valid option");
        }
         
    }
    
}

    

