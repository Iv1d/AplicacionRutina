package com.perseverance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.widget.picker.TimePicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class add extends AppCompatActivity implements View.OnClickListener {
    Button btn_fecha, btn_hora;
    EditText edt_fecha, edt_hora;
    private int dia,mes,anio,hora,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btn_fecha=(Button)findViewById(R.id.btn_Fecha);
        btn_hora=(Button)findViewById(R.id.btn_Hora);
        edt_fecha=(EditText) findViewById(R.id.edt_Fecha);
        edt_hora=(EditText) findViewById(R.id.edt_Hora);
        btn_fecha.setOnClickListener(this);
        btn_hora.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn_fecha){
            final Calendar c = Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            anio=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int dayOfMonth, int month, int year) {
                    edt_fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                }
            }
                    ,dia,mes,anio);
            datePickerDialog.show();

        }
        if(v==btn_hora){
            final Calendar c = Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(android.widget.TimePicker timePicker, int hourOfDay, int minute) {
                    edt_hora.setText(hourOfDay+":"+minute);
                }
            }
                    ,hora,minutos,false);
            timePickerDialog.show();

        }

    }


}