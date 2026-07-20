package zg;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Iterator, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f11591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f11592b;

    public l(m mVar) {
        this.f11592b = mVar;
        this.f11591a = mVar.f11593a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11591a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f11592b.f11594b.invoke(this.f11591a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f11591a.remove();
    }
}
