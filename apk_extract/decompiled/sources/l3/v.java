package l3;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class v extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7315a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f7317c;

    public v(b0 b0Var) {
        this.f7317c = b0Var;
        this.f7316b = b0Var.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7315a < this.f7316b;
    }

    @Override // l3.y
    public final byte zza() {
        int i8 = this.f7315a;
        if (i8 >= this.f7316b) {
            throw new NoSuchElementException();
        }
        this.f7315a = i8 + 1;
        return this.f7317c.zzb(i8);
    }
}
