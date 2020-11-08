package com.example.news

/**
 * @Description
 * 代码高手
 */
//数据类 只提供数据，不进行操作
data class NewsModel(val title:String,
                     val imageId:Int,
                     var like:Int,
                     val type:Int
                     )