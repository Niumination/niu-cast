package zg;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import zf.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Map.Entry, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11609b;

    public x(h0 h0Var) {
        this.f11608a = h0Var.f11503c;
        this.f11609b = h0Var.f11504d;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (Intrinsics.areEqual(entry.getKey(), this.f11608a) && Intrinsics.areEqual(entry.getValue(), this.f11609b)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11608a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f11609b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f11609b.hashCode() ^ this.f11608a.hashCode();
    }

    @Override // java.util.Map.Entry
    public final /* bridge */ /* synthetic */ Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        return this.f11608a + '=' + this.f11609b;
    }
}
