package i4;

import java.util.Objects;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class t4 extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f5698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient int f5699d;
    public final transient int e;

    public t4(Object[] objArr, int i8, int i9) {
        this.f5698c = objArr;
        this.f5699d = i8;
        this.e = i9;
    }

    @Override // java.util.List
    public Object get(int i8) {
        v8.h(i8, this.e);
        Object obj = this.f5698c[(i8 * 2) + this.f5699d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.e;
    }
}
