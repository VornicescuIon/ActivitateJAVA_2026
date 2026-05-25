import java.util.*;
public class Main {
    public static void main(String[] args) {

List<String> x=new ArrayList<>();
x.add("ion");
        x.add("matei");
        x.add("vera");
        x.add("vera");
        x.add("vera");
        for (String z:x) {
            System.out.println(z);
        }
List<Integer> y =new ArrayList<>();
        y.add(1);
        y.add(1);
        y.add(1);
        y.add(1);
        y.add(1);
        y.add(1);
        y.add(1);
        y.add(1);
        y.add(1);
        y.add(20);
int s=0;
for (int w:y){
    s+=w;
}
int r=s/y.toArray().length;
        System.out.println(r);
        Collections.reverse(y);
        System.out.println(y);

        String sentence = "java este cool si java este puternic";
        String[] words = sentence.toLowerCase().split(" ");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Cuvinte unice: " + uniqueWords);
        System.out.println("Număr cuvinte unice: " + uniqueWords.size());


                String input = "apple banana apple orange banana apple";
                String[] ws = input.split(" ");
                Map<String, Integer> counts = new HashMap<>();

                for (String w : words) {
                    counts.put(w, counts.getOrDefault(w, 0) + 1);
                }
                System.out.println("Frecvență cuvinte: " + counts);
        Map<String, String> contacts = new HashMap<>();
        contacts.put("Andrei", "0722123456");
        contacts.put("Maria", "0744987654");

        String search = "Andrei";
        System.out.println("Caută " + search + ": " + contacts.get(search));

        System.out.println("Toate contactele:");
        contacts.forEach((name, phone) -> System.out.println(name + " -> " + phone));


        List<Student> students = new ArrayList<>();
                students.add(new Student("Andrei", 9));
                students.add(new Student("Elena", 10));
                students.add(new Student("Matei", 8));
                students.add(new Student("Andrei", 9)); // Duplicat

                // 7. Highest Grade
                Student topStudent = Collections.max(students, Comparator.comparingInt(Student::getGrade));
                System.out.println("Studentul cu nota maximă: " + topStudent);

                // 8. Sortare
                students.sort(Comparator.comparing(Student::getName));
                System.out.println("Sortat după nume: " + students);

                students.sort((s1, s2) -> Integer.compare(s2.grade, s1.grade)); // Descrescători
                System.out.println("Sortat după notă (desc): " + students);

                // 9. Remove Duplicates
                Set<Student> uniqueStudents = new LinkedHashSet<>(students);
                System.out.println("Fără duplicate: " + uniqueStudents);


    }

}