package com.istinye.week11;

import android.os.Bundle;
import android.widget.Toast;

import com.istinye.week11.adapters.PersonAdapter;
import com.istinye.week11.listeners.ItemClickListener;
import com.istinye.week11.models.Person;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView myRecyclerView;
    private PersonAdapter myPersonAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    private List<Person> myPersonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initViews();
    }

    private void initViews() {
        myRecyclerView = findViewById(R.id.myRecyclerView);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(myRecyclerView);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setAdapter(myPersonAdapter);
        myRecyclerView.setLayoutManager(myLayoutManager);
    }

    private void initData() {
        myPersonList = new ArrayList<Person>();
        myPersonList.add(new Person("Burkan", "Yılmaz"));
        myPersonList.add(new Person("Birkan Hakan", "Şimşek"));
        myPersonList.add(new Person("Doğukan", "İnce"));
        myPersonList.add(new Person("Kaan", "İnce"));
        myPersonList.add(new Person("Yusuf", "Aktan"));
        myPersonList.add(new Person("James", "Bond"));
        myPersonList.add(new Person("Lebron", "James"));
        myPersonList.add(new Person("Tarkan", "Tevetoğlu"));
        myPersonList.add(new Person("Tarkan", "Altarınoğlu"));
        myPersonList.add(new Person("Stephen", "Curry"));
        myPersonList.add(new Person("Stephen", "King"));
        myPersonList.add(new Person("Stephen", "Hawking"));

        myPersonAdapter = new PersonAdapter(this, myPersonList);

        //myLayoutManager = new StaggeredGridLayoutManager( 2, RecyclerView.VERTICAL);
        myLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
    }

    @Override
    public void onItemClick(int position) {
        Person clickedPerson = myPersonList.get(position);
        Toast.makeText(MainActivity.this, clickedPerson.getName() + " " + clickedPerson.getSurname(), Toast.LENGTH_SHORT).show();
    }
}