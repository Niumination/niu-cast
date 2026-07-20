package ko;

import eo.l1;
import eo.m1;
import java.lang.reflect.Modifier;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface v extends uo.s {

    public static final class a {
        @os.l
        public static m1 a(@os.l v vVar) {
            l0.p(vVar, "this");
            int modifiers = vVar.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                return l1.h.f4620c;
            }
            if (Modifier.isPrivate(modifiers)) {
                return l1.e.f4617c;
            }
            if (Modifier.isProtected(modifiers)) {
                return Modifier.isStatic(modifiers) ? io.a.c.f8288c : io.a.b.f8287c;
            }
            return io.a.C0218a.f8286c;
        }

        public static boolean b(@os.l v vVar) {
            l0.p(vVar, "this");
            return Modifier.isAbstract(vVar.getModifiers());
        }

        public static boolean c(@os.l v vVar) {
            l0.p(vVar, "this");
            return Modifier.isFinal(vVar.getModifiers());
        }

        public static boolean d(@os.l v vVar) {
            l0.p(vVar, "this");
            return Modifier.isStatic(vVar.getModifiers());
        }
    }

    int getModifiers();
}
