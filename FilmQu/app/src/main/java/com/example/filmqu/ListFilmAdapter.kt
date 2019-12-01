package com.example.filmqu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFilmAdapter (val listFilm:ArrayList<Film>): RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view:View=LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_hero,viewGroup,false)
        return ListViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,ranking,photo,sinopsis,detail)=listFilm[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.ImgPhoto)
        holder.TvName.text=name
        holder.TvDetail.text=sinopsis
        val mContext=holder.itemView.context
        holder.itemView.setOnClickListener{
            val moveDetail=Intent(mContext,DetailFilm::class.java)
            moveDetail.putExtra(DetailFilm.EXTRA_RANKING,ranking)
            moveDetail.putExtra(DetailFilm.EXTRA_NAME,name)
            moveDetail.putExtra(DetailFilm.EXTRA_PHOTO,photo)
            moveDetail.putExtra(DetailFilm.EXTRA_DETAIL,detail)
            moveDetail.putExtra(DetailFilm.EXTRA_SINOPSIS,sinopsis)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listFilm.size//To change body of created functions use File | Settings | File Templates.
    }
    inner class ListViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var TvName:TextView=itemView.findViewById(R.id.item_name)
        var TvDetail:TextView=itemView.findViewById(R.id.item_detail)
        var ImgPhoto:ImageView=itemView.findViewById(R.id.img_film)

    }

}