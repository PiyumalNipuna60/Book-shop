

import java.util.Arrays;
import java.util.Scanner;


 class main {
    private final static Scanner scanner = new Scanner(System.in);
    private static final String userName = "yasindu";
    private static final String password = "1234";

    public static Book[] bookObject = new Book[0];

    public static void main(String[] args) {

        header("Book shop");
        login();
        manu();


    }

    private static void manu() {

        clearConsole();
        header("WELCOME TO SHI BOOK SHOP MANAGEMENT SYSTEM");

        while (true) {
            System.out.println("		[1]Add Book                                       [2]Delete Book ");
            System.out.println("		[3]Update Book                                    [4]Show All Book");
            System.out.println("		[5]Log out                                        [6]Exit the System ");

            System.out.println();
            System.out.print("                ENTER AN OPTION TO COTINUE :");
            int x = scanner.nextInt();

            switch (x) {
                case 1:
                    clearConsole();
                    addBook();
                    break;
                case 2:
                    clearConsole();
                    DeleteBook();
                    break;
                case 3:
                    clearConsole();
                    UpdateBook();
                    break;
                case 4:
                    clearConsole();
                    ShowAllBook();
                    break;
                case 5:
                    clearConsole();
                    login();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:

                    System.out.println("\nwrong input!!! please input number belongs to menu....");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
                    header("WELCOME TO SHI BOOK SHOP MANAGEMENT SYSTEM");
            }
        }
    }


     // showAllBook
    private static void ShowAllBook() {
        header("VIEW All BOOk");
        System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
        System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", "BOOK ID", "BOOK NAME", "BOOK PRICE", "BOOK QTY", "BOOK AUTHORS");
        System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
        for (int i = 0; i < bookObject.length; i++) {
            System.out.printf("|%15s        |%15s        |%15s        |%15s        |%15s        |\n", bookObject[i].bId, bookObject[i].bName, bookObject[i].price, bookObject[i].qty, bookObject[i].authors);
            System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
        }
        boolean checked=yesNo("Do you want to go Book manage page(Y/N):");
        if (checked) {
            clearConsole();
            manu();
        }
    }


     // updateBook
    private static void UpdateBook() {
        header("UPDATE BOOK");
        L1:
        while (true) {
            System.out.print("Book ID:");
            String id = scanner.next();
            boolean flag=false;
            for (int i = 0; i < bookObject.length; i++) {
                if (id.equals(bookObject[i].bId)) {
                    System.out.println("Book name:"+bookObject[i].bName);
                    System.out.println(Arrays.deepToString(bookObject));
                    System.out.print("Enter the new Book name:");
                    bookObject[i].bName= scanner.next();
                    System.out.println(Arrays.deepToString(bookObject));

                    boolean checked=yesNo("Updated successfully!Do you want to update another Book?(Y/N):");
                    if(checked){
                        continue L1;
                    } else if (checked==false) {
                        clearConsole();
                        manu();
                        break;
                    }
                }else{
                    flag=true;
                }
            }
            if(flag){
                System.out.println("can't find Book id.try again!");
                continue L1;
            }
        }
    }


     // deleteBook
    private static void DeleteBook() {
        header("DELETE BOOK");
        if (bookObject.length == 0) {
            System.out.print("oops seems like you havent add Book yet.please add Book first press num 1 to  Book Menu page -> ");
            int x = scanner.nextInt();
            if (x == 1) {
                manu();
            }
        }
        System.out.println();
        boolean flag = false;
        L1:
        while (true) {
            int j = 0;
            Book temp[] = new Book[bookObject.length-1];
            System.out.print("Book ID:");
            String id = scanner.next();



            for (int i = 0; i < bookObject.length; i++) {
                if (id.equals(bookObject[i].bId)) {
                    bookObject[i].bId = "deleted";
                    bookObject[i].bName = "deleted";
                    bookObject[i].price = 0.0;
                    bookObject[i].qty = 0;
                    bookObject[i].authors = "deleted";

                    flag = true;
                }
            }
            if(!flag){
                System.out.println("can't find Book!!try again");
                continue L1;
            }

            if (flag) {
                for (int i = 0; i < bookObject.length; i++) {
                    if (!bookObject[i].bId.equals("deleted")) {
                        temp[j] = bookObject[i];
                        j++;
                    }
                }

                bookObject = temp;
                System.out.println("after>" + Arrays.deepToString(bookObject));
                System.out.println("deleted Successfully!");
                L2:
                while (true){
                    boolean checked=yesNo("\ndo you want to delete another Book(Y/N):");
                    if (checked) {
                        if(bookObject.length==0){
                            System.out.println("\noops Book list is empty!!");
                            while (true) {
                                System.out.print("\nEnter num'1' to go to Book menu page -> ");
                                int x = scanner.nextInt();
                                if (x == 1) {
                                    manu();
                                }
                            }
                        }
                        continue L1;
                    } else {
                        manu();

                    }
                }
            }
        }
    }


     // addBook
    private static void addBook() {
        header("ADD SUPPLIER");

        String bId = "";
        String bName = "";
        Double price = 0.00;
        int qty = 0;
        String authors = "";


        System.out.println(bookObject.length);
        grow();
        System.out.println(bookObject.length);
        boolean flag = true;
        L1:
        while (true) {

            System.out.print("Book ID: ");
            bId = scanner.next();

            if (flag) {

                System.out.print("Book Name : ");
                bName = scanner.next();

                System.out.print("Book Price : ");
                price = scanner.nextDouble();

                System.out.print("Book Qty: ");
                qty = scanner.nextInt();

                System.out.print("Book Authors : ");
                authors = scanner.next();

                //save Object
                bookObject[bookObject.length - 1] = new Book(bId, bName, price, qty, authors);
//                for (int i = 0; i < bookObject.length; i++) {
//                    System.out.println(bookObject[i].toString());
//                }

                boolean checked = yesNo("added succesfully..!  Do you want to add another Book(Y/N):");
                if (checked) {
                    grow();
                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                    continue L1;
                } else {
                    clearConsole();
                    manu();
                    break;
                }
            }
        }
    }


    // grow Object Array
    private static void grow() {
        Book[] book = new Book[bookObject.length + 1];
        System.arraycopy(bookObject, 0, book, 0, bookObject.length);
        bookObject = book;
    }


    //yes Or No respond
    private static boolean yesNo(String x) {
        L1:
        while (true) {
            System.out.print(x);
            String yesNo = scanner.next();
            boolean flag = false;
            yesNo = yesNo.toUpperCase();
            if (yesNo.equals("Y") || yesNo.equals("YES")) {
                flag = true;
            } else if (yesNo.equals("N") || yesNo.equals("NO")) {
                flag = false;
            } else {
                continue L1;
            }
            return flag;
        }
    }


    //header
    private static void header(String title) {
        System.out.print("                   +----------------------------------------------------------------------------------------------------+\n");
        System.out.printf("                   |  %55s                                           |\n", title);
        System.out.print("                   +----------------------------------------------------------------------------------------------------+\n");
        System.out.println();
    }


    //login page
    private static void login() {
        clearConsole();
        header("LOGIN PAGE");
        while (true) {
            System.out.print("Enter your UserName : ");
            String name = scanner.next();

            System.out.print("Enter your password : ");
            String pas = scanner.next();

            if (pas.equals(password) && name.equals(userName)) {
                System.out.println("login successfull");
                return;
            } else if (!name.equals(userName) && !pas.equals(password)) {
                System.out.println("Wrong userName and password..! Try again....");
                System.out.println();
            } else if (!pas.equals(password)) {
                System.out.println("Wrong password..! Try again....");
                System.out.println();
            } else {
                System.out.println("Wrong userName..! Try again....");
                System.out.println();
            }
        }
    }


    //clear console
    private static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows 10")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }


}


class Book {
    String bId;
    String bName;
    Double price;
    int qty;
    String authors;

    public Book(String bId, String bName, Double price, int qty, String authors) {
        this.bId = bId;
        this.bName = bName;
        this.price = price;
        this.qty = qty;
        this.authors = authors;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId='" + bId + '\'' +
                ", bName='" + bName + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", authors='" + authors + '\'' +
                '}';
    }
}
