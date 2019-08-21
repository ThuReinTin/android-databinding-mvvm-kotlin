package tin.thurein.android_databinding_mvvm_kotlin

import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.databinding.Bindable

class UserViewModel(private var user: User = User(), private var _nameError: String? = null, private var _passwordError: String? = null) : BaseObservable() {

    var mutableUser : MutableLiveData<User> = MutableLiveData()

    var usernameError : String?
        @Bindable
        get() {
            return _nameError
        }
        set(value) {
            _nameError = value
            notifyPropertyChanged(BR.usernameError)
        }

    var passwordError : String?
        @Bindable
        get() { return _passwordError}
        set(value) {
            _passwordError = value
            notifyPropertyChanged(BR.passwordError)
        }

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

    private fun isValid(): Boolean {
        if (user.username.isBlank()) {
            usernameError = "User name is required"
            return false
        }

        if (user.password.isBlank()) {
            passwordError = "Password is required"
            return false
        }
        return true
    }

    fun onBtnLoginClick() {
        if (isValid()) {
            //emit successful user value to activity
            mutableUser.value = user
        }
    }
}