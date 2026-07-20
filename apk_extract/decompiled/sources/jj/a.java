package jj;

import hj.m;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import qj.b0;
import qj.l;
import qj.t;
import qj.z;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f6315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f6317c;

    public a(g gVar) {
        this.f6317c = gVar;
        this.f6315a = new l(((t) gVar.f6333g).f9221a.b());
    }

    @Override // qj.z
    public long W(qj.f sink, long j8) throws IOException {
        g gVar = this.f6317c;
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            return ((t) gVar.f6333g).W(sink, j8);
        } catch (IOException e) {
            ((m) gVar.f).k();
            a();
            throw e;
        }
    }

    public final void a() {
        g gVar = this.f6317c;
        int i8 = gVar.f6330b;
        if (i8 == 6) {
            return;
        }
        if (i8 == 5) {
            g.i(gVar, this.f6315a);
            gVar.f6330b = 6;
        } else {
            throw new IllegalStateException("state: " + gVar.f6330b);
        }
    }

    @Override // qj.z
    public final b0 b() {
        return this.f6315a;
    }
}
