package com.example.tugas_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugas_api.databinding.ItemContainerPahlawanBinding
import com.example.tugas_api.model.Data
import com.example.tugas_api.model.Hero


class HeroAdapter(private val listHero: List<Data>) :
    RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>() {
    inner class ItemHeroViewHolder(private val binding: ItemContainerPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemImage: ImageView = itemView.findViewById(R.id.imageHero)
        fun bind(data: Data) {
            with(binding) {
                txtHeroName.text = data.title
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemHeroViewHolder {
        val binding =
            ItemContainerPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHeroViewHolder(binding)
    }
    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
        Glide.with(holder.itemView.context)
            .load(listHero[position].image)
            .centerCrop()
            .into(holder.itemImage)
    }
}

//class HeroAdapter(var results: ArrayList<Hero>, val listener: OnAdapterListener) :
//    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
//        LayoutInflater.from( parent.context ).inflate( R.layout.item_container_pahlawan,
//            parent, false)
//    )
//
//    override fun getItemCount() = results.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val result = results[position]
//        holder.view. = result.data[position].title
//        Glide.with(holder.view)
//            .load(result.image)
//            .placeholder(R.drawable.img_placeholder)
//            .error(R.drawable.img_placeholder)
//            .centerCrop()
//            .into(holder.view.imageView)
//        holder.view.setOnClickListener { listener.onClick( result ) }
//    }
//
//    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)
//
//    fun setData(data: List<Hero>){
//        this.results.clear()
//        this.results.addAll(data)
//        notifyDataSetChanged()
//    }
//
//    interface OnAdapterListener {
//        fun onClick(result: Hero)
//    }
//}