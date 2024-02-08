package com.example.homework17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework17.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {


    private var binding: FragmentFirstBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setonClickListener()
    }

    private fun navigateTosite(url: String, fragment: Fragment) {

        var bundle = Bundle()
        bundle.putString("Site", url)

        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment).commit()
    }



    private fun setonClickListener() {
        binding?.btnSiteToSwift?.setOnClickListener {
            navigateTosite("https://www.swift.com/", fragment = SecondFragment())
        }

        binding?.btnSiteToKotlin?.setOnClickListener {
            navigateTosite("https://kotlinlang.org/", fragment = SecondFragment())
        }
        binding?.btnSiteToPHP?.setOnClickListener {
            navigateTosite("https://www.php.net/", fragment = SecondFragment())
        }
    }

}