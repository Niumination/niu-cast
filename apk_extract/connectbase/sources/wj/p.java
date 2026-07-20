package wj;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends vj.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f19144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n3 f19145b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19146a;

        static {
            int[] iArr = new int[vj.h.a.values().length];
            f19146a = iArr;
            try {
                iArr[vj.h.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19146a[vj.h.a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19146a[vj.h.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public p(q qVar, n3 n3Var) {
        this.f19144a = (q) c1.h0.F(qVar, "tracer");
        this.f19145b = (n3) c1.h0.F(n3Var, RtspHeaders.Values.TIME);
    }

    public static void d(vj.c1 c1Var, vj.h.a aVar, String str) {
        Level levelF = f(aVar);
        if (q.f19167f.isLoggable(levelF)) {
            q.d(c1Var, levelF, str);
        }
    }

    public static void e(vj.c1 c1Var, vj.h.a aVar, String str, Object... objArr) {
        Level levelF = f(aVar);
        if (q.f19167f.isLoggable(levelF)) {
            q.d(c1Var, levelF, MessageFormat.format(str, objArr));
        }
    }

    public static Level f(vj.h.a aVar) {
        int i10 = a.f19146a[aVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return Level.FINE;
        }
        return i10 != 3 ? Level.FINEST : Level.FINER;
    }

    public static vj.v0.c.b.EnumC0456b g(vj.h.a aVar) {
        int i10 = a.f19146a[aVar.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? vj.v0.c.b.EnumC0456b.CT_INFO : vj.v0.c.b.EnumC0456b.CT_WARNING;
        }
        return vj.v0.c.b.EnumC0456b.CT_ERROR;
    }

    @Override // vj.h
    public void a(vj.h.a aVar, String str) {
        d(this.f19144a.f19169b, aVar, str);
        if (c(aVar)) {
            h(aVar, str);
        }
    }

    @Override // vj.h
    public void b(vj.h.a aVar, String str, Object... objArr) {
        a(aVar, (c(aVar) || q.f19167f.isLoggable(f(aVar))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean c(vj.h.a aVar) {
        return aVar != vj.h.a.DEBUG && this.f19144a.c();
    }

    public final void h(vj.h.a aVar, String str) {
        if (aVar == vj.h.a.DEBUG) {
            return;
        }
        q qVar = this.f19144a;
        vj.v0.c.b.a aVar2 = new vj.v0.c.b.a();
        aVar2.f17318a = str;
        aVar2.f17319b = g(aVar);
        aVar2.f17320c = Long.valueOf(this.f19145b.a());
        qVar.f(aVar2.a());
    }
}
