package com.example.lab6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.lab6.R.drawable.piz;

public class Main3Activity extends AppCompatActivity {
    TextView tv_menu1,tv_menu2,tv_menu3,tv_name,tel,hp,regDate;
    Button button;
    ImageView iv,phonecall,homepagecall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = (Button)findViewById(R.id.btnback);
        tv_menu1 = (TextView)findViewById(R.id.etmenu1);
        tv_menu2 = (TextView)findViewById(R.id.etmenu2);
        tv_menu3 = (TextView)findViewById(R.id.etmenu3);
        tv_name = (TextView)findViewById(R.id.txtname);
        tel = (TextView)findViewById(R.id.tvTel);
        hp = (TextView)findViewById(R.id.tvURL);
        regDate =(TextView)findViewById(R.id.tvRegdate);
        iv = (ImageView)findViewById(R.id.imgno);
       final Intent intent = getIntent();
        Matzip matzip = intent.getParcelableExtra("msg_matzip_data");

        tv_name.setText(matzip.name);
        tv_menu1.setText(matzip.menu1);
        tv_menu2.setText(matzip.menu2);
        tv_menu3.setText(matzip.menu3);
        tel.setText(matzip.call_num);
        hp.setText(matzip.homepage);
        regDate.setText(matzip.enroll_date);
        if(matzip.menu_kind == 1 ) iv.setImageResource(R.drawable.chicken);
        else if(matzip.menu_kind==2) iv.setImageResource(R.drawable.piz);
        else if (matzip.menu_kind==3) iv.setImageResource(R.drawable.ham);

    }

    public void onClick(View v) {
        if( v.getId() == R.id.btnback) {
            setResult(RESULT_OK);
            finish();
        }
        if(v.getId() == R.id.imageView2) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+tel.getText().toString()));
            startActivity(intent);
        }
        if(v.getId() == R.id.imageView3) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+hp.getText().toString()));
            startActivity(intent);
        }

    }
}
