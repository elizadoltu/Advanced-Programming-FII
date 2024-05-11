package com.lab8;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            var authors = new AuthorDAO();
            var shakespeare = new Author("William Shakespeare");
            authors.create(shakespeare.getName());

            var books = new BookDAO();
            var hamlet = new Book(1, "Hamlet", "English", new java.util.Date(), 342, shakespeare);
            books.create(hamlet);

            Database.getConnection().commit();

            Database.getConnection().commit();

          

            Database.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                Database.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    }
