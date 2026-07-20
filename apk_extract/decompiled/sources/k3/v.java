package k3;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6673c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y f6674d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y f6675h;

    public /* synthetic */ v(y yVar, int i8) {
        this.e = i8;
        this.f6675h = yVar;
        this.f6674d = yVar;
        this.f6671a = yVar.f6713b;
        this.f6672b = yVar.zze();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6672b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object xVar;
        y yVar = this.f6674d;
        if (yVar.f6713b != this.f6671a) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f6672b;
        this.f6673c = i8;
        switch (this.e) {
            case 0:
                Object[] objArr = this.f6675h.zzb;
                objArr.getClass();
                xVar = objArr[i8];
                break;
            case 1:
                Object[] objArr2 = this.f6675h.zzc;
                objArr2.getClass();
                xVar = objArr2[i8];
                break;
            default:
                xVar = new x(this.f6675h, i8);
                break;
        }
        this.f6672b = yVar.zzf(this.f6672b);
        return xVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        y yVar = this.f6674d;
        if (yVar.f6713b != this.f6671a) {
            throw new ConcurrentModificationException();
        }
        na.c("no calls to next() since the last call to remove()", this.f6673c >= 0);
        this.f6671a += 32;
        int i8 = this.f6673c;
        Object[] objArr = yVar.zzb;
        objArr.getClass();
        yVar.remove(objArr[i8]);
        this.f6672b--;
        this.f6673c = -1;
    }
}
