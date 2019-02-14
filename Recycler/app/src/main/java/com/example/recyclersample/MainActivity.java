package com.example.recyclersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclersample.Adapter.MyRecyclerViewAdapter;
import com.example.recyclersample.dataModel.infoDataModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {

//        ArrayList<String> animalNames = new ArrayList<>();
//        animalNames.add("Horse");
//        animalNames.add("Cow");
//        animalNames.add("Camel");
//        animalNames.add("Sheep");
//        animalNames.add("Goat");

        //Dados estaticos
        ArrayList<infoDataModel> myData = new ArrayList<>();
        infoDataModel linha1 = new infoDataModel("Categoria1", "Corrida de farrapos", 1);
        infoDataModel linha2 = new infoDataModel("Categoria3", "Corrida de Macarrão", 3);
        infoDataModel linha3 = new infoDataModel("Categoria2", "Natação", 3);
        myData.add(linha1);
        myData.add(linha2);
        myData.add(linha3);

        RecyclerView recyclerView = findViewById(R.id.myReciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, myData);
        recyclerView.setAdapter(adapter);

    }
}
