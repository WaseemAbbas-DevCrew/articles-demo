package io.devcrew.articlesdemo.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/"
    private const val API_KEY = "oWWhEHEvQpryviZcarNnOF9IcctBUubb"

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        val client = OkHttpClient.Builder()
        client.addInterceptor { chain: Interceptor.Chain? ->
            val original: Request? = chain?.request()
            val originalHttpUrl: HttpUrl? = original?.url()

            val url: HttpUrl? = originalHttpUrl?.newBuilder()
                ?.addQueryParameter("api-key", API_KEY)
                ?.build()

            val requestBuilder: Request.Builder? = original?.newBuilder()
            ?.url(url!!)

            chain?.proceed(requestBuilder?.build()!!)!!
        }
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client.build())
            .build()
    }
}