package se;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u2 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b3 f10015b;

    public /* synthetic */ u2(b3 b3Var, int i8) {
        this.f10014a = i8;
        this.f10015b = b3Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f10014a) {
            case 0:
                jf.e HttpClient = (jf.e) obj;
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                qg.y0 block = new qg.y0(5);
                HttpClient.getClass();
                Intrinsics.checkNotNullParameter(block, "block");
                HttpClient.f6268d = new gi.a(2, HttpClient.f6268d, block);
                HttpClient.a(pf.e1.f8839b, new u2(this.f10015b, 1));
                HttpClient.a(sf.k.f10096a, new qg.y0(6));
                HttpClient.a(uf.m.f10434d, new qg.y0(7));
                break;
            default:
                pf.a1 install = (pf.a1) obj;
                Intrinsics.checkNotNullParameter(install, "$this$install");
                b3 b3Var = this.f10015b;
                Long lValueOf = Long.valueOf(b3Var.f9657b);
                install.getClass();
                pf.a1.a(lValueOf);
                install.f8822a = lValueOf;
                long j8 = b3Var.f9657b;
                Long lValueOf2 = Long.valueOf(j8);
                pf.a1.a(lValueOf2);
                install.f8823b = lValueOf2;
                Long lValueOf3 = Long.valueOf(j8);
                pf.a1.a(lValueOf3);
                install.f8824c = lValueOf3;
                break;
        }
        return Unit.INSTANCE;
    }
}
