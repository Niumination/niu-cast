package wl;

import java.nio.ByteBuffer;
import kn.l0;
import pl.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Throwable f19694b;

    public d(@os.l Throwable th2) {
        l0.p(th2, "cause");
        this.f19694b = th2;
    }

    @os.l
    public Void a(int i10) throws Throwable {
        throw this.f19694b;
    }

    @Override // pl.b0
    @os.l
    public ByteBuffer b(int i10, int i11) throws Throwable {
        throw this.f19694b;
    }

    @Override // pl.b0
    public void b0(int i10) throws Throwable {
        throw this.f19694b;
    }

    @os.l
    public final Throwable c() {
        return this.f19694b;
    }

    @Override // pl.d0
    @os.m
    public Object w(int i10, @os.l um.d<? super Boolean> dVar) throws Throwable {
        throw this.f19694b;
    }
}
