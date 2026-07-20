package uo;

import java.util.Collection;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends l {

    /* JADX INFO: renamed from: uo.a$a, reason: collision with other inner class name */
    public static final class C0440a {
        public static boolean a(@os.l a aVar) {
            l0.p(aVar, "this");
            return false;
        }

        public static boolean b(@os.l a aVar) {
            l0.p(aVar, "this");
            return false;
        }
    }

    boolean E();

    @os.m
    dp.b f();

    boolean j();

    @os.l
    Collection<b> n();

    @os.m
    g resolve();
}
