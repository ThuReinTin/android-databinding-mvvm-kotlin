package tin.thurein.android_databinding_mvvm_kotlin

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log

class UserViewModel(private var user: User = User()) : BaseObservable() {

    @Bindable
    fun getUsername(): String {
        return this.user.username
    }

    fun setUsername(username: String) {
        this.user.username = username
        notifyPropertyChanged(BR.username)
    }

    @Bindable
    fun getPassword(): String {
        return this.user.password
    }

    fun setPassword(password: String) {
        this.user.password = password
        notifyPropertyChanged(BR.password)
    }

    fun onBtnLoginClick() {
        Log.e("OnClick", user.username)
    }
}