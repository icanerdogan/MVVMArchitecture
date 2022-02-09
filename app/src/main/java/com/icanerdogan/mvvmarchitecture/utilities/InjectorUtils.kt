package com.icanerdogan.mvvmarchitecture.utilities

import com.icanerdogan.mvvmarchitecture.data.BookRepository
import com.icanerdogan.mvvmarchitecture.data.FakeDatabase
import com.icanerdogan.mvvmarchitecture.ui.BooksViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): BooksViewModelFactory{
        val bookRepository = BookRepository.getInstance(FakeDatabase.getInstance().bookDao)
        return BooksViewModelFactory(bookRepository)
    }
}