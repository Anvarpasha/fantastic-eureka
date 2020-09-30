package com.anvarpasha.avtogarage.ui.search

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.ui.orders.OrderHistoryFragment
import com.anvarpasha.avtogarage.ui.profile.ProfileActivity
import com.anvarpasha.avtogarage.ui.searchList.SearchListActivity
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_auth.toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_order_history.*
import kotlinx.android.synthetic.main.search_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class SearchActivity : AppCompatActivity() {
    // method which is using to get  Calendar class
    private val cal: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_fragment)

        // assign to the val fromDate which we get from XML file
        val fromDate = findViewById<TextView>(R.id.fromDate)

        //assign to the val toDate which we got from XML file
        val toDate = findViewById<TextView>(R.id.toDate)



        fromDate?.text = "From"
        toDate?.text = "To"

        // create an OnDateSetListener
        val fromDateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                fromUpdateDateInView()
            }

        // create an OnDateSetListener for toDate
        val toDateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                toUpdateDateInView()
            }

        toDate?.setOnClickListener(View.OnClickListener {
            DatePickerDialog(
                this@SearchActivity,
                toDateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        })




        fromDate?.setOnClickListener(View.OnClickListener {
            DatePickerDialog(
                this@SearchActivity,
                fromDateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        })

        btnSearch.setOnClickListener {

        }


        var toolbar = findViewById<Toolbar>(R.id.toolbars)

        setSupportActionBar(toolbar)
        supportActionBar?.setIcon(R.drawable.ic_baseline_arrow_back_24)




    }



    private fun toUpdateDateInView() {
        val toMyFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(toMyFormat, Locale.US)
        toDate!!.text = sdf.format(cal.time)
    }

    private fun fromUpdateDateInView() {
        val fromMyFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(fromMyFormat, Locale.US)
        fromDate!!.text = sdf.format(cal.time)
    }


}

