package lbc.gallery.domain.usecases.base

/**
 * Created by Safa NAOUI on 19/12/2020.
 */

sealed class Error {
    object NetworkError : Error()
    object GenericError : Error()
    object ResponseError : Error()
    object PersistenceError : Error()
}