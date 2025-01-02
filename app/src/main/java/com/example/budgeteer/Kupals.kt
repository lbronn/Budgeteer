package com.example.budgeteer

data class Kupals(
    val header: String,
    val text: String,
    val type: KupalsType
)

enum class KupalsType {
    TEXT,
    VIDEO,
    IMAGE
}