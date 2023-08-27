import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("***Menu***");
            System.out.println("Select from the list of options below:");
            System.out.println("1) Add new student");
            System.out.println("2) Update existing student");
            System.out.println("3) Remove existing student");
            System.out.println("4) Display student records");
            System.out.println("5) Exit program");
            System.out.println();
            System.out.println("For each selected option, enter requested information and press enter");
            System.out.println();

            int option = scanner.nextInt();
            String search_by_first_name;

            switch (option) {
                case 1 -> {
                    System.out.println("Option: Add a new student");
                    System.out.print("Enter first name: ");
                    String first_name = scanner.next().toLowerCase();
                    System.out.print("Enter last name: ");
                    String last_name = scanner.next().toLowerCase();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    char grade = scanner.next().toLowerCase().charAt(0);

                    Student new_student = new Student(first_name, last_name, age, grade);
                    students.add(new_student);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Option: Update existing student");

                    System.out.print("Enter first name of student: ");
                    search_by_first_name = scanner.next().toLowerCase();

                    students.forEach((student) -> {
                        if (Objects.equals(student.first_name, search_by_first_name)) {
                            System.out.println("Enter new information below");
                            System.out.print("Enter first name: ");
                            String new_first_name = scanner.next().toLowerCase();

                            System.out.print("Enter last name: ");
                            String new_last_name = scanner.next().toLowerCase();

                            System.out.print("Enter age: ");
                            int new_age = scanner.nextInt();

                            System.out.print("Enter grade: ");
                            char new_grade = scanner.next().toLowerCase().charAt(0);

                            Student new_student = new Student(new_first_name, new_last_name, new_age, new_grade);
                            int position_of_existing_student = students.indexOf(student);

                            students.set(position_of_existing_student, new_student);
                        } else {
                            System.out.println("Name does not exist.");
                        }
                    });
                    System.out.println();
                    break;
                }
                case 3 -> {
                    System.out.println("Option: Remove existing student");
                    System.out.print("Enter first name of student: ");
                    search_by_first_name = scanner.next().toLowerCase();

                    boolean result = students.removeIf(student ->
                            Objects.equals(student.first_name, search_by_first_name));

                    if (result) {
                        System.out.println("Student by name '" + search_by_first_name + "' has been successfully removed.");
                    } else {
                        System.out.println("Student by name '" + search_by_first_name + "' does not exist in our records.");
                    }
                    System.out.println();
                    break;
                }
                case 4 -> {
                    System.out.println("Option: Display student records");
                    if (students.isEmpty()) {
                        System.out.println("There are no student records.");
                    } else {
                        students.forEach((student) -> System.out.println("First Name: " + student.first_name + " Last Name: " + student.last_name
                                + " Age: " + student.age + " Grade: " + String.valueOf(student.grade).toUpperCase()));
                    }
                    System.out.println();
                    break;
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
            }
        }
    }
}