package com.first.retflix.model.database

import android.arch.persistence.room.*

@Dao
interface SetsliderDao{
    @Query("SELECT * FROM setslider")
    fun getAll(): List<Setslider>

    @Insert
    fun insertAll(vararg setsliders: Setslider)

    @Delete
    fun delete(setslider: Setslider)
}