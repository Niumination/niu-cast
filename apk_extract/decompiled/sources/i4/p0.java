package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class p0 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f5674a;

    public p0(Map.Entry entry) {
        this.f5674a = entry;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5674a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return s1.of(this.f5674a.getValue());
    }
}
