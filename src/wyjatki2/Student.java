
package wyjatki2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Student extends Person implements Comparable<Student>{
    
    private String kierunek;
    private double dochod;
    private String uczelnia;
    private  int points;
    private int semestr;
    private int il_poprawek;
    private int ile_przedmiotow;
    private int ECTS;
    private int ilSubject;
    
    public Student(String kierunek, int dochod, String uczelnia, String name, String lastname, int age, char sex, String ID)
    {
        super(name, lastname, age, sex, ID);
        this.kierunek = kierunek;
        this.dochod = dochod;
        this.uczelnia = uczelnia;
    }
   
    public void setKierunek(String kierunek)
    {
        if(kierunek.isEmpty()) System.out.println("Bad data");
        else this.kierunek=kierunek;
    }
    
    public String getKierunek()
    {
        return kierunek;
    }
    
    public void setUczelnia(String uczelnia)
    {
        if(uczelnia.isEmpty()) System.out.println("Empty pole");
        else this.uczelnia=uczelnia;
    }
    
    public String getUczelnia()
    {
        return uczelnia;
    }
    
    public void setDochod(double dochod)
    {
        if(dochod==0) System.out.println("I dont have work yet");
        else if(dochod<0) throw new BadDataException(String.format("This is incorrect value"));
        else this.dochod=dochod;
    }
    
   public String toString()
   {
       return "Name "+getName()+" lastname "+getLastName()+" plec "+getSex()+" "+getUczelnia()+" "+ getKierunek();
   }
   
  public String setPoints(int points)
  {
      if(points<0 || points>100) throw new BadDataException(String.format("Bad data",100));
        
      if(points<40)
        {   
            this.points=points;
            return "This University is not good as i think";
        }
        
       else if(points<60)
       {
           this.points=points;
           return "This University is not suberb but it is not bad";
       }
       
       else
       {
           this.points=points;
           return "This University was the best choice in my entire life and the greatest investition in my self build";
       }
     
       

  }
  
  public void setSemestr(int semestr)
  {
      if(semestr<0 || semestr>7) throw new BadDataException(String.format("Semestr is illeagal start of expression",202));
      else this.semestr=semestr;
          
  }
  
  public int ilePrzedmiotow(int ile_przedmiotow)
  {
      this.ile_przedmiotow=ile_przedmiotow;
      return ile_przedmiotow;
  }
  
  public int getSemestr()
  {
      return semestr;
  }
  
    public int getPoints()
    {    
        return points ;
    }
   
    public void setECTS(int ECTS)
    {
        if(ECTS<0 || ECTS>30) throw new BadDataException(String.format("Bad Data",404));
        else this.ECTS=ECTS;
    }
    
    public int getECTS()
    {
        return ECTS;    
    }
    
    public int setIlePoprawek(int il_poprawek)
    {
        this.il_poprawek=il_poprawek;
        return this.il_poprawek;
    }
    
    
    public int uzyskanePkt()
    {
        int suma=0;
        switch(semestr)
        {
            case 1: suma+=ECTS;return suma;
            case 2: suma+=ECTS;return suma;
            case 3: suma+=ECTS;return suma;
            case 4: suma+=ECTS;return suma;
            case 5: suma+=ECTS;return suma;
            case 6: suma+=ECTS;return suma;
            default: suma+=ECTS;return suma;
            
        }
    }
    
    public void sumaECTS(int ile_semestrow)
    {
        int suma=0;
        int liczba;
        int il_poprawek;
        
         Scanner sc=new Scanner(System.in);
         
        for( semestr=1;semestr<=ile_semestrow;semestr++)
        {
        
            setSemestr(semestr);
            System.out.println("Enter numbers of  ECTS you get in  semestr " +semestr);
            liczba=sc.nextInt();
            System.out.println("Enter numbers of corrections in semestr "+ semestr);
            il_poprawek=sc.nextInt();
            setECTS(liczba);
            suma+=uzyskanePkt();
        
        switch(semestr)
        {
            case 1:{
                    if(ECTS<19)
                    {
                        
                        System.out.println("\nPrzykro mi zostałeś skreślony z listy Studentów ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Nie zostajesz dopuszczony na nastepny semestr");
                        System.out.println("Twoja suma ECTS w semestrze "+ semestr+" wynosi "+suma);
                        System.out.println("W nastpenym roku zaczniesz od semestru: "+1);
                        System.out.println();
                        return;
                        
                    }
                    else if(ECTS<30 && il_poprawek<=3)
                    {
                        System.out.println("Zdałeś warunkowo musisz zapłacić musisz poprawić przedmioty "+ (30-ECTS)*120+" zlotych");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twoj następny semestr to "+2);
                        System.out.println();
                    }
                    else if(ECTS<30 && il_poprawek>4)
                    {
                        
                        System.out.println("Przykro nam nie mozemy cię przepuścić na kolejny semestr");
                        System.out.println("Uzyskałeś w tym semestrze "+getECTS());
                        System.out.println("Spróbuj za rok od nowa "+1);
                        System.out.println();
                    }
                    
                    else if(ECTS<30)
                    {
                        
                        System.out.println("Zdałeś musisz jednak zaplacić oraz poprawić przedmioty"+ (30-ECTS)*120+" zlotych ");
                        System.out.println("Uzyskałeś w tym semestrze "+getECTS());
                        System.out.println("Twój następny semestr to: "+ 2);
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Uzyskałes maksymalna ilość ECTS na ten semestr "+30);
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój nastepny semestr to: "+2);
                        System.out.println();
                    }
            }break;
              
            case 2:{
                    if(ECTS<19)
                    {
                        System.out.println("\nPrzykro mi zostałeś skreślony z listy Studentów ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Nie zostajesz dopuszczony na nastepny semestr");
                        System.out.println("Twoja suma ECTS w semestrze "+ semestr+" wynosi "+suma);
                        System.out.println("W nastpenym roku zaczniesz od semestru: "+1);
                        System.out.println();
                        return;
                    } 
                    else if(ECTS<30 && il_poprawek<=3)
                    {
                        System.out.println("Zdałeś warunkowo musisz zapłacić musisz poprawić przedmioty "+ (30-ECTS)*120+" zlotych");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twoj następny semestr to "+3);
                        System.out.println();
                    }
                    else if(ECTS<30 && il_poprawek>4)
                    {
                        System.out.println("Przykro nam nie mozemy cię przepuścić na kolejny semestr");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Spróbuj za rok od nowa "+2);
                        System.out.println();
                    }
                    else if(ECTS<30)
                    {
                        System.out.println("Zdałeś musisz jednak zaplacić oraz poprawić przedmioty"+ (30-ECTS)*120+" zlotych ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój następny semestr to: "+ 3);
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Uzyskałes maksymalna ilość ECTS na ten semestr "+30);
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój nastepny semestr to: "+3);
                        System.out.println();
                    }
            }break;
            case 3:{
                if(ECTS<19)
                    {
                        System.out.println("Przykro mi zostałeś skreślony z listy Studentów ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Nie zostajesz dopuszczony na nastepny semestr");
                        System.out.println("Twoja suma ECTS w semestrze "+ semestr+" wynosi "+suma);
                        System.out.println("W nastpenym roku zaczniesz od semestru: "+1);
                        System.out.println();
                        return;
                    } 
                    else if(ECTS<30 && il_poprawek<=3)
                    {
                        System.out.println("Zdałeś warunkowo musisz zapłacić musisz poprawić przedmioty "+ (30-ECTS)*120+" zlotych");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twoj następny semestr to "+4);
                        System.out.println();
                    }
                    else if(ECTS<30 && il_poprawek>4)
                    {
                        System.out.println("Przykro nam nie mozemy cię przepuścić na kolejny semestr");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Spróbuj za rok od nowa "+3);
                        System.out.println();
                             
                    }
                    else if(ECTS<30)
                    {
                        System.out.println("Zdałeś musisz jednak zaplacić oraz poprawić przedmioty"+ (30-ECTS)*120+" zlotych ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój następny semestr to: "+ 4);
                        System.out.println(); 
                                
                    }
                    else
                    {
                        System.out.println("Uzyskałes maksymalna ilość ECTS na ten semestr "+30);
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój nastepny semestr to: "+4);
                        System.out.println();
                    }}
            break;
            case 4: {
                    if(ECTS<19)
                    {
                        System.out.println("\nPrzykro mi zostałeś skreślony z listy Studentów ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Nie zostajesz dopuszczony na nastepny semestr");
                        System.out.println("Twoja suma ECTS w semestrze "+ semestr+" wynosi "+suma);
                        System.out.println("W nastpenym roku zaczniesz od semestru: "+1);
                        System.out.println();
                        return;
                    } 
                    else if(ECTS<30 && il_poprawek<=3)
                    {
                        System.out.println("Zdałeś warunkowo musisz zapłacić musisz poprawić przedmioty "+ (30-ECTS)*120+" zlotych");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twoj następny semestr to "+5);
                        System.out.println();
                    }
                    else if(ECTS<30 && il_poprawek>4)
                    {
                        System.out.println("Przykro nam nie mozemy cię przepuścić na kolejny semestr");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Spróbuj za rok od nowa "+4);
                        System.out.println();
                    }
                    else if(ECTS<30)
                    {
                        System.out.println("Zdałeś musisz jednak zaplacić oraz poprawić przedmioty"+ (30-ECTS)*120+" zlotych ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój następny semestr to: "+ 5);
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Uzyskałes maksymalna ilość ECTS na ten semestr "+30);
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój nastepny semestr to: "+5);
                        System.out.println();
                    }}
                    break;
            case 5:{  
                if(ECTS<19)
                    {
                        
                        System.out.println("\nPrzykro mi zostałeś skreślony z listy Studentów ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Nie zostajesz dopuszczony na nastepny semestr");
                        System.out.println("Twoja suma ECTS w semestrze "+ semestr+" wynosi "+suma);
                        System.out.println("W nastpenym roku zaczniesz od semestru: "+1);
                        System.out.println();
                        return;
                    } 
                    else if(ECTS<30 && il_poprawek<=3)
                    {
                        System.out.println("Zdałeś warunkowo musisz zapłacić musisz poprawić przedmioty "+ (30-ECTS)*120+" zlotych");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twoj następny semestr to "+6);
                        System.out.println();
                    }
                    else if(ECTS<30 && il_poprawek>4)
                    {
                        System.out.println("Przykro nam nie mozemy cię przepuścić na kolejny semestr");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Spróbuj za rok od nowa "+5);
                        System.out.println();
                    }
                    else if(ECTS<30)
                    {
                        System.out.println("Zdałeś musisz jednak zaplacić oraz poprawić przedmioty"+ (30-ECTS)*120+" zlotych ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój następny semestr to: "+ 6);
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Uzyskałes maksymalna ilość ECTS na ten semestr "+30);
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój nastepny semestr to: "+6);
                        System.out.println();
                    }}
            break;
            case 6:  {
                    if(ECTS<19)
                    {
                        System.out.println("\nPrzykro mi zostałeś skreślony z listy Studentów ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Nie zostajesz dopuszczony na nastepny semestr");
                        System.out.println("Twoja suma ECTS w semestrze "+ semestr+" wynosi "+suma);
                        System.out.println("W nastpenym roku zaczniesz od semestru: "+1);
                        System.out.println();
                        return;
                    } 
                    else if(ECTS<30 && il_poprawek<=3)
                    {
                        System.out.println("Zdałeś warunkowo musisz zapłacić musisz poprawić przedmioty "+ (30-ECTS)*120+" zlotych");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twoj następny semestr to "+7);
                        System.out.println();
                    }
                    else if(ECTS<30 && il_poprawek>4)
                    {
                        System.out.println("Przykro nam nie mozemy cię przepuścić na kolejny semestr");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Spróbuj za rok od nowa "+1);
                        System.out.println();
                    }
                    else if(ECTS<30)
                    {
                        System.out.println("Zdałeś musisz jednak zaplacić oraz poprawić przedmioty"+ (30-ECTS)*120+" zlotych ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój następny semestr to: "+ 7);
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Uzyskałes maksymalna ilość ECTS na ten semestr "+30);
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twój nastepny semestr to: "+7);
                        System.out.println();
                    }}
                    break;
            case 7:{  
                if(ECTS<19)
                    {
                        
                        System.out.println("\nPrzykro mi zostałeś skreślony z listy Studentów ");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Nie zostajesz dopuszczony na nastepny semestr");
                        System.out.println("Twoja suma ECTS w semestrze "+ semestr+" wynosi "+suma);
                        System.out.println("W nastpenym roku zaczniesz od semestru: "+1);
                        System.out.println();
                        return;
                    } 
                    else if(ECTS<30 && il_poprawek<=3)
                    {
                        System.out.println("Niestety nie możesz przystąpić do obrony inżyniera");
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Twoj następny semestr: "+7);
                        System.out.println();
                    }
                   
                    else
                    {
                        System.out.println("Uzyskałes maksymalna ilość ECTS na ten semestr "+30);
                        System.out.println("Uzyskałeś w tym semestrze "+ getECTS());
                        System.out.println("Możesz przystąpić do obrony inżyniera  oraz brać udział w rekrutacji na studia II stopnia");
                        System.out.println();
                       
                    }
            }
        break; 
        
        }
        
        }
        System.out.println("You get  "+suma+" ECTS points at all semestr you studied ");
        int zm=((ile_semestrow*30)-suma)*120;
        System.out.println("You have to paid "+zm+" money");
        System.out.println();
        
        
    }
  

    @Override
    public void showPerson()
    {
        System.out.println("My name is "+getName());
        System.out.println("My lastname is "+getLastName());
        System.out.println("My age is "+getAge());
        System.out.println("My sex is "+getSex());
        System.out.println("I am studing "+getKierunek()+" "+getUczelnia());
        System.out.println("My ID number is "+getIdNumber());
    }

    @Override
    public int compareTo(Student o)
    {
        if(o.getSex().equals("M")) return -1;
        if(o.getSex().equals("K")) return 1;
        return 0;
    }

  public void showSubject(List<University.Subject> s){
      for(University.Subject sub:s)
      {
          sub.SubjectShow();
      }
  }
  
  
    public List<University.Subject> setSubjectOnSemestr(List<University.Subject> list,University uni){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of your next Semestr");
        semestr=sc.nextInt();
        int ilSubject=3;
        University.Subject s;
        
        List<University.Subject> names_mechatronika=new LinkedList<>();
        List<University.Subject> names_informatyka=new LinkedList<>();
        List<University.Subject> names_elektrotechnika=new LinkedList<>();
        List<University.Subject> names_biomedyczna=new LinkedList<>();
        
        List<University.Subject> names=new LinkedList<>();
        names.clear();
    
        String name1;
        sc.nextLine();
        switch(semestr){
            case 1:
            { 
                
                 switch(kierunek)
            {
                case "mechatronika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter Subject name which you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,1);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(0).getSubjectName()))
                                names_mechatronika.add(s);
                        }
                    }
                    
                    return names_mechatronika;
                
                case "inżyniera biomedyczna":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,1);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_biomedyczna.add(s);
                        }
                    }
                    
                    return names_biomedyczna;
                
                case "elektrotechnika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name whoch you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,1);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_elektrotechnika.add(s);
                        }
                    }
                    return names_elektrotechnika;
              
                case "informatyka":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,1);
                       
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))        
                                names_informatyka.add(s);
                        }
                        
                    }
                    return names_informatyka;
              
                default:
                    System.out.println("Sorry your deegre course is not avalible ");
                    break;
            }
                
            }
            break;
            case 2:
            {
                 
            switch (kierunek) 
            {
                case "mechatronika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter Subject name which you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,2);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_mechatronika.add(s);
                        }
                    }
                    
                    return names_mechatronika;
               
                case "inżyniera biomedyczna":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,2);
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_biomedyczna.add(s);
                        }
                        
                    }
                    
                    return names_biomedyczna;
                
                case "elektrotechnika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Sybject name whoch you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,2);
                        
                        for(int z=0;z<list.size();z++)
                        {    
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_elektrotechnika.add(s);
                        }
                    }
                    return names_elektrotechnika;
               
                case "informatyka":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,2);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_informatyka.add(s);
                        }
                    }
                    return names_informatyka;
               
                default:
                    System.out.println("Sorry your deegre course is not avalible ");
                    break;
            }
                
            };
            break;
            
            case 3:
            {
                
               
            switch (kierunek) 
            {
                case "mechatronika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter Subject name which you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,3);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_mechatronika.add(s);
                        }
                    }
                    
                    return names_mechatronika;
                
                case "inżyniera biomedyczna":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,3);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_biomedyczna.add(s);
                        }
                    }
                    
                    return names_biomedyczna;
                
                case "elektrotechnika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Sybject name whoch you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,3);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_elektrotechnika.add(s);
                        }
                    }
                    return names_elektrotechnika;
                
                case "informatyka":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,3);
                    
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_informatyka.add(s);
                        }
                    }
                    return names_informatyka;
                
                default:
                    System.out.println("Sorry your deegre course is not avalible ");
                    break;
            }
                
            };
            break;
            case 4:{
                
                
            switch (kierunek)
            {
                case "mechatronika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter Subject name which you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,4);
                        
                        for(int z=0;z<list.size();z++)
                        {  
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_mechatronika.add(s);
                        }
                    }
                    
                    return names_mechatronika;
                
                case "inżyniera biomedyczna":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,4);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_biomedyczna.add(s);
                        }
                              
                    }
                    
                    return names_biomedyczna;
                
                case "elektrotechnika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Sybject name whoch you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,4);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_elektrotechnika.add(s);
                        }
                    }
                    return names_elektrotechnika;
                
                case "informatyka":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,4);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_informatyka.add(s);
                        }
                    }
                    return names_informatyka;
                
                default:
                    System.out.println("Sorry your deegre course is not avalible ");
                    break;
            }
                
            };
            break;
            case 5:
            {
                
                
            switch (kierunek)
            {
                case "mechatronika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter Subject name which you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,5);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_mechatronika.add(s);
                        }
                      
                    }
                    
                    return names_mechatronika;
                
                case "inżyniera biomedyczna":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,5);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_biomedyczna.add(s);
                        }    
                    }
                    
                    return names_biomedyczna;
                
                case "elektrotechnika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Sybject name whoch you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,5);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_elektrotechnika.add(s);
                        }
                    }
                    return names_elektrotechnika;
                
                case "informatyka":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,5);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_informatyka.add(s);
                        }
                    }
                    return names_informatyka;
                
                default:
                    System.out.println("Sorry your deegre course is not avalible ");
                    break;
            }
                
            };
            break;
            case 6:
            {
             
            switch (kierunek) 
            {               
                case "mechatronika":    
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter Subject name which you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,6);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_mechatronika.add(s);
                        }
                      
                    }
                    
                    return names_mechatronika;
                
                case "inżyniera biomedyczna":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,6);
                    
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_biomedyczna.add(s);
                        }
                        
                    }
                    
                    return names_biomedyczna;
                
                case "elektrotechnika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Sybject name whoch you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,6);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_elektrotechnika.add(s);
                        }
                    }
                    return names_elektrotechnika;
                
                case "informatyka":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,6);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_informatyka.add(s);
                        }
                    }
                    return names_informatyka;
                
                default:
                    System.out.println("Sorry your deegre course is not avalible ");
                    break;
            }
                
            };
            break;
            
            default:
               
               
            switch (kierunek) 
            {
                case "mechatronika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter Subject name which you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,7);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_mechatronika.add(s);
                        }
                    }
                    
                    return names_mechatronika;
                
                case "inżyniera biomedyczna":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,7);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_biomedyczna.add(s);
                        }
                    }
                    
                    return names_biomedyczna;
                
                case "elektrotechnika":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Sybject name whoch you chose "+ i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,7);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_elektrotechnika.add(s);
                        }
                    }
                    return names_elektrotechnika;
                
                case "informatyka":
                    for(int i=1;i<ilSubject;i++)
                    {
                        System.out.println("Enter the Subject name which you chose "+i);
                        name1=sc.nextLine();
                        s=uni.new Subject(name1,7);
                        
                        for(int z=0;z<list.size();z++)
                        {
                            if(s.getSubjectName().equals(list.get(z).getSubjectName()))
                                names_informatyka.add(s);
                        }
                    }
                    return names_informatyka;
                    
                default:
                    System.out.println("Sorry your deegre course is not avalible ");
                    break;
            }

                
        }
         return names;
    }
   
}
