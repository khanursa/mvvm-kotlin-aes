package com.belajar.mvvmpassgenerate.ui.password

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.belajar.mvvmpassgenerate.R
import com.belajar.mvvmpassgenerate.adapter.PasswordGenerateAdapter
import com.belajar.mvvmpassgenerate.data.Password
import com.belajar.mvvmpassgenerate.helper.Constans
import com.belajar.mvvmpassgenerate.helper.Utils
import com.belajar.mvvmpassgenerate.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-08
 */
 
class PasswordActivity: AppCompatActivity(), PasswordGenerateAdapter.Listener{
private val passGenerateAdapter by lazy { PasswordGenerateAdapter() }
    private val utils by lazy { Utils(this@PasswordActivity) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi(){
val factory =InjectorUtils.providePasswordViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(PasswordViewModel::class.java)
        setupRecyclerView()
        viewModel.getPassword().observe(this, Observer {password ->
                passGenerateAdapter.clearAdapter()
                passGenerateAdapter.addData(password = password as ArrayList)
        })
        mainButtonGenerate.setOnClickListener{
            val name = mainEdittextType.text.toString()
            val password = utils.encrypt(name) ?: ""
            viewModel.addPassword(Password( name, password))
            Log.d("PASS", password)
            mainEdittextType.setText("")
        }
    }

    private fun setupRecyclerView(){
        mainRecyclerView.layoutManager = LinearLayoutManager(this@PasswordActivity, RecyclerView.VERTICAL, false)
        passGenerateAdapter.listener(this)
        mainRecyclerView.adapter = passGenerateAdapter
    }

    override fun listenerButtonCopy(passCopy: String) {
        val clipboard: ClipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(Constans.INITAL_NAME, passCopy)
        clipboard.setPrimaryClip(clip)
    }

    override fun listenerButtonGenerate(passCopy: String) {
        utils.decrypt(passCopy)?.let { utils.toast(it) }
    }
}