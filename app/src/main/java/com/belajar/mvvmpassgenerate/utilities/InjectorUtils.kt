package com.belajar.mvvmpassgenerate.utilities

import com.belajar.mvvmpassgenerate.data.FakeDatabase
import com.belajar.mvvmpassgenerate.data.PasswordRepository
import com.belajar.mvvmpassgenerate.ui.password.PasswordViewModelFactory

object InjectorUtils {

    fun providePasswordViewModelFactory(): PasswordViewModelFactory {
        val passwordFactory = PasswordRepository.getInstance(FakeDatabase.getInstance().passwordDao)
        return PasswordViewModelFactory(passwordFactory)
    }
}