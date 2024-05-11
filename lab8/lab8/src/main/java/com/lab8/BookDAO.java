package com.lab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
      //  this.connection = Database.getConnection();
    }

    public void create(Book book) {
        String sql = "INSERT INTO book (title, language, publication_date, num_pages, author_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getLanguage());
            pstmt.setDate(3, new java.sql.Date(book.getPublicationDate().getTime()));
            pstmt.setInt(4, book.getNumPages());
            pstmt.setInt(5, book.getAuthor().getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //aici ar mai veni si alte metode
}

