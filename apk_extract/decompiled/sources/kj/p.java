package kj;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends gj.a {
    public final /* synthetic */ int e = 1;
    public final /* synthetic */ s f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f6932h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(String str, s sVar, int i8, List list) {
        super(str, true);
        this.f = sVar;
        this.f6931g = i8;
        this.f6932h = list;
    }

    @Override // gj.a
    public final long a() {
        switch (this.e) {
            case 0:
                d0 d0Var = this.f.f6945m;
                List responseHeaders = this.f6932h;
                d0Var.getClass();
                Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                try {
                    this.f.f6954y.i(this.f6931g, c.CANCEL);
                    synchronized (this.f) {
                        this.f.A.remove(Integer.valueOf(this.f6931g));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            default:
                d0 d0Var2 = this.f.f6945m;
                List requestHeaders = this.f6932h;
                d0Var2.getClass();
                Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
                try {
                    this.f.f6954y.i(this.f6931g, c.CANCEL);
                    synchronized (this.f) {
                        this.f.A.remove(Integer.valueOf(this.f6931g));
                    }
                    return -1L;
                } catch (IOException unused2) {
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(String str, s sVar, int i8, List list, boolean z2) {
        super(str, true);
        this.f = sVar;
        this.f6931g = i8;
        this.f6932h = list;
    }
}
