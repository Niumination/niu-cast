package af;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicReference;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class f3 extends ze.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f279b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j3 f281d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f278a = new AtomicReference(j3.f344i0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3 f280c = new c3(this);

    public f3(j3 j3Var, String str) {
        this.f281d = j3Var;
        v8.i(str, "authority");
        this.f279b = str;
    }

    @Override // ze.g
    public final String b() {
        return this.f279b;
    }

    @Override // ze.g
    public final ze.j e(ze.r1 r1Var, ze.f fVar) {
        AtomicReference atomicReference = this.f278a;
        Object obj = atomicReference.get();
        t2 t2Var = j3.f344i0;
        if (obj != t2Var) {
            return h(r1Var, fVar);
        }
        j3 j3Var = this.f281d;
        j3Var.f357m.execute(new d3(this, 2));
        if (atomicReference.get() != t2Var) {
            return h(r1Var, fVar);
        }
        if (j3Var.F.get()) {
            return new o0(2);
        }
        e3 e3Var = new e3(this, ze.y.i(), r1Var, fVar);
        j3Var.f357m.execute(new e(19, this, e3Var));
        return e3Var;
    }

    public final ze.j h(ze.r1 r1Var, ze.f fVar) {
        ze.p0 p0Var = (ze.p0) this.f278a.get();
        c3 c3Var = this.f280c;
        if (p0Var == null) {
            return c3Var.e(r1Var, fVar);
        }
        if (!(p0Var instanceof o3)) {
            return new y2(p0Var, c3Var, this.f281d.f352h, r1Var, fVar);
        }
        p3 p3Var = ((o3) p0Var).f483b;
        p3Var.getClass();
        n3 n3Var = (n3) p3Var.f501b.get(r1Var.f11423b);
        if (n3Var == null) {
            n3Var = (n3) p3Var.f502c.get(r1Var.f11424c);
        }
        if (n3Var == null) {
            n3Var = p3Var.f500a;
        }
        if (n3Var != null) {
            fVar = fVar.e(n3.f465g, n3Var);
        }
        return c3Var.e(r1Var, fVar);
    }

    public final void i(ze.p0 p0Var) {
        LinkedHashSet linkedHashSet;
        AtomicReference atomicReference = this.f278a;
        ze.p0 p0Var2 = (ze.p0) atomicReference.get();
        atomicReference.set(p0Var);
        if (p0Var2 != j3.f344i0 || (linkedHashSet = this.f281d.A) == null) {
            return;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((e3) it.next()).j();
        }
    }
}
