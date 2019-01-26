package com.first.retflix.model.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
 class Setslider {
    @PrimaryKey(autoGenerate = true)
    var uid: Int ?= 0
    @ColumnInfo(name = "first_set")
    var firstSet: String?= null
    @ColumnInfo(name = "first_impression")
    var firstImpression: String?= null
}