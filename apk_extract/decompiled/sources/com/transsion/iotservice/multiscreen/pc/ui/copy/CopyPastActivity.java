package com.transsion.iotservice.multiscreen.pc.ui.copy;

import ag.d0;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.RoundedCardData;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityCopyPasteBinding;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivity;
import com.transsion.iotservice.multiscreen.pc.ui.copy.CopyPastActivity;
import com.transsion.iotservice.multiscreen.pc.ui.copy.CopyPastViewModel;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetslistitemlayout.OSListItemView;
import h0.a;
import k3.gc;
import k3.ud;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import na.c;
import o.d;
import rb.b;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/copy/CopyPastActivity;", "Lcom/transsion/iotservice/multiscreen/pc/ui/BaseActivity;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class CopyPastActivity extends BaseActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2703d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CopyPastViewModel f2704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f2705c = new b(this);

    @Override // com.transsion.base.arch.mvvm.DataBindingActivity
    public final ViewDataBinding j() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R$layout.activity_copy_paste);
        final ActivityCopyPasteBinding activityCopyPasteBinding = (ActivityCopyPasteBinding) contentView;
        CopyPastViewModel copyPastViewModel = this.f2704b;
        if (copyPastViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCopyVM");
            copyPastViewModel = null;
        }
        activityCopyPasteBinding.e(copyPastViewModel);
        activityCopyPasteBinding.d(this.f2705c);
        d0 d0Var = new d0(this, 28);
        OSLiquidToolBar oSLiquidToolBar = activityCopyPasteBinding.f2421d;
        oSLiquidToolBar.setOnLeftIconClickListener(d0Var);
        oSLiquidToolBar.setMaskVisibility(8);
        oSLiquidToolBar.setLeftIconFillColor(0);
        Intrinsics.checkNotNull(activityCopyPasteBinding);
        OSListItemView itemCopyPaste = activityCopyPasteBinding.f2419b;
        Intrinsics.checkNotNullExpressionValue(itemCopyPaste, "itemCopyPaste");
        final int i8 = 0;
        ud.a(itemCopyPaste, new Function1() { // from class: rb.a
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v11 */
            /* JADX WARN: Type inference failed for: r11v12, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r11v18 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CopyPastViewModel copyPastViewModel2 = null;
                ActivityCopyPasteBinding activityCopyPasteBinding2 = activityCopyPasteBinding;
                Boolean bool = (Boolean) obj;
                switch (i8) {
                    case 0:
                        boolean zBooleanValue = bool.booleanValue();
                        int i9 = CopyPastActivity.f2703d;
                        b bVar = activityCopyPasteBinding2.f2423i;
                        if (bVar != null) {
                            Intrinsics.checkNotNullParameter("CopyPastActivity", "tag");
                            Intrinsics.checkNotNullParameter("onCopyPasteSwitch", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("CopyPastActivity"), "onCopyPasteSwitch");
                            }
                            CopyPastViewModel copyPastViewModel3 = bVar.f9391a.f2704b;
                            if (copyPastViewModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mCopyVM");
                            } else {
                                copyPastViewModel2 = copyPastViewModel3;
                            }
                            if (!Intrinsics.areEqual(bool, copyPastViewModel2.f2706a.getValue())) {
                                String switchTo = zBooleanValue ? "on" : "off";
                                ob.b bVar2 = ob.b.f8417b;
                                bVar2.getClass();
                                Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                                Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                                bVar2.f8437a.getClass();
                                Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                                Bundle bundle = new Bundle();
                                bundle.putString("switch_to", switchTo);
                                bundle.putString("device_type", w.B());
                                bundle.putString("my_device_type", w.B());
                                w.X("iot_multi_con_shareclipboard_switch", bundle);
                                lb.a.e("clipboard_shared_enabled", zBooleanValue);
                                String log = "<saveCopyPasteSwitchState>:switchOn " + zBooleanValue;
                                Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
                                Intrinsics.checkNotNullParameter(log, "log");
                                if (gc.f6462a <= 4) {
                                    Log.i(gc.f6463b.concat("CopyPastViewModel"), log);
                                }
                                if (zBooleanValue) {
                                    boolean zAreEqual = Intrinsics.areEqual(lb.a.b("air_copy_user_original_state").getValue(), Boolean.TRUE);
                                    String strO = d.o("Restoring air copy original state: ", zAreEqual, "CopyPastViewModel", "tag", "log");
                                    if (gc.f6462a <= 4) {
                                        Log.i(gc.f6463b.concat("CopyPastViewModel"), strO);
                                    }
                                    za.b.a(zAreEqual);
                                } else {
                                    Boolean bool2 = (Boolean) za.b.f11271d.getValue();
                                    ?? BooleanValue = bool2 != null ? bool2.booleanValue() : 0;
                                    String strO2 = d.o("Current air copy state before saving: ", BooleanValue, "CopyPastViewModel", "tag", "log");
                                    if (gc.f6462a <= 4) {
                                        Log.i(gc.f6463b.concat("CopyPastViewModel"), strO2);
                                    }
                                    try {
                                        lb.a.e("air_copy_user_original_state", BooleanValue);
                                        String log2 = "Air copy user original state saved with value " + ((int) BooleanValue);
                                        Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
                                        Intrinsics.checkNotNullParameter(log2, "log");
                                        if (gc.f6462a <= 3) {
                                            Log.d(gc.f6463b.concat("CopyPastViewModel"), log2);
                                        }
                                    } catch (Exception unused) {
                                        String strO3 = d.o("Failed to save air copy user original state: ", BooleanValue, "CopyPastViewModel", "tag", "log");
                                        if (gc.f6462a <= 6) {
                                            Log.e(gc.f6463b.concat("CopyPastViewModel"), strO3);
                                        }
                                    }
                                    String strO4 = d.o("Saving air copy original state: ", BooleanValue, "CopyPastViewModel", "tag", "log");
                                    if (gc.f6462a <= 4) {
                                        Log.i(gc.f6463b.concat("CopyPastViewModel"), strO4);
                                    }
                                    za.b.a(false);
                                }
                                Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
                                Intrinsics.checkNotNullParameter("toggleCopyPasteSwitch", "log");
                                if (gc.f6462a <= 4) {
                                    Log.i(gc.f6463b.concat("CopyPastViewModel"), "toggleCopyPasteSwitch");
                                }
                            }
                        }
                        break;
                    default:
                        boolean zBooleanValue2 = bool.booleanValue();
                        int i10 = CopyPastActivity.f2703d;
                        b bVar3 = activityCopyPasteBinding2.f2423i;
                        if (bVar3 != null) {
                            Intrinsics.checkNotNullParameter("CopyPastActivity", "tag");
                            Intrinsics.checkNotNullParameter("onThreeCopyPasteSwitch", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("CopyPastActivity"), "onThreeCopyPasteSwitch");
                            }
                            CopyPastViewModel copyPastViewModel4 = bVar3.f9391a.f2704b;
                            if (copyPastViewModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mCopyVM");
                            } else {
                                copyPastViewModel2 = copyPastViewModel4;
                            }
                            copyPastViewModel2.getClass();
                            za.b.a(zBooleanValue2);
                            String log3 = "toggleAirCopySwitch " + zBooleanValue2;
                            Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
                            Intrinsics.checkNotNullParameter(log3, "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("CopyPastViewModel"), log3);
                            }
                        }
                        break;
                }
                return Unit.INSTANCE;
            }
        });
        OSListItemView itemThreeCopy = activityCopyPasteBinding.f2420c;
        Intrinsics.checkNotNullExpressionValue(itemThreeCopy, "itemThreeCopy");
        final int i9 = 1;
        ud.a(itemThreeCopy, new Function1() { // from class: rb.a
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v11 */
            /* JADX WARN: Type inference failed for: r11v12, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r11v18 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CopyPastViewModel copyPastViewModel2 = null;
                ActivityCopyPasteBinding activityCopyPasteBinding2 = activityCopyPasteBinding;
                Boolean bool = (Boolean) obj;
                switch (i9) {
                    case 0:
                        boolean zBooleanValue = bool.booleanValue();
                        int i10 = CopyPastActivity.f2703d;
                        b bVar = activityCopyPasteBinding2.f2423i;
                        if (bVar != null) {
                            Intrinsics.checkNotNullParameter("CopyPastActivity", "tag");
                            Intrinsics.checkNotNullParameter("onCopyPasteSwitch", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("CopyPastActivity"), "onCopyPasteSwitch");
                            }
                            CopyPastViewModel copyPastViewModel3 = bVar.f9391a.f2704b;
                            if (copyPastViewModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mCopyVM");
                            } else {
                                copyPastViewModel2 = copyPastViewModel3;
                            }
                            if (!Intrinsics.areEqual(bool, copyPastViewModel2.f2706a.getValue())) {
                                String switchTo = zBooleanValue ? "on" : "off";
                                ob.b bVar2 = ob.b.f8417b;
                                bVar2.getClass();
                                Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                                Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                                bVar2.f8437a.getClass();
                                Intrinsics.checkNotNullParameter(switchTo, "switchTo");
                                Bundle bundle = new Bundle();
                                bundle.putString("switch_to", switchTo);
                                bundle.putString("device_type", w.B());
                                bundle.putString("my_device_type", w.B());
                                w.X("iot_multi_con_shareclipboard_switch", bundle);
                                lb.a.e("clipboard_shared_enabled", zBooleanValue);
                                String log = "<saveCopyPasteSwitchState>:switchOn " + zBooleanValue;
                                Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
                                Intrinsics.checkNotNullParameter(log, "log");
                                if (gc.f6462a <= 4) {
                                    Log.i(gc.f6463b.concat("CopyPastViewModel"), log);
                                }
                                if (zBooleanValue) {
                                    boolean zAreEqual = Intrinsics.areEqual(lb.a.b("air_copy_user_original_state").getValue(), Boolean.TRUE);
                                    String strO = d.o("Restoring air copy original state: ", zAreEqual, "CopyPastViewModel", "tag", "log");
                                    if (gc.f6462a <= 4) {
                                        Log.i(gc.f6463b.concat("CopyPastViewModel"), strO);
                                    }
                                    za.b.a(zAreEqual);
                                } else {
                                    Boolean bool2 = (Boolean) za.b.f11271d.getValue();
                                    ?? BooleanValue = bool2 != null ? bool2.booleanValue() : 0;
                                    String strO2 = d.o("Current air copy state before saving: ", BooleanValue, "CopyPastViewModel", "tag", "log");
                                    if (gc.f6462a <= 4) {
                                        Log.i(gc.f6463b.concat("CopyPastViewModel"), strO2);
                                    }
                                    try {
                                        lb.a.e("air_copy_user_original_state", BooleanValue);
                                        String log2 = "Air copy user original state saved with value " + ((int) BooleanValue);
                                        Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
                                        Intrinsics.checkNotNullParameter(log2, "log");
                                        if (gc.f6462a <= 3) {
                                            Log.d(gc.f6463b.concat("CopyPastViewModel"), log2);
                                        }
                                    } catch (Exception unused) {
                                        String strO3 = d.o("Failed to save air copy user original state: ", BooleanValue, "CopyPastViewModel", "tag", "log");
                                        if (gc.f6462a <= 6) {
                                            Log.e(gc.f6463b.concat("CopyPastViewModel"), strO3);
                                        }
                                    }
                                    String strO4 = d.o("Saving air copy original state: ", BooleanValue, "CopyPastViewModel", "tag", "log");
                                    if (gc.f6462a <= 4) {
                                        Log.i(gc.f6463b.concat("CopyPastViewModel"), strO4);
                                    }
                                    za.b.a(false);
                                }
                                Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
                                Intrinsics.checkNotNullParameter("toggleCopyPasteSwitch", "log");
                                if (gc.f6462a <= 4) {
                                    Log.i(gc.f6463b.concat("CopyPastViewModel"), "toggleCopyPasteSwitch");
                                }
                            }
                        }
                        break;
                    default:
                        boolean zBooleanValue2 = bool.booleanValue();
                        int i11 = CopyPastActivity.f2703d;
                        b bVar3 = activityCopyPasteBinding2.f2423i;
                        if (bVar3 != null) {
                            Intrinsics.checkNotNullParameter("CopyPastActivity", "tag");
                            Intrinsics.checkNotNullParameter("onThreeCopyPasteSwitch", "log");
                            if (gc.f6462a <= 3) {
                                Log.d(gc.f6463b.concat("CopyPastActivity"), "onThreeCopyPasteSwitch");
                            }
                            CopyPastViewModel copyPastViewModel4 = bVar3.f9391a.f2704b;
                            if (copyPastViewModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mCopyVM");
                            } else {
                                copyPastViewModel2 = copyPastViewModel4;
                            }
                            copyPastViewModel2.getClass();
                            za.b.a(zBooleanValue2);
                            String log3 = "toggleAirCopySwitch " + zBooleanValue2;
                            Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
                            Intrinsics.checkNotNullParameter(log3, "log");
                            if (gc.f6462a <= 4) {
                                Log.i(gc.f6463b.concat("CopyPastViewModel"), log3);
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
        this.f2704b = (CopyPastViewModel) this.f2329a.A(this, CopyPastViewModel.class);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.ui.BaseActivity, com.transsion.base.arch.mvvm.DataBindingActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        va.b.e(this);
        CopyPastViewModel copyPastViewModel = this.f2704b;
        if (copyPastViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCopyVM");
            copyPastViewModel = null;
        }
        boolean zA = c.a();
        copyPastViewModel.getClass();
        String log = "loadData " + zA;
        Intrinsics.checkNotNullParameter("CopyPastViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("CopyPastViewModel"), log);
        }
        String str = zA ? "xos" : "hios";
        copyPastViewModel.f2707b.setValue(new RoundedCardData(R$string.md_transfer_tip3, R$string.md_transfer_tip4, a.j("PcTransferSetting/", str, "/air-copy/light/data.json"), a.j("PcTransferSetting/", str, "/air-copy/night/data.json")));
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
