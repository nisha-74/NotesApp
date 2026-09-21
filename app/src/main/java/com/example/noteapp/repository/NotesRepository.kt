package com.example.noteapp.repository

import androidx.lifecycle.LiveData
import com.example.noteapp.model.Note
import com.example.noteapp.model.NoteDao

// Repository : Serves as a single source of truth
// for data in your App, Handling all Data Ops:
// 1 - Fetching data from the network
// 2- Loading Data from a local DB
class NotesRepository (private  val noteDao: NoteDao){
    val allNotes : LiveData<List<Note>>  = noteDao.getAllNotes()

    suspend fun insertNote(note: Note){
        return noteDao.insert(note)
    }

}