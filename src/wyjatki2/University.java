
package wyjatki2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class University implements Comparable<University>, Opinion {
    
    private   String name;
    private   String city;
    private  int position;
    
    public University(String name, String city, int position)
    { 
      this.name=name;
      this.city=city; 
      
        if(position<0) throw new BadDataException(String.format("The number is not correct",505));
        else this.position = position;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setCity(String city)
    {
        this.city=city;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setPosition(int position)
    {
        this.position=position;
    }
    
    public void Studing(Student s)
    {    
        if(s.getUczelnia().equals(name)) System.out.println("This student "+s.getName()+" is study at Univeristy "+name +" in the city "+city);    
    }
    
    public String toString()
    {
        return "The "+name+" in the city "+city+" ranking position "+position;
    }
    
    public boolean zm(Student s)
    {   
        return s.getUczelnia().equals(name);
    }

    public int compare(University o1, University o2)
    {
       if(o1.position>o2.position) return o1.position;
       else return o2.position;
    }

    @Override
    public int compareTo(University o)
    {
        if(o.position>position) return -1;
        if(position>o.position) return 1;
        return 0;
    }
    
    @Override
    public void opinionAbout(Student s)
    {    
        System.out.println("Student  name "+s.getName()+" "+s.getLastName()+" set opinion "+s.setPoints(s.getPoints())+" about University "+name);
        System.out.println("The University get "+s.getPoints()+" points in scale from 0 to 100"); 
              
    }
    
    
    class Subject
    {
        private String SubjectName;
        private String DeegreCourse;
        private int year;
    
        public Subject(String SubjectName,int year)
        {
            this.SubjectName=SubjectName;
            this.year=year;
        }
        
        public void SubjectShow()
        {
            System.out.println("Subject name "+ SubjectName+" on the semestr "+ year);
            System.out.println();
        }
        
        public String getSubjectName()
        {
            return SubjectName;
        }
    }
    
    
    public void showCourses(List<Subject> subject)
    {
        for(Subject sub: subject)
        {
            sub.SubjectShow();
        }
    }
    
    public List<Subject> AvalibleCourses()
    {
        Scanner sc= new Scanner(System.in);
        
        List<Subject> informatyka= new ArrayList<>();
        List<Subject> mechatronika= new ArrayList<>();
        List<Subject> elektrotechnika= new ArrayList<>();
        List<Subject> biomedyczna=new ArrayList<>();
        List<Subject> allSubjects=new ArrayList<>();
       
        allSubjects.addAll(informatyka);
        allSubjects.addAll(mechatronika);
        allSubjects.addAll(elektrotechnika);
        allSubjects.addAll(elektrotechnika);
        
        System.out.println("Enter the deegree course");
        String course=sc.nextLine();
    
        if(course.equals("mechatronika"))
        {
            mechatronika.add(new Subject("Diagnostyka Maszyn",1));
            mechatronika.add(new Subject("Mechanika Teoretyczna",1));
            mechatronika.add(new Subject("Informatyka I",1));
        
            mechatronika.add(new Subject("Nauka o materiałach I",2));
            mechatronika.add(new Subject("Nauka o materiałach II",2));
            mechatronika.add(new Subject("Małe i średnia przedsiębiorstwa",2));
        
            mechatronika.add(new Subject("Mechanika Techniczna",3));
            mechatronika.add(new Subject("Wstęp do komputerowego projektowania maszyn",3));
            mechatronika.add(new Subject("Matematyka II",3));
        
            mechatronika.add(new Subject("Podstawy elektroniki",4));
            mechatronika.add(new Subject("Metrologia wielkości elektrycznych",4));
            mechatronika.add(new Subject("Podstawy konstrukcji maszyn ",4));
        
            mechatronika.add(new Subject("Podstawy konstrukcji maszyn-projektowanie",5));
            mechatronika.add(new Subject("Metrologia wielokości geometrycznych",5));
            mechatronika.add(new Subject("Podstawy automatyki",5));
        
            mechatronika.add(new Subject("Metrologia wielkości geometrycznych",6));
            mechatronika.add(new Subject("Jezyk obcy",6));
            mechatronika.add(new Subject("Wychowanie fizyczne",6));
        
            mechatronika.add(new Subject("Projektowanie systemów mechatronicznych",7));
            mechatronika.add(new Subject("Podstawy logistyki",7));
            mechatronika.add(new Subject("Projektowanie systemów mechatronicznych",7));
        
            return mechatronika;
        }
      
        else if(course.equals("inżynieria biomedyczna"))
        {
            biomedyczna.add(new Subject("Metrologia wielkości nieelektrycznych",1));
            biomedyczna.add(new Subject("Matematyka I",1));
            biomedyczna.add(new Subject("Matematyka II",1));
        
            biomedyczna.add(new Subject("Podstawy programowania strukturalnego",2));
            biomedyczna.add(new Subject("Podstawy elektroniki",2));
            biomedyczna.add(new Subject("Metrologia wielkości elektrycznych",2));
        
            biomedyczna.add(new Subject("Grafika inżynierska I",3));
            biomedyczna.add(new Subject("Grafika inżynierska II",3));
            biomedyczna.add(new Subject("Podstawy anatomii",3));
        
            biomedyczna.add(new Subject("Materiałoznastwo",4));
            biomedyczna.add(new Subject("Komputerowe modelowanie urządzeń elektromagnetycznych",4));
            biomedyczna.add(new Subject("Cyfrowe przetwarzanie sygnałów",4));
        
            biomedyczna.add(new Subject("Podstawy technologii wytwarzania",5));
            biomedyczna.add(new Subject("Biomechanika inżynierska",5));
            biomedyczna.add(new Subject("Teoria sygnałów",5));
        
            biomedyczna.add(new Subject("Podstawy Telemedycyny",6));
            biomedyczna.add(new Subject("Sensory i pomiary wielkości nieelektrycznych",6));
            biomedyczna.add(new Subject("Wychowanie fizyczne",6));
        
        
            biomedyczna.add(new Subject("Chemia fizyczna",7));
            biomedyczna.add(new Subject("Technologia informacyjna",7));
            biomedyczna.add(new Subject("Mechanizm zachowania i sterowania organizmem ludzkim",7));
        
            return biomedyczna;
        }
        
        else if(course.equals("elektrotechnia"))
        {
           elektrotechnika.add(new Subject("Ochrona Własności Intelektualnej",1));
           elektrotechnika.add(new Subject("BHP",1));
           elektrotechnika.add(new Subject("Ekonomiczne aspekty środowiska",1));
      
           elektrotechnika.add(new Subject("Język niemiecki",2));
           elektrotechnika.add(new Subject("Język angielski",2));
           elektrotechnika.add(new Subject("Język rosyjski",2));
      
           elektrotechnika.add(new Subject("Mechatronika",3));
           elektrotechnika.add(new Subject("Mechanika",3));
           elektrotechnika.add(new Subject("Wprowadzenie do światłowodów",3));
      
           elektrotechnika.add(new Subject("Maszyny elektryczne",4));
           elektrotechnika.add(new Subject("Mechatronika 2",4));
           elektrotechnika.add(new Subject("Mechanika 2",4));
      
           elektrotechnika.add(new Subject("Zaawansowane techniki projektowe z CAD",5));
           elektrotechnika.add(new Subject("Komputerowe wspomaganie projektowania",5));
           elektrotechnika.add(new Subject("Urządzenia elektryczne",5));
      
           elektrotechnika.add(new Subject("Gospodarka elektroenergetyczna",6));
           elektrotechnika.add(new Subject("Ekonomia w energetyce",6));
           elektrotechnika.add(new Subject("Elektryczne systemy energetyczne",6));
      
           elektrotechnika.add(new Subject("Programowanie w elektrotechnice",7));
           elektrotechnika.add(new Subject("Graficzne programowanie mikrokontrolerów",7));
           elektrotechnika.add(new Subject("Przemiany energetyczne",7));
             
      return elektrotechnika;
        }
        
        else if(course.equals("informatyka"))
        {
           informatyka.add(new Subject("Wstep do matematyki",1));
           informatyka.add(new Subject("Matematyka dyskretna",1));
           informatyka.add(new Subject("Przysposobienie biblioteczne",1));
      
           informatyka.add(new Subject("Podstawy ekonomii",2));
           informatyka.add(new Subject("Wprowadznie na rynek pracy",2));
           informatyka.add(new Subject("Podstawy fizyki",2));
      
           informatyka.add(new Subject("Wprowadzenie do informatyki",3));
           informatyka.add(new Subject("Metrologia",3));
           informatyka.add(new Subject("Programowanie niskopozimowe",3));
      
           informatyka.add(new Subject("Technika cyfrowa",4));
           informatyka.add(new Subject("Architektura komputerów",4));
           informatyka.add(new Subject("Programowanie systemowe",4));
      
           informatyka.add(new Subject("Bezpieczeństwo informacji",5));
           informatyka.add(new Subject("Podstawy grafiki komputerowej",5));
           informatyka.add(new Subject("Sieci komputerowe",5));
      
           informatyka.add(new Subject("Sieci rozproszone",6));
           informatyka.add(new Subject("Algorytmy analizy numerycznej",6));
           informatyka.add(new Subject("Wprowadzenie do systemó baz danych",6));
      
           informatyka.add(new Subject("Bazdy danych NoSQL i SQL",7));
           informatyka.add(new Subject("Architektura i programowanie w .NET",7));
           informatyka.add(new Subject("Hurtowanie i eksploracja danych",7));
        
           return informatyka;
        }
        
        return allSubjects;
    }
}
