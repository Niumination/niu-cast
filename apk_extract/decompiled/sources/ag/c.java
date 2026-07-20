package ag;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Map.Entry, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f758b;

    public c(d dVar, int i8) {
        this.f758b = dVar;
        this.f757a = i8;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f758b.f761c.c(this.f757a).toString();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return CollectionsKt.listOf(this.f758b.f761c.f(this.f757a).toString());
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
