package com.example.finalproject.models;

import com.example.finalproject.beans.Cmt;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

public class CommentModel {
    public static void addCmt(Cmt comment){
        final String query = "INSERT INTO comment (comment_articles_id,comment_users_id,comment,comment_date) " +
                "VALUES (:comment_articles_id,:comment_users_id,:comment,:comment_date)";;
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("comment_articles_id",Cmt.getComArtID())
                    .addParameter("comment_users_id",Cmt.getComUID())
                    .addParameter("comment",Cmt.getComm())
                    .addParameter("comment_date",Cmt.getComDate())
                    .executeUpdate();
        }
    }
    public static void DeleteCmtByArticlesId(int comment_articles_id)
    {
        final String query = "DELETE FROM comments WHERE comment_articles_id = :comment_articles_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("comment_articles_id",comment_articles_id)
                    .executeUpdate();
        }
    }
}


