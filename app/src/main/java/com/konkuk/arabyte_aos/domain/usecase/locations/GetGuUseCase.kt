package com.konkuk.arabyte_aos.domain.usecase.locations

import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.repository.LocationsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetGuUseCase @Inject constructor(
    private val locationsRepository: LocationsRepository
) {
    suspend operator fun invoke(sidoCode: String): Result<List<LocationData>> {
        return locationsRepository.getGu(sidoCode)
    }
}
