package com.lucciola.haskellanywhereforandroidkt.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = "haskell")
data class Haskell @JvmOverloads constructor (
    @ColumnInfo(name = "result") var result: String = "",
    @ColumnInfo(name = "warnings") var warnings: String = "",
    @ColumnInfo(name = "errors") var errors: String = "",
    @ColumnInfo(name = "status") var status: String = "",
    @ColumnInfo(name = "files") var files: String = "",
    @ColumnInfo(name = "addedDefine") var addedDefine: String = "",
    @ColumnInfo(name = "exception") var exception: String = "",
    @ColumnInfo(name = "httpStatusCode") var httpStatusCode: String = ""
)
