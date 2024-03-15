import java.util.Scanner;

public class Admin {
    private String[][] userStudent = {
    };

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        String nim, name, faculty, programStudy;

        System.out.print("Masukkan NIM: ");
        nim = scanner.nextLine();

        if (nim.length() != 15) {
            System.out.println("NIM tidak valid. Must be 15 characters long.");
            return;
        }

        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        System.out.print("Enter Faculty: ");
        faculty = scanner.nextLine();

        System.out.print("Enter Program Study: ");
        programStudy = scanner.nextLine();

        userStudent = addToArray(userStudent, nim, name, faculty, programStudy);
    }

    public String[][] displayStudent() {
        System.out.println("NIM\t\t\t\tName\tFaculty\t\tProgram Study");
        for (String[] student: userStudent) {
            System.out.println(student[0] + "\t" + student[1] + "\t" + student[2] + "\t\t" + student[3]);
        }
        return userStudent;
    }

    public String[][] addToArray(String[][] array, String nim, String name, String faculty, String programStudy) {
        String[][] newArray = new String[array.length + 1][];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[array.length] = new String[]{nim, name, faculty, programStudy};

        return newArray;
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    System.out.println("Logged out.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}