package com.transsion.iotservice.multiscreen.pc.ui.setting;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import bd.b;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.ConnectedDevice;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.bean.TextBean;
import eb.g0;
import eb.l2;
import eb.y0;
import k3.gc;
import k3.pb;
import k3.sb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lb.a;
import se.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/setting/PcConnectSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PcConnectSettingViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f2863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData f2866d;
    public final MutableLiveData e;
    public final MutableLiveData f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f2867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f2868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData f2869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData f2870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableLiveData f2871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData f2872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f2873m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MutableLiveData f2874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MutableLiveData f2875o;
    public final MutableLiveData p;
    public final MutableLiveData q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MutableLiveData f2876r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final MutableLiveData f2877s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MutableLiveData f2878t;
    public final int u;

    /* JADX WARN: Multi-variable type inference failed */
    public PcConnectSettingViewModel() {
        SearchPageText searchPageText;
        int i8 = 1;
        MutableLiveData mutableLiveData = new MutableLiveData(0);
        this.f2863a = mutableLiveData;
        this.f2864b = mutableLiveData;
        y0 y0Var = y0.f4813a;
        MutableLiveData mutableLiveData2 = za.b.f11268a;
        this.f2865c = a.b("multi_device_connection.share_network");
        this.f2866d = a.b("multi_device_connection.share_notifications");
        this.e = a.b("clipboard_shared_enabled");
        this.f = a.b("multi_device_connection.share_call");
        this.f2867g = a.b("multi_device_connection.share_sms");
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.f2868h = mutableLiveData3;
        this.f2869i = mutableLiveData3;
        this.f2870j = new MutableLiveData();
        this.f2871k = new MutableLiveData(Boolean.FALSE);
        MutableLiveData mutableLiveData4 = new MutableLiveData();
        try {
            pb.a().getPackageManager().getPackageInfo("com.transsion.tips", 0);
            searchPageText = new SearchPageText(new TextBean(Integer.valueOf(R$string.md_func_tip14), null), new TextBean(Integer.valueOf(R$string.md_use_show), null), true);
        } catch (PackageManager.NameNotFoundException unused) {
            searchPageText = new SearchPageText(new TextBean(Integer.valueOf(R$string.intro_unsupport_tip), null), new TextBean(Integer.valueOf(R$string.empty_string), null), true);
        }
        mutableLiveData4.setValue(searchPageText);
        this.f2872l = mutableLiveData4;
        this.f2873m = new b();
        MutableLiveData mutableLiveData5 = new MutableLiveData();
        this.f2874n = mutableLiveData5;
        this.f2875o = mutableLiveData5;
        MutableLiveData mutableLiveData6 = new MutableLiveData();
        this.p = mutableLiveData6;
        this.q = mutableLiveData6;
        MutableLiveData mutableLiveData7 = new MutableLiveData();
        this.f2876r = mutableLiveData7;
        this.f2877s = mutableLiveData7;
        this.f2878t = g0.e;
        sb.b();
        this.u = R$drawable.icon_connect_devices_os;
        String log = "refreshSettings: network=" + ((Boolean) a.b("multi_device_connection.share_network").getValue()) + ", notification=" + ((Boolean) a.b("multi_device_connection.share_notifications").getValue()) + ", copyPaste=" + ((Boolean) a.b("clipboard_shared_enabled").getValue());
        Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SettingViewModel"), log);
        }
        e listener = new e(this, i8);
        Intrinsics.checkNotNullParameter(listener, "listener");
        g0.f4761k = listener;
        c();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final int a() {
        ConnectedDevice connectedDevice = (ConnectedDevice) this.f2878t.getValue();
        String type = connectedDevice != null ? connectedDevice.getType() : null;
        if (type != null) {
            switch (type.hashCode()) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    if (type.equals("1")) {
                        return R$drawable.icon_phone;
                    }
                    break;
                case 50:
                    if (type.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                        return R$drawable.icon_pad;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (type.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                        return R$drawable.icon_pc;
                    }
                    break;
            }
        }
        return R$drawable.icon_pc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String b() {
        String subTitleForString;
        ConnectedDevice connectedDevice = (ConnectedDevice) this.f2878t.getValue();
        return (connectedDevice == null || (subTitleForString = connectedDevice.getSubTitleForString()) == null) ? "" : subTitleForString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        ConnectedDevice connectedDevice = (ConnectedDevice) this.f2878t.getValue();
        String name = connectedDevice != null ? connectedDevice.getName() : null;
        String str = l2.f4778i;
        if (str == null) {
            str = "";
        }
        if (name == null || StringsKt.isBlank(name)) {
            name = StringsKt.isBlank(str) ? null : str;
        }
        this.f2870j.postValue(name);
        this.f2871k.postValue(Boolean.valueOf(name != null));
        String log = "title: " + name + ", deviceItemVisible: " + (name != null);
        Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SettingViewModel"), log);
        }
    }

    public final void d(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2874n.setValue(Intrinsics.areEqual(a.b("multi_device_connection.allow_find").getValue(), Boolean.TRUE) ? context.getString(R$string.md_all_device) : context.getString(R$string.md_trust_device));
    }

    public final void e(Application context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        int iC = a.c("multi_device_connection.share_call_pad");
        MutableLiveData mutableLiveData = this.p;
        if (iC == 0) {
            string = context.getString(R$string.only_cast_tip);
        } else if (iC != 1) {
            string = iC != 2 ? context.getString(R$string.no_tip) : context.getString(R$string.no_tip);
        } else {
            string = context.getString(R$string.connect_tip);
        }
        mutableLiveData.setValue(string);
    }

    public final void f(Application context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        int iC = a.c("multi_device_connection.share_sms_pad");
        MutableLiveData mutableLiveData = this.f2876r;
        if (iC == 0) {
            string = context.getString(R$string.only_cast_tip);
        } else if (iC != 1) {
            string = iC != 2 ? context.getString(R$string.no_tip) : context.getString(R$string.no_tip);
        } else {
            string = context.getString(R$string.connect_tip);
        }
        mutableLiveData.setValue(string);
    }
}
