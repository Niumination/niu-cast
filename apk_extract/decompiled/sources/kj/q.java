package kj;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends gj.a {
    public final /* synthetic */ int e;
    public final /* synthetic */ s f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f6934h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(String str, s sVar, int i8, c cVar, int i9) {
        super(str, true);
        this.e = i9;
        this.f = sVar;
        this.f6933g = i8;
        this.f6934h = cVar;
    }

    @Override // gj.a
    public final long a() {
        switch (this.e) {
            case 0:
                d0 d0Var = this.f.f6945m;
                c errorCode = this.f6934h;
                d0Var.getClass();
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                synchronized (this.f) {
                    this.f.A.remove(Integer.valueOf(this.f6933g));
                    Unit unit = Unit.INSTANCE;
                }
                return -1L;
            default:
                s sVar = this.f;
                try {
                    int i8 = this.f6933g;
                    c statusCode = this.f6934h;
                    sVar.getClass();
                    Intrinsics.checkNotNullParameter(statusCode, "statusCode");
                    sVar.f6954y.i(i8, statusCode);
                    break;
                } catch (IOException e) {
                    sVar.c(e);
                }
                return -1L;
        }
    }
}
