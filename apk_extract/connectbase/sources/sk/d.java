package sk;

import java.io.Closeable;
import nq.l2;
import nq.n1;

/* JADX INFO: loaded from: classes2.dex */
public interface d extends Closeable, n1 {

    public static final class a {
        public static void a(@os.l d dVar) {
            kn.l0.p(dVar, "this");
            try {
                dVar.close();
            } catch (Throwable unused) {
            }
        }
    }

    @os.l
    l2 O1();

    void dispose();
}
