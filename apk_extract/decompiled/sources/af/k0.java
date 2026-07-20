package af;

import java.util.ArrayList;
import java.util.Iterator;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f375b;

    public e0 a(i4 i4Var) {
        ze.z0 z0Var = ((j3) this.f375b).f365x;
        if (((j3) this.f375b).F.get()) {
            return ((j3) this.f375b).D;
        }
        if (z0Var == null) {
            ((j3) this.f375b).f357m.execute(new f(this, 4));
            return ((j3) this.f375b).D;
        }
        e0 e0VarG = l1.g(z0Var.a(i4Var), Boolean.TRUE.equals(i4Var.f333a.f));
        return e0VarG != null ? e0VarG : ((j3) this.f375b).D;
    }

    public void b(ze.q qVar) {
        v8.i(qVar, "newState");
        if (((ze.q) this.f374a) == qVar || ((ze.q) this.f374a) == ze.q.SHUTDOWN) {
            return;
        }
        this.f374a = qVar;
        if (((ArrayList) this.f375b).isEmpty()) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.f375b;
        this.f375b = new ArrayList();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }
}
