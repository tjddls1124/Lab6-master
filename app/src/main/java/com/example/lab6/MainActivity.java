package com.example.lab6;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.attr.isDefault;

public class MainActivity extends AppCompatActivity {
    static int count=0;

    ListView listView;
    ArrayList<Matzip> matzip_list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ArrayList<String> matzip_list_name = new ArrayList<>();
    int REQUEST_MSG_CODE = 1;
    int REQUEST_MSG_CODE2= 2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListView();

    }

    public void onClick(View v){
        Intent intent = new Intent(this, Main2Activity.class);
         Matzip matzip = new Matzip("","",0,"","","","","");

        intent.putExtra("msg_matzip",matzip);

        startActivityForResult(intent,REQUEST_MSG_CODE);
    }
    public void setListView(){
       final Intent intent = new Intent(this, Main3Activity.class);

        listView = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,matzip_list_name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                intent.putExtra("msg_matzip_data",matzip_list.get(position));
                startActivityForResult(intent,REQUEST_MSG_CODE2);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                ListView listView = (ListView) parent;
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("삭제확인");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setMessage("등록된 맛집정보를 삭제하시겠습니까?");
                dlg.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        matzip_list_name.remove(position);
                        matzip_list.remove(position);
                        adapter.notifyDataSetChanged();
                        count--;
                    }
                });
                dlg.setPositiveButton("취소", null);
                dlg.show();
                return true;
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_MSG_CODE)
        {
            if(resultCode == RESULT_OK){
                Matzip m;
                m = data.getParcelableExtra("remakemsg");
                String name = m.name;
                tv = (TextView)findViewById(R.id.tv);
                matzip_list_name.add(count,name);
                int size = matzip_list_name.size();

                tv.setText("맛집 리스트(" +size+"개)");
                matzip_list.add(count,m);
                count++;

                adapter.notifyDataSetChanged();
            }

        }
    }
}
