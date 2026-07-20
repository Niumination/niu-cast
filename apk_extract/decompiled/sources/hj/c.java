package hj;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import qj.b0;
import qj.x;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f5421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5424d;
    public final long e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ dj.m f5425h;

    public c(dj.m mVar, x delegate, long j8) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f5425h = mVar;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f5421a = delegate;
        this.e = j8;
    }

    public final void a() {
        this.f5421a.close();
    }

    @Override // qj.x
    public final b0 b() {
        return this.f5421a.b();
    }

    public final IOException c(IOException iOException) {
        if (this.f5422b) {
            return iOException;
        }
        this.f5422b = true;
        return this.f5425h.a(false, true, iOException);
    }

    @Override // qj.x, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f5424d) {
            return;
        }
        this.f5424d = true;
        long j8 = this.e;
        if (j8 != -1 && this.f5423c != j8) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            a();
            c(null);
        } catch (IOException e) {
            throw c(e);
        }
    }

    @Override // qj.x, java.io.Flushable
    public final void flush() throws IOException {
        try {
            g();
        } catch (IOException e) {
            throw c(e);
        }
    }

    public final void g() {
        this.f5421a.flush();
    }

    @Override // qj.x
    public final void k0(qj.f source, long j8) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f5424d) {
            throw new IllegalStateException("closed");
        }
        long j10 = this.e;
        if (j10 != -1 && this.f5423c + j8 > j10) {
            throw new ProtocolException("expected " + j10 + " bytes but received " + (this.f5423c + j8));
        }
        try {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f5421a.k0(source, j8);
            this.f5423c += j8;
        } catch (IOException e) {
            throw c(e);
        }
    }

    public final String toString() {
        return c.class.getSimpleName() + '(' + this.f5421a + ')';
    }
}
