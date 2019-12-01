package com.example.filmqu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailFilm : AppCompatActivity() {


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    companion object{
        const val EXTRA_NAME="extra_name"
        const val EXTRA_PHOTO="extra_photo"
        const val EXTRA_DETAIL="extra_detail"
        const val EXTRA_SINOPSIS="extra_sinopsis"
        const val EXTRA_RANKING="extra_ranking"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        //title bar
        val actionbar=supportActionBar
        actionbar!!.title="Detail Film"
        actionbar.setDisplayHomeAsUpEnabled(true)
        //id layout
        val dtName:TextView=findViewById(R.id.dt_name)
        val imgFilm:ImageView=findViewById(R.id.img_film)
        val dtDetail:TextView=findViewById(R.id.dt_contentDetail)
        val dtInfo:TextView=findViewById(R.id.dt_sinopsis)
        val dtRank:TextView=findViewById(R.id.dt_ranting)

        //inten
        val dName=intent.getStringExtra(EXTRA_NAME)
        val dImg=intent.getStringExtra(EXTRA_PHOTO)
        val dDetail=intent.getStringExtra(EXTRA_DETAIL)
        val dInfo=intent.getStringExtra(EXTRA_SINOPSIS)
        val dRank=intent.getStringExtra(EXTRA_RANKING)

        dtName.text=dName
            Glide.with(this)
                .load(dImg)
                .apply(RequestOptions())
                .into(imgFilm)
        dtDetail.text=dDetail
        dtInfo.text=dInfo
        dtRank.text=dRank
    }
}
