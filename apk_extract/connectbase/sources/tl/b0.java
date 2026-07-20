package tl;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    public static final <C extends Closeable, R> R a(@os.l C c10, @os.l jn.l<? super C, ? extends R> lVar) throws IllegalAccessException, IOException, InvocationTargetException {
        kn.l0.p(c10, "<this>");
        kn.l0.p(lVar, "block");
        try {
            R rInvoke = lVar.invoke(c10);
            c10.close();
            return rInvoke;
        } catch (Throwable th2) {
            try {
                c10.close();
            } catch (Throwable th3) {
                a0.a(th2, th3);
            }
            throw th2;
        }
    }
}
