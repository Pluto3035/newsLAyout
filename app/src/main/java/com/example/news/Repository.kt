package com.example.news

/**
 * @Description
 * 代码高手
 */
//单例设计模式
class Repository private constructor(){
    //自己使用的可变数据源
    private val mdatas = mutableListOf<NewsModel>()
    //封装为不可变的提供给外部使用
    var datas:List<NewsModel> = listOf()
        get() {
        if(field.isEmpty()){
            //如果没有就加载一次，有就直接返回
            loadData()
            field = mdatas.toList()
        }
            return field
    }

    //提供静态方法
    companion object{
        private var instance = Repository()
        fun getInstance() = instance
    }

    //获取数据的接口
    private fun loadData(){
        //当前通过localUtil获取数据
       val dataSource:DataInterface = LocalUtil()
        //将获取的数据添加到数据源中
       mdatas.addAll( dataSource.getData())
    }
    //更改数据的接口

}