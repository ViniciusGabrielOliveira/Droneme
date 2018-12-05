package com.example.store.store;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ModeloAndroid modeloAndroid = new ModeloAndroid();
    private RecyclerView recyclerViewDrone;
    private ReciclerViewAdaptador adaptadorDrone;
    private Conexao con = new Conexao();
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Items List");


        recyclerViewDrone = findViewById(R.id.recyclerDrone);
        recyclerViewDrone.setLayoutManager(new LinearLayoutManager(this));

        try {
            Toast.makeText(getApplicationContext(), con.sendResponse().toString(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {

            adaptadorDrone = new ReciclerViewAdaptador(this, con.sendGet());
        } catch (Exception e) {
            e.printStackTrace();
        }

        recyclerViewDrone.setAdapter(adaptadorDrone);
    }



        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);

            MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
            SearchView searchView = (SearchView)myActionMenuItem.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    if (TextUtils.isEmpty(s)){
                        adaptadorDrone.filter("");
                    }
                    else {
                        adaptadorDrone.filter(s);
                    }
                    return true;
                }
            });
            return true;
        }

//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            int id = item.getItemId();
//
//            if (id==R.id.action_settings){
//                //do your functionality here
//                return true;
//            }
//            return super.onOptionsItemSelected(item);
//        }
//    }




}
