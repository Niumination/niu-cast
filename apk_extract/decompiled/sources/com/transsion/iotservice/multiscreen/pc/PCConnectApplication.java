package com.transsion.iotservice.multiscreen.pc;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import com.transsion.base.arch.mvvm.VmOwnerApplication;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import j3.z;
import jb.f;
import jb.g;
import k3.gc;
import k3.lb;
import k3.n1;
import k3.pb;
import k3.vb;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import li.g0;
import li.h0;
import li.l0;
import pa.a;
import pd.j;
import qi.c;
import ra.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/PCConnectApplication;", "Lcom/transsion/base/arch/mvvm/VmOwnerApplication;", "Lli/g0;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nPCConnectApplication.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PCConnectApplication.kt\ncom/transsion/iotservice/multiscreen/pc/PCConnectApplication\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,147:1\n1#2:148\n*E\n"})
public final class PCConnectApplication extends VmOwnerApplication implements g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PCConnectApplication f2386d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f2387b = n1.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedViewModel f2388c;

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f2387b.f9137a;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        SharedViewModel sharedViewModel = this.f2388c;
        if (sharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedVM");
            sharedViewModel = null;
        }
        sharedViewModel.a();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x009d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0124  */
    /* JADX WARN: Code duplicated, block: B:21:0x013b  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // com.transsion.base.arch.mvvm.VmOwnerApplication, android.app.Application
    public final void onCreate() {
        int i8;
        gb.c cVar;
        Intrinsics.checkNotNullParameter("pcconnect-", "logTag");
        Intrinsics.checkNotNullParameter("tr_pcconnect.log_level.model.config", "logLevelKey");
        gc.f6463b = "pcconnect-";
        a aVar = a.f8703a;
        Intrinsics.checkNotNullParameter("tr_pcconnect.log_level.model.config", "logKey");
        String strK = aVar.k("tr_pcconnect.log_level.model.config", "pcconnect.log.level", String.valueOf(3));
        if (strK.length() != 0) {
            try {
                i8 = Integer.parseInt(strK);
            } catch (NumberFormatException unused) {
                Intrinsics.checkNotNullParameter("FrameworkProxy", "tag");
                Intrinsics.checkNotNullParameter("init:parse log level error", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("FrameworkProxy"), "init:parse log level error");
                }
                i8 = 3;
            }
            gc.f6462a = i8;
            lb.f6529c = 3;
            super.onCreate();
            Intrinsics.checkNotNullParameter(this, "<set-?>");
            f2386d = this;
            Intrinsics.checkNotNullParameter(this, "context");
            vb.f6684a = getSharedPreferences("pc_connect", 0);
            a aVar2 = a.f8703a;
            String packageName = getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            aVar2.f(packageName);
            f fVar = f.f6135a;
            g dataSource = new g();
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            f.f6136b = dataSource;
            if (z.f6094c == null) {
                z.f6094c = new z();
            }
            z zVar = z.f6094c;
            Context applicationContext = getApplicationContext();
            zVar.getClass();
            Context applicationContext2 = applicationContext.getApplicationContext();
            z.f6093b = applicationContext2;
            k9.a.b(applicationContext2);
            boolean z2 = j9.a.f6132a;
            Intrinsics.checkNotNullParameter(this, "<set-?>");
            pb.f6621a = this;
            pd.a.a(pb.a(), j.c(com.transsion.widgetslib.R$style.OSDefaultColorHIOS, com.transsion.widgetslib.R$style.OSDefaultColorXOS, com.transsion.widgetslib.R$style.OSDefaultColorITELOS), false);
            Thread.setDefaultUncaughtExceptionHandler(new b());
            Log.i("PCConnectApplication", "onCreate,inTestEnvironment:false,inDebugModel:false,versionName:1.3.1.227");
            l0.p(this, null, null, new ra.f(null), 3);
            l0.p(this, null, null, new ra.g(this, this, null), 3);
            Intrinsics.checkNotNullParameter(this, "application");
            Intrinsics.checkNotNullParameter(SharedViewModel.class, "modelClass");
            ViewModelProvider viewModelProvider = new ViewModelProvider(this);
            Intrinsics.checkNotNull(viewModelProvider);
            SharedViewModel sharedViewModel = (SharedViewModel) viewModelProvider.get(SharedViewModel.class);
            sharedViewModel.a();
            this.f2388c = sharedViewModel;
            cVar = gb.c.f5123b;
            cVar.getClass();
            Intrinsics.checkNotNullParameter(this, "context");
            Intrinsics.checkNotNullParameter("Atomic-AtomicManager", "tag");
            Intrinsics.checkNotNullParameter("initAtomic", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("Atomic-AtomicManager"), "initAtomic");
            }
            if (((Boolean) fb.c.f5016a.getValue()).booleanValue()) {
                l0.p(cVar, null, null, new gb.b(this, null), 3);
            }
        }
        Intrinsics.checkNotNullParameter("FrameworkProxy", "tag");
        Intrinsics.checkNotNullParameter("init:get property result is empty", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("FrameworkProxy"), "init:get property result is empty");
        }
        i8 = 3;
        gc.f6462a = i8;
        lb.f6529c = 3;
        super.onCreate();
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        f2386d = this;
        Intrinsics.checkNotNullParameter(this, "context");
        vb.f6684a = getSharedPreferences("pc_connect", 0);
        a aVar3 = a.f8703a;
        String packageName2 = getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
        aVar3.f(packageName2);
        f fVar2 = f.f6135a;
        g dataSource2 = new g();
        Intrinsics.checkNotNullParameter(dataSource2, "dataSource");
        f.f6136b = dataSource2;
        if (z.f6094c == null) {
            z.f6094c = new z();
        }
        z zVar2 = z.f6094c;
        Context applicationContext3 = getApplicationContext();
        zVar2.getClass();
        Context applicationContext4 = applicationContext3.getApplicationContext();
        z.f6093b = applicationContext4;
        k9.a.b(applicationContext4);
        boolean z3 = j9.a.f6132a;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        pb.f6621a = this;
        pd.a.a(pb.a(), j.c(com.transsion.widgetslib.R$style.OSDefaultColorHIOS, com.transsion.widgetslib.R$style.OSDefaultColorXOS, com.transsion.widgetslib.R$style.OSDefaultColorITELOS), false);
        Thread.setDefaultUncaughtExceptionHandler(new b());
        Log.i("PCConnectApplication", "onCreate,inTestEnvironment:false,inDebugModel:false,versionName:1.3.1.227");
        l0.p(this, null, null, new ra.f(null), 3);
        l0.p(this, null, null, new ra.g(this, this, null), 3);
        Intrinsics.checkNotNullParameter(this, "application");
        Intrinsics.checkNotNullParameter(SharedViewModel.class, "modelClass");
        ViewModelProvider viewModelProvider2 = new ViewModelProvider(this);
        Intrinsics.checkNotNull(viewModelProvider2);
        SharedViewModel sharedViewModel2 = (SharedViewModel) viewModelProvider2.get(SharedViewModel.class);
        sharedViewModel2.a();
        this.f2388c = sharedViewModel2;
        cVar = gb.c.f5123b;
        cVar.getClass();
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter("Atomic-AtomicManager", "tag");
        Intrinsics.checkNotNullParameter("initAtomic", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("Atomic-AtomicManager"), "initAtomic");
        }
        if (((Boolean) fb.c.f5016a.getValue()).booleanValue()) {
            l0.p(cVar, null, null, new gb.b(this, null), 3);
        }
    }

    @Override // android.app.Application
    public final void onTerminate() {
        super.onTerminate();
        h0.b(this, null);
    }
}
