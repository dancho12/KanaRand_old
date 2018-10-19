package com.example.danch.kanarand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    String[] cities = {"A", "KA", "SA", "TA", "NA", "HA","MA","YA","RA","WA","11"};
    TextView selection;
    String item;
    private int selectedTest;
    RadioGroup radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());


        RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroup);
        selectedTest = radio.getCheckedRadioButtonId();

        Spinner spinner = (Spinner) findViewById(R.id.kana_select);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                item = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


    }

    private void readFile2(InputStream fstream) {
        try{
            //InputStream fstream = getResources().openRawResource(R.raw.test);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);

                Imput(strLine);

            }
            fstream.close();
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }

    private void readFile(InputStream fstream,int r) {
        try{
            int a=0,b=0;
            //InputStream fstream = getResources().openRawResource(R.raw.test);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                System.out.println(strLine);
                if(r==1) {
                    a++;
                    if(a<6) {
                        Imput(strLine);
                    }
                    if(a>6){
                        r=11;
                    }
                }
                if(r==6) {
                    a++;
                    if(a>5&&a<11) {
                        Imput(strLine);
                    }
                }
                if(r==11) {
                    a++;
                    if (a > 10) {
                        Imput(strLine);
                    }
                }
            }
            fstream.close();
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }

    public void onClickRadioSelectTest (View v)
    {
        selectedTest = v.getId();
        Log.d("onClickRadioGroupSelectTest", "selectedTest="+selectedTest);
    }

    public void fu(View v){
        int r=0;
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();


        switch(selectedTest) {
            case R.id.radioButton1: {
                switch (item) {

                    case "A":
                        r=1;
                        InputStream fstream3 = getResources().openRawResource(R.raw.a);
                        readFile(fstream3,r);
                        break;
                    case "KA":
                        r=1;
                        InputStream fstream6 = getResources().openRawResource(R.raw.ka);
                        readFile(fstream6,r);
                        break;


                }
                break;
            }
            case R.id.radioButton2: {

                    switch (item) {

                        case "A":
                            r=6;
                            InputStream fstream3 = getResources().openRawResource(R.raw.a);
                            readFile(fstream3,r);
                            break;
                        case "KA":
                            r=6;
                            InputStream fstream4 = getResources().openRawResource(R.raw.ka);
                            readFile(fstream4,r);
                            break;
                    }
                break;
            }
        }
        selection = (TextView) findViewById(R.id.textView2);
        if (switchState == (true)){
            selection.setText(OutPutLat());
        }
        else {
            selection.setText(OutPutRand());
        }
        Clean();
    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String Imput(String a);
    public native String Imput2(String a);
    public native String OutPutLat();
    public native String Clean();
    public native String OutPutRand();
}
