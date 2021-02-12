package de.kozlowski.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import de.kozlowski.profile.core.di.ProfileCoreDiProvider
import de.kozlowski.profile.databinding.FragmentProfileTabBinding
import de.kozlowski.profile.di.ProfileViewModelFactory

class ProfileTabFragment : Fragment(R.layout.fragment_profile_tab) {

    private val profileViewModelFactory: ProfileViewModelFactory by lazy {
        ProfileViewModelFactory(ProfileCoreDiProvider.profileRepository)
    }

    private val viewModel: ProfileViewModel by lazy {
        ViewModelProvider(this, profileViewModelFactory)
            .get(ProfileViewModel::class.java)
    }

    private var _binding: FragmentProfileTabBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileTabBinding.inflate(inflater, container, false).apply {
            this.profileViewModel = this@ProfileTabFragment.viewModel
            this.lifecycleOwner = this@ProfileTabFragment.viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.profileLiveData.observe(viewLifecycleOwner, Observer {
            binding.profileName.text = it.name
            binding.profileLastName.text = it.lastName
            binding.profileEmail.text = it.email
        })
    }

}