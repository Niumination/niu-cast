package se;

import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r6 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.c0 f9968b;

    public /* synthetic */ r6(com.welink.protocol.nfbd.c0 c0Var, int i8) {
        this.f9967a = i8;
        this.f9968b = c0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TranConnectionController$MessageInfo msgInfo = (TranConnectionController$MessageInfo) obj;
        switch (this.f9967a) {
            case 0:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var = this.f9968b;
                c0Var.j(msgInfo, c0Var.e);
                break;
            case 1:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var2 = this.f9968b;
                c0Var2.j(msgInfo, c0Var2.e);
                break;
            case 2:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var3 = this.f9968b;
                c0Var3.j(msgInfo, c0Var3.e);
                break;
            default:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var4 = this.f9968b;
                c0Var4.j(msgInfo, c0Var4.e);
                break;
        }
        return Unit.INSTANCE;
    }
}
