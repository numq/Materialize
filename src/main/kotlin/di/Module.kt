package di

import com.google.gson.Gson
import formatter.FormatterService
import generation.GenerationFeature
import generation.GenerationReducer
import name.NameService
import org.koin.dsl.bind
import org.koin.dsl.module
import scheme.FormatScheme
import scheme.GetScheme
import scheme.SchemeRepository
import scheme.UpdateScheme

private val application = module {
    single { Gson() }
}

private val name = module {
    single { NameService.Default(get()) } bind NameService::class
}

private val formatter = module {
    single { FormatterService.Default(get()) } bind FormatterService::class
}

private val scheme = module {
    single { SchemeRepository.Default(get(), get()) } bind SchemeRepository::class
    factory { FormatScheme(get()) }
    factory { GetScheme(get()) }
    factory { UpdateScheme(get()) }
}

private val generation = module {
    factory { GenerationReducer(get(), get(), get()) }
    single { GenerationFeature(get()) }
}

internal val appModule = application + name + formatter + scheme + generation