package tin.thurein.android_databinding_mvvm_kotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import tin.thurein.android_databinding_mvvm_kotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
         val user = User()
        val userViewModel = UserViewModel(user)
        binding.user = userViewModel
    }

    override fun onPause() {
        super.onPause()
        binding.unbind()
    }
}
