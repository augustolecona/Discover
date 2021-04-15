package com.doordash.discovery.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.doordash.discovery.models.Stores


class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context,
        TableName, null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE " + TableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL1 + " TEXT NOT NULL,"+
                    COL2 + " TEXT NOT NULL);"
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        val dropTable = "DROP TABLE IF EXISTS $TableName"
        db.execSQL(dropTable)
        onCreate(db)
    }


    fun SaveRestaurant(stores: Stores.Store): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL1, stores.id)
        contentValues.put(COL2, stores.name)
        val result = db.insert(TableName, null, contentValues)
        db.close()
        return result != -1L
    }

    fun getRestaurantFav(id: Int?): Cursor? {
        val db = this.writableDatabase
        val selectUsers = "SELECT * FROM $TableName WHERE $COL1 =${id} "
        return db.rawQuery(selectUsers, null)
    }

    fun existsRestaurantsFav(id: Int?): Cursor? {
        val db = this.writableDatabase
        val selectUsers = "SELECT COUNT(1) FROM $TableName WHERE $COL1 =${id} "
        return db.rawQuery(selectUsers, null)
    }

    companion object {
        const val TAG = "DatabaseHelper"
        private const val TableName = "Restaurants"
        private const val COL1 = "IDRestaurant"
        private const val COL2 = "restaurantName"
    }
}
