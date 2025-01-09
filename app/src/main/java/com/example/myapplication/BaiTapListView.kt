package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
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

        var listItem1 : ArrayList<String> = arrayListOf("Hello", "hi", "Xin chao", "Ni Hao", "Bonjour")

        //binding.listView1.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listItem1)
        val listItem2 = arrayOf("")
        var mergeArray = listItem2.plus(listItem1)
        var indexPosition = 0
        binding.btn1.setOnClickListener {
            binding.listView1.adapter =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem1)
        }

        binding.listView1.setOnItemClickListener { parent, view, position, id ->
            var text = listItem1[position]
            indexPosition = position
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
        }

        binding.btnAdd.setOnClickListener {
            listItem1.add("Chao")
            println("tetetetet ${listItem1.size}")
            binding.listView1.adapter =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem1)
        }
        binding.btnRemove.setOnClickListener {

            listItem1.removeAt(indexPosition)
            println("tetetetet ${listItem1.size}")
            binding.listView1.adapter =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem1)
        }
    }
}
