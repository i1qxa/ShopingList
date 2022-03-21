package com.example.shopinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shopinglist.R
import com.example.shopinglist.domain.ShopItem

class ShopListAdapter :
    androidx.recyclerview.widget.ListAdapter<ShopItem, ShopItemViewHolder>(
        ShopItemDiffCallback()) {
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown View Type $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {

        val shopItem = getItem(position)

        viewHolder.view.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        viewHolder.view.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)

        }

        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enable) VIEW_TYPE_ENABLED else VIEW_TYPE_DISABLED

    }

    companion object {
        const val VIEW_TYPE_ENABLED = 0
        const val VIEW_TYPE_DISABLED = 1
        const val MAX_POOL_SIZE = 10
    }


}