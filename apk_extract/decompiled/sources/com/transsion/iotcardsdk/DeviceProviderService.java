package com.transsion.iotcardsdk;

import a4.b;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Preconditions;
import ck.c;
import ck.j;
import com.transsion.iotcardsdk.bean.AppActionKt;
import com.transsion.iotcardsdk.bean.ControlAction;
import com.transsion.iotcardsdk.bean.ControlActionWrapper;
import com.transsion.iotcardsdk.bean.IotCardTemplateActionWrapper;
import com.transsion.iotcardsdk.bean.IotCardTemplateBean;
import com.transsion.iotcardsdk.bean.IotCardTemplatePublisherWrapper;
import com.transsion.iotcardsdk.bean.UnregisterAction;
import com.transsion.iotcardsdk.event.EventBean;
import dk.f;
import ik.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k3.t9;
import k3.x1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import qk.e;
import sh.a;
import tj.x;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 >2\u00020\u0001:\u0005?>@ABB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u001b\u0010%\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b%\u0010&R\u001c\u0010(\u001a\b\u0018\u00010'R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R.\u00108\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/transsion/iotcardsdk/DeviceProviderService;", "Landroid/app/Service;", "<init>", "()V", "", "onMessageEvent", "onCreate", "onDestroy", "", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "getRegisterDevices", "()Ljava/util/List;", "", "controlId", "Lcom/transsion/iotcardsdk/bean/ControlAction;", "action", "Lsh/a;", "", "consumer", "performControlAction", "(Ljava/lang/String;Lcom/transsion/iotcardsdk/bean/ControlAction;Lsh/a;)V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "iotCardTemplateBean", "registerDevice", "(Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;)V", "unregisterDevice", "updateDevice", "", "isRegister", "(Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;)Z", "Lqh/a;", "Lcom/transsion/iotcardsdk/bean/IotCardTemplatePublisherWrapper;", "iotCardTemplatePublisherWrapper", "wrapDeviceCardInfoBean", "(Lqh/a;)V", "Lcom/transsion/iotcardsdk/DeviceProviderService$RequestHandler;", "mHandler", "Lcom/transsion/iotcardsdk/DeviceProviderService$RequestHandler;", "mToken", "Landroid/os/IBinder;", "getMToken", "()Landroid/os/IBinder;", "setMToken", "(Landroid/os/IBinder;)V", "Lcom/transsion/iotcardsdk/IControlsSubscriber;", "mSubscriber", "Lcom/transsion/iotcardsdk/IControlsSubscriber;", "getMSubscriber", "()Lcom/transsion/iotcardsdk/IControlsSubscriber;", "setMSubscriber", "(Lcom/transsion/iotcardsdk/IControlsSubscriber;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "mRegisterDeviceList", "Ljava/util/concurrent/ConcurrentHashMap;", "getMRegisterDeviceList", "()Ljava/util/concurrent/ConcurrentHashMap;", "setMRegisterDeviceList", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "Companion", "ActionMessage", "RequestHandler", "SubscriberProxy", "SubscriptionAdapter", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nDeviceProviderService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceProviderService.kt\ncom/transsion/iotcardsdk/DeviceProviderService\n+ 2 Bus.kt\ncom/eightbitlab/rxbus/Bus\n*L\n1#1,354:1\n40#2:355\n*S KotlinDebug\n*F\n+ 1 DeviceProviderService.kt\ncom/transsion/iotcardsdk/DeviceProviderService\n*L\n328#1:355\n*E\n"})
public abstract class DeviceProviderService extends Service {
    public static final String ACTION = "com.transsion.iotservice.iotcard.ControlsProviderService";
    public static final String CALLBACK_BUNDLE = "CALLBACK_BUNDLE";
    public static final String CALLBACK_TOKEN = "CALLBACK_TOKEN";
    public static final String KEY_BUNDLE_IOT = "iot_bundle";
    public static final int MSG_ACTION = 3;
    public static final int MSG_LOAD = 1;
    public static final String TAG = "DeviceProviderService";
    private RequestHandler mHandler;
    private ConcurrentHashMap<String, IotCardTemplateBean> mRegisterDeviceList = new ConcurrentHashMap<>();
    private IControlsSubscriber mSubscriber;
    private IBinder mToken;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/iotcardsdk/DeviceProviderService$ActionMessage;", "", "mControlId", "", "mAction", "Lcom/transsion/iotcardsdk/bean/ControlAction;", "mCb", "Lcom/transsion/iotcardsdk/IControlsActionCallback;", "(Ljava/lang/String;Lcom/transsion/iotcardsdk/bean/ControlAction;Lcom/transsion/iotcardsdk/IControlsActionCallback;)V", "getMAction", "()Lcom/transsion/iotcardsdk/bean/ControlAction;", "getMCb", "()Lcom/transsion/iotcardsdk/IControlsActionCallback;", "getMControlId", "()Ljava/lang/String;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class ActionMessage {
        private final ControlAction mAction;
        private final IControlsActionCallback mCb;
        private final String mControlId;

        public ActionMessage(String mControlId, ControlAction mAction, IControlsActionCallback mCb) {
            Intrinsics.checkNotNullParameter(mControlId, "mControlId");
            Intrinsics.checkNotNullParameter(mAction, "mAction");
            Intrinsics.checkNotNullParameter(mCb, "mCb");
            this.mControlId = mControlId;
            this.mAction = mAction;
            this.mCb = mCb;
        }

        public final ControlAction getMAction() {
            return this.mAction;
        }

        public final IControlsActionCallback getMCb() {
            return this.mCb;
        }

        public final String getMControlId() {
            return this.mControlId;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0083\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/transsion/iotcardsdk/DeviceProviderService$RequestHandler;", "Landroid/os/Handler;", "Landroid/os/Looper;", "looper", "<init>", "(Lcom/transsion/iotcardsdk/DeviceProviderService;Landroid/os/Looper;)V", "", "controlId", "Lcom/transsion/iotcardsdk/IControlsActionCallback;", "cb", "Lsh/a;", "", "consumerFor", "(Ljava/lang/String;Lcom/transsion/iotcardsdk/IControlsActionCallback;)Lsh/a;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "", "handleMessage", "(Landroid/os/Message;)V", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
    @SourceDebugExtension({"SMAP\nDeviceProviderService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceProviderService.kt\ncom/transsion/iotcardsdk/DeviceProviderService$RequestHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,354:1\n1855#2,2:355\n*S KotlinDebug\n*F\n+ 1 DeviceProviderService.kt\ncom/transsion/iotcardsdk/DeviceProviderService$RequestHandler\n*L\n103#1:355,2\n*E\n"})
    public final class RequestHandler extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestHandler(Looper looper) {
            super(looper);
            Intrinsics.checkNotNull(looper);
        }

        private final a consumerFor(String controlId, IControlsActionCallback cb2) {
            return new b(cb2, DeviceProviderService.this, controlId);
        }

        private static final void consumerFor$lambda$1(IControlsActionCallback cb2, DeviceProviderService this$0, String controlId, int i8) {
            Intrinsics.checkNotNullParameter(cb2, "$cb");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(controlId, "$controlId");
            Preconditions.checkNotNull(Integer.valueOf(i8));
            try {
                if (cb2.asBinder().isBinderAlive()) {
                    cb2.accept(this$0.getMToken(), controlId, i8);
                }
            } catch (RemoteException e) {
                e.rethrowAsRuntimeException();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            int i8 = msg.what;
            if (i8 == 1) {
                List<IotCardTemplateBean> registerDevices = DeviceProviderService.this.getRegisterDevices();
                DeviceProviderService deviceProviderService = DeviceProviderService.this;
                Iterator<T> it = registerDevices.iterator();
                while (it.hasNext()) {
                    deviceProviderService.registerDevice((IotCardTemplateBean) it.next());
                }
                return;
            }
            if (i8 != 3) {
                return;
            }
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.transsion.iotcardsdk.DeviceProviderService.ActionMessage");
            ActionMessage actionMessage = (ActionMessage) obj;
            if (actionMessage.getMAction() instanceof UnregisterAction) {
                DeviceProviderService.this.setMSubscriber(null);
            } else {
                DeviceProviderService.this.performControlAction(actionMessage.getMControlId(), actionMessage.getMAction(), consumerFor(actionMessage.getMControlId(), actionMessage.getMCb()));
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\b\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB%\b\u0010\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010 R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/transsion/iotcardsdk/DeviceProviderService$SubscriberProxy;", "Luj/a;", "Lcom/transsion/iotcardsdk/bean/IotCardTemplatePublisherWrapper;", "Landroid/os/IBinder;", "mToken", "Lcom/transsion/iotcardsdk/IControlsSubscriber;", "mCs", "<init>", "(Landroid/os/IBinder;Lcom/transsion/iotcardsdk/IControlsSubscriber;)V", "Landroid/content/Context;", "context", "token", "cs", "(Landroid/content/Context;Landroid/os/IBinder;Lcom/transsion/iotcardsdk/IControlsSubscriber;)V", "Lkotlin/Function0;", "", "block", "checkBindAlive", "(Lkotlin/jvm/functions/Function0;)V", "", "t", "onError", "(Ljava/lang/Throwable;)V", "onComplete", "()V", "p0", "onNext", "(Lcom/transsion/iotcardsdk/bean/IotCardTemplatePublisherWrapper;)V", "Luj/b;", "s", "onSubscribe", "(Luj/b;)V", "Landroid/os/IBinder;", "Lcom/transsion/iotcardsdk/IControlsSubscriber;", "mContext", "Landroid/content/Context;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class SubscriberProxy implements uj.a {
        private Context mContext;
        private final IControlsSubscriber mCs;
        private final IBinder mToken;

        public SubscriberProxy(IBinder iBinder, IControlsSubscriber mCs) {
            Intrinsics.checkNotNullParameter(mCs, "mCs");
            this.mToken = iBinder;
            this.mCs = mCs;
        }

        private final void checkBindAlive(Function0<Unit> block) {
            try {
                if (this.mCs.asBinder().isBinderAlive()) {
                    Log.i(DeviceProviderService.TAG, "tdk:DeviceProviderService isBinderAlive:true");
                    block.invoke();
                } else {
                    Log.e(DeviceProviderService.TAG, "tdk:DeviceProviderService checkBindAlive isBinderAlive: false");
                }
            } catch (Exception e) {
                Log.e(DeviceProviderService.TAG, "tdk:DeviceProviderService checkBindAlive error: " + e);
            }
        }

        @Override // uj.a
        public void onComplete() {
            try {
                checkBindAlive(new Function0<Unit>() { // from class: com.transsion.iotcardsdk.DeviceProviderService$SubscriberProxy$onComplete$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() throws RemoteException {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() throws RemoteException {
                        this.this$0.mCs.onComplete(this.this$0.mToken);
                    }
                });
            } catch (RemoteException e) {
                e.rethrowAsRuntimeException();
            }
        }

        @Override // uj.a
        public void onError(final Throwable t3) {
            Intrinsics.checkNotNullParameter(t3, "t");
            try {
                checkBindAlive(new Function0<Unit>() { // from class: com.transsion.iotcardsdk.DeviceProviderService$SubscriberProxy$onError$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() throws RemoteException {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() throws RemoteException {
                        this.this$0.mCs.onError(this.this$0.mToken, t3.toString());
                    }
                });
            } catch (RemoteException e) {
                e.rethrowAsRuntimeException();
            }
        }

        @Override // uj.a
        public void onSubscribe(final uj.b s2) {
            if (s2 != null) {
                try {
                    checkBindAlive(new Function0<Unit>() { // from class: com.transsion.iotcardsdk.DeviceProviderService$SubscriberProxy$onSubscribe$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() throws RemoteException {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() throws RemoteException {
                            this.this$0.mCs.onSubscribe(this.this$0.mToken, new DeviceProviderService.SubscriptionAdapter(s2));
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                } catch (RemoteException e) {
                    Intrinsics.checkNotNullExpressionValue(e.rethrowAsRuntimeException(), "{\n                      …n()\n                    }");
                }
            }
        }

        @Override // uj.a
        public void onNext(final IotCardTemplatePublisherWrapper p0) {
            checkBindAlive(new Function0<Unit>() { // from class: com.transsion.iotcardsdk.DeviceProviderService$SubscriberProxy$onNext$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() throws RemoteException {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws RemoteException {
                    this.this$0.mCs.onNext(this.this$0.mToken, p0);
                }
            });
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SubscriberProxy(Context context, IBinder iBinder, IControlsSubscriber cs) {
            this(iBinder, cs);
            Intrinsics.checkNotNullParameter(cs, "cs");
            this.mContext = context;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/transsion/iotcardsdk/DeviceProviderService$SubscriptionAdapter;", "Lcom/transsion/iotcardsdk/IControlsSubscription$Stub;", "Luj/b;", "mSubscription", "<init>", "(Luj/b;)V", "", "n", "", "request", "(J)V", "cancel", "()V", "Luj/b;", "getMSubscription", "()Luj/b;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class SubscriptionAdapter extends IControlsSubscription.Stub {
        private final uj.b mSubscription;

        public SubscriptionAdapter(uj.b mSubscription) {
            Intrinsics.checkNotNullParameter(mSubscription, "mSubscription");
            this.mSubscription = mSubscription;
        }

        @Override // com.transsion.iotcardsdk.IControlsSubscription
        public void cancel() {
            this.mSubscription.cancel();
        }

        public final uj.b getMSubscription() {
            return this.mSubscription;
        }

        @Override // com.transsion.iotcardsdk.IControlsSubscription
        public void request(long n2) {
            this.mSubscription.request(n2);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void onMessageEvent() {
        j jVar;
        y1.b.e.getClass();
        pk.b bVar = y1.b.f11024c;
        bVar.getClass();
        c cVarA = bVar.a(new x(n.isInstanceOf(EventBean.class))).a(new n5.a());
        Intrinsics.checkExpressionValueIsNotNull(cVarA, "bus.ofType(T::class.java)");
        mk.a aVar = new mk.a(new ik.a(new c.a(2, new Function1<EventBean, Unit>() { // from class: com.transsion.iotcardsdk.DeviceProviderService.onMessageEvent.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EventBean eventBean) {
                invoke2(eventBean);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EventBean eventBean) {
                int eventTypeId = eventBean.getEventTypeId();
                if (eventTypeId == 0) {
                    Log.d(DeviceProviderService.TAG, "registerDevice");
                    DeviceProviderService.this.registerDevice(eventBean.getDeviceBean());
                } else if (eventTypeId == 1) {
                    Log.d(DeviceProviderService.TAG, "unregisterDevice");
                    DeviceProviderService.this.unregisterDevice(eventBean.getDeviceBean());
                } else {
                    if (eventTypeId != 2) {
                        return;
                    }
                    Log.d(DeviceProviderService.TAG, "updateDevice");
                    DeviceProviderService.this.updateDevice(eventBean.getDeviceBean());
                }
            }
        }), n.ERROR_NOT_IMPLEMENTED));
        try {
            nk.a aVar2 = c.f1727b;
            ck.a aVar3 = cVarA.f1728a;
            aVar2.getClass();
            aVar3.mo0call(aVar);
            jVar = aVar;
        } catch (Throwable th2) {
            x1.b(th2);
            if (aVar.f1736a.f5909b) {
                c.f1727b.getClass();
                t9.a();
            } else {
                try {
                    c.f1727b.getClass();
                    aVar.onError(th2);
                } catch (Throwable th3) {
                    x1.b(th3);
                    f fVar = new f("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                    c.f1727b.getClass();
                    throw fVar;
                }
            }
            jVar = e.f9242a;
        }
        Intrinsics.checkNotNullExpressionValue(jVar, "private fun onMessageEve…registerInBus(this)\n    }");
        y1.b.e.getClass();
        qk.b bVar2 = (qk.b) y1.b.a().get(this);
        qk.b bVar3 = bVar2;
        if (bVar2 == null) {
            bVar3 = new qk.b();
        }
        bVar3.a(jVar);
        y1.b.a().put(this, bVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageEvent$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final ConcurrentHashMap<String, IotCardTemplateBean> getMRegisterDeviceList() {
        return this.mRegisterDeviceList;
    }

    public final IControlsSubscriber getMSubscriber() {
        return this.mSubscriber;
    }

    public final IBinder getMToken() {
        return this.mToken;
    }

    public abstract List<IotCardTemplateBean> getRegisterDevices();

    public final synchronized boolean isRegister(IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        return this.mRegisterDeviceList.containsKey(iotCardTemplateBean.getControlId());
    }

    @Override // android.app.Service
    @RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.mHandler = new RequestHandler(Looper.getMainLooper());
        Bundle bundleExtra = intent.getBundleExtra(CALLBACK_BUNDLE);
        Intrinsics.checkNotNull(bundleExtra);
        this.mToken = bundleExtra.getBinder(CALLBACK_TOKEN);
        return new IControlsProvider.Stub() { // from class: com.transsion.iotcardsdk.DeviceProviderService.onBind.1
            @Override // com.transsion.iotcardsdk.IControlsProvider
            public void action(String controlId, ControlActionWrapper action, IControlsActionCallback cb2) {
                Intrinsics.checkNotNullParameter(controlId, "controlId");
                Intrinsics.checkNotNullParameter(action, "action");
                Intrinsics.checkNotNullParameter(cb2, "cb");
                ActionMessage actionMessage = new ActionMessage(controlId, action.getWrappedAction(), cb2);
                RequestHandler requestHandler = DeviceProviderService.this.mHandler;
                Intrinsics.checkNotNull(requestHandler);
                requestHandler.obtainMessage(3, actionMessage).sendToTarget();
            }

            @Override // com.transsion.iotcardsdk.IControlsProvider
            public void load(IControlsSubscriber subscriber) {
                DeviceProviderService.this.getMRegisterDeviceList().clear();
                DeviceProviderService.this.setMSubscriber(subscriber);
                RequestHandler requestHandler = DeviceProviderService.this.mHandler;
                Intrinsics.checkNotNull(requestHandler);
                requestHandler.obtainMessage(1, subscriber).sendToTarget();
            }
        };
    }

    @Override // android.app.Service
    public void onCreate() {
        onMessageEvent();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        HashSet hashSet;
        y1.b.e.getClass();
        qk.b bVar = (qk.b) y1.b.a().get(this);
        if (bVar == null) {
            Log.w(y1.b.f11022a, "Trying to unregister subscriber that wasn't registered");
        } else {
            if (!bVar.f9239b) {
                synchronized (bVar) {
                    if (!bVar.f9239b && (hashSet = bVar.f9238a) != null) {
                        bVar.f9238a = null;
                        qk.b.c(hashSet);
                    }
                }
            }
            y1.b.a().remove(this);
        }
        super.onDestroy();
    }

    public abstract void performControlAction(String controlId, ControlAction action, a consumer);

    public final synchronized void registerDevice(IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        Log.e(TAG, "registerDevice:iotCardTemplateBean :" + iotCardTemplateBean.getDataBundle());
        this.mRegisterDeviceList.put(iotCardTemplateBean.getControlId(), iotCardTemplateBean);
        IotCardTemplatePublisherWrapper iotCardTemplatePublisherWrapper = new IotCardTemplatePublisherWrapper(new IotCardTemplateActionWrapper(AppActionKt.REGISTER, iotCardTemplateBean));
        int i8 = qh.a.f9127a;
        th.a aVar = new th.a(iotCardTemplatePublisherWrapper);
        Intrinsics.checkNotNullExpressionValue(aVar, "just(iotCardTemplatePublisherWrapper)");
        wrapDeviceCardInfoBean(aVar);
    }

    public final void setMRegisterDeviceList(ConcurrentHashMap<String, IotCardTemplateBean> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.mRegisterDeviceList = concurrentHashMap;
    }

    public final void setMSubscriber(IControlsSubscriber iControlsSubscriber) {
        this.mSubscriber = iControlsSubscriber;
    }

    public final void setMToken(IBinder iBinder) {
        this.mToken = iBinder;
    }

    public final synchronized void unregisterDevice(IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        Log.e(TAG, "unregisterDevice:iotCardTemplateBean :" + iotCardTemplateBean.getDataBundle());
        this.mRegisterDeviceList.remove(iotCardTemplateBean.getControlId());
        IotCardTemplatePublisherWrapper iotCardTemplatePublisherWrapper = new IotCardTemplatePublisherWrapper(new IotCardTemplateActionWrapper(AppActionKt.UNREGISTER, iotCardTemplateBean));
        int i8 = qh.a.f9127a;
        th.a aVar = new th.a(iotCardTemplatePublisherWrapper);
        Intrinsics.checkNotNullExpressionValue(aVar, "just(iotCardTemplatePublisherWrapper)");
        wrapDeviceCardInfoBean(aVar);
    }

    public final synchronized void updateDevice(IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        Log.e(TAG, "updateDevice:iotCardTemplateBean :" + iotCardTemplateBean.getDataBundle());
        IotCardTemplatePublisherWrapper iotCardTemplatePublisherWrapper = new IotCardTemplatePublisherWrapper(new IotCardTemplateActionWrapper(AppActionKt.UPDATE, iotCardTemplateBean));
        int i8 = qh.a.f9127a;
        th.a aVar = new th.a(iotCardTemplatePublisherWrapper);
        Intrinsics.checkNotNullExpressionValue(aVar, "just(iotCardTemplatePublisherWrapper)");
        wrapDeviceCardInfoBean(aVar);
    }

    public final synchronized void wrapDeviceCardInfoBean(qh.a iotCardTemplatePublisherWrapper) {
        IBinder iBinderAsBinder;
        Intrinsics.checkNotNullParameter(iotCardTemplatePublisherWrapper, "iotCardTemplatePublisherWrapper");
        IControlsSubscriber iControlsSubscriber = this.mSubscriber;
        if (iControlsSubscriber != null && (iBinderAsBinder = iControlsSubscriber.asBinder()) != null && iBinderAsBinder.isBinderAlive()) {
            IBinder iBinder = this.mToken;
            IControlsSubscriber iControlsSubscriber2 = this.mSubscriber;
            Intrinsics.checkNotNull(iControlsSubscriber2);
            uj.a subscriberProxy = new SubscriberProxy(this, iBinder, iControlsSubscriber2);
            iotCardTemplatePublisherWrapper.getClass();
            if (subscriberProxy instanceof qh.b) {
                iotCardTemplatePublisherWrapper.a((qh.b) subscriberProxy);
            } else {
                iotCardTemplatePublisherWrapper.a(new uh.a(subscriberProxy));
            }
        }
    }
}
