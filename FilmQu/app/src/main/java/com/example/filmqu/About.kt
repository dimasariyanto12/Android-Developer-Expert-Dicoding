package com.example.filmqu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        //Titile Bar
        val actBar=supportActionBar
        actBar!!.title="About"
        actBar.setDisplayHomeAsUpEnabled(true)

        //Photo Profile
        val imgProfile:ImageView=findViewById(R.id.img_profile)
        val Image="https://d2zvxgfo5lha7k.cloudfront.net/small/avatar/20191129102104ef0edee18a69feb7c4182f53b40d347b.jpg"
        Glide.with(this)
            .load(Image)
            .apply(RequestOptions())
            .into(imgProfile)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
