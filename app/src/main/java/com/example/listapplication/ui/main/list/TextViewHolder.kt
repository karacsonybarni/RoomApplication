package com.example.listapplication.ui.main.list

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listapplication.data.text.model.TextModel

class TextViewHolder(private val textView: TextView) : RecyclerView.ViewHolder(textView) {

    fun bind(textModel: TextModel) {
        textView.text = textModel.text
    }
}