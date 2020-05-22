package com.belajar.mvvmpassgenerate.data


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-08
 */
 
data class Password(
    val name: String,
    val password: String
){
    override fun toString(): String {
        return "Name: $name\nPassword : ${password}"
    }
}