import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int marks;
    
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    
    public String getName() {
        return name;
    }
    
    public int getMarks() {
        return marks;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        scanner.nextLine(); 

        List<Student> students = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int marks = Integer.parseInt(parts[1]);
            students.add(new Student(name, marks));
        }
        
        int K = scanner.nextInt();
        
        List<String> topKStudents = students.stream()
            .sorted(Comparator.comparingInt(Student::getMarks).reversed()
                    .thenComparing(Student::getName))
            .limit(K)
            .map(Student::getName)
            .collect(Collectors.toList());
        
        // Print result
        System.out.println(String.join(" ", topKStudents));
    }
}
