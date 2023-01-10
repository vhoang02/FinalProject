package com.example.finalproject.models;

import com.example.finalproject.beans.Category;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class CategoryModel {
    public static List<Category> findAllCategory() {
        final String query = "SELECT * FROM categories";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Category.class);
        }
    }




}


