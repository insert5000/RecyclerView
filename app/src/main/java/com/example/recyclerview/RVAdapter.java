package com.example.recyclerview;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class RVAdapter
        extends RecyclerView.Adapter<RVAdapter.PersonaViewHolder>
        implements View.OnClickListener{

    private  View.OnClickListener listener;
    int posicionMarcada=0;
    List<Persona> personas;
    Context context;

    RVAdapter(List<Persona> personas, Context context){
        this.personas = personas;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                . inflate(R.layout.persona,parent,false);

        view.setOnClickListener(this);
        PersonaViewHolder pvh = new PersonaViewHolder(view);
        return pvh;

    }


    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        final int pos = position;

        holder.nombrePersona.setText(personas.get(position).nombre);
        holder.edadPersona.setText(personas.get(position).descripcion);
        holder.year.setText(personas.get(position).year);


        Drawable original = context
                .getResources()
                .getDrawable(personas.get(position).foto
                        ,null);

        Bitmap originalBitmap = ((BitmapDrawable) original).getBitmap();

        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(context.getResources()
                        , originalBitmap);

        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        holder.fotoPersona.setImageDrawable(roundedDrawable);






    }


        @Override
    public int getItemCount() {
        return personas.size();
    }

    public  void setOncCickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        if( listener != null ){
            listener.onClick(v);
        }
        

    }


    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nombrePersona;
        TextView edadPersona;
        ImageView fotoPersona;
        TextView year;

        PersonaViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            nombrePersona = (TextView)itemView.findViewById(R.id.nombrePersona);
            edadPersona = (TextView)itemView.findViewById(R.id.edadPersona);
            fotoPersona = (ImageView) itemView.findViewById(R.id.fotoPersona);
            year = (TextView)itemView.findViewById(R.id.year);
        }
    }
}

