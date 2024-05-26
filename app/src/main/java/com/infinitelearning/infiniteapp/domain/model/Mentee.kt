package com.infinitelearning.infiniteapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mentee(
    val id: Int,
    val name: String,
    val role: String,
    val batch: String,
    val photo: String,
): Parcelable