public class Validator
{   
    //method for name validation
    public static boolean nameValidator(String name)
    {
        String givenName = name;
        //if the name length is greater tha 0
        if(givenName.length() > 0)
        {
            //for loop to iterate 
            for (int i =0; i<givenName.length(); i++)
            {
                
              if(givenName.charAt(i) != '-' && givenName.charAt(i) != '.' && givenName.charAt(i) != ' ')//if the character is -,. and space also it should take 
              {
                  if(!Character.isLetter(givenName.charAt(i)))
                  {                      
                      return false;
                  }
              }
            }
            
           return true;
        }
        else
            return false;
        
    }
    
    //method for email validation
    public static boolean emailValidator(String email)
    {
        String givenEmail = email, subStr = " ";
    
        int countOfAtSign = 0, countOfCharacters = 0;
        //if email length is greater than equal to 6
        if(givenEmail.length() >= 6)
        {
            //for loop to iterate the email length
            for (int i =0; i<givenEmail.length() ; i++)
            {
              if(givenEmail.charAt(i) != '@')//if the character not equal to @ increase the count of characters
                    countOfCharacters++;
              
              if(givenEmail.charAt(i) == '@')//if the character equal to @ increase the count of atsign
                    countOfAtSign++;              
            }
            
            //substr is used for checking .com
            subStr = givenEmail.substring(givenEmail.length()-4, givenEmail.length());
                           
            if(countOfCharacters < 0 || !".com".equals(subStr) || countOfAtSign != 1)//if character count less tha 0 or .com not equals to substr or count not equal to 1
            {
                return false; 
            }               
             
            return true;
        }
        else
            return false;
    }
    
    //method for cellnumber validation
    public static boolean cellNumberValidator(String cellNumber)
    {
        String givenCellNumber = cellNumber;
        String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}";
        
        //if length of cellnumber greater than 0
        if(cellNumber.length() > 0)
        {
            //if given cellnumber does not matches the pattern return false
            if(!givenCellNumber.matches(pattern))
            {
                return false;
            }
            
            return true;
        }
        else
            return false;
    }
}
