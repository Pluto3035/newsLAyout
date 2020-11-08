package com.example.news

/**
 * @Description
 * 代码高手
 */
//提供一个方法,判断是从哪个地方加载的。本地/数据库/网络
interface DataInterface {
    fun getData():ArrayList<NewsModel>
}