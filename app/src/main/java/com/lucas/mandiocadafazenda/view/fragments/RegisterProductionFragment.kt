package com.lucas.mandiocadafazenda.view.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import com.lucas.mandiocadafazenda.R
import kotlinx.android.synthetic.main.fragment_register_production.view.*
import java.util.*

class RegisterProductionFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    private var date = ""
    private lateinit var viewMajor: View
    private var dateToSend = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewMajor = inflater.inflate(R.layout.fragment_register_production, container, false)
        viewMajor.ll_chooseDate.setOnClickListener {
            openCalendar()
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
        viewMajor.tv_date_production.text = date
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

}
