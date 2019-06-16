package com.lucas.mandiocadafazenda.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.lucas.mandiocadafazenda.R
import com.lucas.mandiocadafazenda.view.adapters.RegisterViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_main_registrar.view.*


class MainRegistrarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_registrar, container, false)
        view.tl_entregador.addTab(view.tl_entregador.newTab().setText("Venda"))
        view.tl_entregador.addTab(view.tl_entregador.newTab().setText("Despesa"))
        view.tl_entregador.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = RegisterViewPagerAdapter(childFragmentManager, view.tl_entregador.tabCount)
        view.vp_entregador.adapter = adapter
        view.vp_entregador.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(view.tl_entregador))

        view.tl_entregador.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view.vp_entregador.currentItem = tab!!.position
            }
        })

        return view
    }


}
