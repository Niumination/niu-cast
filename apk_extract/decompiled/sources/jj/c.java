package jj;

import af.i;
import dj.b0;
import dj.l;
import dj.s;
import dj.u;
import hj.m;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import qj.t;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6321d;
    public boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f6322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g f6323i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar, u url) {
        super(gVar);
        Intrinsics.checkNotNullParameter(url, "url");
        this.f6323i = gVar;
        this.f6322h = url;
        this.f6321d = -1L;
        this.e = true;
    }

    @Override // jj.a, qj.z
    public final long W(qj.f sink, long j8) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(o.d.j("byteCount < 0: ", j8).toString());
        }
        if (this.f6316b) {
            throw new IllegalStateException("closed");
        }
        if (!this.e) {
            return -1L;
        }
        long j10 = this.f6321d;
        g gVar = this.f6323i;
        if (j10 == 0 || j10 == -1) {
            if (j10 != -1) {
                ((t) gVar.f6333g).l(Long.MAX_VALUE);
            }
            try {
                this.f6321d = ((t) gVar.f6333g).h();
                String string = StringsKt__StringsKt.trim((CharSequence) ((t) gVar.f6333g).l(Long.MAX_VALUE)).toString();
                if (this.f6321d < 0 || (string.length() > 0 && !StringsKt__StringsJVMKt.startsWith$default(string, ";", false, 2, null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f6321d + string + Typography.quote);
                }
                if (this.f6321d == 0) {
                    this.e = false;
                    gVar.f6332d = ((i) gVar.f6331c).a();
                    b0 b0Var = (b0) gVar.e;
                    Intrinsics.checkNotNull(b0Var);
                    l lVar = b0Var.f4503l;
                    s sVar = (s) gVar.f6332d;
                    Intrinsics.checkNotNull(sVar);
                    ij.e.b(lVar, this.f6322h, sVar);
                    a();
                }
                if (!this.e) {
                    return -1L;
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }
        long jW = super.W(sink, Math.min(j8, this.f6321d));
        if (jW != -1) {
            this.f6321d -= jW;
            return jW;
        }
        ((m) gVar.f).k();
        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
        a();
        throw protocolException;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f6316b) {
            return;
        }
        if (this.e && !ej.b.h(this, TimeUnit.MILLISECONDS)) {
            ((m) this.f6323i.f).k();
            a();
        }
        this.f6316b = true;
    }
}
