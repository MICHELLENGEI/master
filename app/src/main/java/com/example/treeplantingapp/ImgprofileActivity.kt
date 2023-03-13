package com.example.treeplantingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class ImgprofileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imgprofile)
        var pickerImage: ImageView?=null

        pickerImage=findViewById(R.id.imagePicker)

        val gallery = findViewById<Button>(R.id.btnGallery)
        val camera = findViewById<Button>(R.id.btnCamera)









    }
}
