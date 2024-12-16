package com.dwan.exe_roomdatabase.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dwan.exe_roomdatabase.data.dao.MahasiswaDao
import com.dwan.exe_roomdatabase.data.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false) // Entitas tabel Mahasiswa
abstract class KrsDatabase: RoomDatabase() {

    abstract fun mahasiswaDao(): MahasiswaDao // Fungsi untuk mengakses data Mahasiswa
}