package com.transsion.iotservice.multiscreen.pc.ui.gesture;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MenuItem;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.RoundedCardData;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityGestureBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivity;
import com.transsion.iotservice.multiscreen.pc.ui.gesture.GestureActivity;
import com.transsion.iotservice.multiscreen.pc.ui.gesture.GestureViewModel;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetslistitemlayout.OSListItemView;
import k3.gc;
import k3.ud;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import na.c;
import sb.a;
import tb.b;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/gesture/GestureActivity;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class GestureActivity extends BaseActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2766d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GestureViewModel f2767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f2768c;

    public GestureActivity() {
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        ob.b.f8428o = SystemClock.elapsedRealtime();
        bVar.f8437a.getClass();
        w.X("iot_pc_con_enter_mirror_gesture_page", w.D());
        this.f2768c = new b(this);
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final ViewDataBinding j() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.activity_gesture);
        final ActivityGestureBinding activityGestureBinding = (ActivityGestureBinding) contentView;
        GestureViewModel gestureViewModel = this.f2767b;
        if (gestureViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGestureVM");
            gestureViewModel = null;
        }
        activityGestureBinding.e(gestureViewModel);
        activityGestureBinding.d(this.f2768c);
        a aVar = new a(this, 5);
        OSLiquidToolBar oSLiquidToolBar = activityGestureBinding.e;
        oSLiquidToolBar.setOnLeftIconClickListener(aVar);
        oSLiquidToolBar.setMaskVisibility(8);
        oSLiquidToolBar.setLeftIconFillColor(0);
        Intrinsics.checkNotNull(activityGestureBinding);
        OSListItemView itemMirrorGesture = activityGestureBinding.f2439c;
        Intrinsics.checkNotNullExpressionValue(itemMirrorGesture, "itemMirrorGesture");
        final int i8 = 0;
        ud.a(itemMirrorGesture, new Function1() { // from class: tb.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GestureViewModel gestureViewModel2 = null;
                ActivityGestureBinding activityGestureBinding2 = activityGestureBinding;
                Boolean bool = (Boolean) obj;
                switch (i8) {
                    case 0:
                        boolean zBooleanValue = bool.booleanValue();
                        int i9 = GestureActivity.f2766d;
                        b bVar = activityGestureBinding2.f2444k;
                        if (bVar != null) {
                            Intrinsics.checkNotNullParameter("GestureActivity", "tag");
                            Intrinsics.checkNotNullParameter("onMirrorGestureSwitch", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("GestureActivity"), "onMirrorGestureSwitch");
                            }
                            GestureViewModel gestureViewModel3 = bVar.f10205a.f2767b;
                            if (gestureViewModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mGestureVM");
                            } else {
                                gestureViewModel2 = gestureViewModel3;
                            }
                            gestureViewModel2.getClass();
                            za.b.c(zBooleanValue);
                            String log = "toggleMirrorGestureSwitch " + zBooleanValue;
                            Intrinsics.checkNotNullParameter("GestureViewModel", "tag");
                            Intrinsics.checkNotNullParameter(log, "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("GestureViewModel"), log);
                            }
                            ob.b bVar2 = ob.b.f8417b;
                            bVar2.getClass();
                            String switchTo = zBooleanValue ? "on" : "off";
                            Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                            bVar2.f8437a.getClass();
                            Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                            Bundle bundle = new Bundle();
                            bundle.putString("switch_to", switchTo);
                            w.X("iot_pc_con_switch_mirror_toggle", bundle);
                        }
                        break;
                    default:
                        boolean zBooleanValue2 = bool.booleanValue();
                        int i10 = GestureActivity.f2766d;
                        b bVar3 = activityGestureBinding2.f2444k;
                        if (bVar3 != null) {
                            Intrinsics.checkNotNullParameter("GestureActivity", "tag");
                            Intrinsics.checkNotNullParameter("onThreeFingerFastSwitch", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("GestureActivity"), "onThreeFingerFastSwitch");
                            }
                            GestureViewModel gestureViewModel4 = bVar3.f10205a.f2767b;
                            if (gestureViewModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mGestureVM");
                            } else {
                                gestureViewModel2 = gestureViewModel4;
                            }
                            gestureViewModel2.getClass();
                            za.b.b(zBooleanValue2);
                            ob.b.f8417b.q(zBooleanValue2);
                            String log2 = "toggleAirTransferSwitch " + zBooleanValue2;
                            Intrinsics.checkNotNullParameter("GestureViewModel", "tag");
                            Intrinsics.checkNotNullParameter(log2, "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("GestureViewModel"), log2);
                            }
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        });
        OSListItemView itemThreeFingerFast = activityGestureBinding.f2440d;
        Intrinsics.checkNotNullExpressionValue(itemThreeFingerFast, "itemThreeFingerFast");
        final int i9 = 1;
        ud.a(itemThreeFingerFast, new Function1() { // from class: tb.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GestureViewModel gestureViewModel2 = null;
                ActivityGestureBinding activityGestureBinding2 = activityGestureBinding;
                Boolean bool = (Boolean) obj;
                switch (i9) {
                    case 0:
                        boolean zBooleanValue = bool.booleanValue();
                        int i10 = GestureActivity.f2766d;
                        b bVar = activityGestureBinding2.f2444k;
                        if (bVar != null) {
                            Intrinsics.checkNotNullParameter("GestureActivity", "tag");
                            Intrinsics.checkNotNullParameter("onMirrorGestureSwitch", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("GestureActivity"), "onMirrorGestureSwitch");
                            }
                            GestureViewModel gestureViewModel3 = bVar.f10205a.f2767b;
                            if (gestureViewModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mGestureVM");
                            } else {
                                gestureViewModel2 = gestureViewModel3;
                            }
                            gestureViewModel2.getClass();
                            za.b.c(zBooleanValue);
                            String log = "toggleMirrorGestureSwitch " + zBooleanValue;
                            Intrinsics.checkNotNullParameter("GestureViewModel", "tag");
                            Intrinsics.checkNotNullParameter(log, "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("GestureViewModel"), log);
                            }
                            ob.b bVar2 = ob.b.f8417b;
                            bVar2.getClass();
                            String switchTo = zBooleanValue ? "on" : "off";
                            Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                            bVar2.f8437a.getClass();
                            Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                            Bundle bundle = new Bundle();
                            bundle.putString("switch_to", switchTo);
                            w.X("iot_pc_con_switch_mirror_toggle", bundle);
                        }
                        break;
                    default:
                        boolean zBooleanValue2 = bool.booleanValue();
                        int i11 = GestureActivity.f2766d;
                        b bVar3 = activityGestureBinding2.f2444k;
                        if (bVar3 != null) {
                            Intrinsics.checkNotNullParameter("GestureActivity", "tag");
                            Intrinsics.checkNotNullParameter("onThreeFingerFastSwitch", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("GestureActivity"), "onThreeFingerFastSwitch");
                            }
                            GestureViewModel gestureViewModel4 = bVar3.f10205a.f2767b;
                            if (gestureViewModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mGestureVM");
                            } else {
                                gestureViewModel2 = gestureViewModel4;
                            }
                            gestureViewModel2.getClass();
                            za.b.b(zBooleanValue2);
                            ob.b.f8417b.q(zBooleanValue2);
                            String log2 = "toggleAirTransferSwitch " + zBooleanValue2;
                            Intrinsics.checkNotNullParameter("GestureViewModel", "tag");
                            Intrinsics.checkNotNullParameter(log2, "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("GestureViewModel"), log2);
                            }
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        });
        Intrinsics.checkNotNullExpressionValue(contentView, "apply(...)");
        return contentView;
    }

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final void k() {
        this.f2767b = (GestureViewModel) this.f2329a.A(this, GestureViewModel.class);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivity, com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        va.b.e(this);
        GestureViewModel gestureViewModel = this.f2767b;
        if (gestureViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGestureVM");
            gestureViewModel = null;
        }
        boolean zA = c.a();
        gestureViewModel.getClass();
        String log = "loadData isXos: " + zA;
        Intrinsics.checkNotNullParameter("GestureViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("GestureViewModel"), log);
        }
        String str = zA ? "xos" : "hios";
        gestureViewModel.f2771c.setValue(new RoundedCardData(R$string.md_transfer_tip8, R$string.md_transfer_tip9, h0.a.j("pcConnectionSetting/", str, "/gesture/light/data.json"), h0.a.j("pcConnectionSetting/", str, "/gesture/night/data.json")));
        gestureViewModel.e.setValue(new RoundedCardData(R$string.md_transfer_tip10, R$string.md_transfer_tip11, h0.a.j("PcTransferSetting/", str, "/air-transfer/light/data.json"), h0.a.j("PcTransferSetting/", str, "/air-transfer/night/data.json")));
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        onBackPressed();
        return true;
    }
}
