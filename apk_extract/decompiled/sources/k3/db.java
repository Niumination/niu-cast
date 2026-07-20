package k3;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class db {
    public static le.a a() {
        Log.d("ServerUtils", "createServer port:0");
        try {
            ze.e0 e0Var = (ze.e0) ze.i.h(new ze.j0());
            ((cf.y) e0Var).f1658a.n(new p2.d());
            ze.b2 b2VarO = ((cf.y) e0Var).f1658a.o();
            b2VarO.b();
            Log.d("ServerUtils", "server:" + b2VarO);
            return new le.a(true, (af.w5) b2VarO, null);
        } catch (Exception e) {
            Log.d("ServerUtils", "createServer exception:" + e);
            return new le.a(false, null, e);
        }
    }
}
