package com.icanerdogan.mvvmarchitecture.data

class FakeDatabase private constructor(){

    var bookDao = BookDao()
        private set

    companion object{
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(lock = this){
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}