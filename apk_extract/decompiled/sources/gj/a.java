package gj;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f5211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5214d;

    public a(String name, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f5213c = name;
        this.f5214d = z2;
        this.f5212b = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f5213c;
    }
}
