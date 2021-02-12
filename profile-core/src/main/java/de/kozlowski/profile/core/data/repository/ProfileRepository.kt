package de.kozlowski.profile.core.data.repository

import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getProfile(): Flow<ProfileCore>
}