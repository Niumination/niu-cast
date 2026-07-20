package qg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class q0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f9104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9106c;

    public q0() {
        u type = u.f9119b;
        Intrinsics.checkNotNullParameter(type, "type");
        this.f9104a = type;
        this.f9105b = "0.0.0.0";
        this.f9106c = 80;
    }

    @Override // qg.r0
    public final String a() {
        return this.f9105b;
    }

    @Override // qg.r0
    public final int getPort() {
        return this.f9106c;
    }

    @Override // qg.r0
    public final u getType() {
        return this.f9104a;
    }

    public final String toString() {
        return this.f9104a.f9121a + ' ' + this.f9105b + ':' + this.f9106c;
    }
}
