package ok;

import java.util.Iterator;
import jq.e0;
import kn.l0;
import lm.i0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final void a(@os.l e eVar, int i10) {
        l0.p(eVar, "<this>");
        if (eVar instanceof u) {
            c(i10, "STRING[" + jq.r.Companion.c(((u) eVar).f12301a) + ']');
            return;
        }
        if (eVar instanceof r) {
            c(i10, "STRING[" + ((r) eVar).f12299a + ']');
            return;
        }
        if (eVar instanceof j) {
            StringBuilder sb2 = new StringBuilder("NAMED[");
            j jVar = (j) eVar;
            sb2.append(jVar.f12293a);
            sb2.append(']');
            c(i10, sb2.toString());
            a(jVar.f12294b, i10 + 2);
            return;
        }
        if (eVar instanceof s) {
            c(i10, "SEQUENCE");
            Iterator<T> it = ((s) eVar).f12300a.iterator();
            while (it.hasNext()) {
                a((e) it.next(), i10 + 2);
            }
            return;
        }
        if (eVar instanceof k) {
            c(i10, "OR");
            Iterator<T> it2 = ((k) eVar).f12295a.iterator();
            while (it2.hasNext()) {
                a((e) it2.next(), i10 + 2);
            }
            return;
        }
        if (eVar instanceof i) {
            c(i10, "MAYBE");
            a(((i) eVar).f12292a, i10 + 2);
            return;
        }
        if (eVar instanceof h) {
            c(i10, "MANY");
            a(((h) eVar).f12291a, i10 + 2);
            return;
        }
        if (eVar instanceof b) {
            c(i10, "MANY_NOT_EMPTY");
            a(((b) eVar).f12289a, i10 + 2);
            return;
        }
        if (eVar instanceof a) {
            c(i10, "ANY_OF[" + jq.r.Companion.c(((a) eVar).f12288a) + ']');
            return;
        }
        if (!(eVar instanceof q)) {
            throw new i0();
        }
        StringBuilder sb3 = new StringBuilder("RANGE[");
        q qVar = (q) eVar;
        sb3.append(qVar.f12297a);
        sb3.append('-');
        sb3.append(qVar.f12298b);
        sb3.append(']');
        c(i10, sb3.toString());
    }

    public static /* synthetic */ void b(e eVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        a(eVar, i10);
    }

    public static final void c(int i10, Object obj) {
        System.out.println((Object) (e0.e2(" ", i10) + (i10 / 2) + ": " + obj));
    }
}
