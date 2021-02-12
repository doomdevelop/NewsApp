package de.kozlowski.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.kozlowski.profile.core.data.repository.ProfileRepository
import de.kozlowski.profile.model.ProfileItem
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

internal class ProfileViewModel(private val profileRepository: ProfileRepository) : ViewModel() {
    //display or hide progress loader
    private val _showProgressLiveData = MutableLiveData<Boolean>()
    val showProgressLiveData: LiveData<Boolean> = _showProgressLiveData

    //data
    private val _profileLiveData = MutableLiveData<ProfileItem>()
    val profileLiveData: LiveData<ProfileItem> = _profileLiveData

    init {
        _showProgressLiveData.value = true
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {

            try {
                profileRepository.getProfile().collect { profile ->
                    _profileLiveData.postValue(ProfileItem(profile.name,profile.lastName,profile.email))
                }
            } catch (e: Exception) {
                Timber.e(e, "Could not fetch profile data")
                //todo : provide error to the view
            } finally {
                _showProgressLiveData.postValue(false)
            }
        }
    }

    fun onSwipeRefresh() {
        fetchData()
    }
}