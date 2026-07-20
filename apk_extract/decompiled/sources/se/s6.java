package se;

import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s6 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.c0 f9979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sb.a f9980c;

    public /* synthetic */ s6(com.welink.protocol.nfbd.c0 c0Var, sb.a aVar, int i8) {
        this.f9978a = i8;
        this.f9979b = c0Var;
        this.f9980c = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TranConnectionController$MessageInfo msgInfo = (TranConnectionController$MessageInfo) obj;
        switch (this.f9978a) {
            case 0:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var = this.f9979b;
                sb.a aVar = c0Var.e;
                if (aVar == null) {
                    aVar = this.f9980c;
                }
                c0Var.j(msgInfo, aVar);
                break;
            case 1:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var2 = this.f9979b;
                sb.a aVar2 = c0Var2.e;
                if (aVar2 == null) {
                    aVar2 = this.f9980c;
                }
                c0Var2.j(msgInfo, aVar2);
                break;
            case 2:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var3 = this.f9979b;
                sb.a aVar3 = c0Var3.e;
                if (aVar3 == null) {
                    aVar3 = this.f9980c;
                }
                c0Var3.j(msgInfo, aVar3);
                break;
            case 3:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var4 = this.f9979b;
                sb.a aVar4 = c0Var4.e;
                if (aVar4 == null) {
                    aVar4 = this.f9980c;
                }
                c0Var4.j(msgInfo, aVar4);
                break;
            case 4:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var5 = this.f9979b;
                sb.a aVar5 = c0Var5.e;
                if (aVar5 == null) {
                    aVar5 = this.f9980c;
                }
                c0Var5.j(msgInfo, aVar5);
                break;
            case 5:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var6 = this.f9979b;
                sb.a aVar6 = c0Var6.e;
                if (aVar6 == null) {
                    aVar6 = this.f9980c;
                }
                c0Var6.j(msgInfo, aVar6);
                break;
            case 6:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var7 = this.f9979b;
                sb.a aVar7 = c0Var7.e;
                if (aVar7 == null) {
                    aVar7 = this.f9980c;
                }
                c0Var7.j(msgInfo, aVar7);
                break;
            case 7:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var8 = this.f9979b;
                sb.a aVar8 = c0Var8.e;
                if (aVar8 == null) {
                    aVar8 = this.f9980c;
                }
                c0Var8.j(msgInfo, aVar8);
                break;
            case 8:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var9 = this.f9979b;
                sb.a aVar9 = c0Var9.e;
                if (aVar9 == null) {
                    aVar9 = this.f9980c;
                }
                c0Var9.j(msgInfo, aVar9);
                break;
            case 9:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var10 = this.f9979b;
                sb.a aVar10 = c0Var10.e;
                if (aVar10 == null) {
                    aVar10 = this.f9980c;
                }
                c0Var10.j(msgInfo, aVar10);
                break;
            case 10:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var11 = this.f9979b;
                sb.a aVar11 = c0Var11.e;
                if (aVar11 == null) {
                    aVar11 = this.f9980c;
                }
                c0Var11.j(msgInfo, aVar11);
                break;
            default:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.c0 c0Var12 = this.f9979b;
                sb.a aVar12 = c0Var12.e;
                if (aVar12 == null) {
                    aVar12 = this.f9980c;
                }
                c0Var12.j(msgInfo, aVar12);
                break;
        }
        return Unit.INSTANCE;
    }
}
