package com.android.support.exercise.bd

import android.content.Context
import androidx.room.CoroutinesRoom
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.support.exercise.bd.dao.UserDao
import com.android.support.exercise.bd.entities.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        private fun initDatabase(context: Context) {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context, AppDatabase::class.java,
                            "user-database")
                            .build()
                    CoroutineScope(Dispatchers.IO).launch {
                        if (INSTANCE!!.userDao().getUserCount() == 0) {
                            INSTANCE!!.userDao().insertUser(
                                User(
                                    1,
                                    "John Doe",
                                    "https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Barack_Obama_profile.jpg/446px-Barack_Obama_profile.jpg"
                                )
                            )
                        }
                    }
                }
            }
        }

        fun getDatabase(context: Context): AppDatabase? {
            initDatabase(context)
            return INSTANCE
        }
    }
}