package com.transsion.iotservice.multiscreen.pc.ui.guide;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.core.log.LogUtils;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.adapter.FunctionGuideAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideBean;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideRecord;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideResource;
import com.transsion.iotservice.multiscreen.pc.bean.TextBean;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityFunctionGuideBinding;
import com.transsion.iotservice.multiscreen.pc.receiver.HomeKeyReceiver;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseCloseBottomSheetDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import d4.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jb.f;
import jb.g;
import k3.gc;
import k3.sb;
import k3.vb;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import o.d;
import ob.b;
import tj.w;
import v4.a0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/guide/FunctionGuideActivity;", "Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseCloseBottomSheetDialog;", "<init>", "()V", "se/d", "ub/b", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FunctionGuideActivity extends OSBaseCloseBottomSheetDialog {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f2774o = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HomeKeyReceiver f2775k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FunctionGuideViewModel f2776l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FunctionGuideActivity$onPageChangeCallback$1 f2777m = new ViewPager2.OnPageChangeCallback() { // from class: com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity$onPageChangeCallback$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int i8) {
            super.onPageSelected(i8);
            FunctionGuideViewModel functionGuideViewModel = this.f2779a.f2776l;
            if (functionGuideViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                functionGuideViewModel = null;
            }
            MutableLiveData mutableLiveData = functionGuideViewModel.f2783d;
            Integer num = (Integer) mutableLiveData.getValue();
            if (num != null && i8 == num.intValue()) {
                return;
            }
            b bVar = b.f8417b;
            Integer num2 = (Integer) mutableLiveData.getValue();
            boolean z2 = false;
            bVar.i(i8 < (num2 != null ? num2.intValue() : 0) ? "last_page" : "next_page");
            MutableLiveData mutableLiveData2 = functionGuideViewModel.f;
            List list = (List) functionGuideViewModel.f2781b.getValue();
            if (list != null && i8 == list.size() - 1) {
                z2 = true;
            }
            mutableLiveData2.setValue(Boolean.valueOf(z2));
            mutableLiveData.setValue(Integer.valueOf(i8));
            functionGuideViewModel.b();
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ub.b f2778n = new ub.b(this);

    /* JADX WARN: Code duplicated, block: B:20:0x0069  */
    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        FunctionGuideViewModel functionGuideViewModel;
        FunctionGuideViewModel mViewModel;
        Object objFromJson;
        FunctionGuideResource functionGuideResource;
        String triggerScene = "";
        va.b.g(this);
        super.onCreate(bundle);
        FunctionGuideViewModel functionGuideViewModel2 = (FunctionGuideViewModel) new ViewModelProvider(this).get(FunctionGuideViewModel.class);
        this.f2776l = functionGuideViewModel2;
        if (functionGuideViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            functionGuideViewModel = null;
        } else {
            functionGuideViewModel = functionGuideViewModel2;
        }
        if (functionGuideViewModel.f2780a == null) {
            f.f6135a.getClass();
            g gVar = f.f6136b;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
                gVar = null;
            }
            gVar.getClass();
            f.a().f6134b.getClass();
            if (dc.b.e() < 0) {
                g gVar2 = f.f6136b;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
                    gVar2 = null;
                }
                functionGuideResource = gVar2.a();
            } else {
                f.a().f6134b.getClass();
                int iE = dc.b.e();
                if (iE != -1) {
                    String key = "sp_function_guide_cache" + iE;
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter("", "defaultVal");
                    SharedPreferences sharedPreferences = vb.f6684a;
                    if (sharedPreferences == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        sharedPreferences = null;
                    }
                    String string = sharedPreferences.getString(key, "");
                    if (string == null) {
                        string = "";
                    }
                    if (string.length() == 0) {
                        string = null;
                    }
                    if (string != null) {
                        try {
                            objFromJson = na.b.f8132a.fromJson(string, new jb.b().getType());
                        } catch (a0 e) {
                            e.printStackTrace();
                            objFromJson = null;
                        }
                        FunctionGuideResource functionGuideResource2 = (FunctionGuideResource) objFromJson;
                        if (functionGuideResource2 != null) {
                            ArrayList arrayList = new ArrayList();
                            String tag = "CacheDataSource";
                            String str = "log";
                            if (Intrinsics.areEqual(functionGuideResource2.getCountryCode(), Locale.getDefault().toString())) {
                                Iterator it = functionGuideResource2.getResource().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        functionGuideResource = new FunctionGuideResource("", arrayList, iE);
                                        break;
                                    }
                                    FunctionGuideRecord functionGuideRecord = (FunctionGuideRecord) it.next();
                                    if (new File(d.l(functionGuideRecord.getPath(), File.separator, functionGuideRecord.getName())).exists()) {
                                        arrayList.add(new FunctionGuideBean(new VapResource(functionGuideRecord.getPath(), false, 1, functionGuideRecord.getName()), new TextBean(null, functionGuideRecord.getTitle()), new TextBean(null, functionGuideRecord.getDesc()), false, null, 16, null));
                                        tag = tag;
                                        str = str;
                                    } else {
                                        String str2 = "cache resource not exist:" + functionGuideRecord;
                                        Intrinsics.checkNotNullParameter(tag, "tag");
                                        Intrinsics.checkNotNullParameter(str2, str);
                                        if (gc.f6462a <= 6) {
                                            Log.e(gc.f6463b.concat(tag), str2);
                                        }
                                        FilesKt__UtilsKt.deleteRecursively(new File(functionGuideRecord.getPath()));
                                        dc.b.a(iE);
                                    }
                                }
                            } else {
                                Intrinsics.checkNotNullParameter("CacheDataSource", "tag");
                                Intrinsics.checkNotNullParameter("loadFunctionGuideResource: lang mismatch", "log");
                                if (gc.f6462a <= 6) {
                                    Log.e(gc.f6463b.concat("CacheDataSource"), "loadFunctionGuideResource: lang mismatch");
                                }
                                dc.b.a(iE);
                            }
                            functionGuideResource = null;
                            break;
                        }
                        functionGuideResource = null;
                        break;
                    }
                    functionGuideResource = null;
                    break;
                }
                functionGuideResource = null;
                break;
                if (functionGuideResource == null) {
                    LogUtils.e("DataSourceRepository", "loadFunctionGuideResource: cache null");
                    g gVar3 = f.f6136b;
                    if (gVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("defaultDataSource");
                        gVar3 = null;
                    }
                    functionGuideResource = gVar3.a();
                }
            }
            Intrinsics.checkNotNull(functionGuideResource);
            functionGuideViewModel.f2780a = functionGuideResource;
            functionGuideViewModel.f.setValue(Boolean.valueOf(functionGuideResource.getResource().size() <= 1));
            MutableLiveData mutableLiveData = functionGuideViewModel.f2781b;
            FunctionGuideResource functionGuideResource3 = functionGuideViewModel.f2780a;
            if (functionGuideResource3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFunctionGuideResource");
                functionGuideResource3 = null;
            }
            mutableLiveData.setValue(functionGuideResource3.getResource());
            functionGuideViewModel.b();
        }
        LayoutInflater layoutInflater = getLayoutInflater();
        int i8 = ActivityFunctionGuideBinding.f2428j;
        ActivityFunctionGuideBinding activityFunctionGuideBinding = (ActivityFunctionGuideBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.activity_function_guide, null, false, DataBindingUtil.getDefaultComponent());
        activityFunctionGuideBinding.setLifecycleOwner(this);
        FunctionGuideViewModel functionGuideViewModel3 = this.f2776l;
        if (functionGuideViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            functionGuideViewModel3 = null;
        }
        activityFunctionGuideBinding.e(functionGuideViewModel3);
        FunctionGuideViewModel functionGuideViewModel4 = this.f2776l;
        if (functionGuideViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            mViewModel = null;
        } else {
            mViewModel = functionGuideViewModel4;
        }
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        sa.g diffCallback = new sa.g();
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        activityFunctionGuideBinding.f(new FunctionGuideAdapter(diffCallback));
        activityFunctionGuideBinding.g(this.f2777m);
        activityFunctionGuideBinding.d(this.f2778n);
        activityFunctionGuideBinding.f2429a.getOsBigButton().setOnClickListener(new a(2, activityFunctionGuideBinding, this));
        View root = activityFunctionGuideBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        OSPageView oSPageViewJ = j(root);
        oSPageViewJ.e(R$string.md_multi_connect);
        oSPageViewJ.d(new ce.a(this, 9));
        s(true);
        b bVar = b.f8417b;
        int i9 = f2774o;
        bVar.getClass();
        if (i9 == 1) {
            triggerScene = "shortcut_open_click";
        } else if (i9 == 5) {
            triggerScene = "cast_gesture";
        } else if (i9 == 6) {
            triggerScene = "setting_open_click";
        }
        b.f8419d = triggerScene;
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        w wVar = bVar.f8437a;
        wVar.G(triggerScene);
        t(true);
        wVar.getClass();
        w.X(sb.b() ? "iot_multi_con_pc_newtipspage_ex" : "iot_multi_con_pad_newtipspage_ex", w.D());
        HomeKeyReceiver homeKeyReceiver = new HomeKeyReceiver(new ag.a(this, 18));
        va.b.f(this, homeKeyReceiver, "android.intent.action.CLOSE_SYSTEM_DIALOGS", false);
        this.f2775k = homeKeyReceiver;
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        HomeKeyReceiver homeKeyReceiver = this.f2775k;
        if (homeKeyReceiver != null) {
            unregisterReceiver(homeKeyReceiver);
            this.f2775k = null;
        }
    }

    @Override // com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog
    public final boolean u() {
        return false;
    }
}
