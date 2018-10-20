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

    String Res = "";
    String Res2 = "";

    String[] cities = {"A", "KA", "SA", "TA", "NA", "HA","MA","YA","RA","WA","WO"};
    TextView selection;
    String item;
    private int selectedTest;
    RadioGroup radio;
    int ch=0;
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

  public void show(View v)
  {
      selection = (TextView) findViewById(R.id.textView2);
      switch (ch) {

          case  0:
              //selection.setText(OutPutLat());
              selection.setText(Res2);
              ch = 1;
              Log.d("Переключатель", "ch=" + ch);
          break;
          case 1:
              //selection.setText(OutPutRand());
              selection.setText(Res);
              ch = 0;
              Log.d("Переключатель", "ch=" + ch);
          break;
      }
  }

    private void readFile(InputStream fstream,int r) {
        try{
            int a=0,b=0;
            //InputStream fstream = getResources().openRawResource(R.raw.test);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
                if (r == 1) {
                    a++;
                    if (a < 6) {

                            Imput(strLine);
                    }
                }
                if (r == 6) {
                    a++;
                    if (a > 5 && a < 11) {

                            Imput(strLine);

                    }
                }
                if (r == 2) {
                    a++;
                    if (a < 42) {

                        Imput(strLine);

                    }
                }
                if (r == 3) {
                    a++;
                    if (a > 41 && a < 81) {

                        Imput(strLine);

                    }
                }
                b++;
                    if (b > 10&&(r==6||r==1)) {

                            Imput2(strLine);
                    }
                if (b > 82&&(r==2||r==3)) {

                    Imput2(strLine);
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

    public void full_rand(View v)
    {
        Clean();
        int r = 0;
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();
        switch (selectedTest) {
            case R.id.radioButton1: {
                        r = 2;
                        InputStream fstream1 = getResources().openRawResource(R.raw.full);
                        readFile(fstream1, r);
                        break;
            }
            case R.id.radioButton2: {

                    r = 3;
                    InputStream fstream1 = getResources().openRawResource(R.raw.full);
                    readFile(fstream1, r);
                    break;
            }
        }

        selection = (TextView) findViewById(R.id.textView2);
        Rand();
        if (switchState == (true)) {
            //selection.setText(OutPutLat());
            selection.setText(Res2);
            ch=1;
        } else {
            //selection.setText(OutPutRand());
            selection.setText(Res);
            ch=0;
        }
    }

    public void fu(View v) {
        Clean();
        int r = 0;
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();



        switch (selectedTest) {
            case R.id.radioButton1: {
                switch (item) {

                    case "A":
                        r = 1;
                        InputStream fstream1 = getResources().openRawResource(R.raw.a);
                        readFile(fstream1, r);
                        break;
                    case "KA":
                        r = 1;
                        InputStream fstream2 = getResources().openRawResource(R.raw.ka);
                        readFile(fstream2, r);
                        break;

                    case "SA":
                        r = 1;
                        InputStream fstream3 = getResources().openRawResource(R.raw.sa);
                        readFile(fstream3, r);
                        break;
                    case "TA":
                        r = 1;
                        InputStream fstream5 = getResources().openRawResource(R.raw.ta);
                        readFile(fstream5, r);
                        break;
                    case "NA":
                        r = 1;
                        InputStream fstream6 = getResources().openRawResource(R.raw.na);
                        readFile(fstream6, r);
                        break;
                    case "HA":
                        r = 1;
                        InputStream fstream7 = getResources().openRawResource(R.raw.ha);
                        readFile(fstream7, r);
                        break;
                    case "MA":
                        r = 1;
                        InputStream fstream8 = getResources().openRawResource(R.raw.ma);
                        readFile(fstream8, r);
                        break;
                    case "YA":
                        r = 1;
                        InputStream fstream9 = getResources().openRawResource(R.raw.ya);
                        readFile(fstream9, r);
                        break;
                    case "RA":
                        r = 1;
                        InputStream fstream10 = getResources().openRawResource(R.raw.ra);
                        readFile(fstream10, r);
                        break;
                    case "WA":
                        r = 1;
                        InputStream fstream11 = getResources().openRawResource(R.raw.wa);
                        readFile(fstream11, r);
                        break;
                    case "WO":
                        r = 1;
                        InputStream fstream12 = getResources().openRawResource(R.raw.wo);
                        readFile(fstream12, r);
                        break;

                }
                break;
            }
            case R.id.radioButton2: {

                switch (item) {

                    case "A":
                        r = 6;
                        InputStream fstream1 = getResources().openRawResource(R.raw.a);
                        readFile(fstream1, r);
                        break;
                    case "KA":
                        r = 6;
                        InputStream fstream2 = getResources().openRawResource(R.raw.ka);
                        readFile(fstream2, r);
                        break;

                    case "SA":
                        r = 6;
                        InputStream fstream3 = getResources().openRawResource(R.raw.sa);
                        readFile(fstream3, r);
                        break;
                    case "TA":
                        r = 6;
                        InputStream fstream5 = getResources().openRawResource(R.raw.ta);
                        readFile(fstream5, r);
                        break;
                    case "NA":
                        r = 6;
                        InputStream fstream6 = getResources().openRawResource(R.raw.na);
                        readFile(fstream6, r);
                        break;
                    case "HA":
                        r = 6;
                        InputStream fstream7 = getResources().openRawResource(R.raw.ha);
                        readFile(fstream7, r);
                        break;
                    case "MA":
                        r = 6;
                        InputStream fstream8 = getResources().openRawResource(R.raw.ma);
                        readFile(fstream8, r);
                        break;
                    case "YA":
                        r = 6;
                        InputStream fstream9 = getResources().openRawResource(R.raw.ya);
                        readFile(fstream9, r);
                        break;
                    case "RA":
                        r = 6;
                        InputStream fstream10 = getResources().openRawResource(R.raw.ra);
                        readFile(fstream10, r);
                        break;
                    case "WA":
                        r = 6;
                        InputStream fstream11 = getResources().openRawResource(R.raw.wa);
                        readFile(fstream11, r);
                        break;
                    case "WO":
                        r = 6;
                        InputStream fstream12 = getResources().openRawResource(R.raw.wo);
                        readFile(fstream12, r);
                        break;
                }
                break;
            }
        }

        selection = (TextView) findViewById(R.id.textView2);
       Rand();
        if (switchState == (true)) {
            //selection.setText(OutPutLat());
            selection.setText(Res2);
            ch=1;
        } else {
            //selection.setText(OutPutRand());
            selection.setText(Res);
            ch=0;
        }

    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
//    public native String Imput(String a);
//    public native String Imput2(String a);
//    public native String Rand();
//    public native String OutPutLat();
//    public native String Clean();
//    public native String OutPutRand();



    String st = "STOP";
    int a=0,b=0;
    String[] str =new String[200];
    String[] str2 = new String[200];
    int index2=10;


    void Imput(String cstr) {
        if(!cstr.equals(st)) {
            str[b] = cstr;
            b++;
        }
    }

    void Imput2(String cstr) {
        if(!cstr.equals(st))
        {
            str2[a] = cstr;
            a++;
        }
    }

    void Clean() {


        for (int i = 0; i < b; i++) {
            str[i] = "";
            str2[i] = "";
        }
        Res = "";
        b = 0;
        a=0;
    }

    void Rand() {

        int index = (int) ( Math.random() * b+1);
        if(index==index2)
        {
            index = (int) ( Math.random() * b+1);
        }
        index2 =index;
        Res = str[index-1];
        Res2 = str2[index-1];
    }
}
