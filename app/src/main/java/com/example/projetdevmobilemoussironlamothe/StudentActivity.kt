package com.example.projetdevmobilemoussironlamothe

import android.os.Bundle

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        setHeaderTxt("Moussiron")
        showBack()
    }
}