package gb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5130d;
    public int e;

    public d(String deviceName, int i8, int i9, int i10, int i11) {
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.f5127a = i8;
        this.f5128b = deviceName;
        this.f5129c = i9;
        this.f5130d = i10;
        this.e = i11;
    }
}
