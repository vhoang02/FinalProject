package com.example.finalproject.service;

import com.example.finalproject.beans.Category;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class CategoryService {
    public static List<Category> getAll() {
        String sql = "SELECT * FROM categories";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Category.class);
        }
    }

    public static Category get(int id) {
        String sql = "select * from categories where cat_id = :cat_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(sql)
                    .addParameter("cat_id", id)
                    .executeAndFetch(Category.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }
    public static void add(Category c) {
        String sql = "INSERT INTO categories (cat_name, parent_id) VALUES (:cat_name,:parent_id)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("cat_name", c.getCat_name())
                    .addParameter("parent_id", c.getParent_id())
                    .executeUpdate();
        }
    }
    public static void update(Category c) {
        String sql = "UPDATE categories set cat_name = :cat_name, parent_id = :parent_id WHERE cat_id = :cat_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("cat_name", c.getCat_name())
                    .addParameter("parent_id", c.getParent_id())
                    .addParameter("cat_id", c.getCat_id())
                    .executeUpdate();
        }
    }
    public static void delete(int id) {
        String sql = "DELETE from categories WHERE cat_id = :cat_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("cat_id", id)
                    .executeUpdate();
        }
    }

    public static Category Search(String txtSearch) {
        final String query = "SELECT * FROM categories WHERE cat_name LIKE :txt";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(query)
                    .addParameter("txt", "%" + txtSearch + "%")
                    .executeAndFetch(Category.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }
    public static int countCat( ) {
        String query = "SELECT * FROM categories";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(query)
                    .executeAndFetch(Category.class);
            return list.size();
        }
    }
}
