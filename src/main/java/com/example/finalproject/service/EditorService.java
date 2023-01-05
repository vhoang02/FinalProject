package com.example.finalproject.service;

import com.example.finalproject.beans.Editor;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class EditorService {
    public static List<Editor> getAll() {
        String sql = "select * from editor_manage_categories";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Editor.class);
        }
    }

    public static Editor get(int id) {
        String sql = "sselect * from editor_manage_categories where editor_manage_id = :editor_manage_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Editor> list = con.createQuery(sql)
                    .addParameter("editor_manage_id", id)
                    .executeAndFetch(Editor.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }
}
