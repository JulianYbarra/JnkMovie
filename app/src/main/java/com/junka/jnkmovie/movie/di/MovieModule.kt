package com.junka.jnkmovie.movie.di

import com.junka.jnkmovie.movie.service.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
class MovieModule {

    @Provides
    fun provideCharacterService(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)
}