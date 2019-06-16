package com.lucas.mandiocadafazenda.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.lucas.mandiocadafazenda.view.fragments.EntregadorDespesaFragment
import com.lucas.mandiocadafazenda.view.fragments.EntregadorVendaFragment

class RegisterViewPagerAdapter(fm: FragmentManager, private var totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {return when(position) {
        0 -> {
            EntregadorVendaFragment()
        }
        else -> EntregadorDespesaFragment()
    }
    }

    override fun getCount(): Int = totalTabs
}