package com.example.a7_th_month_project.data.mapper

import com.example.a7_th_month_project.data.model.NoteEntity
import com.example.a7_th_month_project.domain.model.Note

fun Note.toNoteEntity() = NoteEntity(
    id, title, description, createdAt
)

fun NoteEntity.toNote() = Note(
    id, title, description, createdAt
)