package com.example.layoutpractice

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_03.*
import render.animations.Attention
import render.animations.Render
import kotlin.math.sqrt

class Main03 : AppCompatActivity(), SensorEventListener {

    val TAG: String = "로그"

    // 센서매니저 나중에 값 설정할 것임
    private lateinit var sensorManager: SensorManager

    private var accel: Float = 0.0f
    private var accelCurrent: Float = 0.0f
    private var accelLast: Float = 0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_03)

        Log.d(TAG, "AndroidSensor - onCreate() called")

        this.sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accel = 10f
        accelCurrent = SensorManager.GRAVITY_EARTH
        accelLast = SensorManager.GRAVITY_EARTH

        next_recycle_view_btn.setOnClickListener {
            onNextRecyclerViewButtonClicked()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        Log.d(TAG, "AndroidSensor - onAccuracyChanged() called")
    }

    override fun onSensorChanged(event: SensorEvent?) {
//        Log.d(TAG, "AndroidSensor - onSensorChanged() called")
        val x: Float = event?.values?.get(0) as Float
        val y: Float = event?.values?.get(1) as Float
        val z: Float = event?.values?.get(2) as Float

        x_text.text = "X : " + x.toInt().toString()
        y_text.text = "Y : " + y.toInt().toString()
        z_text.text = "Z : " + z.toInt().toString()

        // 엑셀값 계산산
        accelLast = accelCurrent
        accelCurrent = sqrt((x*x + y*y + z*z).toDouble()).toFloat()
        val delta: Float = accelCurrent - accelLast
        accel = accel * 0.9f + delta

        if(accel > 30){
            Log.d(TAG, "AndroidSensor - accel : ${accel}")
            Log.d(TAG, "AndroidSensor - 흔들었음")

            footprint_img.setImageResource(R.drawable.footprint_active)

            // Create Render Class
            val render = Render(this)
            // Set Animation
            render.setAnimation(Attention().Ruberband(footprint_img))
            render.start()

            Handler().postDelayed({
                footprint_img.setImageResource(R.drawable.footprint)
            }, 1000L)
//            흔들어지면 이미지 움직이면서 변경
        }
    }

    override fun onResume() {
        Log.d(TAG, "AndroidSensor - onResume() called")
        // 레지스터를 등록해줘야 인식함
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)

        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "AndroidSensor - onPause() called")
        sensorManager.unregisterListener(this)

        super.onPause()
    }
    fun onNextRecyclerViewButtonClicked() {
        Log.d(TAG, "Main03 - onNextRecyclerViewButtonClicked() called")

        val intent = Intent(this, Main04::class.java)

        startActivity(intent)
    }
}