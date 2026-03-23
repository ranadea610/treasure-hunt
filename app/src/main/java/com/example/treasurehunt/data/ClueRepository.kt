package com.example.treasurehunt.data

import android.content.Context
import com.example.treasurehunt.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ClueRepository {

    fun loadClues(context: Context): List<Clue> {
        val inputStream = context.resources.openRawResource(R.raw.clues)
        val json = inputStream.bufferedReader().use { it.readText() }

        val type = object : TypeToken<List<Clue>>() {}.type
        return Gson().fromJson(json, type)
    }
}