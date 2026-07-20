package xn;

import eo.h1;
import eo.t0;
import eo.w0;
import ik.y0;
import java.io.IOException;
import java.util.List;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final c0 f20308a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final gp.c f20309b = gp.c.f6767g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20310a;

        static {
            int[] iArr = new int[un.n.b.values().length];
            iArr[un.n.b.EXTENSION_RECEIVER.ordinal()] = 1;
            iArr[un.n.b.INSTANCE.ordinal()] = 2;
            iArr[un.n.b.VALUE.ordinal()] = 3;
            f20310a = iArr;
        }
    }

    public static final class b extends n0 implements jn.l<h1, CharSequence> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(h1 h1Var) {
            c0 c0Var = c0.f20308a;
            vp.f0 type = h1Var.getType();
            l0.o(type, "it.type");
            return c0Var.h(type);
        }
    }

    public static final class c extends n0 implements jn.l<h1, CharSequence> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(h1 h1Var) {
            c0 c0Var = c0.f20308a;
            vp.f0 type = h1Var.getType();
            l0.o(type, "it.type");
            return c0Var.h(type);
        }
    }

    public final void a(StringBuilder sb2, w0 w0Var) {
        if (w0Var != null) {
            vp.f0 type = w0Var.getType();
            l0.o(type, "receiver.type");
            sb2.append(h(type));
            sb2.append(".");
        }
    }

    public final void b(StringBuilder sb2, eo.a aVar) {
        w0 w0VarI = h0.i(aVar);
        w0 w0VarR = aVar.R();
        a(sb2, w0VarI);
        boolean z10 = (w0VarI == null || w0VarR == null) ? false : true;
        if (z10) {
            sb2.append("(");
        }
        a(sb2, w0VarR);
        if (z10) {
            sb2.append(")");
        }
    }

    public final String c(eo.a aVar) {
        if (aVar instanceof t0) {
            return g((t0) aVar);
        }
        if (aVar instanceof eo.y) {
            return d((eo.y) aVar);
        }
        throw new IllegalStateException(l0.C("Illegal callable: ", aVar).toString());
    }

    @os.l
    public final String d(@os.l eo.y yVar) throws IOException {
        l0.p(yVar, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fun ");
        c0 c0Var = f20308a;
        c0Var.b(sb2, yVar);
        gp.c cVar = f20309b;
        dp.f name = yVar.getName();
        l0.o(name, "descriptor.name");
        sb2.append(cVar.x(name, true));
        List<h1> listH = yVar.h();
        l0.o(listH, "descriptor.valueParameters");
        nm.h0.j3(listH, sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : ", ", (y5.a.f20716e0 & 4) != 0 ? "" : "(", (y5.a.f20716e0 & 8) == 0 ? ")" : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : b.INSTANCE);
        sb2.append(": ");
        vp.f0 returnType = yVar.getReturnType();
        l0.m(returnType);
        l0.o(returnType, "descriptor.returnType!!");
        sb2.append(c0Var.h(returnType));
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public final String e(@os.l eo.y yVar) throws IOException {
        l0.p(yVar, "invoke");
        StringBuilder sb2 = new StringBuilder();
        c0 c0Var = f20308a;
        c0Var.b(sb2, yVar);
        List<h1> listH = yVar.h();
        l0.o(listH, "invoke.valueParameters");
        nm.h0.j3(listH, sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : ", ", (y5.a.f20716e0 & 4) != 0 ? "" : "(", (y5.a.f20716e0 & 8) == 0 ? ")" : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : c.INSTANCE);
        sb2.append(" -> ");
        vp.f0 returnType = yVar.getReturnType();
        l0.m(returnType);
        l0.o(returnType, "invoke.returnType!!");
        sb2.append(c0Var.h(returnType));
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public final String f(@os.l p pVar) {
        l0.p(pVar, "parameter");
        StringBuilder sb2 = new StringBuilder();
        int i10 = a.f20310a[pVar.f20400c.ordinal()];
        if (i10 == 1) {
            sb2.append("extension receiver parameter");
        } else if (i10 == 2) {
            sb2.append("instance parameter");
        } else if (i10 == 3) {
            sb2.append("parameter #" + pVar.f20399b + ' ' + ((Object) pVar.getName()));
        }
        sb2.append(" of ");
        sb2.append(f20308a.c(pVar.f20398a.L()));
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public final String g(@os.l t0 t0Var) {
        l0.p(t0Var, "descriptor");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(t0Var.Q() ? "var " : "val ");
        c0 c0Var = f20308a;
        c0Var.b(sb2, t0Var);
        gp.c cVar = f20309b;
        dp.f name = t0Var.getName();
        l0.o(name, "descriptor.name");
        sb2.append(cVar.x(name, true));
        sb2.append(": ");
        vp.f0 type = t0Var.getType();
        l0.o(type, "descriptor.type");
        sb2.append(c0Var.h(type));
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public final String h(@os.l vp.f0 f0Var) {
        l0.p(f0Var, y0.a.f8215h);
        return f20309b.y(f0Var);
    }
}
