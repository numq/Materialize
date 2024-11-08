package scheme

import interactor.Interactor
import kotlinx.coroutines.flow.StateFlow

class GetScheme(private val schemeRepository: SchemeRepository) : Interactor<Unit, StateFlow<Scheme>> {
    override suspend fun execute(input: Unit) = Result.success(schemeRepository.scheme)
}