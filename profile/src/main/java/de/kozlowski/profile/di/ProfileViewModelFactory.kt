package de.kozlowski.profile.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.kozlowski.profile.ProfileViewModel
import de.kozlowski.profile.core.data.repository.ProfileRepository

internal class ProfileViewModelFactory (private val profileRepository: ProfileRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(profileRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}