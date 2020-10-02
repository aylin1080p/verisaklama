package com.aylingunes.verisaklama;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // ilk açıldığında
        //oncreate çalıştığına gör burada olsun tanımlamalar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tanımlamalar dışardn çağırmalar için
    editText = findViewById(R.id.editText2);
    textView = findViewById(R.id.textView);

        // bu objeyle küçük bi saklama alanı aldık app silinmedi sürece
        sharedPreferences = this.getSharedPreferences("com.aylingunes.verisaklama", Context.MODE_PRIVATE);
int storedAge= sharedPreferences.getInt("storedAge",0); // kayıtllı değer yoksa 0 ver
textView.setText("your age : " +storedAge);



    }

public void save(View view){ // buton idsi save. buna basılınca ne olcak onu belirliyor
if (!editText.getText().toString().matches("")){
    // if içi ünlem aslında else
    int userage = Integer.parseInt(editText.getText().toString());
    textView.setText("youre age " + userage);

    sharedPreferences.edit().putInt("storedAge",userage).apply(); //apply saklama için

}

}

public void delete(View view){
        int storedData = sharedPreferences.getInt("storedAge",0);
        if (  storedData != 0) {
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("youre age : ");
        }


}


}
