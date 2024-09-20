package com.tollcafe.mixedtyperecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.tollcafe.mixedtyperecyclerview.R

// 定义列表项的类型
enum class ItemType {
    TEXT, IMAGE, TEXT_IMAGE
}

// 数据类表示每个列表项的数据
data class ListItem(val type: ItemType, val text: String? = null, val imageResId: Int? = null)

class MultiTypeAdapter(private val itemList: List<ListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 定义不同的 ViewHolder

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
    }

    class TextImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }

    // 根据项类型创建 ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemType.TEXT.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
                TextViewHolder(view)
            }
            ItemType.IMAGE.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
                ImageViewHolder(view)
            }
            ItemType.TEXT_IMAGE.ordinal -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_text_image, parent, false)
                TextImageViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    // 绑定数据到 ViewHolder
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]

        when (holder) {
            is TextViewHolder -> {
                holder.textView.text = item.text
                holder.itemView.setOnClickListener {
                    Toast.makeText(it.context, "Clicked: ${item.text}", Toast.LENGTH_SHORT).show()
                }
            }
            is ImageViewHolder -> {
                item.imageResId?.let { holder.imageView.setImageResource(it) }
                holder.itemView.setOnClickListener {
                    Toast.makeText(it.context, "Clicked Image", Toast.LENGTH_SHORT).show()
                }
            }
            is TextImageViewHolder -> {
                holder.textView.text = item.text
                item.imageResId?.let { holder.imageView.setImageResource(it) }
                holder.itemView.setOnClickListener {
                    Toast.makeText(it.context, "Clicked: ${item.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // 返回项的类型
    override fun getItemViewType(position: Int): Int {
        return itemList[position].type.ordinal
    }

    override fun getItemCount(): Int = itemList.size
}
