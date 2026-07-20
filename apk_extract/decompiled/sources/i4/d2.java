package i4;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class d2 extends h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5577b;

    public d2(Object obj) {
        this.f5577b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f5576a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5576a) {
            throw new NoSuchElementException();
        }
        this.f5576a = true;
        return this.f5577b;
    }
}
