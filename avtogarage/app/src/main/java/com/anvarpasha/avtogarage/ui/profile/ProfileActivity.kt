package com.anvarpasha.avtogarage.ui.profile

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.databinding.ProfileActivityBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)
    }


    lateinit var binding: ProfileActivityBinding
    private val viewModel: ProfileVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = DataBindingUtil.setContentView(this, R.layout.profile_activity)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val logoImg = findViewById<ImageView>(R.id.logoImg)
        val coverImg = findViewById<ImageView>(R.id.coverImg)

        setSupportActionBar(toolbar)
        supportActionBar?.setIcon(R.drawable.ic_baseline_arrow_back_24)



        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        viewModel.properties.observe(this, {
            Glide.with(this).load(it.logoImg).into(logoImg)
            Glide.with(this).load(it.coverImg).into(coverImg)
        })




        viewModel.getProfileScreenAsync()
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