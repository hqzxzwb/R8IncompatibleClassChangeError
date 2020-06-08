package zhu.wenbo.r8incompatibleclasschangeerror

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JavaCaller().caller()
        JavaCaller().caller2()
    }
}