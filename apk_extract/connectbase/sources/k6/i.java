package k6;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class i extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9131a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f9133c;

    public i(String str, Throwable th2) {
        super(str, th2);
        this.f9132b = str;
        this.f9133c = null;
    }

    public String a() {
        return this.f9132b;
    }

    public Bundle b() {
        return this.f9133c;
    }

    public static void a(String str, Throwable th2) {
        l.f9150b.c(new i(str, th2));
    }

    public i(String str, Bundle bundle) {
        super(str, null);
        this.f9132b = str;
        this.f9133c = bundle;
    }
}
