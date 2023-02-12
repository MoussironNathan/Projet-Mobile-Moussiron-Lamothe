package com.example.projetdevmobilemoussironlamothe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonInfo = findViewById<Button>(R.id.buttonInfo)

        setHeaderTxt("Epsi")

        buttonInfo.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, InfoActivity::class.java)
            startActivity(intent)
        })

    }

}