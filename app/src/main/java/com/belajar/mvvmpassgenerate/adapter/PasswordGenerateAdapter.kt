package com.belajar.mvvmpassgenerate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.belajar.mvvmpassgenerate.R
import com.belajar.mvvmpassgenerate.data.Password
import kotlinx.android.synthetic.main.item_password_generate.view.*
import java.lang.StringBuilder
import java.util.ArrayList


/**
 *  Created by Muhammad Rahamatul Khair 0n 2020-05-08
 */
 
class PasswordGenerateAdapter: RecyclerView.Adapter<PasswordGenerateAdapter.ViewHolder>(){
    private var passwordList : MutableList<Password> = ArrayList()
    private lateinit var mListener: Listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_password_generate, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if(passwordList.isNullOrEmpty()) 0
        else passwordList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(passwordList[position], mListener)
    }

    fun addData(password: ArrayList<Password>){
        passwordList.addAll(password)
        notifyDataSetChanged()
    }

    fun clearAdapter(){
        passwordList.clear()
        notifyDataSetChanged()
    }

    interface Listener{
        fun listenerButtonCopy(passCopy: String)

        fun listenerButtonGenerate(passCopy: String)
    }

    fun listener(listener: Listener){
        mListener = listener
    }

    class ViewHolder(mView: View):RecyclerView.ViewHolder(mView) {
        fun bind(password: Password, listener: Listener){
            itemView.itemTviewPassword.text = StringBuilder().append(password).toString()
            itemView.itemButtonCopy.setOnClickListener {
                listener.listenerButtonCopy(passCopy = password.password)
            }

            itemView.itemButtonGenerate.setOnClickListener {
                listener.listenerButtonGenerate(passCopy = password.password)
            }
        }
    }

}