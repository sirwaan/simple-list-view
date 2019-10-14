package com.sirwansoft.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText edittext;
Button btn_add_item,btn_remove_last_item;
ListView listView;
ArrayList<String> namesArray;
ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesArray = new ArrayList<>();
        edittext=findViewById(R.id.edittext);
        btn_add_item =findViewById(R.id.btn_add);
        listView=findViewById(R.id.listview);
        btn_remove_last_item=findViewById(R.id.button_remove_last);


        //fits index item of list
        namesArray.add("soran");
        namesArray.add("sirwan");
        namesArray.add("azad");

        btn_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_name =edittext.getText().toString().trim();
                //if editText is empty don't allow to add empty list
                if (string_name.isEmpty()){Toast.makeText(MainActivity.this,"No text interd",Toast.LENGTH_LONG).show();}else {
                    namesArray.add(string_name);
                    adapter.notifyDataSetChanged();
                }
            }

        });
        btn_remove_last_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (namesArray.isEmpty()){
                    Toast.makeText(MainActivity.this, "No item found", Toast.LENGTH_SHORT).show();

                }else {namesArray.remove(namesArray.size()-1);}
                adapter.notifyDataSetChanged();
            }
        });
        adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,namesArray);
        listView.setAdapter(adapter);



        //delete the position item that is selected
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (namesArray.isEmpty()){
                    Toast.makeText(MainActivity.this, "No item found", Toast.LENGTH_SHORT).show();

                }else {namesArray.remove(position);}
                adapter.notifyDataSetChanged();
            }
        });



    }
}
