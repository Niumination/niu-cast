package rq;

import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
@z0
public final class m implements xm.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final xm.e f14847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public final StackTraceElement f14848b;

    public m(@os.m xm.e eVar, @os.l StackTraceElement stackTraceElement) {
        this.f14847a = eVar;
        this.f14848b = stackTraceElement;
    }

    @Override // xm.e
    @os.m
    public xm.e getCallerFrame() {
        return this.f14847a;
    }

    @Override // xm.e
    @os.l
    public StackTraceElement getStackTraceElement() {
        return this.f14848b;
    }
}
