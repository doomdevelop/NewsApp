package de.kozlowski.profile.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class ProfileItem(val name:String,val lastName:String,val email:String) : Parcelable
