package com.anvarpasha.avtogarage.ui.orderDetail

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.databinding.OrderDetailActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class OrderDetail : AppCompatActivity() {


    private val viewModel: OrderDetailVM by viewModel()
    private val binding: OrderDetailActivityBinding by lazy {
        OrderDetailActivityBinding.inflate(layoutInflater)
    }


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_detail_activity)


        val answered = findViewById<Button>(R.id.btnAnswered)
        val rejected = findViewById<Button>(R.id.btnReject)


        answered.setOnClickListener{
            val dialogBuilder = AlertDialog.Builder(this)


                .setCancelable(false)
                .setPositiveButton("Done") { dialog, id ->
                    finish()
                }
                .setNegativeButton("Cancel") { dialog, id ->
                    dialog.cancel()
                }

            val view = layoutInflater.inflate(R.layout.answer_spinner,null)
            val alert = dialogBuilder.create()
            alert.setTitle("Select")
            alert.setView(view)

            val spinner = view.findViewById<Spinner>(R.id.answerSp)

            alert.show()

        }

        rejected.setOnClickListener{
            val dialogBuilder = AlertDialog.Builder(this)

                .setCancelable(false)
                .setPositiveButton("Done"){dialog, id->
                    finish()
                }
                .setNegativeButton("Cancel"){dialog,id ->
                    dialog.cancel()
                }

            val view =layoutInflater.inflate(R.layout.reject_spinner,null)
            val alert = dialogBuilder.create()
            alert.setTitle("Select")
            alert.setView(view)

            alert.show()
        }


        val orderId = intent.getIntExtra("id", 0)

        viewModel.getSingleOrder(orderId.toString())



        viewModel.properties.observe(this, {

            //  Toast.makeText(this,it.data,Toast.LENGTH_SHORT).show()
            // binding.model = it.data
        })


    }
}