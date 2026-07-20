package nk;

import ik.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import jq.e0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final kl.d f11535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final kl.d f11536b;

    public m(@os.l kl.d dVar) {
        l0.p(dVar, "lastModified");
        this.f11535a = dVar;
        this.f11536b = kl.b.e(dVar);
    }

    public static /* synthetic */ m e(m mVar, kl.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = mVar.f11535a;
        }
        return mVar.d(dVar);
    }

    @Override // nk.a0
    @os.l
    public b0 a(@os.l ik.b0 b0Var) {
        List<kl.d> listI;
        List<kl.d> listI2;
        l0.p(b0Var, "requestHeaders");
        j0 j0Var = j0.f8048a;
        j0Var.getClass();
        List<String> listB = b0Var.b(j0.J);
        if (listB != null && (listI2 = i(listB)) != null && !g(listI2)) {
            return b0.NOT_MODIFIED;
        }
        j0Var.getClass();
        List<String> listB2 = b0Var.b(j0.N);
        return (listB2 == null || (listI = i(listB2)) == null || h(listI)) ? b0.OK : b0.PRECONDITION_FAILED;
    }

    @Override // nk.a0
    public void b(@os.l ik.c0 c0Var) {
        l0.p(c0Var, "builder");
        j0.f8048a.getClass();
        c0Var.v(j0.O, ik.r.e(this.f11535a));
    }

    @os.l
    public final kl.d c() {
        return this.f11535a;
    }

    @os.l
    public final m d(@os.l kl.d dVar) {
        l0.p(dVar, "lastModified");
        return new m(dVar);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && l0.g(this.f11535a, ((m) obj).f11535a);
    }

    @os.l
    public final kl.d f() {
        return this.f11535a;
    }

    public final boolean g(@os.l List<kl.d> list) {
        l0.p(list, "dates");
        List<kl.d> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (this.f11536b.compareTo((kl.d) it.next()) > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(@os.l List<kl.d> list) {
        l0.p(list, "dates");
        List<kl.d> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (this.f11536b.compareTo((kl.d) it.next()) > 0) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f11535a.hashCode();
    }

    public final List<kl.d> i(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!e0.S1((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            kl.d dVarB = null;
            if (!it.hasNext()) {
                break;
            }
            try {
                dVarB = ik.r.b((String) it.next());
            } catch (Throwable unused) {
            }
            if (dVarB != null) {
                arrayList2.add(dVarB);
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return arrayList2;
    }

    @os.l
    public String toString() {
        return "LastModifiedVersion(lastModified=" + this.f11535a + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(@os.l Date date) {
        this(kl.a.b(Long.valueOf(date.getTime())));
        l0.p(date, "lastModified");
    }
}
