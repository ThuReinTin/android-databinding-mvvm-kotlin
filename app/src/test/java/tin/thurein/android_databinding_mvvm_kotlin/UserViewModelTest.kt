package tin.thurein.android_databinding_mvvm_kotlin

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: UserViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = UserViewModel()
    }

    @Test
    fun usenameEmptyAndPasswordEmpty() {
        var username = ""
        var password = ""
        login(username, password)
        Assert.assertEquals("User name is required", viewModel.usernameError)
    }

    @Test
    fun usenameEmptyAndPasswordNotEmpty() {
        var username = ""
        var password = "ff"
        login(username, password)
        Assert.assertEquals("User name is required", viewModel.usernameError)
    }

    @Test
    fun usenameNotEmptyAndPasswordEmpty() {
        var username = "Jhon Doe"
        var password = ""
        login(username, password)
        Assert.assertEquals("Password is required", viewModel.passwordError)
    }

    @Test
    fun usenameNotEmptyAndPasswordNotEmpty() {
        var username = "Jhon Doe"
        var password = "1234"
        login(username, password)
        Assert.assertEquals(username, viewModel.getUsername())
        Assert.assertEquals(password, viewModel.getPassword())
    }

    private fun login(username: String, password: String) {
        viewModel.setUsername(username)
        viewModel.setPassword(password)
        viewModel.onBtnLoginClick()
    }
}