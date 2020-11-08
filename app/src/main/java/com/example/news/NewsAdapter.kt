package com.example.news

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @Description
 * 代码高手
 */
class NewsAdapter :RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    //回调参数
    var callBack:((Int)->Unit)? = null
   inner  class NewsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
           //从当前view中 获取每个控件
        val titleTextView = itemView.findViewById<TextView>(R.id.mTitle)
        val iconImageView = itemView.findViewById<ImageView>(R.id.mIcon)
        val likeTextView = itemView.findViewById<TextView>(R.id.mLike)
        init {
            itemView.setOnClickListener{
               callBack?.let{

               }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
           val lf =  LayoutInflater.from(parent.context)
        val view:View
        //判断当前这个item的类型
        if(viewType == 0){
           view= lf.inflate(R.layout.news_lent,parent,false)
        }else{
           view= lf.inflate(R.layout.news_port,parent,false)
        }
        return NewsViewHolder(view)
    }

    //设置position对应的那个item类型
    override fun getItemViewType(position: Int): Int {
        //获取position对应的模型数据
       val model= Repository.getInstance().datas[position]
        return model.type
    }

    //确定有多少行 item 单元
    override fun getItemCount(): Int {
        //访问数据中心获取数据的条数
      return  Repository.getInstance().datas.size
    }

    //设置数据
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        //获取position对应的模型数据
        val model = Repository.getInstance().datas[position]
        holder.titleTextView.text = model.title
        holder.iconImageView.setImageResource(model.imageId)
        holder.likeTextView.text = model.like.toString()

        holder.itemView.setOnClickListener{
            callBack?.let {
                it(position)
            }
        }
    }
}