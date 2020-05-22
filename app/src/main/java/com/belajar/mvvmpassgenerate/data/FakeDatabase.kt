package com.belajar.mvvmpassgenerate.data


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-08
 */

class FakeDatabase {
    var passwordDao = PasswordDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}