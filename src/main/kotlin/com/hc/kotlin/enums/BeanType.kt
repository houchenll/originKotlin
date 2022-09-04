package com.hc.kotlin.enums

enum class BeanType {
    EASY, MEDIUM, HARD, HELP;

    fun getFormattedName() = name.lowercase().capitalize()
}
