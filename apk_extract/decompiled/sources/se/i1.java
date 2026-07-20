package se;

import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f9791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a8.a f9792d;

    public /* synthetic */ i1(NearDevice nearDevice, Function1 function1, a8.a aVar, int i8) {
        this.f9789a = i8;
        this.f9790b = nearDevice;
        this.f9791c = function1;
        this.f9792d = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TranConnectionController$MessageInfo msgInfo = (TranConnectionController$MessageInfo) obj;
        switch (this.f9789a) {
            case 0:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                this.f9790b.d(msgInfo, this.f9791c, this.f9792d);
                break;
            case 1:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                this.f9790b.d(msgInfo, this.f9791c, this.f9792d);
                break;
            default:
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                this.f9790b.d(msgInfo, this.f9791c, this.f9792d);
                break;
        }
        return Unit.INSTANCE;
    }
}
