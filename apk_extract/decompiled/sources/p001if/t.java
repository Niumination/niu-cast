package p001if;

import af.i4;
import androidx.core.app.NotificationCompat;
import k3.u8;
import k3.v8;
import o6.a;
import ze.q2;
import ze.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f5848a;

    public t(q2 q2Var) {
        v8.i(q2Var, NotificationCompat.CATEGORY_STATUS);
        this.f5848a = q2Var;
    }

    @Override // ze.z0
    public final x0 a(i4 i4Var) {
        q2 q2Var = this.f5848a;
        return q2Var.e() ? x0.e : x0.a(q2Var);
    }

    @Override // p001if.v
    public final boolean b(v vVar) {
        if (vVar instanceof t) {
            t tVar = (t) vVar;
            q2 q2Var = tVar.f5848a;
            q2 q2Var2 = this.f5848a;
            if (u8.a(q2Var2, q2Var) || (q2Var2.e() && tVar.f5848a.e())) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        a aVar = new a(t.class.getSimpleName());
        aVar.d(this.f5848a, NotificationCompat.CATEGORY_STATUS);
        return aVar.toString();
    }
}
