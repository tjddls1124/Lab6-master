package com.example.lab6;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    EditText editText_name,editText_tel,editText_menu1,editText_menu2,editText_menu3,editText_homepage;
    RadioButton radioButton1,radioButton2,radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
//        count = intent.getIntExtra("msg_matzip_number",0);
    }
    public void onClick(View v) {

        editText_homepage= (EditText)findViewById(R.id.etaddr);
        editText_name= (EditText)findViewById(R.id.etname);
        editText_tel= (EditText)findViewById(R.id.ettel);
        editText_menu1= (EditText)findViewById(R.id.etmenu1);
        editText_menu2= (EditText)findViewById(R.id.etmenu2);
        editText_menu3= (EditText)findViewById(R.id.etmenu3);
        radioButton1 = (RadioButton)findViewById(R.id.radio1);
        radioButton2 = (RadioButton)findViewById(R.id.radio2);
        radioButton3 = (RadioButton)findViewById(R.id.radio3);



        if(v.getId()== R.id.btnAdd){
            Intent intent = new Intent();
            int menu_kind=0 ;
                String name = editText_name.getText().toString();
                String tel = editText_tel.getText().toString();
            String m1 = new String();
            m1 = editText_menu1.getText().toString();
            String m2 = new String();
            m2 = editText_menu2.getText().toString();
            String m3 = new String();
            m3 = editText_menu3.getText().toString();


               if (radioButton1.isChecked() == true) menu_kind = 1;
            else if (radioButton2.isChecked()==true) menu_kind = 2;
            else if (radioButton3.isChecked() == true) menu_kind=3;
                String hp = editText_homepage.getText().toString();
            long time = System.currentTimeMillis();

            SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

            String enroll_time = dayTime.format(new Date(time));

            Matzip new_matzip =  new Matzip(name,tel,menu_kind,m1,m2,m3,hp,enroll_time);


            intent.putExtra("remakemsg",new_matzip);
            setResult(RESULT_OK,intent);
            finish();

        }
        else if (v.getId() == R.id.btnCancel)
            finish();
        }
    }

