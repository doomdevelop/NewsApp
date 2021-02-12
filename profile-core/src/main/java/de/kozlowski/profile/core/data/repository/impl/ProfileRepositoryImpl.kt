package de.kozlowski.profile.core.data.repository.impl

import de.kozlowski.profile.core.data.repository.ProfileCore
import de.kozlowski.profile.core.data.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProfileRepositoryImpl: ProfileRepository {
    override suspend fun getProfile(): Flow<ProfileCore> = flowOf(ProfileCore("Andrzej","Kozlowski","a.kozlowski@protonmail.com"))
}