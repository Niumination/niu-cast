package hj;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import qj.z;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends qj.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5428d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f5429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ dj.m f5430i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(dj.m mVar, z delegate, long j8) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f5430i = mVar;
        this.f5429h = j8;
        this.f5427c = true;
        if (j8 == 0) {
            a(null);
        }
    }

    @Override // qj.z
    public final long W(qj.f sink, long j8) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.e) {
            throw new IllegalStateException("closed");
        }
        try {
            long jW = this.f9198a.W(sink, j8);
            if (this.f5427c) {
                this.f5427c = false;
                dj.m mVar = this.f5430i;
                mVar.getClass();
                i call = (i) mVar.f4610b;
                Intrinsics.checkNotNullParameter(call, "call");
            }
            if (jW == -1) {
                a(null);
                return -1L;
            }
            long j10 = this.f5426b + jW;
            long j11 = this.f5429h;
            if (j11 == -1 || j10 <= j11) {
                this.f5426b = j10;
                if (j10 == j11) {
                    a(null);
                }
                return jW;
            }
            throw new ProtocolException("expected " + j11 + " bytes but received " + j10);
        } catch (IOException e) {
            throw a(e);
        }
    }

    public final IOException a(IOException iOException) {
        if (this.f5428d) {
            return iOException;
        }
        this.f5428d = true;
        dj.m mVar = this.f5430i;
        if (iOException == null && this.f5427c) {
            this.f5427c = false;
            mVar.getClass();
            i call = (i) mVar.f4610b;
            Intrinsics.checkNotNullParameter(call, "call");
        }
        return mVar.a(true, false, iOException);
    }

    @Override // qj.k, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.e) {
            return;
        }
        this.e = true;
        try {
            super.close();
            a(null);
        } catch (IOException e) {
            throw a(e);
        }
    }
}
