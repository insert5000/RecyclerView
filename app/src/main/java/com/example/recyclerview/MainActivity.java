package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Persona> personas;

    private void initializeData(){

            personas = new ArrayList<>();
            personas.add(new Persona("AeroSmith", "Banda estadounidense de hard rock.", R.drawable.aerosmith, "1970" ));
            personas.add(new Persona("Guns and Roses", "Banda de hard rock formada en Hollywood", R.drawable.guns, "1985"));
            personas.add(new Persona("Queen", "Banda británica de rock formada en Londres", R.drawable.queen, "1970"));
        personas.add(new Persona("Nirvana", "Banda de grunge estadounidense procedente de Aberdeen, Washington, Estados Unidos", R.drawable.nirvana, "1970"));
        personas.add(new Persona("Rolling Stone", "Banda británica de rock originaria de Londres.", R.drawable.rolling, "1962"));
        personas.add(new Persona("Black Sabbath", "Banda británica de heavy metal y hard rock ", R.drawable.black, "1968"));
        personas.add(new Persona("AC/DC", "Banda de hard rock australiano formado  en Sídney, Australia", R.drawable.acdc, "1973"));
        personas.add(new Persona("Iron Maiden", " Banda británica de heavy metal fundada en 1975 por el bajista Steve Harris.", R.drawable.iron, "1975"));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getApplicationContext());

        rv.setLayoutManager(linearLayoutManager);

        initializeData();

        RVAdapter rvAdapter = new RVAdapter(personas,this);
        rvAdapter.setOncCickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selecciono: "+ personas.get(rv.getChildAdapterPosition(v)).nombre,Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(rvAdapter);

        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

}
