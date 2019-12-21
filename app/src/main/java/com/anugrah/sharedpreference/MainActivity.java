package com.anugrah.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    String a,b;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
        String value=preferences.getString("usname",null);
        if(value!=null)
        {
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);

        }
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.btn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a=e1.getText().toString();
                b=e2.getText().toString();

                if(a.equals("mgcollege") && b.equals("1234")) {

                    SharedPreferences.Editor edit = getSharedPreferences("login",MODE_PRIVATE).edit();
                    edit.putString("usname",a);
                    edit.commit();

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"login failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
