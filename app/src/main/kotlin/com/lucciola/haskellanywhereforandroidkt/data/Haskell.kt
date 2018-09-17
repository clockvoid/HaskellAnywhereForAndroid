package com.lucciola.haskellanywhereforandroidkt.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = "haskell")
data class Haskell @JvmOverloads constructor (
    @ColumnInfo(name = "Result") var Result: String = "Default",
    @ColumnInfo(name = "Warnings") var Warnings: String = "",
    @ColumnInfo(name = "Errors") var Errors: String = "",
    @ColumnInfo(name = "Status") var Status: String = "",
    @ColumnInfo(name = "Files") var Files: String = "",
    @ColumnInfo(name = "AddedDefine") var AddedDefine: String = "",
    @ColumnInfo(name = "Exception") var Exception: String = "",
    @ColumnInfo(name = "HttpStatusCode") var HttpStatusCode: String = ""
)
