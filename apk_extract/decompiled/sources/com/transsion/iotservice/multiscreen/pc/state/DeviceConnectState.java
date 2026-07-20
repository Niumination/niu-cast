package com.transsion.iotservice.multiscreen.pc.state;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import eb.y;
import k3.gc;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.h0;
import li.l0;
import li.v0;
import qi.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/state/DeviceConnectState;", "", "<init>", "()V", "", "newState", "", "refreshCastState", "(I)V", "", "isConnecting", "()Z", "isConnected", "", "TAG", "Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "_castState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "castState", "Landroidx/lifecycle/LiveData;", "getCastState", "()Landroidx/lifecycle/LiveData;", "Lli/g0;", "sCoroutineScope", "Lli/g0;", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DeviceConnectState {
    public static final DeviceConnectState INSTANCE = new DeviceConnectState();
    private static final String TAG = "DeviceConnectState";
    private static final MutableLiveData<Integer> _castState;
    private static final LiveData<Integer> castState;
    private static final g0 sCoroutineScope;

    /* JADX INFO: renamed from: com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState$refreshCastState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lli/g0;", "", "<anonymous>", "(Lli/g0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState$refreshCastState$1", f = "DeviceConnectState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<g0, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $newState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i8, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newState = i8;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$newState, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DeviceConnectState._castState.setValue(Boxing.boxInt(this.$newState));
            gc.d(DeviceConnectState.TAG, "refreshCastState newState:" + this.$newState);
            DeviceConnectState._castState.setValue(Boxing.boxInt(0));
            gc.c(DeviceConnectState.TAG, "refreshCastState newState:0");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        _castState = mutableLiveData;
        castState = mutableLiveData;
        sCoroutineScope = h0.a(v0.f7499b);
    }

    private DeviceConnectState() {
    }

    public final LiveData<Integer> getCastState() {
        return castState;
    }

    public final boolean isConnected() {
        String log = "isConnected: " + y.f4804h;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TAG), log);
        }
        return Intrinsics.areEqual(y.f4804h, new CapabilitySocketConnected());
    }

    public final boolean isConnecting() {
        y yVar = y.f4799a;
        BaseState baseState = y.f4804h;
        return Intrinsics.areEqual(baseState, new PhysicalConnecting()) || Intrinsics.areEqual(baseState, new MainSocketInit()) || Intrinsics.areEqual(baseState, new MainSocketConnected()) || Intrinsics.areEqual(baseState, new PhysicalConnected());
    }

    public final void refreshCastState(int newState) {
        if (newState == 4) {
            l0.p(sCoroutineScope, r.f9163a, null, new AnonymousClass1(newState, null), 2);
            return;
        }
        _castState.postValue(Integer.valueOf(newState));
        String log = "refreshCastState post newState:" + newState;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TAG), log);
        }
    }
}
