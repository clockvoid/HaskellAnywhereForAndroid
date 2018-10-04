package com.lucciola.haskellanywhereforandroidkt.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = "haskell")
data class Haskell @JvmOverloads constructor (
    @ColumnInfo(name = "Result") var Result: String? = null,
    @ColumnInfo(name = "Warnings") var Warnings: String? = null,
    @ColumnInfo(name = "Errors") var Errors: String? = null,
    @ColumnInfo(name = "Status") var Status: String? = null,
    @ColumnInfo(name = "Files") var Files: String? = null,
    @ColumnInfo(name = "networkError") var networkError: String? = null
)
