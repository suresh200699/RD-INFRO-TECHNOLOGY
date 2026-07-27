package com.suresh.task6profileimageupload

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imgProfile: ImageView
    private lateinit var btnChooseImage: Button

    private val pickImage =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                imgProfile.setImageURI(it)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgProfile = findViewById(R.id.imgProfile)
        btnChooseImage = findViewById(R.id.btnChooseImage)

        btnChooseImage.setOnClickListener {
            pickImage.launch("image/*")
        }
    }
}