package l3;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class b2 extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c2 f7205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f7206b;

    public b2(e2 e2Var) {
        c2 c2Var = new c2(e2Var);
        this.f7205a = c2Var;
        this.f7206b = c2Var.hasNext() ? c2Var.next().iterator() : null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7206b != null;
    }

    @Override // l3.y
    public final byte zza() {
        y yVar = this.f7206b;
        if (yVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = yVar.zza();
        if (!this.f7206b.hasNext()) {
            c2 c2Var = this.f7205a;
            this.f7206b = c2Var.hasNext() ? c2Var.next().iterator() : null;
        }
        return bZza;
    }
}
