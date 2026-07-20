package zd;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f11292b;

    public /* synthetic */ l(n nVar, int i8) {
        this.f11291a = i8;
        this.f11292b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11291a) {
            case 0:
                n this$0 = this.f11292b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.c(this$0.f11297b);
                this$0.f11298c = false;
                break;
            case 1:
                n this$1 = this.f11292b;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                this$1.c(this$1.f11297b);
                break;
            case 2:
                n this$2 = this.f11292b;
                Intrinsics.checkNotNullParameter(this$2, "this$0");
                this$2.c(this$2.f11297b);
                this$2.f11298c = false;
                break;
            default:
                n this$3 = this.f11292b;
                Intrinsics.checkNotNullParameter(this$3, "this$0");
                this$3.c(this$3.f11297b);
                this$3.f11298c = false;
                break;
        }
    }
}
