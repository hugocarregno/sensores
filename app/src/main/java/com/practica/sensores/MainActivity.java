package com.practica.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usarSensores();
    }
    public void usarSensores(){
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
        if(sensors.size() > 0){
            sensorManager.registerListener(this, sensors.get(0), SensorManager.SENSOR_DELAY_GAME);
        }
        //for (Sensor it:listaSensores){


          //  Log.d("Nombre: ", it.getName());
        //}
//listaSensores.get(0)
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Toast.makeText(this, sensorEvent.values[0]+" ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
