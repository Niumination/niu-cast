package ta;

import android.content.ComponentName;
import android.content.Context;
import android.service.notification.NotificationListenerService;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f15544d = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public td.a f15545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c8.a f15546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NotificationListenerService f15547c;

    public a(NotificationListenerService notificationListenerService) {
        this.f15547c = notificationListenerService;
    }

    public ng.a a(String str) {
        if (fc.b.b(str)) {
            td.a aVar = this.f15545a;
            if (aVar != null) {
                return aVar;
            }
            td.a aVar2 = new td.a(this.f15547c);
            this.f15545a = aVar2;
            return aVar2;
        }
        c8.a aVar3 = this.f15546b;
        if (aVar3 != null) {
            return aVar3;
        }
        c8.a aVar4 = new c8.a(this.f15547c);
        this.f15546b = aVar4;
        return aVar4;
    }

    public void b(Context context, ComponentName componentName, int i10) {
        a(fc.b.a.f5985e).a(context, componentName, i10);
    }

    public void c() {
        a(fc.b.a.f5985e).b();
    }
}
