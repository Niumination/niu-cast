package o6;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.view.accessibility.AccessibilityManager;
import dc.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements af.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12104b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityManager f12105a = (AccessibilityManager) bc.a.a().getSystemService("accessibility");

    @Override // af.a
    public boolean a(ComponentName componentName, int i10) {
        return false;
    }

    @Override // af.a
    public List<AccessibilityServiceInfo> b() {
        Object objJ = cc.a.j(cc.a.g(this.f12105a.getClass(), "getInstalledAccessibilityServiceList", new Class[0]), this.f12105a, new Object[0]);
        ArrayList arrayList = new ArrayList();
        if (objJ instanceof List) {
            for (Object obj : (List) objJ) {
                if (obj.getClass().equals(AccessibilityServiceInfo.class)) {
                    arrayList.add((AccessibilityServiceInfo) AccessibilityServiceInfo.class.cast(obj));
                }
            }
        }
        return arrayList;
    }

    @Override // af.a
    public boolean c(ComponentName componentName, int i10) {
        return false;
    }

    @Override // af.a
    public boolean d(AccessibilityServiceInfo accessibilityServiceInfo) {
        try {
            return cc.a.d(accessibilityServiceInfo.getClass(), "crashed").getBoolean(accessibilityServiceInfo);
        } catch (Exception unused) {
            e.c(f12104b, "getCrashed fail.");
            return false;
        }
    }
}
