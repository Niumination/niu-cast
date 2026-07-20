package zn;

import dp.b;
import dp.c;
import eo.z0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kn.k1;
import kn.l0;
import no.y;
import no.z;
import os.l;
import os.m;
import wo.p;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f21945a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final Set<b> f21946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final b f21947c;

    /* JADX INFO: renamed from: zn.a$a, reason: collision with other inner class name */
    public static final class C0609a implements p.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f21948a;

        public C0609a(k1.a aVar) {
            this.f21948a = aVar;
        }

        @Override // wo.p.c
        public void a() {
        }

        @Override // wo.p.c
        @m
        public p.a b(@l b bVar, @l z0 z0Var) {
            l0.p(bVar, "classId");
            l0.p(z0Var, "source");
            y.f11796a.getClass();
            if (!l0.g(bVar, y.f11799d)) {
                return null;
            }
            this.f21948a.element = true;
            return null;
        }
    }

    static {
        List listO = nm.y.O(z.f11800a, z.f11810k, z.f11811l, z.f11803d, z.f11805f, z.f11808i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(b.m((c) it.next()));
        }
        f21946b = linkedHashSet;
        b bVarM = b.m(z.f11809j);
        l0.o(bVarM, "topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION)");
        f21947c = bVarM;
    }

    @l
    public final b a() {
        return f21947c;
    }

    @l
    public final Set<b> b() {
        return f21946b;
    }

    public final boolean c(@l p pVar) {
        l0.p(pVar, "klass");
        k1.a aVar = new k1.a();
        pVar.c(new C0609a(aVar), null);
        return aVar.element;
    }
}
