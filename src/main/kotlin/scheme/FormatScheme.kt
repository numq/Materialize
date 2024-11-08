package scheme

import interactor.Interactor

class FormatScheme(private val schemeRepository: SchemeRepository) : Interactor<Scheme, String> {
    override suspend fun execute(input: Scheme) = schemeRepository.formatScheme(scheme = input)
}