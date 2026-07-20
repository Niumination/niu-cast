package dn;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import kn.l0;
import lm.f1;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "CloseableKt")
public final class c {
    @f1(version = "1.1")
    @z0
    public static final void a(@os.m Closeable closeable, @os.m Throwable th2) throws IllegalAccessException, IOException, InvocationTargetException {
        if (closeable != null) {
            if (th2 == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th3) {
                lm.p.a(th2, th3);
            }
        }
    }

    @an.f
    public static final <T extends Closeable, R> R b(T t10, jn.l<? super T, ? extends R> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        l0.p(lVar, "block");
        try {
            R rInvoke = lVar.invoke(t10);
            if (an.m.a(1, 1, 0)) {
                a(t10, null);
            } else if (t10 != null) {
                t10.close();
            }
            return rInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                if (an.m.a(1, 1, 0)) {
                    a(t10, th2);
                } else if (t10 != null) {
                    try {
                        t10.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
    }
}
