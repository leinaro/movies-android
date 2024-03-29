package com.leinaro.peiky.movies.Models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie (
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    @NonNull
    var poster_path: String,
    @NonNull
    var original_title: String,
    @NonNull
    var title: String,
    @NonNull
    var overview: String
)