package com.domain.model

import java.util.*

data class HistoryModel(
    val date: Date,
    val price: String,
    val side: String,
    val service: String,
    val payMethod: String
)