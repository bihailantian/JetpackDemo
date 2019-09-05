package com.xxm.jetpackdemo.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xxm.jetpackdemo.common.BaseConstant
import com.xxm.jetpackdemo.databinding.RecyclerItemFavouriteBinding
import com.xxm.jetpackdemo.db.data.Shoe
import com.xxm.jetpackdemo.ui.activity.DetailActivity

class FavouriteAdapter constructor(val context: Context) :
    ListAdapter<Shoe, FavouriteAdapter.FavouriteViewHolder>(ShoeDiffCallback()) {


    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.apply {
            bind(onCreateListener(shoe.id), shoe)
            itemView.tag = shoe
        }
    }

    /**
     * Holder的点击事件
     */
    private fun onCreateListener(id: Long): View.OnClickListener {
        return View.OnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(BaseConstant.DETAIL_SHOE_ID, id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        return FavouriteViewHolder(
            RecyclerItemFavouriteBinding.inflate(
                LayoutInflater.from(parent.context)
                , parent
                , false
            )
        )
    }

    class FavouriteViewHolder(private val binding: RecyclerItemFavouriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Shoe) {
            binding.apply {
                this.listener = listener
                this.shoe = item
                this.price = item.price.toString()
                executePendingBindings()
            }
        }
    }
}