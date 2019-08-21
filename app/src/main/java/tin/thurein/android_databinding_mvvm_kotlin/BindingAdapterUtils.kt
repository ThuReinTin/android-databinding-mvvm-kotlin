package tin.thurein.android_databinding_mvvm_kotlin

import android.databinding.BindingAdapter
import android.widget.EditText

class BindingAdapterUtils {
    companion object {
        @BindingAdapter("app:error")
        @JvmStatic
        fun setError(et: EditText, error: String?) {
            et.error = error
        }
    }
}