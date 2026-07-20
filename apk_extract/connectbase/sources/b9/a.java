package b9;

import android.content.Context;
import com.transsion.hubsdk.api.view.TranBrightnessInfo;

/* JADX INFO: loaded from: classes2.dex */
public class a implements lh.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f757b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f758c = cc.a.a("android.view.Display");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f759d = cc.a.a("android.hardware.display.BrightnessInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f760a = bc.a.a();

    @Override // lh.a
    public TranBrightnessInfo a() {
        try {
            TranBrightnessInfo tranBrightnessInfo = new TranBrightnessInfo();
            Object objJ = cc.a.j(cc.a.g(f758c, "getBrightnessInfo", new Class[0]), null, new Object[0]);
            if (objJ == null) {
                return tranBrightnessInfo;
            }
            if (f759d.isInstance(objJ)) {
                dc.e.f(f757b, "object :" + objJ);
            }
            float f10 = cc.a.d(f759d, "brightness").getFloat(objJ);
            float f11 = cc.a.d(f759d, "adjustedBrightness").getFloat(objJ);
            float f12 = cc.a.d(f759d, "brightnessMinimum").getFloat(objJ);
            float f13 = cc.a.d(f759d, "brightnessMaximum").getFloat(objJ);
            float f14 = cc.a.d(f759d, "highBrightnessTransitionPoint").getFloat(objJ);
            int i10 = cc.a.d(f759d, "highBrightnessMode").getInt(objJ);
            int i11 = cc.a.d(f759d, "brightnessMaxReason").getInt(objJ);
            tranBrightnessInfo.f2260a = f10;
            tranBrightnessInfo.f2261b = f11;
            tranBrightnessInfo.f2262c = f12;
            tranBrightnessInfo.f2263d = f13;
            tranBrightnessInfo.f2264e = f14;
            tranBrightnessInfo.f2265f = i10;
            tranBrightnessInfo.f2266g = i11;
            return tranBrightnessInfo;
        } catch (Exception e10) {
            p6.b.a("getBrightnessInfo fail ", e10, f757b);
            return null;
        }
    }
}
