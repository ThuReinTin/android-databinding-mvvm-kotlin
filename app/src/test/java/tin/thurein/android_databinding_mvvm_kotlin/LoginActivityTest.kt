package tin.thurein.android_databinding_mvvm_kotlin

import android.widget.Button
import android.widget.EditText
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.Robolectric.buildActivity
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
class LoginActivityTest {

    private fun getActivity(): LoginActivity {
        val controller = buildActivity(LoginActivity::class.java).setup()
        val activity = controller.resume().get()
        return activity
    }
    @Test
    fun activityNotNull() {
        assertNotNull(getActivity())
    }

    private fun login(name: String, password: String, message: String, destination: Int, isSuccess: Boolean) {
        val activity = getActivity()
        val etUsername: EditText = activity.findViewById(R.id.etUsername)
        val etPassword: EditText = activity.findViewById(R.id.etPassword)
        val btnLogin: Button = activity.findViewById(R.id.btnLogin)

        assertNotNull(etUsername)
        assertNotNull(etPassword)
        assertNotNull(btnLogin)

        etUsername.setText(name)
        etPassword.setText(password)

        if (btnLogin.performClick()) {
            if (isSuccess) {
                assertThat(ShadowToast.getTextOfLatestToast(), equalTo(message))
            } else {
                assertThat(if (destination == R.id.etUsername) etUsername.error.toString() else etPassword.error.toString(), equalTo(message))
            }
        }
    }

    @Test
    fun loginTest() {
        val name = ""
        val password = ""
        val message = "User name is required"
        val destination = R.id.etUsername
        val isSuccess = false

        login(name, password, message, destination, isSuccess)
    }
}