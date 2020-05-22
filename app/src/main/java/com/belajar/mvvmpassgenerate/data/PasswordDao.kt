package com.belajar.mvvmpassgenerate.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-08
 */

class PasswordDao {
    private val passwordList = mutableListOf<Password>()
    private val passwords = MutableLiveData<List<Password>>()

    init {
        passwords.value = passwordList
    }

    fun addPassword(password: Password) {
        passwordList.add(password)
        passwords.value = passwordList
    }

    fun getPassword()= passwords as LiveData<List<Password>>
}