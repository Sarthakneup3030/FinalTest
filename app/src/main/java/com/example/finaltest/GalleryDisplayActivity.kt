package com.example.finaltest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryDisplayActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var currentOrientation: String = "vertical"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_display)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        currentOrientation = intent.getStringExtra("orientation") ?: "vertical"
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = if (currentOrientation == "vertical") {
            LinearLayoutManager(this)
        } else {
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        }

        val images = listOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9,
            R.drawable.image10
        )

        recyclerView.adapter = ImageAdapter(this, images)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.layout.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_change_preferences -> {
                showChangePreferencesDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showChangePreferencesDialog() {
        // Placeholder for a dialog - in reality, you would want to implement this properly
        val newOrientation = if (currentOrientation == "vertical") "horizontal" else "vertical"
        val intent = Intent(this, GalleryDisplayActivity::class.java)
        intent.putExtra("orientation", newOrientation)
        startActivity(intent)
        finish()
    }
}
