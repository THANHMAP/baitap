package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityImageViewhomeworkBinding

class ImageViewhomework : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewhomeworkBinding
    private lateinit var list: ListView
    val mainTitle : ArrayList<String> =  arrayListOf("Title 1","Title 2","Title 3")
    val subTitle : ArrayList<String> = arrayListOf("Sub Title 1","Sub Title 2","Sub Title 3")
    val srcImage : ArrayList<Int> = arrayListOf(R.drawable.image,R.drawable.image2,R.drawable.image3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImageViewhomeworkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyListAdapter(this, mainTitle, subTitle, srcImage)
        list = binding.listView
        list.adapter = adapter

        list.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> Toast.makeText(applicationContext, "Place Your First Option Code", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(applicationContext, "Place Your Second Option Code", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(applicationContext, "Place Your Third Option Code", Toast.LENGTH_SHORT).show()
            }
        }


    }

    class MyListAdapter(
        private val context: Activity,
        private val maintitle: ArrayList<String>,
        private val subtitle: ArrayList<String>,
        private val imgid: ArrayList<Int>
    ) : ArrayAdapter<String>(context, R.layout.layout, maintitle) {

        override fun getView(position: Int, view: View?, parent: ViewGroup): View {
            val inflater = context.layoutInflater
            val rowView = inflater.inflate(R.layout.layout, null, true)

            val titleText = rowView.findViewById<TextView>(R.id.Title)
            val imageView = rowView.findViewById<ImageView>(R.id.imageView)
            val subtitleText = rowView.findViewById<TextView>(R.id.subTitle)

            titleText.text = maintitle[position]
            imageView.setImageResource(imgid[position])
            subtitleText.text = subtitle[position]

            return rowView
        }
    }

}