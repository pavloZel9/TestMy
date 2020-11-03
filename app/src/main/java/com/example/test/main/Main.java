package com.example.test.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.test.R;
import com.example.test.example.Item;
import com.example.test.example.Radapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main extends AppCompatActivity {

    @BindView(R.id.editTextTextPersonName)
    EditText editTextTextPersonName;

    @BindView(R.id.list)
    RecyclerView recyclerView;


    ArrayList<Item> items= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        init();
    }

    public void init(){

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.green_primary));
        }

        editTextTextPersonName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.taptap, 0, 0, 0);

        FireBaseConnected();

    }

    public void FireBaseConnected(){
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Double arrival;
                for(DataSnapshot ds : dataSnapshot.getChildren()) {

                    items.add(new Item(ds.child("name").getValue(String.class),
                            ds.child("url").getValue(String.class),
                            ds.child("price").getValue(Double.class),
                            ds.child("old_price").getValue(Double.class),
                            ds.child("rating").getValue(Integer.class),
                            ds.child("len_rating").getValue(Integer.class)));

                }


                LinearLayoutManager layoutManager =
                        new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                Radapter adapter = new Radapter(getApplicationContext(), items,getApplicationContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        rootRef.addListenerForSingleValueEvent(valueEventListener);
    }




}