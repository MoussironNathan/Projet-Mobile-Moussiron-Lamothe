package com.example.projetdevmobilemoussironlamothe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailProduitActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produit)

        setHeaderTxt(intent.extras!!.getString("nom", ""))
        showBack()

        val imageProduit = findViewById<ImageView>(R.id.imageProduit)
        val descProduit = findViewById<TextView>(R.id.descriptionProduit)

        Picasso.get().load(intent.extras!!.getString("picture_url", "")).into(imageProduit)
        descProduit.text = intent.extras!!.getString("description", "")
    }
}