import java.util.Comparator;
import java.util.TreeSet;

public class Catalog extends TreeSet<Catalog.Student> {

    public static class Student implements Comparable<Student> {
        String name;
        double media;
        int clazz;

        public Student(String name, double media, int clazz) {
            this.name = name;
            this.media = media;
            this.clazz = clazz;
        }

        public String getName() {
            return name;
        }

        public double getMedia() {
            return media;
        }

        public int getClazz() {
            return clazz;
        }

        @Override
        public int compareTo(Student o) {
            int byMedia = Double.compare(media, o.media);
            if (byMedia != 0) {
                return byMedia;
            }
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return name + " " + media + " " + clazz;
        }
    }

    public Catalog() {
        super();
    }

    public Catalog(Comparator<Student> comparator) {
        super(comparator);
    }

    public void addStudent(String name, double media, int clazz) {
        add(new Student(name, media, clazz));
    }

    public Student getStudent(String name) {
        for (Student student : this) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(String name) {
        Student student = getStudent(name);
        if (student != null) {
            remove(student);
        }
    }

    public Catalog byClass(int clazz) {
        Catalog result = new Catalog(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                int byName = a.name.compareTo(b.name);
                if (byName != 0) {
                    return byName;
                }
                return Double.compare(a.media, b.media);
            }
        });

        for (Student student : this) {
            if (student.clazz == clazz) {
                result.add(student);
            }
        }
        return result;
    }
}
