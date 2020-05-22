package com.belajar.mvvmpassgenerate.data


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-08
 */
 
class PasswordRepository private constructor(val passwordDao: PasswordDao) {
    fun addPassword(password: Password){
        passwordDao.addPassword(password)
    }

    fun getPassword() = passwordDao.getPassword()

    companion object{
        @Volatile private var instance : PasswordRepository? = null

        fun getInstance(passwordDao: PasswordDao) = instance ?: synchronized(this){
            instance ?: PasswordRepository(passwordDao).also { instance = it }
        }
    }

}