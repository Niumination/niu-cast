package com.transsion.iotservice.multiscreen.pc.ui.guide;

import a1.a;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideResource;
import jb.f;
import k3.gc;
import k3.sb;
import k3.vb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;
import ob.b;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/guide/FunctionGuideViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FunctionGuideViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FunctionGuideResource f2780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData f2783d;
    public final MutableLiveData e;
    public final MutableLiveData f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f2784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f2785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData f2786i;

    public FunctionGuideViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f2781b = mutableLiveData;
        this.f2782c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData(0);
        this.f2783d = mutableLiveData2;
        this.e = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData(Boolean.FALSE);
        this.f = mutableLiveData3;
        this.f2784g = mutableLiveData3;
        MutableLiveData mutableLiveData4 = new MutableLiveData(Integer.valueOf(R$string.function_guide_next));
        this.f2785h = mutableLiveData4;
        this.f2786i = mutableLiveData4;
    }

    public final void a() {
        f fVar = f.f6135a;
        FunctionGuideResource functionGuideResource = this.f2780a;
        SharedPreferences sharedPreferences = null;
        if (functionGuideResource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFunctionGuideResource");
            functionGuideResource = null;
        }
        int version = functionGuideResource.getVersion();
        String key = a.o(version, "sp_function_guide_already_remind_count");
        String strH = d.h(version, "sp_function_guide_already_remind_count", "key");
        SharedPreferences sharedPreferences2 = vb.f6684a;
        if (sharedPreferences2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences2 = null;
        }
        int i8 = sharedPreferences2.getInt(strH, 0) + 1;
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences sharedPreferences3 = vb.f6684a;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences3 = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences3.edit();
        editorEdit.putInt(key, i8);
        editorEdit.apply();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter("sp_function_guide_last_show_time", "key");
        SharedPreferences sharedPreferences4 = vb.f6684a;
        if (sharedPreferences4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        } else {
            sharedPreferences = sharedPreferences4;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
        editorEdit2.putLong("sp_function_guide_last_show_time", jCurrentTimeMillis);
        editorEdit2.apply();
        b bVar = b.f8417b;
        bVar.getClass();
        String triggerScene = b.f8419d;
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        w wVar = bVar.f8437a;
        wVar.H(triggerScene);
        wVar.getClass();
        w.X(sb.b() ? "iot_multi_con_pc_newtipspage_exit" : "iot_multi_con_pad_newtipspage_exit", w.D());
    }

    public final void b() {
        int i8;
        boolean zAreEqual = Intrinsics.areEqual(this.f.getValue(), Boolean.TRUE);
        if (zAreEqual) {
            i8 = sb.b() ? R$string.md_taste_now : R$string.md_know;
        } else {
            i8 = R$string.function_guide_next;
        }
        String log = "updateButtonTextResId: isLast=" + zAreEqual + ", isPhone=" + sb.b();
        Intrinsics.checkNotNullParameter("FunctionGuideViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FunctionGuideViewModel"), log);
        }
        this.f2785h.setValue(Integer.valueOf(i8));
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        a();
    }
}
