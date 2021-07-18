package org.rakulee.retrofitexample

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.rakulee.retrofitexample.databinding.ItemExchangeListBinding

class RvExchangeAdapter : RecyclerView.Adapter<RvExchangeAdapter.ViewHolder>() {
    lateinit var lists : ArrayList<ExchangeResult.ExchangeItem>

    fun update(lists : ArrayList<ExchangeResult.ExchangeItem>) {
        this.lists = lists
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exchange_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lists[position])
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemExchangeListBinding.bind(itemView)
        fun bind(item : ExchangeResult.ExchangeItem){
            binding.item = item
            Glide.with(itemView.context).asBitmap().load(item.image).into(binding.ivExchangeLogo)
        }
    }
}