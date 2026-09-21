package com.example.noteapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NotesDb : RoomDatabase() {

   abstract val notesDao: NoteDao


   companion object {

       @Volatile
       private  var  INSTANCE: NotesDb?= null

       fun getInstance(context: Context): NotesDb{
           //ensuring that only one thread can execute the block
           // of code inside the synchronized block at given time
           synchronized(this){
               var instance =INSTANCE
               if(instance== null){
                   //creating DB  objects
                   instance= Room.databaseBuilder(
                       context=context.applicationContext,
                       NotesDb::class.java,
                       "notes_db"
                   ).build()
               }
               INSTANCE=instance
               return  instance

           }
       }
   }


}