package g9;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import dc.e;
import hc.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6446c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f6447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o6.a f6448b;

    public boolean a(ComponentName componentName, int i10) {
        if (componentName == null) {
            return false;
        }
        return d(fc.b.a.F).c(componentName, i10);
    }

    @yb.a(level = 1)
    public boolean b(AccessibilityServiceInfo accessibilityServiceInfo) {
        return d(fc.b.a.f5983c).d(accessibilityServiceInfo);
    }

    public List<AccessibilityServiceInfo> c() {
        return d(fc.b.a.f5986f).b();
    }

    public af.a d(String str) {
        if (fc.b.b(str)) {
            e.f(f6446c, "TranThubAccessibilityServiceInfoManager");
            b bVar = this.f6447a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f6447a = bVar2;
            return bVar2;
        }
        e.f(f6446c, "TranAospAccessibilityServiceInfoManager");
        o6.a aVar = this.f6448b;
        if (aVar != null) {
            return aVar;
        }
        o6.a aVar2 = new o6.a();
        this.f6448b = aVar2;
        return aVar2;
    }

    public boolean e(ComponentName componentName, int i10) {
        if (componentName == null) {
            return false;
        }
        return d(fc.b.a.F).a(componentName, i10);
    }
}
