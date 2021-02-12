package de.kozlowski.profile.core.di

import de.kozlowski.profile.core.data.repository.impl.ProfileRepositoryImpl

object ProfileCoreDiProvider {
    val profileRepository by lazy { ProfileRepositoryImpl() }
}