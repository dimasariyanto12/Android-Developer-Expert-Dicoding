package com.example.filmqu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvFilm:RecyclerView
    private var list:ArrayList<Film> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //title bar
        val actionbar=supportActionBar
        actionbar!!.title="Home"

        rvFilm=findViewById(R.id.rv_Film)
        rvFilm.setHasFixedSize(true)

        list.addAll(FilmData.lisData)
        showRecyclerList()
    }
    private fun showRecyclerList(){
        rvFilm.layoutManager=LinearLayoutManager(this)
        val listFilmAdapter=ListFilmAdapter(list)
        rvFilm.adapter=listFilmAdapter
    }
    override fun onOptionsItemSelected(item:MenuItem):Boolean{
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setMode(selectedMode:Int){
        when(selectedMode){

        }
    }
}
