package com.icanerdogan.mvvmarchitecture.ui

import androidx.lifecycle.ViewModel
import com.icanerdogan.mvvmarchitecture.data.Book
import com.icanerdogan.mvvmarchitecture.data.BookRepository

class BooksViewModel (private  val bookRepository: BookRepository) : ViewModel() {

    fun getBooks() = bookRepository.getBooks()

    fun addBook(book: Book) = bookRepository.addBook(book)

}