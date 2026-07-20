package db;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.transsion.iotcardsdk.SdkInit;
import com.transsion.iotcardsdk.bean.DisplayTemplateBean;
import com.transsion.iotservice.multiscreen.pc.R$string;
import eb.k1;
import java.util.Locale;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import li.g2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4395a = "com.transssion.pcconnect";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DisplayTemplateBean f4396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static g2 f4398d;

    public static DisplayTemplateBean a(hc.c cVar) {
        int i8;
        String upperCase;
        String str;
        String str2;
        String strConcat;
        String strValueOf = String.valueOf(cVar != null ? Integer.valueOf(cVar.f) : null);
        if (Intrinsics.areEqual(strValueOf, ExifInterface.GPS_MEASUREMENT_2D)) {
            i8 = 17;
        } else {
            i8 = Intrinsics.areEqual(strValueOf, "1") ? 18 : 4;
        }
        int i9 = i8;
        String str3 = cVar != null ? cVar.f5288c : null;
        if (str3 != null) {
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            upperCase = str3.toUpperCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        String strI = h0.a.i("WelinkService-", upperCase);
        if (cVar == null || (str = cVar.f5286a) == null) {
            str = "";
        }
        String str4 = str;
        String str5 = f4395a;
        String str6 = cVar != null ? cVar.f5287b : null;
        if (str6 == null || str6.length() == 0) {
            int i10 = cVar != null ? cVar.f5289d : 0;
            if (i10 == Integer.parseInt("03")) {
                str2 = "Tecno";
            } else if (i10 == Integer.parseInt("04")) {
                str2 = "Infinix";
            } else {
                str2 = i10 == Integer.parseInt("02") ? "Itel" : "UNKONW";
            }
            strConcat = "PC ".concat(str2);
        } else {
            strConcat = h0.a.i("PC ", cVar != null ? cVar.f5287b : null);
        }
        String str7 = strConcat;
        String string = pb.a().getResources().getString(R$string.module_pc_tranfer_connected);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        DisplayTemplateBean displayTemplateBean = new DisplayTemplateBean(strI, str5, str7, null, null, null, i9, str4, true, string, null, null, null, null, null, null, System.currentTimeMillis(), null, null, false, null, null, 0, null, null, null, 0, null, null, 536804408, null);
        f4396b = displayTemplateBean;
        Intrinsics.checkNotNull(displayTemplateBean);
        return displayTemplateBean;
    }

    public static void b() {
        k1 k1Var = k1.f4765a;
        hc.c cVar = k1.e;
        String str = cVar != null ? cVar.f5287b : null;
        String str2 = cVar != null ? cVar.f5288c : null;
        Integer numValueOf = cVar != null ? Integer.valueOf(cVar.f) : null;
        StringBuilder sbP = h0.a.p("registerDevice bean: ", str, ", ", str2, ", ");
        sbP.append(numValueOf);
        gc.c("PCIotCardManager", sbP.toString());
        if (f4397c) {
            gc.c("PCIotCardManager", "registerDevice is iot card shown");
            return;
        }
        DisplayTemplateBean displayTemplateBeanA = a(cVar);
        f4397c = true;
        gc.c("PCIotCardManager", "iotCardTemplateBean: " + displayTemplateBeanA.getDataBundle());
        SdkInit.INSTANCE.registerDevice(pb.a(), displayTemplateBeanA);
    }

    public static void c() {
        if (!f4397c) {
            Intrinsics.checkNotNullParameter("PCIotCardManager", "tag");
            Intrinsics.checkNotNullParameter("unRegisterDevice: is iot card not shown", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCIotCardManager"), "unRegisterDevice: is iot card not shown");
                return;
            }
            return;
        }
        DisplayTemplateBean displayTemplateBean = f4396b;
        if (displayTemplateBean != null) {
            f4397c = false;
            String log = "<unRegisterDevice> " + displayTemplateBean;
            Intrinsics.checkNotNullParameter("PCIotCardManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCIotCardManager"), log);
            }
            SdkInit.INSTANCE.unregisterDevice(pb.a(), displayTemplateBean);
        }
    }
}
