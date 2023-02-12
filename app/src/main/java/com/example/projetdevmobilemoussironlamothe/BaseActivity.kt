package com.example.projetdevmobilemoussironlamothe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

open class BaseActivity : AppCompatActivity() {

    fun setHeaderTxt(title: String) {
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.setText(title)
    }

    fun showBack(){
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility = View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}