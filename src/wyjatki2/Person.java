
package wyjatki2;


public  abstract class Person {
    
   public String name;
   public String lastname;
   private  int age;
   private  char sex;
   private  String ID;

    public Person(String name, String lastname, int age, char sex, String ID) 
    {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
        this.ID = ID;
    }
    
    public void setName(String Name)
    {
        if(!(Name.matches("^[A-Z][a-z]*$")))
           throw new BadNameException(String.format("The name is incorect because name contains number or  alphanumeric sign or begin with small letter%s",Name));
        else this.name=Name;   
    }
    
    public void setLastName(String n)
    {
        if(!(n.matches("^[A-Z][a-z]*$")))
            throw new BadLastNameException(String.format("The lastname is incorect because contains number  or alphanumeric character or begin with small letter%s",n));
        else this.lastname=n;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getLastName()
    {
        return lastname;
    }
    
    
    public void setAge(int age)
    {
        if(age<0 || age> 120)  throw new BadAgeDataException(String.format("The number is out of range %d",age));
        else this.age=age;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setSex(char sex)
    {
        this.sex=sex;
    }
    
    public String getSex()
    {
        switch(sex)
        {
            case 'M':return "M";
            case 'm': return "M";
            case 'K': return "K";
            case 'k': return "K";
            default: return "Nie znam twojej płci";
        }
    }
    
    public void setIdNumber(String ID)
    {
        if(ID.isEmpty() || ID.equals(""))
        {
           throw new BadIdException(String.format("Your ID is empty "),23);
        }
        
        else if(ID.length()!=6)
        {
            BadIdException e=new BadIdException(String.format("This ID number is out of range too short or too long "),404);
            throw e;
        }
        else this.ID=ID;
        
    }
    
    public String getIdNumber()
    {
        return ID;
    }
    
     public  abstract void showPerson();
     
}
