package com.example.kotlin1_dz3_fragment.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun replaceFragmentBundle(activity: FragmentActivity?, id: Int, fragment: Fragment, bundle: Bundle, tag: String){

    activity?.supportFragmentManager?.beginTransaction()?.replace(id, fragment::class.java, bundle, tag)?.commit()

}
fun replaceFragment2(activity: FragmentActivity?, id: Int, fragment: Fragment,  tag: String){

    activity?.supportFragmentManager?.beginTransaction()?.replace(id,fragment, tag)?.commit()

}