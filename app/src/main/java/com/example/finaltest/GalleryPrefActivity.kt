package com.example.finaltest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class GalleryPrefActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_pref)

        val radioGroup = findViewById<RadioGroup>(R.id.viewingOptionRadioGroup)
        val buttonConfirm = findViewById<Button>(R.id.buttonConfirm)

        buttonConfirm.setOnClickListener {
            val isVertical = radioGroup.checkedRadioButtonId == R.id.radioVertical
            val intent = Intent(this, GalleryDisplayActivity::class.java)
            intent.putExtra("orientation", if (isVertical) "vertical" else "horizontal")
            startActivity(intent)
        }
    }
}
