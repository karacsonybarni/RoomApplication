package com.example.listapplication.data.text.model

data class TextsModel(val texts: Array<TextModel>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TextsModel

        if (!texts.contentEquals(other.texts)) return false

        return true
    }

    override fun hashCode(): Int {
        return texts.contentHashCode()
    }
}