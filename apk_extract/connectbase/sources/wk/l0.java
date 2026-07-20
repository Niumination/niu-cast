package wk;

import androidx.core.app.NotificationCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dk.b f19635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<String> f19636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final n0<m0> f19637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public m0 f19638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends List<? extends k0>> f19639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k0 f19640f;

    public static final class a extends kn.n0 implements jn.l<List<? extends k0>, CharSequence> {
        public static final a INSTANCE = new a();

        /* JADX INFO: renamed from: wk.l0$a$a, reason: collision with other inner class name */
        public static final class C0482a extends kn.n0 implements jn.l<k0, CharSequence> {
            public static final C0482a INSTANCE = new C0482a();

            public C0482a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final CharSequence invoke(@os.l k0 k0Var) {
                kn.l0.p(k0Var, "it");
                return "\"" + k0Var.f19630a.J + '\"';
            }
        }

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l List<? extends k0> list) {
            kn.l0.p(list, "path");
            return nm.h0.m3(list, " -> ", "  ", null, 0, null, C0482a.INSTANCE, 28, null);
        }
    }

    public l0(@os.l dk.b bVar, @os.l List<String> list) {
        kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        kn.l0.p(list, "segments");
        this.f19635a = bVar;
        this.f19636b = list;
        this.f19637c = new n0<>();
    }

    public final void a(@os.l v vVar, int i10) {
        kn.l0.p(vVar, "route");
        this.f19637c.d(new m0(vVar, i10, null, 4, null));
    }

    @os.l
    public final String b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(toString());
        kn.l0.o(sb2, "append(value)");
        sb2.append('\n');
        kn.l0.o(sb2, "append('\\n')");
        m0 m0Var = this.f19638d;
        if (m0Var != null) {
            m0Var.b(sb2, 0);
        }
        if (this.f19639e != null) {
            sb2.append("Matched routes:");
            kn.l0.o(sb2, "append(value)");
            sb2.append('\n');
            kn.l0.o(sb2, "append('\\n')");
            List<? extends List<? extends k0>> list = this.f19639e;
            k0 k0Var = null;
            if (list == null) {
                kn.l0.S("successResults");
                list = null;
            }
            if (list.isEmpty()) {
                sb2.append("  No results");
                kn.l0.o(sb2, "append(value)");
                sb2.append('\n');
                kn.l0.o(sb2, "append('\\n')");
            } else {
                List<? extends List<? extends k0>> list2 = this.f19639e;
                if (list2 == null) {
                    kn.l0.S("successResults");
                    list2 = null;
                }
                sb2.append(nm.h0.m3(list2, "\n", null, null, 0, null, a.INSTANCE, 30, null));
                kn.l0.o(sb2, "append(value)");
                sb2.append('\n');
                kn.l0.o(sb2, "append('\\n')");
            }
            sb2.append("Route resolve result:");
            kn.l0.o(sb2, "append(value)");
            sb2.append('\n');
            kn.l0.o(sb2, "append('\\n')");
            k0 k0Var2 = this.f19640f;
            if (k0Var2 == null) {
                kn.l0.S("finalResult");
            } else {
                k0Var = k0Var2;
            }
            sb2.append(kn.l0.C("  ", k0Var));
            kn.l0.o(sb2, "append(value)");
            sb2.append('\n');
            kn.l0.o(sb2, "append('\\n')");
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void c(@os.l v vVar, int i10, @os.l k0 k0Var) {
        kn.l0.p(vVar, "route");
        kn.l0.p(k0Var, "result");
        m0 m0VarC = this.f19637c.c();
        if (!kn.l0.g(m0VarC.f19643a, vVar)) {
            throw new IllegalArgumentException("end should be called for the same route as begin");
        }
        if (m0VarC.f19644b != i10) {
            throw new IllegalArgumentException("end should be called for the same segmentIndex as begin");
        }
        m0VarC.f19645c = k0Var;
        f(m0VarC);
    }

    @os.l
    public final dk.b d() {
        return this.f19635a;
    }

    @os.l
    public final List<String> e() {
        return this.f19636b;
    }

    public final void f(m0 m0Var) {
        if (this.f19637c.f19648a.isEmpty()) {
            this.f19638d = m0Var;
        } else {
            this.f19637c.b().a(m0Var);
        }
    }

    public final void g(@os.l k0 k0Var) {
        kn.l0.p(k0Var, "result");
        this.f19640f = k0Var;
    }

    public final void h(@os.l List<? extends List<? extends k0>> list) {
        kn.l0.p(list, "successResults");
        this.f19639e = list;
    }

    public final void i(@os.l v vVar, int i10, @os.l k0 k0Var) {
        kn.l0.p(vVar, "route");
        kn.l0.p(k0Var, "result");
        f(new m0(vVar, i10, k0Var));
    }

    @os.l
    public String toString() {
        return kn.l0.C("Trace for ", this.f19636b);
    }
}
