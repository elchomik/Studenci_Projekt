
package wyjatki2;




import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) throws InterruptedException {
        
        
        List<Student> students=new ArrayList<>();
        List<University> universities=new ArrayList<>();
        
       
        Student s1=new Student("medycyna",0,"Uniwersytet Warszawski","Jan","Kowalski",20,'M',"093223");
        Student s2=new Student("Medycyna",0,"Uniwersytet Medyczny w Lublinie","Tomasz","Kot",23,'M',"33232");
        Student s3=new Student("Medycyna",0,"Uniwersytet Medyczny w Lublinie","Gabriela","Andrzejczak",19,'K',"3443");
        Student s4=new Student("Medycyna",0,"Uniwersytet Medyczny w Białymstoku","Katarzyna","Krawiec",24,'K',"323232");
        Student s5=new Student("informatyka",3000,"Politechnika Lubelska","Mateusz","Markiewicz",21,'M',"090997");
        
        University u1=new University("Uniwersytet Warszawski","Warszawa",1);
        University u2=new University("Politechnika Warszawska","Warszawa",3);
        University u3=new University("Uniwersytet Jagiellonski","Kraków", 2);
        University u4=new University("Uniwersytet Medyczny w Lublinie","Lublin",5);
        University u5=new University("Uniwersytet Medyczny w Gdansku","Gdańsk",4);
        University u6=new University("Politechnika Lubelska","Lublin",8);
        University u7=new University("Politechnika Wrocławska","Wrocław",6);
        University u8=new University("AGH","Kraków",9);
        University u9=new University("Politechnika Poznanska","Poznań",7);
        University u10=new University("Uniwersytet Medyczny w Warszawie","Warszawa",10);
      
        
        
        
        
                
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        
        universities.add(u1);
        universities.add(u2);
        universities.add(u3);
        universities.add(u4);
        universities.add(u5);
        universities.add(u6);
        universities.add(u7);
        universities.add(u8);
        universities.add(u9);
        universities.add(u10);
        
        int op;
        Student s6 = null;
        Scanner sc=new Scanner(System.in);
        

        do{ 
                    
        System.out.println("\n-- Welcome guys you in your virtual campus if you wanna do something please follow the instructions below ---\n");
        System.out.println("1. Show  default students and universities ");
        System.out.println("2. Add new Students to the list ");
        System.out.println("3. Add new University to the list ");
        System.out.println("4. Remove students from the list");
        System.out.println("5. Remove University from the list");
        System.out.println("6. Show Students sorted by sex ");
        System.out.println("7. Show University sorted by ratings");
        System.out.println("8. Show where Students are Studnig (if this University is on the list)");
        System.out.println("9. Rate University");
        System.out.println("10.Show Students Points on the stydy peroid");
        System.out.println("11. Show avalible Subject to chose on the semestr");
        System.out.println("12. Chose subject to your semestr");
        System.out.println("13. Close the aplication");
            
        System.out.println("\n--Chose your option --");
        op=sc.nextInt();
        
        
        switch(op)
        {
            case 1:
            {
                    
                System.out.println("--- Begin of Students List ---\n");
                    
                for(Student st: students)
                    {
                        st.showPerson();
                        System.out.println("\n");
                    }
            
                    System.out.println("\n--- End of Students List ---\n");
                    System.out.println("--- Begin of Universities List ---\n");
                    
                    for(University u : universities)
                    {
                        System.out.println(u.toString()+"\n");
                    }
                    
                    System.out.println("--- End of Universities List ---\n");
                    
                    System.out.println("Please Enter Any Key To Continue ...");
                    new Scanner(System.in).nextLine();
                 
            };
            break;   
            
            case 2:
            { 
                String name = null,lastname = null, deegre_course = null,ID = null,university_name = null;
                int age = 0,salary = 0;
                char sex = 0;
                s6=new Student(deegre_course,salary,university_name, name, lastname, age, sex, ID);
                sc.nextLine();
                
                System.out.println("Enter the name");
                name=sc.nextLine();
                s6.setName(name);
                
                System.out.println("Enter the lastname");
                lastname=sc.nextLine();
                s6.setLastName(lastname);
                
                System.out.println("Enter the deegre course");
                deegre_course=sc.nextLine();
                s6.setKierunek(deegre_course);
                
                System.out.println("Enter the ID number");
                ID=sc.nextLine();
                s6.setIdNumber(ID);
                
                System.out.println("Enter the University name");
                university_name=sc.nextLine();
                s6.setUczelnia(university_name);
                
                
                System.out.println("Enter the sex ");
                sex=sc.nextLine().charAt(0);
                s6.setSex(sex);
                
                System.out.println("Enter the age ");
                age=sc.nextInt();
                s6.setAge(age);
                
                System.out.println("Enter the salary");
                salary=sc.nextInt();
                s6.setDochod(salary);
                sc.nextLine();
              
                s6.showPerson();
                students.add(s6);
               
                System.out.println("\n--You succesfully create your Student and added him to the list of Students--\n");
                
                System.out.println("Please Enter Any Key To Continue ..");
                new Scanner(System.in).nextLine();
              
            };
            break;
            case 3:
            {
                String name=null,city=null;
                int position=0;
                University u=new University(name, city,position);
                sc.nextLine();
                System.out.println("Enter the University name");
                name=sc.nextLine();
                u.setName(name);
                
                System.out.println("Enter the City");
                city=sc.nextLine();
                u.setCity(city);
                
                System.out.println("Enter the position in ranking");
                position=sc.nextInt();
                u.setPosition(position);
                System.out.println("\nUniversity which you add");
                System.out.println(u.toString());
                universities.add(u);
                 
                        
                System.out.println("Please Enter Any Key to Continue ..");
                new Scanner(System.in).nextLine();
            };
            break;
            
            case 4:
            {
                sc.nextLine();
                System.out.println("Enter the name student which you wanna remove from University");
                String name=sc.nextLine();
                System.out.println("Enter the lastname student which you wanna remove from University");
                String lastname=sc.nextLine();
              
                for(Iterator<Student> studentop=students.iterator();studentop.hasNext();)
                {
                    Student student=studentop.next();
                      if(student.getName().equals(name) && student.getLastName().equals(lastname))        
                          studentop.remove();
                }
                
                System.out.println("Press Any Key To Continue ..");
                new Scanner(System.in).nextLine();
            };
            break;
            
            case 5: 
            {
                sc.nextLine();
                System.out.println("Enter the University name ");
                String name=sc.nextLine();
                System.out.println("Enter the City name ");
                String city=sc.nextLine();
                
                    // remove object
              for(Iterator<University> universityop=universities.iterator();universityop.hasNext();)
              {
                  University uni=universityop.next();
              
                if(uni.getName().equals(name)) universityop.remove();
                  
              }
                
              System.out.println("Press Any Key To Continue ..");
                new Scanner(System.in).nextLine();
              
            };
            break;
            
            case 6:
            {
                
                Collections.sort(students);
                for(Student student: students)
                {
                    System.out.println(student.toString());
                    System.out.println();
                }
                
                System.out.println("Press Any Key To Continue ..");
                new Scanner(System.in).nextLine();
            };
            break;
            
            case 7:
            {
                Collections.sort(universities);
                for(University uni : universities)
                {
                    System.out.println(uni.toString());
                    System.out.println();
                }
                
                System.out.println("Press Any Key To Continue ..");
                new Scanner(System.in).nextLine();
            };
            break;
            
            case 8:
            {
                 Iterator<Student> student=students.iterator();
                 Student st;
                 while(student.hasNext())
                 {
                     st=student.next();
                    for(University uni : universities)
                    {    
                        if(uni.zm(st)) uni.Studing(st);
                    }
                   
                }
                 
                System.out.println("Press Any Key To Continue ..");
                new Scanner(System.in).nextLine();
            };
            break;
            
            case 9:
            {    
                int choice; 
                do{
                    System.out.println("--Chose the Student who will be rate the University--");
                    System.out.println("1. Student 1");
                    System.out.println("2. Student 2");
                    System.out.println("3. Student 3");
                    System.out.println("4. Student 4");
                    System.out.println("5. Student 5");
                    System.out.println("6. Student who was created");
                    System.out.println("7.Exit loop");
                    System.out.println("--Choice--");
                    choice=sc.nextInt();
                    
                    switch(choice)
                    {
                        case 1:
                        {
                            sc.nextLine();
                            System.out.println("Please Enter the University name");
                            String name=sc.nextLine();
                            System.out.println("Please Enter the points ");
                            int points=sc.nextInt();
                            
                            Iterator<University> univ=universities.iterator();
                            University uni;
                            
                            while(univ.hasNext())
                            {
                                    uni=univ.next();
                                if(uni.getName().equals(name))
                                {
                                    s1.setPoints(points);
                                    uni.opinionAbout(s1);
                                    System.out.println();
                                }
                                
                            }
                            
                            System.out.println("Press Any Key To Continue ..");
                            new Scanner(System.in).nextLine();
                        };
                        break;
                        
                        case 2:
                        {
                            sc.nextLine();
                            System.out.println("Please Enter the University name");
                            String name=sc.nextLine();
                            System.out.println("Please Enter the points ");
                            int points=sc.nextInt();
                              
                            Iterator<University> univ=universities.iterator();
                            University uni;
                            
                            while(univ.hasNext())
                            {
                                uni=univ.next();      
                                
                                if(uni.getName().equals(name))
                                {
                                    s2.setPoints(points);
                                    uni.opinionAbout(s2);
                                    System.out.println();
                                }        
                            }
                            
                            System.out.println("Press Any Key To Continue ..");
                            new Scanner(System.in).nextLine();
                            
                        };
                        break;
                        
                        case 3:
                        {
                            sc.nextLine();
                            System.out.println("Please Enter the University name");
                            String name=sc.nextLine();
                            System.out.println("Please Enter the points");
                            int points=sc.nextInt();
                            
                            
                            Iterator<University> univ=universities.iterator();
                            University uni;
                            
                            while(univ.hasNext())
                            {
                                uni=univ.next();
                                if(uni.getName().equals(name))
                                {
                                    s3.setPoints(points);
                                    uni.opinionAbout(s3);
                                    System.out.println();
                                }
                                
                            }
                            
                            System.out.println("Press Any Key To Continue ..");
                            new Scanner(System.in).nextLine();
                        };
                        break;
                        
                        case 4:
                        {
                            sc.nextLine();
                            System.out.println("Please Enter the University name");
                            String name=sc.nextLine();
                            System.out.println("Please Enter the points");
                            int points=sc.nextInt();
                            
                            Iterator<University> univ=universities.iterator();
                            University uni;
                            
                            while(univ.hasNext())
                            {
                                uni=univ.next();
                                if(uni.getName().equals(name))
                                {
                                    s4.setPoints(points);
                                    uni.opinionAbout(s4);
                                    System.out.println();
                                }
                                
                            }
                               
                            System.out.println("Press Any Key To Continue ..");
                            new Scanner(System.in).nextLine();
                        };
                        break;
                        
                        case 5:
                        {
                            sc.nextLine();
                            System.out.println("Please Enter the University name");
                            String name=sc.nextLine();
                            System.out.println("Please Enter the points");
                            int points=sc.nextInt();
                           
                            Iterator<University> univ=universities.iterator();
                            University uni;
                            
                            while(univ.hasNext())
                            {
                             uni=univ.next();
                             
                             if(uni.getName().equals(name))
                             {
                                s5.setPoints(points);
                                uni.opinionAbout(s5);
                                System.out.println();
                             }
                             
                            }
                            
                            System.out.println("Press Any Key To Continue ..");
                            new Scanner(System.in).nextLine();
                        };    
                        break;
                        
                        case 6:
                        {
                            sc.nextLine();
                            System.out.println("Please Enter the Student name");
                            String Sname=sc.nextLine();
                            
                            try{
                                s6.setName(Sname);
                            }catch(BadNameException e){
                                e.printStackTrace();
                            }
                            
                            System.out.println("Please Enter the Student lastname");
                            String Lname=sc.nextLine();
                            
                            try{
                                s6.setLastName(Lname);
                            }catch(BadLastNameException e){
                               e.printStackTrace();
                            }
                            
                            System.out.println("Please Enter the Student ID");
                            String id=sc.nextLine();
                            
                            try{
                                s6.setIdNumber(id);
                                s6.getIdNumber();
                            }catch(BadDataException e){
                                e.printStackTrace();
                            }
                           
                            Iterator<Student> student=students.iterator();
                            Student st;
                            
                            while(student.hasNext())
                            {
                                st=student.next();
                                if(st.getName().equals(Sname) && st.getLastName().equals(Lname) && st.getIdNumber().equals(id)){
                                    
                                    System.out.println("Please Enter the University name");
                                    String name=sc.nextLine();
                                    
                                    System.out.println("Please Enter the Points");
                                    int points=sc.nextInt();
                                    
                                    Iterator<University> univ=universities.iterator();
                                    University uni;
                                    
                                    while(univ.hasNext())
                                    {
                                        uni=univ.next();
                                        
                                        if(uni.getName().equals(name)){
                                            st.setPoints(points);
                                            uni.opinionAbout(st);
                                            System.out.println();
                                        }
                                        
                                    }
                                }
                                
                            }
                            System.out.println("Press Any Key to Continue ..");
                            new Scanner(System.in).nextLine();
                            
                        }
                        break;
                       
                    }
                }while(choice!=7);
                        
            };
            break;
            case 10:
            {
                Iterator<Student> st=students.iterator();
                Student s;
                sc.nextLine();
                int c,semestr,corrections;
                String name,lastname;
                
                System.out.println("1. Show all Students points");
                System.out.println("2. Show only one Student point");
                System.out.println("Chose your option");
                c=sc.nextInt();
                
                switch(c){
                    case 1:
                    {
                       
                       for(Student student: students)
                       {
                           System.out.println("Enter the semestr "+student.getName()+" "+student.getLastName());
                           semestr=sc.nextInt();
                           
                           student.sumaECTS(semestr);
                           System.out.println();
                    }
                        System.out.println("Press Any Key To Continue ..");
                        new Scanner(System.in).nextLine();
                };
                break;
                
                  case 2:
                  {
                      sc.nextLine();
                      System.out.println("Enter the student name");
                      name=sc.nextLine();
                      
                      System.out.println("Enter the student lastname");
                      lastname=sc.nextLine();
                     
                      while(st.hasNext())
                      {
                          s=st.next();
                          if(s.getName().equals(name) && s.getLastName().equals(lastname))
                          {
                              System.out.println("Enter the  number of semestrs for "+ s.getName()+" "+s.getLastName());
                              semestr=sc.nextInt();
                              s.sumaECTS(semestr);
                          }
                      }
                      
                      System.out.println("Press Any Key To Continue ..");
                      new Scanner(System.in).nextLine();
                  };
                  break;
            }
            };
            break;
            
            case 11:
            {
                sc.nextLine();
              
                Iterator<Student> student=students.iterator();
              
                Student s;
                System.out.println("Enter your University name ");
                String name=sc.nextLine();
                
                while(student.hasNext())
                {
                    s=student.next();
                    if(s.getUczelnia().equals(name))
                    {
                        
                        Iterator<University> univ=universities.iterator();
                        University uni;
                        
                        while(univ.hasNext())
                        {
                            uni=univ.next();
                            if(uni.getName().equals(s.getUczelnia()))
                            {
                                
                                List<University.Subject> list=uni.AvalibleCourses();
                                uni.showCourses(list);
                                
                                System.out.println("Add Subject");
                                List<University.Subject> z=s.setSubjectOnSemestr(list,uni);
                                s.showSubject(z);
                            }
                        }
                    }
                    
                }    
                
                System.out.println("Press Any Key To Continue ...");
                new Scanner(System.in).nextLine();
                
            };
            break;
            
            case 12:
            {
               
                System.out.println("Press Any Key To Continue ...");
                new Scanner(System.in).nextLine();
            }
            break;
        }
        }while(op!=13);
        
        System.out.println("\n--List of universities--\n");
        for(University u: universities)
        {
            System.out.println(u.toString()+"\n");
        }
        
        System.out.println("--List of Students --");
        for(Student student: students)
        {
            student.showPerson();
            System.out.println();
        }
        
    }
    
}
