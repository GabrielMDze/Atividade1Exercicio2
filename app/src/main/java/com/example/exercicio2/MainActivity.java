package com.example.exercicio2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private EditText editDado;
    private TextView textLados, textResultado;
    private SeekBar seekLados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDado=findViewById(R.id.editDado);
        seekLados=findViewById(R.id.seekLados);
        textLados=findViewById(R.id.textLado);
        textResultado=findViewById(R.id.textResultado);

        seekLados.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int faces, boolean b) {
                textLados.setText(String.valueOf(faces));
                play();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        editDado.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                play();
            }
            @Override
            public void afterTextChanged(Editable editable) {
                play();
            }
        });

    }

    public void play(){
        Random r = new Random();
        int sum=0;
        if(editDado.getText().toString().isEmpty()||textLados.getText().toString().isEmpty()){
            textResultado.setText("Informe os valores");
        }else{
            int qtd = Integer.parseInt(editDado.getText().toString());
            int DFaces=Integer.parseInt(textLados.getText().toString());

            for(int i=0;i<qtd;i++){
                int value = r.nextInt(DFaces)+1;
                sum=sum+value;
            }
            String result="Soma dos resultados: "+sum;
            textResultado.setText(result);
        }

    }
}
