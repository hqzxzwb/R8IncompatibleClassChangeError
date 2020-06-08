package zhu.wenbo.r8incompatibleclasschangeerror

import android.os.Build
import android.system.ErrnoException

object KotlinObjectCallee {
    // This function becomes static after R8
    fun foo(): String? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                println("a")
                println("a")
                println("a")
                println("a")
                println("a")
                println("a")
                println("a")
                println("a")
                println("a")
                println("a")
                println("a")
                return "s"
            } catch (e: ErrnoException) { // Prevents inlining.
                throw RuntimeException(e)
            }
        }
        return null
    }
}
