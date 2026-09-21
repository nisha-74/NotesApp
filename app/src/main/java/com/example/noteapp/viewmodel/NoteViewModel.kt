package com.example.noteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.Note
import com.example.noteapp.repository.NotesRepository
import kotlinx.coroutines.launch

class NoteViewModel( private val notesRepository: NotesRepository): ViewModel() {
    val allNotes: LiveData<List<Note>> = notesRepository.allNotes

    fun insertNote(note: Note){
        viewModelScope.launch {
            notesRepository.insertNote(note)
        }
    }

}