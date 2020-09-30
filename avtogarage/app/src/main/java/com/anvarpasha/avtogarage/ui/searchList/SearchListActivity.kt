package com.anvarpasha.avtogarage.ui.searchList

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.databinding.SearchResultListFragmentBinding
import kotlinx.android.synthetic.main.search_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_result_list_fragment)
    }


    private val viewModel: SearchVM by viewModel()
    lateinit var binding: SearchResultListFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = DataBindingUtil.setContentView(this, R.layout.search_result_list_fragment)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView= binding.recyclerView

        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recyclerView.layoutManager = layoutManager

        viewModel.properties.observe(this, {
            recyclerView.adapter = SearchAdapter(it.list,SearchAdapter.OnClickListener{

            })
        })
        viewModel.getSearchScreen(value1 = fromDate, value2 = toDate)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return true
    }


}