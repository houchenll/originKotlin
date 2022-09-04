package com.hc.kotlin.pattern.single

enum class SingleDialogEnum {
    INSTANCE;

    companion object {
        val instance: SingleDialogEnum
            get() = INSTANCE
    }
}
