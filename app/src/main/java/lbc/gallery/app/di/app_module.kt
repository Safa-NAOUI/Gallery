package lbc.gallery.app.di

/**
 * Created by Safa NAOUI on 28/12/2020.
 */

import kotlinx.coroutines.ObsoleteCoroutinesApi
import lbc.gallery.app.utils.API
import lbc.gallery.app.utils.BASE_URL
import lbc.gallery.app.utils.GET_NEWS_USECASE
import lbc.gallery.app.utils.OKHTTP_INSTANCE
import lbc.gallery.app.viewmodel.AlbumListViewModel
import lbc.gallery.data.api.service.AlbumService
import lbc.gallery.data.repositories.remote.AlbumRepositoryImp
import lbc.gallery.domain.repository.AlbumRepository
import lbc.gallery.domain.usecases.GetAlbumUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModules = module {
    single(named("remote")) { AlbumRepositoryImp(get(named(API))) as AlbumRepository }
}
val useCaseModules = module {
    factory(named(GET_NEWS_USECASE)) {
        GetAlbumUseCase(get(named("remote")))
    }
}
val networkModules = module {
    single(named(OKHTTP_INSTANCE)) { createOkHttpClient() }
    single(named(API)) { createWebService<AlbumService>(get(named(OKHTTP_INSTANCE)), BASE_URL) }
}

@ObsoleteCoroutinesApi
val viewModels = module {
    viewModel {
        AlbumListViewModel(get(named(GET_NEWS_USECASE)))
    }
}
