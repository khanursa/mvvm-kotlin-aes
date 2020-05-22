package com.belajar.mvvmpassgenerate.ui.password

import androidx.lifecycle.ViewModel
import com.belajar.mvvmpassgenerate.data.Password
import com.belajar.mvvmpassgenerate.data.PasswordRepository


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-08
 */

class PasswordViewModel(private val passwordRepository: PasswordRepository) : ViewModel() {
    fun getPassword() = passwordRepository.getPassword()
    fun addPassword(password: Password) = passwordRepository.addPassword(password)
}