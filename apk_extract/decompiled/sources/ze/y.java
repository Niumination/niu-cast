package ze;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f11473d = Logger.getLogger(y.class.getName());
    public static final y e = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f11474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1 f11475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11476c;

    public y(y1 y1Var, int i8) {
        this.f11474a = null;
        this.f11475b = y1Var;
        this.f11476c = i8;
        if (i8 == 1000) {
            f11473d.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static y i() {
        ((w2) w.f11460a).getClass();
        y yVar = (y) w2.f11465b.get();
        y yVar2 = e;
        if (yVar == null) {
            yVar = yVar2;
        }
        return yVar == null ? yVar2 : yVar;
    }

    public void a(t tVar, m4.k kVar) {
        h(kVar, "executor");
        s sVar = this.f11474a;
        if (sVar == null) {
            return;
        }
        sVar.s(new v(kVar, tVar, this));
    }

    public y c() {
        ((w2) w.f11460a).getClass();
        ThreadLocal threadLocal = w2.f11465b;
        y yVar = (y) threadLocal.get();
        y yVar2 = e;
        if (yVar == null) {
            yVar = yVar2;
        }
        threadLocal.set(this);
        return yVar == null ? yVar2 : yVar;
    }

    public Throwable g() {
        s sVar = this.f11474a;
        if (sVar == null) {
            return null;
        }
        return sVar.g();
    }

    public void k(y yVar) {
        h(yVar, "toAttach");
        ((w2) w.f11460a).getClass();
        ThreadLocal threadLocal = w2.f11465b;
        y yVar2 = (y) threadLocal.get();
        y yVar3 = e;
        if (yVar2 == null) {
            yVar2 = yVar3;
        }
        if (yVar2 != this) {
            w2.f11464a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (yVar != yVar3) {
            threadLocal.set(yVar);
        } else {
            threadLocal.set(null);
        }
    }

    public z l() {
        s sVar = this.f11474a;
        if (sVar == null) {
            return null;
        }
        return sVar.f11426h;
    }

    public boolean m() {
        s sVar = this.f11474a;
        if (sVar == null) {
            return false;
        }
        return sVar.m();
    }

    public void o(t tVar) {
        s sVar = this.f11474a;
        if (sVar == null) {
            return;
        }
        sVar.w(tVar, this);
    }

    public y(y yVar, y1 y1Var) {
        s sVar;
        if (yVar instanceof s) {
            sVar = (s) yVar;
        } else {
            sVar = yVar.f11474a;
        }
        this.f11474a = sVar;
        this.f11475b = y1Var;
        int i8 = yVar.f11476c + 1;
        this.f11476c = i8;
        if (i8 == 1000) {
            f11473d.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public y() {
        this.f11474a = null;
        this.f11475b = null;
        this.f11476c = 0;
    }
}
