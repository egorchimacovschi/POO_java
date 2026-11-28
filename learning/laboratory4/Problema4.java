import java.util.Vector;

public class Problema4 {
    public static void main(String args[]) {
        Person student, teacher, person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");
        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).removeCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        ((Student) student).addCourseGrade("Programare", 10);
        ((Student) student).addCourseGrade("Algoritmica", 9);
        ((Student) student).addCourseGrade("Matematica", 8);
        assert (Math.abs(((Student) student).getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa " +
                "Student nu a fost implementat corect";
        ((Student) student).printGrades();
        //Ce metoda toString se va apela? Din ce clasa?
        System.out.println(student);
        System.out.println(person);
        System.out.println("Felicitari! Problema a fost rezolvata corect!");
    }
}

class Person{
    private String name;
    private String address;

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    @Override
    public String toString(){
        return "name: " + name + " " + "address: " + address;
    }
}

class Teacher extends Person{
    private Vector<String> courses;

    public Teacher(String name, String address){
        super(name, address);
        courses = new Vector<String>();
    }

    @Override
    public String toString() {
        return super.toString() + " " + courses.toString();
    }

    public boolean addCourse(String course){
        if(!courses.contains(course)){
            courses.add(course);
            return true;
        }

        return false;
    }

    public boolean removeCourse(String course){
        if(courses.contains(course)){
            courses.remove(course);
            return true;
        }

        return false;
    }
}

class Student extends Person{
    private Vector<String> courses;
    private Vector<Integer> grades;

    public Student(String name, String address){
        super(name, address);
        courses = new Vector<String>();
        grades = new Vector<Integer>();
    }

    @Override
    public String toString(){
        return super.toString() + courses.toString() + "\n" + grades.toString();
    }

    public void addCourseGrade(String course, int grade){
        courses.add(course);
        grades.add(grade);
    }

    public void printGrades(){
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i) + ": " + grades.get(i));
        }
    }

    public double getAverageGrade(){
        if(grades.isEmpty()){
            return 0;
        }

        int sum = 0;
        for(int grade : grades){
            sum += grade;
        }

        double average = (double) sum / grades.size();
        return average;
    }
}