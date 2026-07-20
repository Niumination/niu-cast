package vf;

import kotlin.jvm.internal.Intrinsics;
import li.i2;
import li.l0;
import m3.c6;
import m3.j6;
import m3.k6;
import m3.q6;
import zf.f0;
import zf.j0;
import zf.r0;
import zf.s;
import zf.s0;
import zf.t;
import zf.x;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f10557a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f10558b = x.f11553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f10559c = new s();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f10560d = xf.b.f10923a;
    public i2 e = l0.d();
    public final zg.h f = j6.a(true);

    public final d a() {
        r0 r0VarB = this.f10557a.b();
        x xVar = this.f10558b;
        t tVarO = this.f10559c.o();
        Object obj = this.f10560d;
        cg.j jVar = obj instanceof cg.j ? (cg.j) obj : null;
        if (jVar != null) {
            return new d(r0VarB, xVar, tVarO, jVar, this.e, this.f);
        }
        throw new IllegalStateException(("No request transformation found: " + this.f10560d).toString());
    }

    public final void b(ih.a aVar) {
        zg.h hVar = this.f;
        if (aVar != null) {
            hVar.e(i.f10584a, aVar);
            return;
        }
        zg.a key = i.f10584a;
        hVar.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        hVar.c().remove(key);
    }

    public final void c(c builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.e = builder.e;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f10558b = builder.f10558b;
        this.f10560d = builder.f10560d;
        zg.a aVar = i.f10584a;
        zg.h hVar = builder.f;
        b((ih.a) hVar.d(aVar));
        j0 j0Var = this.f10557a;
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        j0 url = builder.f10557a;
        Intrinsics.checkNotNullParameter(url, "url");
        j0Var.f11512d = url.f11512d;
        j0Var.e(url.f11509a);
        j0Var.f(url.f11511c);
        j0Var.d(url.f11514h);
        j0Var.e = url.e;
        j0Var.f = url.f;
        f0 value = c6.a();
        q6.a(value, url.f11515i);
        Intrinsics.checkNotNullParameter(value, "value");
        j0Var.f11515i = value;
        j0Var.f11516j = new s0(value);
        String str = url.f11513g;
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        j0Var.f11513g = str;
        j0Var.f11510b = url.f11510b;
        j0Var.d(j0Var.f11514h);
        q6.a(this.f10559c, builder.f10559c);
        k6.a(this.f, hVar);
    }
}
