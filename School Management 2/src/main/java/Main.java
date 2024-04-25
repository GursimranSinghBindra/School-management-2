import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        System.out.println("Enter details for teachers:");
        System.out.print("How many teachers? ");
        int numTeachers = getIntInput(scanner);
        scanner.nextLine();
        for (int i = 0; i < numTeachers; i++) {
            System.out.print("Enter teacher name: ");
            String teacherName = scanner.nextLine();
            System.out.print("Enter teacher id: ");
            int teacherId = getIntInput(scanner);
            System.out.print("Enter teacher salary: ");
            int teacherSalary = getIntInput(scanner);
            teachers.add(new Teacher(teacherName, teacherId, teacherSalary));
            scanner.nextLine();
        }

        System.out.println("Enter details for students:");
        System.out.print("How many students? ");
        int numStudents = getIntInput(scanner);
        scanner.nextLine();
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter student id: ");
            int studentId = getIntInput(scanner);
            System.out.print("Enter student grade: ");
            int studentGrade = getIntInput(scanner);
            students.add(new Student(studentId, studentName, studentGrade));
            scanner.nextLine();
        }

        // Connect to MongoDB
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("school_management");
            MongoCollection<Document> teacherCollection = database.getCollection("teachers");
            MongoCollection<Document> studentCollection = database.getCollection("students");

            // Insert teachers into MongoDB
            for (Teacher teacher : teachers) {
                Document teacherDoc = new Document()
                        .append("name", teacher.getName())
                        .append("id", teacher.getId())
                        .append("salary", teacher.getSalary());
                teacherCollection.insertOne(teacherDoc);
            }

            // Insert students into MongoDB
            for (Student student : students) {
                Document studentDoc = new Document()
                        .append("name", student.getName())
                        .append("id", student.getId())
                        .append("grade", student.getGrade());
                studentCollection.insertOne(studentDoc);
            }

            // Rest of your existing code goes here

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getIntInput(Scanner scanner) {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        return input;
    }
}
