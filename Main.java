import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDAOImpl dao = new StudentDAOImpl();

        while (true) {
            System.out.println("1.Add 2.View 3.Exit");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 1) {
                Student s = new Student();
                System.out.print("Name: ");
                s.setName(sc.nextLine().trim());
                System.out.print("Email: ");
                s.setEmail(sc.nextLine().trim());
                System.out.print("Course: ");
                s.setCourse(sc.nextLine().trim());
                Double marks = null;
                while (marks == null) {
                    System.out.print("Marks: ");
                    String m = sc.nextLine().trim();
                    try {
                        marks = Double.parseDouble(m);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number for marks.");
                    }
                }
                s.setMarks(marks);
                try {
                    dao.addStudent(s);
                } catch (Exception e) {
                    System.out.println("Failed to add student: " + e.getMessage());
                }
            } 
            else if (choice == 2) {
                try {
                    dao.viewStudents();
                } catch (Exception e) {
                    System.out.println("Failed to fetch students: " + e.getMessage());
                }
            } 
            else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
