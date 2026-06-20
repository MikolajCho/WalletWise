package com.example.walletwise.data.model

enum class Category(val displayName: String, val emoji: String, val colorHex: String) {
    FOOD("Jedzenie", "🍕", "#E53935"),
    TRANSPORT("Transport", "🚗", "#1E88E5"),
    ENTERTAINMENT("Rozrywka", "🎮", "#8E24AA"),
    HEALTH("Zdrowie", "🏥", "#43A047"),
    HOME("Dom", "🏠", "#FB8C00"),
    OTHER("Inne", "📋", "#757575");

    companion object {
        fun fromName(name: String): Category =
            entries.firstOrNull { it.name == name } ?: OTHER
    }
}
