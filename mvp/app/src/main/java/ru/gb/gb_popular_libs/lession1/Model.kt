package ru.gb.gb_popular_libs.lession1

class Model(indexArray: List<Int>){
    var counters: MutableMap<Int, Int> = indexArray.map{it to 0}.toMap() as MutableMap<Int, Int>

    fun next(indexBut: Int): Int{
        counters[indexBut] = getCounter(indexBut).inc()
        return getCounter(indexBut)
    }

    fun getCounter(indexBut: Int): Int{
        return counters[indexBut]!!
    }

}