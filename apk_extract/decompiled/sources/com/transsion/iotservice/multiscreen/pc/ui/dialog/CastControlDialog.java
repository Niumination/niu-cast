package com.transsion.iotservice.multiscreen.pc.ui.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import bb.f;
import ce.a;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.VapAssetList;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityCastControlBinding;
import com.transsion.iotservice.multiscreen.pc.receiver.HomeKeyReceiver;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import eb.y;
import k3.gc;
import k3.sb;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import li.g2;
import li.h0;
import li.l0;
import li.v0;
import qi.c;
import sb.e;
import sb.g;
import sb.h;
import sb.i;
import sb.k;
import tj.w;
import va.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/dialog/CastControlDialog;", "Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nCastControlDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CastControlDialog.kt\ncom/transsion/iotservice/multiscreen/pc/ui/dialog/CastControlDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,295:1\n1#2:296\n*E\n"})
public final class CastControlDialog extends OSBaseBottomSheetDialog {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f2710n = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CastControlViewModel f2712k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HomeKeyReceiver f2713l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f2711j = h0.a(v0.f7499b);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f2714m = new e(this);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext, li.j0] */
    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        g2 g2Var;
        ?? r10;
        int i8 = 3;
        final int i9 = 1;
        final int i10 = 0;
        b.g(this);
        super.onCreate(bundle);
        gc.a("CastControlDialog", "onCreate");
        Intrinsics.checkNotNullParameter(this, "activity");
        Intrinsics.checkNotNullParameter(CastControlViewModel.class, "modelClass");
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        Intrinsics.checkNotNull(viewModelProvider);
        this.f2712k = (CastControlViewModel) viewModelProvider.get(CastControlViewModel.class);
        LayoutInflater layoutInflater = getLayoutInflater();
        int i11 = ActivityCastControlBinding.f2404n;
        ActivityCastControlBinding activityCastControlBinding = (ActivityCastControlBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_cast_control, null, false, DataBindingUtil.getDefaultComponent());
        activityCastControlBinding.setLifecycleOwner(this);
        CastControlViewModel castControlViewModel = this.f2712k;
        if (castControlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            castControlViewModel = null;
        }
        activityCastControlBinding.e(castControlViewModel);
        activityCastControlBinding.d(this.f2714m);
        View root = activityCastControlBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        j(root).d(new a(this, 8));
        getString(R$string.pad_phone_mirror);
        CastControlViewModel castControlViewModel2 = this.f2712k;
        if (castControlViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            castControlViewModel2 = null;
        }
        MutableLiveData mutableLiveData = castControlViewModel2.f;
        LinearLayout mirrorButtonInner = activityCastControlBinding.e;
        Intrinsics.checkNotNullExpressionValue(mirrorButtonInner, "mirrorButtonInner");
        mutableLiveData.observe(this, new h(0, new sb.a(mirrorButtonInner, 0)));
        CastControlViewModel castControlViewModel3 = this.f2712k;
        if (castControlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            castControlViewModel3 = null;
        }
        MutableLiveData mutableLiveData2 = castControlViewModel3.f2721g;
        LinearLayout extendButtonInner = activityCastControlBinding.f2407c;
        Intrinsics.checkNotNullExpressionValue(extendButtonInner, "extendButtonInner");
        mutableLiveData2.observe(this, new h(0, new sb.a(extendButtonInner, 0)));
        CastControlViewModel castControlViewModel4 = this.f2712k;
        if (castControlViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            castControlViewModel4 = null;
        }
        MutableLiveData mutableLiveData3 = castControlViewModel4.f;
        CastControlViewModel castControlViewModel5 = this.f2712k;
        if (castControlViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            castControlViewModel5 = null;
        }
        MutableLiveData mutableLiveData4 = castControlViewModel5.f2721g;
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Boolean bool = (Boolean) mutableLiveData3.getValue();
        booleanRef.element = bool != null ? bool.booleanValue() : false;
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        Boolean bool2 = (Boolean) mutableLiveData4.getValue();
        booleanRef2.element = bool2 != null ? bool2.booleanValue() : false;
        final sb.b bVar = new sb.b(new Ref.ObjectRef(), new Handler(Looper.getMainLooper()), mediatorLiveData, booleanRef, booleanRef2);
        mediatorLiveData.setValue(TuplesKt.to(Boolean.valueOf(booleanRef.element), Boolean.valueOf(booleanRef2.element)));
        mediatorLiveData.addSource(mutableLiveData3, new h(0, new Function1() { // from class: sb.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                b bVar2 = bVar;
                Ref.BooleanRef booleanRef3 = booleanRef;
                Boolean bool3 = (Boolean) obj;
                switch (i10) {
                    case 0:
                        int i12 = CastControlDialog.f2710n;
                        booleanRef3.element = bool3 != null ? bool3.booleanValue() : false;
                        bVar2.invoke();
                        break;
                    default:
                        int i13 = CastControlDialog.f2710n;
                        booleanRef3.element = bool3 != null ? bool3.booleanValue() : false;
                        bVar2.invoke();
                        break;
                }
                return Unit.INSTANCE;
            }
        }));
        mediatorLiveData.addSource(mutableLiveData4, new h(0, new Function1() { // from class: sb.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                b bVar2 = bVar;
                Ref.BooleanRef booleanRef3 = booleanRef2;
                Boolean bool3 = (Boolean) obj;
                switch (i9) {
                    case 0:
                        int i12 = CastControlDialog.f2710n;
                        booleanRef3.element = bool3 != null ? bool3.booleanValue() : false;
                        bVar2.invoke();
                        break;
                    default:
                        int i13 = CastControlDialog.f2710n;
                        booleanRef3.element = bool3 != null ? bool3.booleanValue() : false;
                        bVar2.invoke();
                        break;
                }
                return Unit.INSTANCE;
            }
        }));
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        booleanRef3.element = CastControlViewModel.f2715l;
        Ref.BooleanRef booleanRef4 = new Ref.BooleanRef();
        booleanRef4.element = CastControlViewModel.f2716m;
        mediatorLiveData.observe(this, new h(0, new f(booleanRef3, i8, booleanRef4, this)));
        OSScrollbarLayout oSScrollbarLayout = activityCastControlBinding.f2410i;
        OverBoundNestedScrollView overBoundNestedScrollView = activityCastControlBinding.f2409h;
        oSScrollbarLayout.setOverScrollView(overBoundNestedScrollView);
        overBoundNestedScrollView.setUpOverScroll();
        s(true);
        ob.b bVar2 = ob.b.f8417b;
        CastControlViewModel castControlViewModel6 = this.f2712k;
        if (castControlViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            castControlViewModel6 = null;
        }
        Boolean bool3 = (Boolean) castControlViewModel6.f.getValue();
        String mirrorStatus = bool3 != null ? bool3.booleanValue() : false ? "on" : "off";
        bVar2.getClass();
        Intrinsics.checkNotNullParameter(mirrorStatus, "mirrorStatus");
        w wVar = bVar2.f8437a;
        wVar.getClass();
        Intrinsics.checkNotNullParameter(mirrorStatus, "mirrorStatus");
        Bundle bundle2 = new Bundle();
        bundle2.putString("mirror_status", mirrorStatus);
        bundle2.putString("device_type", w.B());
        w.X("pad_connection_mirror_toggle_window_show", bundle2);
        v0 v0Var = v0.f7498a;
        l0.p(h0.a(si.e.f10118a), null, null, new g(this, null), 3);
        HomeKeyReceiver homeKeyReceiver = new HomeKeyReceiver(new ag.a(this, 14));
        b.f(this, homeKeyReceiver, "android.intent.action.CLOSE_SYSTEM_DIALOGS", false);
        this.f2713l = homeKeyReceiver;
        if (getIntent().getBooleanExtra("EXTRA_AUTO_CLOSE", false)) {
            CastControlViewModel castControlViewModel7 = this.f2712k;
            if (castControlViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                castControlViewModel7 = null;
            }
            castControlViewModel7.getClass();
            if (sb.b() && ((g2Var = castControlViewModel7.e) == null || !g2Var.a())) {
                r10 = 0;
                castControlViewModel7.e = l0.p(ViewModelKt.getViewModelScope(castControlViewModel7), null, null, new k(castControlViewModel7, null), 3);
            } else {
                r10 = 0;
            }
            l0.p(LifecycleOwnerKt.getLifecycleScope(this), r10, r10, new i(this, r10), 3);
        }
        ta.a aVar = ta.b.f10202a;
        TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
        x7.f.f("extend_is_show_cast_dialog", String.valueOf(true));
        if (getIntent().getBooleanExtra("extra_from_cast_notification", false)) {
            wVar.getClass();
            w.X("iot_multi_con_phonepad_connect_status_push_click", w.D());
            gc.c("CastControlDialog", "Notification clicked");
        }
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        HomeKeyReceiver homeKeyReceiver = this.f2713l;
        if (homeKeyReceiver != null) {
            unregisterReceiver(homeKeyReceiver);
            this.f2713l = null;
        }
        CastControlViewModel castControlViewModel = this.f2712k;
        if (castControlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            castControlViewModel = null;
        }
        g2 g2Var = castControlViewModel.e;
        if (g2Var != null) {
            g2Var.h(null);
        }
        castControlViewModel.e = null;
        ta.a aVar = ta.b.f10202a;
        TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
        x7.f.f("extend_is_show_cast_dialog", String.valueOf(false));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("extra_from_cast_notification", false)) {
            ob.b.f8417b.f8437a.getClass();
            w.X("iot_multi_con_phonepad_connect_status_push_click", w.D());
            Intrinsics.checkNotNullParameter("CastControlDialog", "tag");
            Intrinsics.checkNotNullParameter("Notification clicked", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("CastControlDialog"), "Notification clicked");
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        VapResource close_extension_resource;
        super.onStart();
        CastControlViewModel castControlViewModel = this.f2712k;
        if (castControlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            castControlViewModel = null;
        }
        castControlViewModel.getClass();
        y yVar = y.f4799a;
        y.t(CastControlViewModel.f2716m);
        y.v(CastControlViewModel.f2715l);
        if (CastControlViewModel.f2715l) {
            close_extension_resource = VapAssetList.getCLOSE_MIRROR_RESOURCE();
        } else {
            close_extension_resource = CastControlViewModel.f2716m ? VapAssetList.getCLOSE_EXTENSION_RESOURCE() : VapAssetList.getMIRROR_CLOSE_RESOURCE();
        }
        castControlViewModel.f2724j.setValue(close_extension_resource);
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final void q() {
    }
}
