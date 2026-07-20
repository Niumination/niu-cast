package go;

import eo.y0;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final a f6753a = new a();

        @Override // go.c
        public boolean c(@l eo.e eVar, @l y0 y0Var) {
            l0.p(eVar, "classDescriptor");
            l0.p(y0Var, "functionDescriptor");
            return true;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final b f6754a = new b();

        @Override // go.c
        public boolean c(@l eo.e eVar, @l y0 y0Var) {
            l0.p(eVar, "classDescriptor");
            l0.p(y0Var, "functionDescriptor");
            return !y0Var.getAnnotations().p(d.a());
        }
    }

    boolean c(@l eo.e eVar, @l y0 y0Var);
}
