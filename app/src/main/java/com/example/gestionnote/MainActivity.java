package com.example.gestionnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText note,resultat;
    TextView moyenne;
    Button saisir;
    ListView ls;
    Spinner sp;
    ArrayList<String> arraylist;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note = (EditText) findViewById(R.id.editText1);
        resultat = (EditText) findViewById(R.id.editText2);
        moyenne=(TextView) findViewById(R.id.textView5_mo);
        saisir = (Button) findViewById(R.id.button_s);
        ls = (ListView) findViewById(R.id.list);
        sp = (Spinner) findViewById(R.id.spinner1);
        double moy=0,somme=0;

        arraylist = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, arraylist);
        ls.setAdapter(adapter);

        saisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spinner = sp.getSelectedItem().toString() ;
                String no = note.getText().toString();
                arraylist.add(spinner+" : "+no);

                ls.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                //Somme();
                Calculmoyenne();


            }
        });



        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.modules, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

/**
    public double Somme(){

        double moy,no,tot=0;

        for (int i=0;i< arraylist.size();i++) {
            no = Integer.parseInt(note.getText().toString());
            tot=no+tot;

        }

        return tot;

    }

    public void Calculmoyenne(){

        double avg;
        avg=Somme()/ arraylist.size();
        moyenne.setText(String.valueOf(avg));


    }**/
public void Calculmoyenne() {
    int m1,tot =0;
    double avg, moy;

    for(int i=0;i<arraylist.size();i++ ){
        m1 = Integer.parseInt(note.getText().toString());
        tot = tot + m1 ;

    }
    avg = tot;
    moy = avg/4;
    moyenne.setText(String.valueOf("    "+moy));
}
}