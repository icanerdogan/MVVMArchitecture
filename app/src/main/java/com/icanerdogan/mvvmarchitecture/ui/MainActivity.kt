package com.icanerdogan.mvvmarchitecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.icanerdogan.mvvmarchitecture.R
import com.icanerdogan.mvvmarchitecture.data.Book
import com.icanerdogan.mvvmarchitecture.databinding.ActivityMainBinding
import com.icanerdogan.mvvmarchitecture.utilities.InjectorUtils
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initializeUI()
    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(BooksViewModel::class.java)

        viewModel.getBooks().observe(this, Observer { books ->
            val stringBuilder = StringBuilder()
            books.forEach{book ->
                stringBuilder.append("$book\n\n")
            }
            binding.textViewBooks.text = stringBuilder.toString()
        })

        binding.buttonAddBook.setOnClickListener {
            val book = Book(binding.editTextBook.text.toString(), binding.editTextAuthor.text.toString())
            viewModel.addBook(book)
            binding.editTextBook.setText("")
            binding.editTextAuthor.setText("")
        }
    }
}