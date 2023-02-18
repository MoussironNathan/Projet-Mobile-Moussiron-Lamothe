package com.example.projetdevmobilemoussironlamothe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTxt("EPSI")

        val infoButton = findViewById<Button>(R.id.buttonInfo)
        val produitButton = findViewById<Button>(R.id.buttonProduits)

        infoButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, InfoActivity::class.java)
            startActivity(intent)
        })

        produitButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, CategoriesActivity::class.java)
            startActivity(intent)
        })
    }

}