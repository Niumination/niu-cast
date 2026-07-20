package e8;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4719a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f4721c;

    public d(String str, Throwable th2) {
        super(str, th2);
        this.f4720b = str;
        this.f4721c = null;
    }

    public String a() {
        return this.f4720b;
    }

    public Bundle b() {
        return this.f4721c;
    }

    public static void a(String str, Throwable th2) {
        g.f4735b.a(new d(str, th2));
    }

    public d(String str, Bundle bundle) {
        super(str, null);
        this.f4720b = str;
        this.f4721c = bundle;
    }
}
