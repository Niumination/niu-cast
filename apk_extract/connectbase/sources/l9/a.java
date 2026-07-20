package l9;

import android.appwidget.AppWidgetProviderInfo;
import dc.e;
import fc.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9749c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mc.a f9750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t6.a f9751b;

    public List<AppWidgetProviderInfo> a(int i10) {
        return b(b.a.f5988h).a(i10);
    }

    public ff.a b(String str) {
        if (b.b(str)) {
            e.f(f9749c, "TranAppWidgetManager");
            mc.a aVar = this.f9750a;
            if (aVar != null) {
                return aVar;
            }
            mc.a aVar2 = new mc.a();
            this.f9750a = aVar2;
            return aVar2;
        }
        e.f(f9749c, "TranAospAppWidgetManager");
        t6.a aVar3 = this.f9751b;
        if (aVar3 != null) {
            return aVar3;
        }
        t6.a aVar4 = new t6.a();
        this.f9751b = aVar4;
        return aVar4;
    }
}
