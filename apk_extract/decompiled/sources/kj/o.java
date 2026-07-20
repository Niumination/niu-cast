package kj;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends gj.a {
    public final /* synthetic */ s e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ qj.f f6929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f6930h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String str, s sVar, int i8, qj.f fVar, int i9, boolean z2) {
        super(str, true);
        this.e = sVar;
        this.f = i8;
        this.f6929g = fVar;
        this.f6930h = i9;
    }

    @Override // gj.a
    public final long a() {
        try {
            d0 d0Var = this.e.f6945m;
            qj.f source = this.f6929g;
            int i8 = this.f6930h;
            d0Var.getClass();
            Intrinsics.checkNotNullParameter(source, "source");
            source.A(i8);
            this.e.f6954y.i(this.f, c.CANCEL);
            synchronized (this.e) {
                this.e.A.remove(Integer.valueOf(this.f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
