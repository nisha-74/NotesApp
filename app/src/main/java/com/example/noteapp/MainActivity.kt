package com.example.noteapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.style.IconMarginSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.model.Note
import com.example.noteapp.model.NotesDb
import com.example.noteapp.repository.NotesRepository
import com.example.noteapp.ui.theme.NoteAppTheme
import com.example.noteapp.view.DisplayDialog
import com.example.noteapp.view.DisplayNotesList
import com.example.noteapp.viewmodel.NoteViewModel
import com.example.noteapp.viewmodel.NoteViewModelFactory


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database= NotesDb.getInstance(applicationContext)
        val repository= NotesRepository(database.notesDao)

        val viewModelFactory = NoteViewModelFactory(repository)

        val noteViewModel= ViewModelProvider(this,
            viewModelFactory)[NoteViewModel::class.java]


            //noteViewModel.insertNote(note1)
        setContent {
            NoteAppTheme {


                Scaffold(
                    floatingActionButton = { MyFab(noteViewModel) }
                ) {
                    //observeAsState : converts a LiveData into a state object
                    // then can be observed within composables
                    val notes by noteViewModel.allNotes.observeAsState(emptyList())

                    DisplayNotesList(notes = notes)
                }

            }
        }
    }
}

@Composable
fun MyFab( viewModel: NoteViewModel){
    var show by remember { mutableStateOf(false) }
    DisplayDialog(viewModel=viewModel, showDialog = show, ) {
        show=false
    }

    FloatingActionButton(onClick = {
     show=true

    }, containerColor = Color.Blue,
        contentColor =  Color.White) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Note"
        )

    }
}
