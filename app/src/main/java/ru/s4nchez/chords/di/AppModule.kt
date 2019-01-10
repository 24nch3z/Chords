package ru.s4nchez.chords.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.s4nchez.chords.data.shared.SharedPrefHelper
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideSharedPrefHelper(context: Context): SharedPrefHelper {
        return SharedPrefHelper(context)
    }
}