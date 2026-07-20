package com.transsion.iotservice.multiscreen.pc.socket;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import k3.gc;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.h0;
import li.l0;
import li.p1;
import li.r0;
import li.v0;
import m.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013¨\u0006 "}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/HeartbeatManager;", "", "", "mBeatsInterval", "", "mMaxLostBeatsCount", "Ljava/lang/Runnable;", "mHeartbeatKeepRunnable", "mOnTimeoutRunnable", "<init>", "(JILjava/lang/Runnable;Ljava/lang/Runnable;)V", "", "resetBeatCount", "()V", "start", "cancel", "updateHeartbeat", "J", "I", "Ljava/lang/Runnable;", "mLostBeatsCount", "mState", "mUpdateBeatLock", "Ljava/lang/Object;", "Lli/g0;", "scope", "Lli/g0;", "Lli/p1;", "heartbeatJob", "Lli/p1;", "mHeartbeatCheckRunnable", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HeartbeatManager {
    private static final int STATE_IDLE = 0;
    private static final int STATE_RUNNING = 1;
    private static final String TAG = "HeartbeatManager";
    private p1 heartbeatJob;
    private final long mBeatsInterval;
    private final Runnable mHeartbeatCheckRunnable;
    private final Runnable mHeartbeatKeepRunnable;
    private int mLostBeatsCount;
    private final int mMaxLostBeatsCount;
    private final Runnable mOnTimeoutRunnable;
    private int mState;
    private final Object mUpdateBeatLock;
    private final g0 scope;

    /* JADX INFO: renamed from: com.transsion.iotservice.multiscreen.pc.socket.HeartbeatManager$start$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lli/g0;", "", "<anonymous>", "(Lli/g0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.iotservice.multiscreen.pc.socket.HeartbeatManager$start$1", f = "HeartBeatManager.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<g0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HeartbeatManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i8 = this.label;
            if (i8 != 0 && i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            while (HeartbeatManager.this.mState == 1) {
                HeartbeatManager.this.mHeartbeatKeepRunnable.run();
                HeartbeatManager.this.mHeartbeatCheckRunnable.run();
                long j8 = HeartbeatManager.this.mBeatsInterval;
                this.label = 1;
                if (r0.a(j8, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public HeartbeatManager(long j8, int i8, Runnable mHeartbeatKeepRunnable, Runnable mOnTimeoutRunnable) {
        Intrinsics.checkNotNullParameter(mHeartbeatKeepRunnable, "mHeartbeatKeepRunnable");
        Intrinsics.checkNotNullParameter(mOnTimeoutRunnable, "mOnTimeoutRunnable");
        this.mBeatsInterval = j8;
        this.mMaxLostBeatsCount = i8;
        this.mHeartbeatKeepRunnable = mHeartbeatKeepRunnable;
        this.mOnTimeoutRunnable = mOnTimeoutRunnable;
        this.mUpdateBeatLock = new Object();
        this.scope = h0.a(v0.f7499b);
        this.mHeartbeatCheckRunnable = new c(this, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mHeartbeatCheckRunnable$lambda$1(HeartbeatManager heartbeatManager) {
        synchronized (heartbeatManager.mUpdateBeatLock) {
            String log = "heartbeat check:lost-" + heartbeatManager.mLostBeatsCount + ",maxLost-" + heartbeatManager.mMaxLostBeatsCount;
            Intrinsics.checkNotNullParameter(TAG, "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat(TAG), log);
            }
            int i8 = heartbeatManager.mLostBeatsCount;
            if (i8 >= heartbeatManager.mMaxLostBeatsCount) {
                heartbeatManager.mOnTimeoutRunnable.run();
                heartbeatManager.cancel();
            } else {
                heartbeatManager.mLostBeatsCount = i8 + 1;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void resetBeatCount() {
        synchronized (this.mUpdateBeatLock) {
            this.mLostBeatsCount = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void cancel() {
        p1 p1Var;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter("cancel heart beat", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat(TAG), "cancel heart beat");
        }
        p1 p1Var2 = this.heartbeatJob;
        if (p1Var2 != null && p1Var2.a() && (p1Var = this.heartbeatJob) != null) {
            p1Var.h(null);
        }
        resetBeatCount();
        this.mState = 0;
    }

    public final void start() {
        gc.c(TAG, "start heartbeat check and send");
        if (this.mState == 1) {
            gc.b(TAG, "start:already running");
        } else {
            this.mState = 1;
            this.heartbeatJob = l0.p(this.scope, null, null, new AnonymousClass1(null), 3);
        }
    }

    public final void updateHeartbeat() {
        if (this.mState != 0) {
            resetBeatCount();
            return;
        }
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter("update heartbeat when idle", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat(TAG), "update heartbeat when idle");
        }
    }
}
