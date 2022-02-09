package com.icanerdogan.mvvmarchitecture.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.icanerdogan.mvvmarchitecture.data.BookRepository

class BooksViewModelFactory(private val bookRepository: BookRepository) :
    ViewModelProvider.NewInstanceFactory()
{
    @SuppressWarnings("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BooksViewModel(bookRepository) as T
    }
}