package com.example.listapplication.ui.main.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listapplication.R
import com.example.listapplication.data.text.model.TextsModel

class TextAdapter : RecyclerView.Adapter<TextViewHolder>() {

    var textsModel: TextsModel? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view: TextView =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder, parent, false) as TextView
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        textsModel?.let { holder.bind(it.texts[position]) }
    }

    override fun getItemCount(): Int {
        return textsModel?.texts?.size ?: 0
    }
}