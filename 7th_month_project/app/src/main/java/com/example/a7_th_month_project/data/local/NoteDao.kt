package com.example.a7_th_month_project.data.local

import androidx.room.*
import com.example.a7_th_month_project.data.model.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteEntity : NoteEntity)

    @Update
    fun update(noteEntity : NoteEntity)

    @Delete
    fun delete(noteEntity : NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes() : List<NoteEntity>
}