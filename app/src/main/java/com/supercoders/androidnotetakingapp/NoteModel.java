package com.supercoders.androidnotetakingapp;

public class NoteModel {
    String id;
    String note_data;
    String created_at;

    public NoteModel(){

    }
    public NoteModel(String id, String note_data, String created_at) {
        this.id = id;
        this.note_data = note_data;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote_data() {
        return note_data;
    }

    public void setNote_data(String note_data) {
        this.note_data = note_data;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
