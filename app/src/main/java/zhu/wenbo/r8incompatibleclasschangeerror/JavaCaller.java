package zhu.wenbo.r8incompatibleclasschangeerror;

import android.os.Build;

import androidx.annotation.Keep;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

class JavaCaller {
    private int i = Build.VERSION.SDK_INT;

    @Keep
    void caller() {
        Function0<Unit> r = () -> {
            // This call becomes a invoke-virtual and crashes.
            String s = KotlinObjectCallee.INSTANCE.foo();
            System.out.println(i); // This is necessary. Remove this and problem is gone.
            System.out.println(s);
            return Unit.INSTANCE;
        };
        System.out.println(r.invoke());
    }

    @Keep
    void caller2() {
        Function0<Unit> r = new Function0<Unit>() {
            @Override
            public Unit invoke() {
                // This call becomes a invoke-static which is OK.
                String s = KotlinObjectCallee.INSTANCE.foo();
                System.out.println(i); // This is necessary. Remove this and problem is gone.
                System.out.println(s);
                return Unit.INSTANCE;
            }
        };
        System.out.println(r.invoke());
    }
}
