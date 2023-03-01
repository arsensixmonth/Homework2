package com.example.a7_th_month_project.data.repository

import com.example.a7_th_month_project.data.local.NoteDao
import com.example.a7_th_month_project.data.mapper.toNote
import com.example.a7_th_month_project.data.mapper.toNoteEntity
import com.example.a7_th_month_project.domain.model.Note
import com.example.a7_th_month_project.domain.repository.NoteRepository
import com.example.a7_th_month_project.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao : NoteDao
) : NoteRepository{

    override fun createNote(note: Note) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = dao.insert(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        }catch (e: IOException){
            emit(ResultStatus.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)


    override fun updateNote(note: Note) {
        dao.update(note.toNoteEntity())
    }


    override fun deleteNote(note: Note) {
        dao.delete(note.toNoteEntity())
    }


    override fun getAllNotes(): List<Note> {
        return dao.getAllNotes().map { it.toNote() }
    }
}