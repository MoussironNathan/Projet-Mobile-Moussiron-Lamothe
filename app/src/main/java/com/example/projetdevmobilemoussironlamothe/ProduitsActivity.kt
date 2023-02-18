package com.example.projetdevmobilemoussironlamothe

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProduitsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits)

        setHeaderTxt(intent.extras!!.getString("title", ""))
        showBack()

        val produits = arrayListOf<Produits>()

        val recyclerviewProduit = findViewById<RecyclerView>(R.id.recyclerviewProduit)
        recyclerviewProduit.layoutManager = LinearLayoutManager(this)
        val produitsAdapter = ProduitsAdapter(application, produits)
        recyclerviewProduit.adapter = produitsAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestUrl = intent.extras!!.getString("product_url", "")
        val request =
            Request.Builder().url(mRequestUrl).cacheControl(CacheControl.FORCE_NETWORK).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if (data != null) {
                    val jsProduits = JSONObject(data)
                    val jsArrayProduit = jsProduits.getJSONArray("items")

                    for (i in 0 until jsArrayProduit.length()) {
                        val jsProduit = jsArrayProduit.getJSONObject(i)
                        val produit = Produits(
                            jsProduit.optString("name", "Not found"),
                            jsProduit.optString("description", "Not found"),
                            jsProduit.optString("picture_url", "Not found")
                        )
                        produits.add(produit)
                    }
                    runOnUiThread(Runnable {
                        produitsAdapter.notifyDataSetChanged()
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