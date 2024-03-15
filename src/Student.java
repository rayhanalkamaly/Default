import java.util.Scanner;

public class Student {
    private String[][] bookList = {
            {"1", "101", "Akira Tori", "Dragon Ball", "Action", "54"},
            {"2", "102", "Sui Ishida", "Tokyo Ghoul", "Fantasy", "42"},
            {"3", "103", "Kumo Kagyu", "Goblin Slayer", "Action", "78"}
    };

    private String[][] borrowedBooks = new String[0][6];

    public void displayBooks() {
        System.out.println("No\tBook ID\tAuthor\t\t\t\t\tTitle\t\t\t\t\tCategory\tStock");
        for (String[] book : bookList) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t\t\t" + book[3] + "\t\t\t\t" + book[4] + "\t\t" + book[5]);
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("No\tBook ID\tAuthor\t\t\t\tTitle\t\t\tCategory\tStatus");
        for (String[] book : borrowedBooks) {
            System.out.println(book[0] + "\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t\t" + book[4]+ "\t\t" + "Borrowed");
        }
    }

    public void logout() {
        System.out.println("Logged out.");
    }

    public void borrowBook(String bookId) {
        for (String[] book : bookList) {
            if (bookId.equals(book[1])) {
                if (Integer.parseInt(book[5]) > 0) {
                    String[] newBook = new String[6];
                    System.arraycopy(book, 0, newBook, 0, 6);
                    newBook[5] = String.valueOf(Integer.parseInt(newBook[5]) - 1);
                    String[] newBorrowedBook = new String[6];
                    System.arraycopy(book, 0, newBorrowedBook, 0, 6);
                    borrowedBooks = append(borrowedBooks, newBorrowedBook);
                    System.out.println("Buku berhasil dipinjam.");
                    return;
                } else {
                    System.out.println("Buku tidak tersedia.");
                    return;
                }
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    public String[][] append(String[][] array, String[] toAppend) {
        String[][] newArray = new String[array.length + 1][];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = toAppend;
        return newArray;
    }

    public void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n1. Display Books");
            System.out.println("2. Display Borrowed Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    displayBorrowedBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID: ");
                    scanner.nextLine();
                    borrowBook(scanner.nextLine());
                    break;
                case 4:
                    logout();
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}