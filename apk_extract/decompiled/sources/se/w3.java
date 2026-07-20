package se;

import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class w3 extends SuspendLambda implements Function2 {
    final /* synthetic */ NearDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ boolean $isTrust;
    final /* synthetic */ String $localAddress;
    final /* synthetic */ String $remoteAddress;
    final /* synthetic */ int $reqType;
    final /* synthetic */ int $responseType;
    final /* synthetic */ String $version;
    int label;
    final /* synthetic */ com.welink.protocol.nfbd.p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w3(com.welink.protocol.nfbd.p pVar, String str, String str2, int i8, String str3, int i9, NearDevice nearDevice, boolean z2, String str4, Continuation<? super w3> continuation) {
        super(2, continuation);
        this.this$0 = pVar;
        this.$remoteAddress = str;
        this.$version = str2;
        this.$reqType = i8;
        this.$deviceId = str3;
        this.$responseType = i9;
        this.$device = nearDevice;
        this.$isTrust = z2;
        this.$localAddress = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new w3(this.this$0, this.$remoteAddress, this.$version, this.$reqType, this.$deviceId, this.$responseType, this.$device, this.$isTrust, this.$localAddress, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws JSONException {
        Object objU;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            com.welink.protocol.nfbd.p pVar = this.this$0;
            String str = this.$remoteAddress;
            String str2 = this.$version;
            int i9 = this.$reqType;
            String str3 = this.$deviceId;
            int i10 = this.$responseType;
            NearDevice nearDevice = this.$device;
            boolean z2 = this.$isTrust;
            this.label = 1;
            k kVar = com.welink.protocol.nfbd.p.f4184k;
            objU = pVar.u(str, str2, 0, 47872, i9, str3, "02:00:00:00:00:00", i10, nearDevice, z2, this);
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objU = obj;
        }
        if (((Boolean) objU).booleanValue()) {
            int i11 = this.$responseType;
            if (i11 == 1) {
                com.welink.protocol.nfbd.p pVar2 = this.this$0;
                String str4 = this.$remoteAddress;
                String str5 = this.$localAddress;
                NearDevice nearDevice2 = this.$device;
                k kVar2 = com.welink.protocol.nfbd.p.f4184k;
                pVar2.q(str4, str5, nearDevice2);
            } else if (i11 == 2) {
                com.welink.protocol.nfbd.p pVar3 = this.this$0;
                String str6 = this.$remoteAddress;
                String str7 = this.$localAddress;
                NearDevice nearDevice3 = this.$device;
                k kVar3 = com.welink.protocol.nfbd.p.f4184k;
                pVar3.getClass();
                LanNetworkInfo lanNetworkInfo = new LanNetworkInfo(str6, str7, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4092);
                Iterator it = pVar3.f4188h.iterator();
                while (it.hasNext()) {
                    ((f1) it.next()).b(lanNetworkInfo, nearDevice3);
                }
            } else if (i11 == 3) {
                com.welink.protocol.nfbd.p pVar4 = this.this$0;
                String str8 = this.$remoteAddress;
                String str9 = this.$localAddress;
                NearDevice nearDevice4 = this.$device;
                k kVar4 = com.welink.protocol.nfbd.p.f4184k;
                pVar4.q(str8, str9, nearDevice4);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((w3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
