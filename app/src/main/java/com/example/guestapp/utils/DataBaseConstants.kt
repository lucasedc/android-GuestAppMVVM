package com.example.guestapp.utils

class DataBaseConstants {
    /**
     * Tabelas disponíveis no banco de dados com suas colunas
     */
    object GUEST {
        const val TABLE_NAME = "Guest"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }

    object FILTER{
        const val FILTER_ALL = "ALL"
        const val FILTER_PRESENTS = "PRESENTS"
        const val FILTER_ABSENTS = "ABSENTS"
    }
}