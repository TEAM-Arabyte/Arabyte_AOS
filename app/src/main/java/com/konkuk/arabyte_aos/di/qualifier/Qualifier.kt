package com.konkuk.arabyte_aos.di.qualifier

import javax.inject.Qualifier

@Qualifier
annotation class Arabyte

@Qualifier
annotation class Auth

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Kakao
