package tin.thurein.android_databinding_mvvm_kotlin

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import tin.thurein.android_databinding_mvvm_kotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        //instantiate user view model instance
        val user = User()
        val userViewModel = UserViewModel(user)

        //set user variable in activity_login.xml
        binding.user = userViewModel

        //observe login success
        userViewModel.mutableUser.observe(this, Observer {
            Toast.makeText(this@LoginActivity, "User name : ${it?.username} \n Password : ${it?.password}", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onPause() {
        super.onPause()
        binding.unbind()
    }
}
