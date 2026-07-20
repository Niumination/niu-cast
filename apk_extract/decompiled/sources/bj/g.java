package bj;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cj.c f1350a;

    public g(cj.c cVar) {
        this.f1350a = cVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new f(this.f1350a);
    }
}
