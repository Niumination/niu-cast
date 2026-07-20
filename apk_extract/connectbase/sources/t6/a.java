package t6;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ff.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppWidgetManager f15517a = (AppWidgetManager) bc.a.a().getSystemService("appwidget");

    @Override // ff.a
    public List<AppWidgetProviderInfo> a(int i10) {
        return (List) cc.a.j(cc.a.g(this.f15517a.getClass(), "getInstalledProviders", Integer.TYPE), this.f15517a, Integer.valueOf(i10));
    }
}
