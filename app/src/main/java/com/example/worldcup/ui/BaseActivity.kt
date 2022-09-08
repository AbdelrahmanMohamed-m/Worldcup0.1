package com.example.worldcup.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB:ViewBinding>: AppCompatActivity() {
    abstract val LOG_TAG :String
    abstract val bindinginflater:(LayoutInflater)->VB
    private var _binding:ViewBinding?=null
    protected val binding
    get()  = _binding as VB?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindinginflater(layoutInflater)
              setContentView(requireNotNull(_binding).root)

              setup()
 callback()
    }
    abstract fun setup()
    abstract fun callback()
     protected fun log(Value:Any)
     {
         Log.v(LOG_TAG,Value.toString())
     }
}


