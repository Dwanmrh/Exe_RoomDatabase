package com.dwan.exe_roomdatabase.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dwan.exe_roomdatabase.data.dao.MahasiswaDao
import com.dwan.exe_roomdatabase.data.entity.Mahasiswa
import kotlin.concurrent.Volatile

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false) // Entitas tabel Mahasiswa
abstract class KrsDatabase: RoomDatabase() {

    abstract fun mahasiswaDao(): MahasiswaDao // Fungsi untuk mengakses data Mahasiswa

    companion object {
        @Volatile // Mendefinisikan bahwa nilai variabel Instance selalu sama di semua thread
        private var Instance: KrsDatabase?= null

        fun getDatabase(context: Context): KrsDatabase { // Membuat / mendapatkan instance database room
            return (Instance ?: synchronized(this) { // Mengecek apakah instance sudah dibuat sebelumnya
                Room.databaseBuilder( // Fungsi untuk membuat database room
                    context,
                    KrsDatabase::class.java,
                    name ="KrsDatabase"
                )
                    .build().also { Instance = it } // Membuat database baru dan menyimpan ke instance
            })
        }
    }
}