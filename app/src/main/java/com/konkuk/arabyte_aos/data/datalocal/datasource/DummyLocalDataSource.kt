package com.konkuk.arabyte_aos.data.datalocal.datasource

interface DummyLocalDataSource {
    var token: String
    var nickname: String
    fun clear()
}