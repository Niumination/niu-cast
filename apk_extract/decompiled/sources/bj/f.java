package bj;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cj.c f1349b;

    public f(cj.c cVar) {
        this.f1349b = cVar;
        this.f1348a = cVar.f1718c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1348a > 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        cj.c cVar = this.f1349b;
        int i8 = this.f1348a;
        this.f1348a = i8 - 1;
        return cVar.e[cVar.f1718c - i8];
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
