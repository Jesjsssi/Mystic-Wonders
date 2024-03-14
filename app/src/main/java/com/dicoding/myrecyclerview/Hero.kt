package com.dicoding.myrecyclerview

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Hero(
    val name: String?,
    val power: String?,
    val durability: String?,
    val description: String?,
    val info: String?,
    val photo: Int
) : Parcelable {}