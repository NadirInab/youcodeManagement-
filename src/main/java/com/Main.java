package main.java.com;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;


import main.java.com.Author.AuthorController;
import main.java.com.Book.Book;
import main.java.com.Book.BookController;
import main.java.com.Book.BookService;
import main.java.com.User.User;

public class Main {

    public static void main(String[] args) throws SQLException {
        BookController bookController = new BookController() ;

        System.out.println("welcome to YouBiblio application : \n");
        Scanner scanner=new Scanner(System.in);

        do {
            System.out.println("1. Add Book\n"+
                    "2. Show All Books\n"+
                    "3. Search For a Book\n"+
                    "4. Update Book\n"+
                    "5. Delete Book\n"+
                    "6. Borrow a Book\n"+
                    "7. Return a Book\n");
            System.out.println("Enter your choice : ");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter Title : ");
                    String title= scanner.next();
                    System.out.println("Enter Author : ");
                    int author=scanner.nextInt();
                    System.out.println("Enter ISBN : ");
                    int isbn =scanner.nextInt();
                    System.out.println("Enter Status : ");
                    String status= scanner.next();

                    Book book = new Book(isbn, title, author) ;
                    bookController.add(book);

                    break;
                case 2:
                        bookController.index();
                    break;
                case 3:
                    System.out.print("Enter Book Title : ");
                    String searchInput = scanner.next();
                    bookController.searchForBook(searchInput);
                    break;

                case 4:
                    // update a book
                    System.out.print("Enter the ISBN to find your Book : \n");
                    BookService bookService = new BookService() ;
                    int bookIsbn = scanner.nextInt();
                    boolean isExist = bookService.findByIsbn(bookIsbn) ;
                    if(!isExist){
                        System.out.println("Fortunately book doesn't exist !!");
                    }else {
                        System.out.println("Enter Title : ");
                        String updatedTitle= scanner.next();
                        System.out.println("Enter Author : ");
                        int updatedAuthor =scanner.nextInt();
                        System.out.println("Enter Status : ");
                        String updDatedStatus= scanner.next();
                        System.out.println("Enter isbn : ");
                        int updDatedIsbn= scanner.nextInt();

                        Book upDatedBook = new Book(updDatedIsbn, updatedTitle, updatedAuthor) ;

                        bookController.upDate(upDatedBook, bookIsbn);
                    }

                    break;
                case 5:
                    System.out.print("Enter Book ISBN : ");
                    break;
                case 6:
                    System.out.print("Enter Book ISBN : ");

                    break;
                case 7:
                    System.out.print("Enter Book ISBN : ");
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("Thank you for using our Application.");
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Choice !");
                    break;
            }
        }while (true);
    }
}
