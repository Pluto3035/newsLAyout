package com.example.news

/**
 * @Description
 * 代码高手
 */
//在这个类里面加载数据
class LocalUtil :DataInterface{
    override fun getData(): ArrayList<NewsModel> {
        //制造数据
        val d1 = NewsModel("安卓开发",R.drawable.cute2,20,0)
        val d2 = NewsModel("ios开发",R.drawable.cute1,202,1)
        val d3 = NewsModel("python开发",R.drawable.cute1,3000,0)
        val d4 = NewsModel("Web开发",R.drawable.cute2,150,1)
        return arrayListOf(d1,d2,d3,d4)
    }
}