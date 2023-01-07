package com.example.finalproject.beans;

public class Editor {
    private int editor_manage_id, manage_users_id, manage_categories_id;

    public Editor() {
    }

    public Editor(int editor_manage_id, int manage_users_id, int manage_categories_id) {
        this.editor_manage_id = editor_manage_id;
        this.manage_users_id = manage_users_id;
        this.manage_categories_id = manage_categories_id;
    }

    public int getEditor_manage_id() {
        return editor_manage_id;
    }

    public void setEditor_manage_id(int editor_manage_id) {
        this.editor_manage_id = editor_manage_id;
    }

    public int getManage_users_id() {
        return manage_users_id;
    }

    public void setManage_users_id(int manage_users_id) {
        this.manage_users_id = manage_users_id;
    }

    public int getManage_categories_id() {
        return manage_categories_id;
    }

    public void setManage_categories_id(int manage_categories_id) {
        this.manage_categories_id = manage_categories_id;
    }
}
