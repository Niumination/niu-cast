package fo;

import eo.h0;
import jp.v;
import kn.l0;
import kn.n0;
import lm.t0;
import nm.d1;
import nm.k0;
import vp.f0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final dp.f f6162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final dp.f f6163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final dp.f f6164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final dp.f f6165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final dp.f f6166e;

    public static final class a extends n0 implements jn.l<h0, f0> {
        final /* synthetic */ ao.h $this_createDeprecatedAnnotation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ao.h hVar) {
            super(1);
            this.$this_createDeprecatedAnnotation = hVar;
        }

        @Override // jn.l
        @os.l
        public final f0 invoke(@os.l h0 h0Var) {
            l0.p(h0Var, "module");
            vp.n0 n0VarL = h0Var.n().l(o1.INVARIANT, this.$this_createDeprecatedAnnotation.W());
            l0.o(n0VarL, "module.builtIns.getArray…ce.INVARIANT, stringType)");
            return n0VarL;
        }
    }

    static {
        dp.f fVarK = dp.f.k("message");
        l0.o(fVarK, "identifier(\"message\")");
        f6162a = fVarK;
        dp.f fVarK2 = dp.f.k("replaceWith");
        l0.o(fVarK2, "identifier(\"replaceWith\")");
        f6163b = fVarK2;
        dp.f fVarK3 = dp.f.k("level");
        l0.o(fVarK3, "identifier(\"level\")");
        f6164c = fVarK3;
        dp.f fVarK4 = dp.f.k("expression");
        l0.o(fVarK4, "identifier(\"expression\")");
        f6165d = fVarK4;
        dp.f fVarK5 = dp.f.k("imports");
        l0.o(fVarK5, "identifier(\"imports\")");
        f6166e = fVarK5;
    }

    @os.l
    public static final c a(@os.l ao.h hVar, @os.l String str, @os.l String str2, @os.l String str3) {
        l0.p(hVar, "<this>");
        l0.p(str, "message");
        l0.p(str2, "replaceWith");
        l0.p(str3, "level");
        j jVar = new j(hVar, ao.k.a.B, d1.W(new t0(f6165d, new v(str2)), new t0(f6166e, new jp.b(k0.INSTANCE, new a(hVar)))));
        dp.c cVar = ao.k.a.f619y;
        t0 t0Var = new t0(f6162a, new v(str));
        t0 t0Var2 = new t0(f6163b, new jp.a(jVar));
        dp.f fVar = f6164c;
        dp.b bVarM = dp.b.m(ao.k.a.A);
        l0.o(bVarM, "topLevel(StandardNames.FqNames.deprecationLevel)");
        dp.f fVarK = dp.f.k(str3);
        l0.o(fVarK, "identifier(level)");
        return new j(hVar, cVar, d1.W(t0Var, t0Var2, new t0(fVar, new jp.j(bVarM, fVarK))));
    }

    public static /* synthetic */ c b(ao.h hVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "WARNING";
        }
        return a(hVar, str, str2, str3);
    }
}
