package gn;

import an.f;
import in.i;
import jn.l;
import kn.l0;
import lm.f1;
import lm.p;
import lm.z0;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "AutoCloseableKt")
public final class a {
    @f1(version = "1.2")
    @z0
    public static final void a(@m AutoCloseable autoCloseable, @m Throwable th2) throws Exception {
        if (autoCloseable != null) {
            if (th2 == null) {
                autoCloseable.close();
                return;
            }
            try {
                autoCloseable.close();
            } catch (Throwable th3) {
                p.a(th2, th3);
            }
        }
    }

    @f1(version = "1.2")
    @f
    public static final <T extends AutoCloseable, R> R b(T t10, l<? super T, ? extends R> lVar) throws Exception {
        l0.p(lVar, "block");
        try {
            R rInvoke = lVar.invoke(t10);
            a(t10, null);
            return rInvoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                a(t10, th2);
                throw th3;
            }
        }
    }
}
