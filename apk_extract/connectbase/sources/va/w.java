package va;

import android.os.UserHandle;
import vd.m0;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16847c = "w";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m0 f16848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.x f16849b;

    public int a() {
        return b(fc.b.a.f5982b).a();
    }

    public pg.p b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16847c, "TranThubUserHandleManager");
            m0 m0Var = this.f16848a;
            if (m0Var != null) {
                return m0Var;
            }
            m0 m0Var2 = new m0();
            this.f16848a = m0Var2;
            return m0Var2;
        }
        dc.e.f(f16847c, "TranAospUserHandleManager");
        e8.x xVar = this.f16849b;
        if (xVar != null) {
            return xVar;
        }
        e8.x xVar2 = new e8.x();
        this.f16849b = xVar2;
        return xVar2;
    }

    public int c(UserHandle userHandle) {
        if (userHandle != null) {
            return b(fc.b.a.f5985e).b(userHandle);
        }
        throw new IllegalArgumentException("handle can not be null");
    }
}
