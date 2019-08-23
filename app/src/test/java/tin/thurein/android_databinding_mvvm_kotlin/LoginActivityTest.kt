package tin.thurein.android_databinding_mvvm_kotlin

import android.util.Log
import android.widget.Button
import android.widget.EditText
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
class LoginActivityTest {
    lateinit var activity: LoginActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(LoginActivity::class.java)
            .create()
            .get()
    }

    @Test
    fun activityNotNull() {
        Assert.assertNotNull(activity)
    }

    private fun login(name: String, password: String) {
        val etUsername: EditText = activity.findViewById(R.id.etUsername)
        val etPassword: EditText = activity.findViewById(R.id.etPassword)

        assertNotNull(etUsername)
        assertNotNull(etPassword)

        etUsername.setText(name)
        etPassword.setText(password)

        assertThat(etUsername.text.toString(), equalTo(name))
        assertThat(etPassword.text.toString(), equalTo(password))

    }

    @Test
    fun loginTest() {
        val name = ""
        val password = ""

        login(name, password)
    }
}