package com.ajcm.menuslider.hilt

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MenuModules {

    @Singleton
    @Provides
    fun provideFirestore() = Firebase.firestore

}
