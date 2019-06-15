package com.lucas.mandiocadafazenda.view.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucas.mandiocadafazenda.R
import com.lucas.mandiocadafazenda.model.ProductModelTest
import com.lucas.mandiocadafazenda.view.adapters.ProductAdapter
import kotlinx.android.synthetic.main.fragment_consult_product.*
import kotlinx.android.synthetic.main.fragment_consult_product.view.*
import java.util.*

class ConsultProductFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    private var date = ""
    private lateinit var viewMajor: View
    private var dateToSend = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewMajor = inflater.inflate(R.layout.fragment_consult_product, container, false)
        viewMajor.ll_chooseDateConsult.setOnClickListener {
            openCalendar()
        }
        viewMajor.bt_consultProducts.setOnClickListener {
            if (date == "") {
                Toast.makeText(context!!, "Selecione uma data", Toast.LENGTH_LONG).show()
            } else {
                tv_search_result.text = "Resultado da busca para: $date"
                viewMajor.rv_request_product.adapter = ProductAdapter(items(), context!!)
                viewMajor.rv_request_product.layoutManager = LinearLayoutManager(context!!)
            }
        }

        return viewMajor
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val mes = month + 1
        val mesString = if (mes < 10) {
            "0$mes"
        } else {
            "$mes"
        }
        val dayString = if (dayOfMonth < 10) {
            "0$dayOfMonth"
        } else {
            "$dayOfMonth"
        }
        dateToSend = "$year-$mesString-$dayString"
        date = "$dayString/$mesString/$year"
        viewMajor.tv_date_production_consult.text = date
    }

    private fun openCalendar() {
        val tz = TimeZone.getTimeZone("America/Sao_Paulo")
        TimeZone.setDefault(tz)
        val currentTime = Calendar.getInstance()
        var year = currentTime.get(Calendar.YEAR)
        var month = currentTime.get(Calendar.MONTH)
        var day = currentTime.get(Calendar.DAY_OF_MONTH)
        if (date != "") {
            val splitDate = date.split("/")
            year = splitDate[2].toInt()
            month = splitDate[1].toInt() - 1
            day = splitDate[0].toInt()
        }
        val datePickerDialog = DatePickerDialog(context!!, this, year, month, day)
        datePickerDialog.show()
        datePickerDialog.setCancelable(false)
    }

    private fun items(): List<ProductModelTest> {
        return listOf(
            ProductModelTest(
                "Mandioca - 2 Kg",
                "Quantidade: 200"
            ),
            ProductModelTest(
                "Mandioca - 5 Kg",
                "Quantidade: 50"
            ),
            ProductModelTest(
                "Mandioca - 10 Kg",
                "Quantidade: 50"
            )
        )
    }
}
