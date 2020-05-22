package com.belajar.mvvmpassgenerate.helper

import android.content.Context
import android.util.Base64
import android.widget.Toast
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-06
 */

class Utils (private val mContext: Context){
    private val key = "aesEncryptionKey"

    fun encrypt(value: String): String? {
        return try {
            val initVector = key.toByteArray(charset("UTF-8"))
            val iv = IvParameterSpec(initVector)
            val skeySpec =
                SecretKeySpec(initVector, "AES")
            val cipher =
                Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv)
            val encrypted = cipher.doFinal(value.toByteArray())
            Base64.encodeToString(encrypted, Base64.NO_PADDING)
        } catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }

    fun decrypt(encrypted: String): String? {
        return try {
            val initVector = key.toByteArray(charset("UTF-8"))
            val iv =
                IvParameterSpec(initVector)
            val skeySpec =
                SecretKeySpec(initVector, "AES")
            val cipher =
                Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv)
            val original =
                cipher.doFinal(Base64.decode(encrypted, Base64.NO_PADDING))
            String(original)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
            null
        }
    }

    fun toast(message: String){
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
    }
}