package com.example.simorientclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {


    private var mSensorManager : SensorManager ?= null
    private var mAccelerometer : Sensor ?= null

    val text_x = findViewById(R.id.text_x) as TextView
    val text_y = findViewById(R.id.text_y) as TextView
    val text_z = findViewById(R.id.text_z) as TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        // focus in accelerometer
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            text_x.text = event.values[0].toString();
            text_y.text = event.values[1].toString();
            text_z.text = event.values[2].toString();

        }
    }

}
