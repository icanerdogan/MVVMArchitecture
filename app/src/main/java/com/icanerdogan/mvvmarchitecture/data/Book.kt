package com.icanerdogan.mvvmarchitecture.data

data class Book(
    val bookName: String,
    val author: String
) {

    override fun toString(): String {
        return "$bookName - $author"
    }

}