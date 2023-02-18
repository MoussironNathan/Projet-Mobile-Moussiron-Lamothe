package com.example.projetdevmobilemoussironlamothe

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTxt("Rayons")
        showBack()

        val categories = arrayListOf<Categories>()

        val recyclerviewCategorie = findViewById<RecyclerView>(R.id.recyclerviewProduit)
        recyclerviewCategorie.layoutManager = LinearLayoutManager(this)
        val categoriesAdapter = CategoriesAdapter(application, categories)
        recyclerviewCategorie.adapter = categoriesAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestUrl = "https://www.ugarit.online/epsi/categories.json"
        val request =
            Request.Builder().url(mRequestUrl).cacheControl(CacheControl.FORCE_NETWORK).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if (data != null) {
                    val jsCategories = JSONObject(data)
                    val jsArrayCategorie = jsCategories.getJSONArray("items")

                    for (i in 0 until jsArrayCategorie.length()) {
                        val jsCategorie = jsArrayCategorie.getJSONObject(i)
                        val categorie = Categories(
                            jsCategorie.optString("category_id", "Not found"),
                            jsCategorie.optString("title", "Not found"),
                            jsCategorie.optString("products_url", "Not found")
                        )
                        categories.add(categorie)
                    }
                    runOnUiThread(Runnable {
                        categoriesAdapter.notifyDataSetChanged()
                    })

                    Log.e("WS", data)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

        })
    }
}