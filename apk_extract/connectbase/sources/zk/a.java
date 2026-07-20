package zk;

import dk.e;
import ik.y0;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.nio.file.WatchEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import kotlin.Metadata;
import nm.h0;
import nm.y;
import os.l;
import os.m;
import rm.g;
import un.d;
import un.i;
import un.n;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final ThreadLocal<List<String>> f21942a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final Class<e> f21943b = e.class;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final Class<dk.a> f21944c = dk.a.class;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: zk.a$a, reason: collision with other inner class name */
    public static final class C0606a<R> extends n0 implements jn.l<i<? extends R>, Comparable<?>> {
        public static final C0606a INSTANCE = new C0606a();

        public C0606a() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Comparable<?> invoke(@l i<? extends R> iVar) {
            l0.p(iVar, "it");
            boolean z10 = false;
            if (!iVar.getParameters().isEmpty() && a.g(iVar.getParameters().get(0))) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class b<R> extends n0 implements jn.l<i<? extends R>, Comparable<?>> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Comparable<?> invoke(@l i<? extends R> iVar) {
            l0.p(iVar, "it");
            List<n> parameters = iVar.getParameters();
            int i10 = 0;
            if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    if (!((n) it.next()).z() && (i10 = i10 + 1) < 0) {
                        y.Y();
                    }
                }
            }
            return Integer.valueOf(i10);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class c<R> extends n0 implements jn.l<i<? extends R>, Comparable<?>> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Comparable<?> invoke(@l i<? extends R> iVar) {
            l0.p(iVar, "it");
            return Integer.valueOf(iVar.getParameters().size());
        }
    }

    @m
    public static final <R> i<R> a(@l List<? extends i<? extends R>> list) {
        l0.p(list, "<this>");
        return (i) h0.v3(h0.u5(list, g.h(C0606a.INSTANCE, b.INSTANCE, c.INSTANCE)));
    }

    @l
    public static final Class<dk.a> b() {
        return f21944c;
    }

    @l
    public static final Class<e> c() {
        return f21943b;
    }

    @l
    public static final ThreadLocal<List<String>> d() {
        return f21942a;
    }

    @m
    public static final WatchEvent.Modifier e() {
        try {
            Class<?> cls = Class.forName("com.sun.nio.file.SensitivityWatchEventModifier");
            Object obj = cls.getField("HIGH").get(cls);
            if (obj instanceof WatchEvent.Modifier) {
                return (WatchEvent.Modifier) obj;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final boolean f(@l i<?> iVar) {
        l0.p(iVar, "<this>");
        if (iVar.isOperator() || iVar.isInfix() || iVar.isInline() || iVar.isAbstract() || iVar.isSuspend()) {
            return false;
        }
        n nVarD = vn.e.d(iVar);
        if (nVarD != null && !g(nVarD) && !h(nVarD)) {
            return false;
        }
        Method methodE = wn.e.e(iVar);
        if (methodE != null) {
            if (methodE.isSynthetic()) {
                return false;
            }
            if (Modifier.isStatic(methodE.getModifiers()) && iVar.getParameters().isEmpty()) {
                return false;
            }
        }
        List<n> parameters = iVar.getParameters();
        if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
            for (n nVar : parameters) {
                if (!g(nVar) && !h(nVar) && nVar.getKind() != n.b.INSTANCE && !nVar.z()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean g(@l n nVar) {
        l0.p(nVar, "parameter");
        return i(nVar, f21944c);
    }

    public static final boolean h(@l n nVar) {
        l0.p(nVar, "parameter");
        return i(nVar, f21943b);
    }

    public static final boolean i(@l n nVar, @l Class<?> cls) {
        l0.p(nVar, "parameter");
        l0.p(cls, y0.a.f8215h);
        Type typeG = wn.e.g(nVar.getType());
        Class<?> cls2 = typeG instanceof Class ? (Class) typeG : null;
        if (cls2 == null) {
            return false;
        }
        return cls.isAssignableFrom(cls2);
    }

    @m
    public static final Class<?> j(@l ClassLoader classLoader, @l String str) {
        l0.p(classLoader, "<this>");
        l0.p(str, "name");
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @m
    public static final d<?> k(@l Class<?> cls) {
        l0.p(cls, "<this>");
        Metadata metadata = (Metadata) cls.getAnnotation(Metadata.class);
        if (metadata == null || metadata.k() != 1) {
            metadata = null;
        }
        if (metadata != null) {
            return in.b.i(cls);
        }
        return null;
    }
}
