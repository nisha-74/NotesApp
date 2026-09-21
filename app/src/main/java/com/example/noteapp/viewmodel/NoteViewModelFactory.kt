package com.example.noteapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.repository.NotesRepository

class NoteViewModelFactory(private val repository: NotesRepository) : ViewModelProvider.Factory{
    /**
     * if you ViewModel requires additional parameters
     * such as a ' repository ' or a 'context' , you need to
     * create a 'ViewModelProvider.Factory. to handle the instantiation*
     * */

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NoteViewModel::class.java)){
            return NoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}