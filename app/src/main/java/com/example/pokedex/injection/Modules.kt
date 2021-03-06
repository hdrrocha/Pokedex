package com.example.pokedex.injection

import androidx.navigation.NavController
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import com.example.pokedex.BuildConfig
import com.example.pokedex.data.api.PokemonApi
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.repository.PokemonListRepositoryImp
import com.example.pokedex.data.repository.SinglePokemonRepositoryImp
import com.example.pokedex.data.source.PokemonListPagingSource
import com.example.pokedex.domain.mapper.PokemonListMapperImp
import com.example.pokedex.domain.mapper.SinglePokemonMapperImp
import com.example.pokedex.domain.mapper.abs.PokemonListMapper
import com.example.pokedex.domain.mapper.abs.SinglePokemonMapper
import com.example.pokedex.domain.repository.PokemonListRepository
import com.example.pokedex.domain.repository.SinglePokemonRepository
import com.example.pokedex.domain.usercase.PokemonListUseCaseImp
import com.example.pokedex.domain.usercase.SinglePokemonUseCaseImp
import com.example.pokedex.domain.usercase.abs.PokemonListUseCase
import com.example.pokedex.domain.usercase.abs.SinglePokemonUseCase
import com.example.pokedex.domain.viewmodel.PokemonListViewModel
import com.example.pokedex.domain.viewmodel.SinglePokemonViewModel
import com.example.pokedex.router.PokemonListRouter
import com.example.pokedex.router.abs.PokemonListRouterAbs
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


object Modules {
    private val network = module {

        single {
            Moshi.Builder()
                .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                .build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(OkHttpProfilerInterceptor())
                        .build()
                )
                .build()
        }
    }

    private val api = module {
        single {
            val retrofit: Retrofit = get()
            retrofit.create(PokemonApi::class.java)
        }
    }
    private val paging = module {
        single<PagingSource<Int, Pokemon>> { PokemonListPagingSource(api = get()) }
        single { PagingConfig(PokemonListRepositoryImp.DEFAULT_LIST_SIZE) }
        single { Pager(get()) { get<PagingSource<Int, Pokemon>>() } }
    }

    private val repository = module {
        single<PokemonListRepository> {
            PokemonListRepositoryImp(
                pager = get()
            )
        }
        single<SinglePokemonRepository> {
            SinglePokemonRepositoryImp(
                pokemonApi = get()
            )
        }
    }

    private val mapper = module {
        single<PokemonListMapper> {
            PokemonListMapperImp()
        }
        single<SinglePokemonMapper> {
            SinglePokemonMapperImp()
        }
    }

    private val useCase = module {
        single<PokemonListUseCase> {
            PokemonListUseCaseImp(
                mapper = get(),
                pokemonListRepository = get()
            )
        }
        single<SinglePokemonUseCase> {
            SinglePokemonUseCaseImp(
                mapper = get(),
                singlePokemonRepository = get()
            )
        }
    }

    private val viewModel = module {
        viewModel {
            PokemonListViewModel(
                useCase = get()
            )
        }
        viewModel {
            SinglePokemonViewModel(
                useCase = get()
            )
        }
    }

    private val database = module {
        //TODO
    }

    private val dao = module {
        //TODO
    }


    private val router = module {
        factory<PokemonListRouterAbs> { (navController: NavController) ->
            PokemonListRouter(navController = navController)
        }
    }

    var all = listOf(
        network,
        api,
        paging,
        repository,
        mapper,
        useCase,
        viewModel,
        router

    )
}

