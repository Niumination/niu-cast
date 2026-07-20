package vp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f17755e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final w0 f17756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final eo.d1 f17757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<c1> f17758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Map<eo.e1, c1> f17759d;

    public static final class a {
        public a() {
        }

        @os.l
        public final w0 a(@os.m w0 w0Var, @os.l eo.d1 d1Var, @os.l List<? extends c1> list) {
            kn.l0.p(d1Var, "typeAliasDescriptor");
            kn.l0.p(list, "arguments");
            List<eo.e1> parameters = d1Var.i().getParameters();
            kn.l0.o(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            List<eo.e1> list2 = parameters;
            ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((eo.e1) it.next()).a());
            }
            return new w0(w0Var, d1Var, list, nm.d1.D0(nm.h0.i6(arrayList, list)));
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ w0(w0 w0Var, eo.d1 d1Var, List list, Map map, kn.w wVar) {
        this(w0Var, d1Var, list, map);
    }

    @os.l
    public final List<c1> a() {
        return this.f17758c;
    }

    @os.l
    public final eo.d1 b() {
        return this.f17757b;
    }

    @os.m
    public final c1 c(@os.l a1 a1Var) {
        kn.l0.p(a1Var, "constructor");
        eo.h hVarD = a1Var.d();
        if (hVarD instanceof eo.e1) {
            return this.f17759d.get(hVarD);
        }
        return null;
    }

    public final boolean d(@os.l eo.d1 d1Var) {
        kn.l0.p(d1Var, "descriptor");
        if (!kn.l0.g(this.f17757b, d1Var)) {
            w0 w0Var = this.f17756a;
            if (!(w0Var == null ? false : w0Var.d(d1Var))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w0(w0 w0Var, eo.d1 d1Var, List<? extends c1> list, Map<eo.e1, ? extends c1> map) {
        this.f17756a = w0Var;
        this.f17757b = d1Var;
        this.f17758c = list;
        this.f17759d = map;
    }
}
