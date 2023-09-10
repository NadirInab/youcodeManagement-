package main.java.com.Borrows;

import java.util.Date;

public class Borrows {
    private int bookId ;
    private int borrowerId ;

    private Date borrowDate ;

    public Borrows(int borrowerId, int bookId, Date borrowDate) {
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate ;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getBookId() {
        return bookId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

}

