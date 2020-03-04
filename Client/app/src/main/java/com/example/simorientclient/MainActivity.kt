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
    private var mSensor : Sensor ?= null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        // focus in accelerometer
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mSensor = mSensorManager!!.getDefaultSensor(Sensor.TYPE_GYROSCOPE)


    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(this,mAccelerometer, SensorManager.SENSOR_DELAY_GAME)
        mSensorManager!!.registerListener(this,mSensor, SensorManager.SENSOR_DELAY_GAME)

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {

                val accel_x = findViewById(R.id.accel_x) as TextView
                val accel_y = findViewById(R.id.accel_y) as TextView
                val accel_z = findViewById(R.id.accel_z) as TextView


                accel_x.text = String.format("%.1f", event.values[0])
                accel_y.text = String.format("%.1f", event.values[1])
                accel_z.text = String.format("%.1f", event.values[2])

            }
            if (event.sensor.type == Sensor.TYPE_GYROSCOPE) {
                val gyro_x = findViewById(R.id.gyro_x) as TextView
                val gyro_y = findViewById(R.id.gyro_y) as TextView
                val gyro_z = findViewById(R.id.gyro_z) as TextView


                gyro_x.text = String.format("%.1f", event.values[0])
                gyro_y.text = String.format("%.1f", event.values[1])
                gyro_z.text = String.format("%.1f", event.values[2])


            }
        }
    }

}
