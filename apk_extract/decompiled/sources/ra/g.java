package ra;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.iotservice.multiscreen.pc.PCConnectApplication;
import com.transsion.iotservice.multiscreen.pc.service.KeepLiveService;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import eb.y;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.gc;
import k3.pb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.g2;
import li.l0;
import m3.h0;
import na.m;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends SuspendLambda implements Function2 {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ PCConnectApplication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, PCConnectApplication pCConnectApplication, Continuation<? super g> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = pCConnectApplication;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new g(this.$context, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zEquals;
        String str;
        String processName;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            Intrinsics.checkNotNullParameter(context, "context");
            yc.f fVar = yc.f.f11122a;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter("com.transsion.iotservice", "targetPackageName");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            yc.f.f11123b = (Application) applicationContext;
            yc.f.f11124c = "com.transsion.iotservice";
            cb.a listener = cb.b.f1457b;
            Intrinsics.checkNotNullParameter(listener, "listener");
            CopyOnWriteArrayList copyOnWriteArrayList = yc.f.f;
            if (!copyOnWriteArrayList.contains(listener)) {
                copyOnWriteArrayList.add(listener);
                o.d.x(copyOnWriteArrayList.size(), "Registered listener, current listener count: ", "ActionCommunicator");
            }
            PCConnectApplication pCConnectApplication = this.this$0;
            Context context2 = this.$context;
            this.label = 1;
            PCConnectApplication pCConnectApplication2 = PCConnectApplication.f2386d;
            pCConnectApplication.getClass();
            pCConnectApplication.bindService(new Intent(context2, (Class<?>) KeepLiveService.class), new h(0), 1);
            if (Unit.INSTANCE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ob.b bVar = ob.b.f8417b;
        Context context3 = this.$context;
        bVar.getClass();
        Intrinsics.checkNotNullParameter(context3, "context");
        w wVar = bVar.f8437a;
        wVar.getClass();
        Intrinsics.checkNotNullParameter(context3, "context");
        if (context3 == null) {
            throw new IllegalArgumentException("The parameter is illegal.");
        }
        if (e8.b.f4712i == null) {
            e8.b.f4712i = context3.getApplicationContext();
        }
        s6.d.p = true;
        if (!TextUtils.isEmpty(null)) {
            TextUtils.isEmpty(null);
        }
        if (t6.d.f10184a != 0) {
            z6.a.a("The host appId has been set 2 times");
        }
        t6.d.f10184a = 7800;
        long j8 = 7800;
        if (e8.b.f4712i != null) {
            if (e8.b.f4711h == 0) {
                e8.b.f4711h = j8;
            }
            e8.f fVar2 = e8.b.f4713j;
            if (fVar2 == null) {
                e8.f fVar3 = new e8.f();
                e8.b.f4713j = fVar3;
                fVar3.f4734m = e8.b.f4711h;
                ((Application) e8.b.f4712i).registerActivityLifecycleCallbacks(e8.b.f4713j);
            } else {
                fVar2.f4734m = e8.b.f4711h;
            }
        }
        Context context4 = e8.b.f4712i;
        if (e8.g.f4735b == null) {
            synchronized (e8.g.class) {
                try {
                    if (e8.g.f4735b == null) {
                        e8.g gVar = new e8.g();
                        gVar.f4736a = context4;
                        e8.g.f4735b = gVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (e8.b.f4710g == -1) {
            try {
                try {
                    str = context3.getApplicationContext().getApplicationInfo().processName;
                } catch (Exception e) {
                    ObjectLogUtils objectLogUtils = z6.a.f11258a;
                    z6.a.c(Log.getStackTraceString(e));
                    str = "";
                }
                if (!TextUtils.isEmpty(null)) {
                    str = null;
                }
                try {
                    processName = Application.getProcessName();
                } catch (Exception e4) {
                    ObjectLogUtils objectLogUtils2 = z6.a.f11258a;
                    z6.a.c(Log.getStackTraceString(e4));
                    processName = null;
                }
                zEquals = TextUtils.equals(str, processName);
            } catch (Exception unused) {
                zEquals = 1;
            }
            e8.b.f4710g = !zEquals;
            if (e8.b.f4710g == 0) {
                String str2 = s6.d.f9538a;
            }
        }
        e8.b.n(9999);
        e8.b.n(j8);
        try {
            ad.b.c(context3);
            h0.f7694b = true;
        } catch (Exception e10) {
            z6.a.c(Log.getStackTraceString(e10));
        }
        String str3 = z6.b.f11259a;
        try {
            Class.forName("com.tencent.mmkv.MMKV");
        } catch (ClassNotFoundException unused2) {
        }
        boolean zAreEqual = Intrinsics.areEqual(Settings.Global.getString(context3.getContentResolver(), "multiconnect_enable_athena_test"), "1");
        String str4 = s6.d.f9538a;
        s6.d.q = zAreEqual ? "test" : "online";
        e8.b.l(Settings.System.getInt(pb.a().getContentResolver(), "user_experience", 0) == 1);
        context3.getContentResolver().registerContentObserver(Settings.System.getUriFor("user_experience"), true, (bc.f) wVar.f10262b);
        PCConnectApplication application = this.this$0;
        Intrinsics.checkNotNullParameter(application, "application");
        qi.c cVar = y.f4800b;
        si.e eVar = si.e.f10118a;
        l0.p(cVar, eVar, null, new db.e(application, null), 2);
        Intrinsics.checkNotNullParameter("PCIotCardManager", "tag");
        Intrinsics.checkNotNullParameter("<initListener>", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PCIotCardManager"), "<initListener>");
        }
        if (DeviceConnectState.INSTANCE.isConnected()) {
            db.f.b();
        } else {
            db.f.c();
        }
        g2 g2Var = db.f.f4398d;
        if (g2Var != null) {
            g2Var.h(null);
        }
        db.f.f4398d = l0.p(cVar, eVar, null, new db.d(null), 2);
        m.c();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((g) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
