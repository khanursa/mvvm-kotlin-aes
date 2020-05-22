package com.belajar.mvvmpassgenerate.ui.password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.belajar.mvvmpassgenerate.data.PasswordRepository


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-08
 */

class PasswordViewModelFactory(private val passwordRepository: PasswordRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PasswordViewModel(passwordRepository) as T
    }
}