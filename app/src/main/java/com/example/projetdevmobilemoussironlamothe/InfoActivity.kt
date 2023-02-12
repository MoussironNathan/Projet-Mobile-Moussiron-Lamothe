package com.example.projetdevmobilemoussironlamothe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class InfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val buttonStudent1 = findViewById<Button>(R.id.button_student1)
        val buttonStudent2 = findViewById<Button>(R.id.button_student2)

        setHeaderTxt("Info")
        showBack()

        buttonStudent1.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, StudentActivity::class.java)
            startActivity(intent)
        })
        buttonStudent2.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, StudentActivity::class.java)
            startActivity(intent)
        })
    }
}