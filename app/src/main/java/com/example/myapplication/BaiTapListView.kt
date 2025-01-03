package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityBaiTapListViewBinding

class BaiTapListView : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityBaiTapListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaiTapListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listItem1 = arrayOf("Hello", "hi", "Xin chao", "Ni Hao", "Bonjour")

        //binding.listView1.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listItem1)
        val listItem2 = arrayOf("")

        binding.btn1.setOnClickListener {
            val mergeArray = listItem2.plus(listItem1)
            binding.listView1.adapter =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, mergeArray)
        }
    }
}
