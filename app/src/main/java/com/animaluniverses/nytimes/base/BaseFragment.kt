package com.animaluniverses.nytimes.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.animaluniverses.nytimes.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB: ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (_binding == null) {
            _binding = inflate.invoke(inflater, container, false)
        }
        onBind()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        loading(false)
    }

    open fun onBind(){

    }

    fun showToast(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }

    private var mDialog :Dialog? = null
    fun loading(isLoading:Boolean){
        if (isLoading) {
            if (mDialog == null) {
                mDialog = Dialog(requireContext())
                mDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
                mDialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
                mDialog?.setCancelable(false)
                mDialog?.window?.setDimAmount(0f)
                mDialog?.setContentView(R.layout.dialog_progressbar)
            }
            mDialog?.show()
        }else{
            mDialog?.dismiss()
        }
    }

}