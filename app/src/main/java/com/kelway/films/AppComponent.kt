package com.kelway.films

import android.content.Context
import com.kelway.films.data.di.DataModule
import com.kelway.films.data.di.RetrofitModule
import com.kelway.films.domain.di.DomainModule
import com.kelway.films.presentation.listfilms.ListFilmsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataModule::class, DomainModule::class, RetrofitModule::class]
)
interface AppComponent {

    fun inject(target: ListFilmsFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context): Builder
        fun build(): AppComponent
    }
}