package com.examen.task.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.examen.task.data.model.Cars
import com.examen.task.databinding.CarLayoutBinding

class CarAdapter(private val cars: MutableList<Cars>): RecyclerView.Adapter<CarAdapter.MyCarViewHolder>() {

    class MyCarViewHolder(private val binding: CarLayoutBinding):RecyclerView.ViewHolder(binding.root){
       fun bind(cars: Cars){
           binding.cartItemId.text = cars.name
           binding.cartItemBrand.text = cars.brand
           binding.cartItemId.text = cars.id.toString()
           binding.cartItemName.text = cars.name
           binding.cartItemPrice.text = cars.price.toString()
           Glide.with(binding.root.context).load(cars.image_url).into(binding.cartItemImage)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCarViewHolder {
        val view = CarLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyCarViewHolder(view)
    }


    override fun getItemCount(): Int {
       return cars.size
    }

    override fun onBindViewHolder(holder: MyCarViewHolder, position: Int) {
        val carItem = cars[position]
        holder.bind(carItem)
        holder.itemView.setOnClickListener {
            cars.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}