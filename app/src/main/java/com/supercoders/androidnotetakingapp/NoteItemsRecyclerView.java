package com.supercoders.androidnotetakingapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class NoteItemsRecyclerView extends RecyclerView.Adapter {

    List<NoteModel> noteModelList;
    NoteClickListener noteClickListener;
    String[] color_list={"#d32f2f","#f50057","#4a148c","#4527a0","#3949ab","#448aff","#006064","#00695c","#388e3c","#558b2f","#827717","#ef6c00","#ff3d00","#795548","#616161","#455a64"};

    public NoteItemsRecyclerView(List<NoteModel> noteModels,NoteClickListener noteClickListener){
        this.noteModelList=noteModels;
        this.noteClickListener=noteClickListener;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        public TextView noteText,create_time;
        public CardView card_item;
        public RelativeLayout note_parent;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteText=itemView.findViewById(R.id.notetext);
            create_time=itemView.findViewById(R.id.create_time);
            note_parent=itemView.findViewById(R.id.note_parent);
            card_item=itemView.findViewById(R.id.card_item);
        }
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row,null);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        NoteViewHolder noteViewHolder= (NoteViewHolder) holder;
        noteViewHolder.noteText.setText(noteModelList.get(position).getNote_data());
        noteViewHolder.create_time.setText(noteModelList.get(position).getCreated_at());

        Random random=new Random();
        int randomNo=random.nextInt(color_list.length);

        noteViewHolder.card_item.setCardBackgroundColor(Color.parseColor(color_list[randomNo]));

        noteViewHolder.note_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteClickListener.onClickItem(noteModelList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return noteModelList.size();
    }
}
