package com.ulyssevaldenaire.todotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Paramètres

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView list_items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_items = (ListView) (findViewById(R.id.list_items));
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        list_items.setAdapter(itemsAdapter);
        items.add("bonjour !");

        setupListViewListener();
    }


    /**
     *  Méthode qui ajoute un nouvel item
     * @param v
     */
    public void AddItem(View v) {
        EditText edit_items = (EditText) findViewById(R.id.edit_items);
        String itemText = edit_items.getText().toString();
        itemsAdapter.add(itemText);
        edit_items.setText("");
    }


    /**
     * Méthode qui met à jour la liste d'items
     */
    private void setupListViewListener() {
        list_items.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });}}
