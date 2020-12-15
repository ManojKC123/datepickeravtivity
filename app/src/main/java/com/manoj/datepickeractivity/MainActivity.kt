package com.manoj.datepickeractivity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnJoinDate: Button
    private lateinit var btnBirthDate: Button
    private lateinit var tvJoinDate: TextView
    private lateinit var tvBirthDate: TextView
    private lateinit var tvWorkYear : TextView
    private lateinit var tvAge : TextView
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJoinDate= findViewById(R.id.btnjoindate)
        btnBirthDate = findViewById(R.id.btnbirthdate)
        tvJoinDate = findViewById(R.id.tvjoindate)
        tvBirthDate = findViewById(R.id.tvbirthdate)
        tvWorkYear = findViewById(R.id.tvWorkYear)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate= findViewById(R.id.btncalculate)


        btnJoinDate.setOnClickListener{
            loadCalender1()
        }

        btnBirthDate.setOnClickListener{
            loadCalender2()
        }
        btnCalculate.setOnClickListener{
            calworkyear()
        }



    }

    private fun calworkyear(){
        var calendar = Calendar.getInstance()
        var currentYr:Int = calendar.get(Calendar.YEAR)
        var selectyear = tvJoinDate.text.toString()
        var a = Integer.parseInt(selectyear)
        var age:Int = currentYr - a
        tvWorkYear.text="Your Working Year: $age "
    }

    private fun loadCalender1(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            {view, year, month, dayOfMonth ->
                tvJoinDate.text="Join Date: $dayOfMonth/$month/$year"},
            year,
            month,
            day
            )
            datePickerDialog.show()

    }
    private fun loadCalender2(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            {view, year, month, dayOfMonth ->
                tvBirthDate.text="Birth Date: $dayOfMonth/$month/$year"},
            year,
            month,
            day
            )
            datePickerDialog.show()

    }
}