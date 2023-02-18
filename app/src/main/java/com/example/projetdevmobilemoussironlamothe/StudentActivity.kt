package com.example.projetdevmobilemoussironlamothe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class StudentActivity : BaseActivity() {
    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val nom = intent.extras!!.getString("nom", "")
        setHeaderTxt(nom)
        showBack()

        val name = findViewById<TextView>(R.id.nameStudent1)
        val mail = findViewById<TextView>(R.id.MailStudent1)
        val avatar = findViewById<ImageView>(R.id.imageView2)

        if (nom == "Lamothe"){
            name.text = "Lamothe Hugo"
            mail.text = "hugo.lamothe@epsi.fr"
            avatar.setImageDrawable(getResources().getDrawable(R.drawable.lamothe))

        }

        val lien = findViewById<TextView>(R.id.lien)
        lien.setOnClickListener(View.OnClickListener {
            val url = "https://www.epsi.fr/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })

    }
}