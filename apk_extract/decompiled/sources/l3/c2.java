package l3;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class c2 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f7211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f7212b;

    public c2(b0 b0Var) {
        if (!(b0Var instanceof e2)) {
            this.f7211a = null;
            this.f7212b = (z) b0Var;
            return;
        }
        e2 e2Var = (e2) b0Var;
        ArrayDeque arrayDeque = new ArrayDeque(e2Var.zzf());
        this.f7211a = arrayDeque;
        arrayDeque.push(e2Var);
        b0 b0Var2 = e2Var.zzd;
        while (b0Var2 instanceof e2) {
            e2 e2Var2 = (e2) b0Var2;
            this.f7211a.push(e2Var2);
            b0Var2 = e2Var2.zzd;
        }
        this.f7212b = (z) b0Var2;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final z next() {
        z zVar;
        z zVar2 = this.f7212b;
        if (zVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.f7211a;
            zVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            b0 b0Var = ((e2) arrayDeque.pop()).zze;
            while (b0Var instanceof e2) {
                e2 e2Var = (e2) b0Var;
                arrayDeque.push(e2Var);
                b0Var = e2Var.zzd;
            }
            zVar = (z) b0Var;
        } while (zVar.zzd() == 0);
        this.f7212b = zVar;
        return zVar2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7212b != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
