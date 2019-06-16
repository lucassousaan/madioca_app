package com.lucas.mandiocadafazenda.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lucas.mandiocadafazenda.R
import com.lucas.mandiocadafazenda.view.fragments.ConsultDeliveryFragment
import com.lucas.mandiocadafazenda.view.fragments.MainRegistrarFragment
import kotlinx.android.synthetic.main.activity_main_entregador.*
import kotlinx.android.synthetic.main.layout_dialog_logout.view.*

class MainEntregadorActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var navigationView: BottomNavigationView
    private var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_entregador)

        val toolbar = tb_entregador
        setSupportActionBar(toolbar)

        num = 1
        navigationView = bn_deliveryman
        navigationView.selectedItemId = R.id.register_delivery
        navigationView.setOnNavigationItemSelectedListener(this)
        val fragment = MainRegistrarFragment()
        openFragment(fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.logout -> {
                openDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openDialog() {
        val builder = AlertDialog.Builder(this)
        val view = LayoutInflater.from(this).inflate(R.layout.layout_dialog_logout, null)
        builder.setView(view)
        val dialog = builder.show()
        dialog.setCancelable(false)
        view.bt_cancelLogout.setOnClickListener {
            dialog.dismiss()
        }
        view.bt_confirmLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_entregador, fragment)
        transaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.register_delivery -> {
                if (num != 1) {
                    num = 1
                    val fragment = MainRegistrarFragment()
                    openFragment(fragment)
                }

            }
            R.id.consult_delivery -> {
                if (num != 2) {
                    num = 2
                    val fragment = ConsultDeliveryFragment()
                    openFragment(fragment)
                }
            }
        }
        return true
    }
}
