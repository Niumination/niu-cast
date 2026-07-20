package com.transsion.iotservice.multiscreen.pc.helper;

import ag.d0;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelKt;
import b4.f;
import bb.c;
import bb.d;
import bb.e;
import bb.g;
import bb.h;
import bb.i;
import bb.k;
import bb.l;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsCarouselAdapter;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsLottieAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.CarouselItem;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAssetList;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcConnectSettingBinding;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcConnectSettingPadBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivity;
import com.transsion.iotservice.multiscreen.pc.ui.SharedViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.setting.PcConnectSettingViewModel;
import com.transsion.pcconnect.invoke.bridge.Device;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetslistitemlayout.OSListItemView;
import eb.g0;
import java.util.ArrayList;
import k3.gc;
import k3.pb;
import k3.sb;
import k3.ud;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import ld.m;
import li.l0;
import pd.j;
import tj.w;
import u6.a;
import va.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/helper/BaseSettingActivity;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivity;", "<init>", "()V", "bb/l", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nBaseSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseSettingActivity.kt\ncom/transsion/iotservice/multiscreen/pc/helper/BaseSettingActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,409:1\n1863#2,2:410\n*S KotlinDebug\n*F\n+ 1 BaseSettingActivity.kt\ncom/transsion/iotservice/multiscreen/pc/helper/BaseSettingActivity\n*L\n222#1:410,2\n*E\n"})
public class BaseSettingActivity extends BaseActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f2662k = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PcConnectSettingViewModel f2663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedViewModel f2664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f2665d;
    public m e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f2666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ActivityResultLauncher f2667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f2668j = LazyKt.lazy(new e(this, 2));

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final ViewDataBinding j() {
        if (sb.b()) {
            ActivityPcConnectSettingBinding activityPcConnectSettingBinding = (ActivityPcConnectSettingBinding) DataBindingUtil.setContentView(this, R$layout.activity_pc_connect_setting);
            Intrinsics.checkNotNull(activityPcConnectSettingBinding);
            l(activityPcConnectSettingBinding);
            o(activityPcConnectSettingBinding);
            return activityPcConnectSettingBinding;
        }
        ActivityPcConnectSettingPadBinding activityPcConnectSettingPadBinding = (ActivityPcConnectSettingPadBinding) DataBindingUtil.setContentView(this, R$layout.activity_pc_connect_setting_pad);
        Intrinsics.checkNotNull(activityPcConnectSettingPadBinding);
        l(activityPcConnectSettingPadBinding);
        o(activityPcConnectSettingPadBinding);
        return activityPcConnectSettingPadBinding;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final void k() {
        a aVar = this.f2329a;
        this.f2664c = (SharedViewModel) aVar.C(this);
        PcConnectSettingViewModel pcConnectSettingViewModel = (PcConnectSettingViewModel) aVar.A(this, PcConnectSettingViewModel.class);
        Intrinsics.checkNotNullParameter(pcConnectSettingViewModel, "<set-?>");
        this.f2663b = pcConnectSettingViewModel;
    }

    public final void l(ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(21, n());
        SharedViewModel sharedViewModel = this.f2664c;
        SharedViewModel sharedViewModel2 = null;
        if (sharedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareViewModel");
            sharedViewModel = null;
        }
        viewDataBinding.setVariable(2, new SettingsCarouselAdapter(sharedViewModel));
        SharedViewModel sharedViewModel3 = this.f2664c;
        if (sharedViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareViewModel");
        } else {
            sharedViewModel2 = sharedViewModel3;
        }
        viewDataBinding.setVariable(9, new SettingsLottieAdapter(sharedViewModel2));
        viewDataBinding.setVariable(4, m());
        viewDataBinding.setVariable(10, viewDataBinding.getRoot().findViewById(R$id.indicator));
        viewDataBinding.setLifecycleOwner(this);
        OSLiquidToolBar oSLiquidToolBar = (OSLiquidToolBar) viewDataBinding.getRoot().findViewById(R$id.liquidBar);
        if (oSLiquidToolBar != null) {
            oSLiquidToolBar.setOnLeftIconClickListener(new d(this, 2));
            oSLiquidToolBar.setMaskVisibility(8);
            oSLiquidToolBar.setLeftIconFillColor(0);
        }
    }

    public final l m() {
        return (l) this.f2668j.getValue();
    }

    public final PcConnectSettingViewModel n() {
        PcConnectSettingViewModel pcConnectSettingViewModel = this.f2663b;
        if (pcConnectSettingViewModel != null) {
            return pcConnectSettingViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSettingViewModel");
        return null;
    }

    public final void o(ViewDataBinding viewDataBinding) {
        OSIconTextView rightImageView;
        TextView viewTitle;
        int i8 = 1;
        View root = viewDataBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        boolean z2 = viewDataBinding instanceof ActivityPcConnectSettingBinding;
        OSListItemView oSListItemView = z2 ? ((ActivityPcConnectSettingBinding) viewDataBinding).f2448a : viewDataBinding instanceof ActivityPcConnectSettingPadBinding ? ((ActivityPcConnectSettingPadBinding) viewDataBinding).f2468a : (OSListItemView) root.findViewById(R$id.device_connect_button);
        OSListItemView oSListItemView2 = z2 ? ((ActivityPcConnectSettingBinding) viewDataBinding).f2449b : viewDataBinding instanceof ActivityPcConnectSettingPadBinding ? ((ActivityPcConnectSettingPadBinding) viewDataBinding).f2469b : (OSListItemView) root.findViewById(R$id.device_connect_item);
        if (oSListItemView != null && (viewTitle = oSListItemView.getViewTitle()) != null) {
            int i9 = R$attr.os_platform_basic_color;
            int i10 = R$color.os_platform_basic_color_hios;
            String[] strArr = j.f8764a;
            viewTitle.setTextColor(j.d(i9, getColor(i10), this));
        }
        if (oSListItemView2 != null && (rightImageView = oSListItemView2.getRightImageView()) != null) {
            rightImageView.setOnTouchListener(new f(this, i8));
        }
        n().f2871k.observe(this, new c(new bb.f(oSListItemView, this, oSListItemView2)));
        View root2 = viewDataBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Integer.valueOf(R$id.item_copy_paste_pad), new g(m())), TuplesKt.to(Integer.valueOf(R$id.item_share_network), new h(m())), TuplesKt.to(Integer.valueOf(R$id.item_share_network_pad), new i(m())), TuplesKt.to(Integer.valueOf(R$id.item_share_call), new bb.j(m())), TuplesKt.to(Integer.valueOf(R$id.item_share_sms), new k(m()))})) {
            int iIntValue = ((Number) pair.component1()).intValue();
            KFunction kFunction = (KFunction) pair.component2();
            OSListItemView oSListItemView3 = (OSListItemView) root2.findViewById(iIntValue);
            if (oSListItemView3 != null) {
                ud.a(oSListItemView3, new d0(kFunction, i8));
            }
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivity, com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b.e(this);
        Intrinsics.checkNotNullParameter(this, "activity");
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(this, "<this>");
        decorView.setSystemUiVisibility((getResources().getConfiguration().uiMode & 48) == 32 ? decorView.getSystemUiVisibility() & (-8193) : decorView.getSystemUiVisibility() | 8192);
        PcConnectSettingViewModel pcConnectSettingViewModelN = n();
        na.c.a();
        pcConnectSettingViewModelN.getClass();
        ArrayList<CarouselItem> pcConnectCarouselData = LottieAssetList.INSTANCE.getPcConnectCarouselData();
        pcConnectSettingViewModelN.f2868h.setValue(pcConnectCarouselData);
        l0.p(ViewModelKt.getViewModelScope(pcConnectSettingViewModelN), null, null, new ac.a(pcConnectSettingViewModelN, pcConnectCarouselData.size(), null), 3);
        this.f2667i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a4.b(this, 4));
        ob.b bVar = ob.b.f8417b;
        String entry = getIntent().getStringExtra("intent_track_entry_setting");
        if (entry == null) {
            entry = "settings";
        }
        bVar.getClass();
        Intrinsics.checkNotNullParameter(entry, "entry");
        w wVar = bVar.f8437a;
        wVar.W(entry);
        wVar.getClass();
        w.X("iot_multi_con_multi_screen_settings_ex", w.D());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        m mVar = this.f2665d;
        if (mVar != null) {
            mVar.dismiss();
        }
        m mVar2 = this.e;
        if (mVar2 != null) {
            mVar2.dismiss();
        }
        m mVar3 = this.f2666h;
        if (mVar3 != null) {
            mVar3.dismiss();
        }
        this.f2665d = null;
        this.e = null;
        this.f2666h = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
        Intrinsics.checkNotNullParameter("onResume", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseSettingActivity"), "onResume");
        }
        n().d(pb.a());
        n().e(pb.a());
        n().f(pb.a());
    }

    public final void p(boolean z2) {
        ob.b.f8417b.f8437a.getClass();
        Bundle bundleD = w.D();
        bundleD.putString("connected_device_type", w.F());
        g0 g0Var = g0.f4753a;
        bundleD.putString("connected_device_name", g0.b());
        w.X("iot_multi_con_device_stpage_click", bundleD);
        if (z2) {
            w.X("iot_multi_con_multi_screen_add_device_click", w.D());
        }
        try {
            Intent intent = new Intent("com.transsion.iotcard.tCircle");
            intent.setFlags(268435456);
            if (!z2) {
                Bundle bundle = new Bundle();
                Device device = g0.f;
                if (device != null) {
                    bundle.putString("deviceId", device.f2947a);
                    bundle.putString("deviceName", device.f2948b);
                }
                intent.putExtras(bundle);
            }
            intent.setPackage("com.transsion.iotcard");
            startActivity(intent);
        } catch (Exception e) {
            String log = "onJumpToTCircle: " + e;
            Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("BaseSettingActivity"), log);
            }
        }
    }
}
