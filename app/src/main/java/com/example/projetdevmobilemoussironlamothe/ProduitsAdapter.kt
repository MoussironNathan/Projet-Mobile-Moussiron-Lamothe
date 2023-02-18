package com.example.projetdevmobilemoussironlamothe

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProduitsAdapter(val context: Context, val produits: ArrayList<Produits>) :
    RecyclerView.Adapter<ProduitsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val infoProduitsContainer = view.findViewById<LinearLayout>(R.id.infoProduitContainer)
        val imageViewProduit = view.findViewById<ImageView>(R.id.imageProduit)
        val textViewProduitName = view.findViewById<TextView>(R.id.produitName)
        val textViewProduitDesc = view.findViewById<TextView>(R.id.produitDesc)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_produits, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produit = produits.get(position)
        holder.textViewProduitName.text = produit.name
        Picasso.get().load(produit.picture_url).into(holder.imageViewProduit)
        holder.textViewProduitDesc.text = produit.description
        holder.infoProduitsContainer.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, DetailProduitActivity::class.java)
            intent.putExtra("name", produit.name)
            intent.putExtra("description", produit.description)
            intent.putExtra("picture_url", produit.picture_url)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return produits.size
    }
}