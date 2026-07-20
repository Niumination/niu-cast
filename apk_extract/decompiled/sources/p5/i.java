package p5;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o4.b f8684b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8685a;

    static {
        i2.h hVarA = o4.b.a(i.class);
        hVarA.a(new o4.j(1, 0, f.class));
        hVarA.a(new o4.j(1, 0, Context.class));
        hVarA.f5548d = b.f8668d;
        f8684b = hVarA.b();
    }

    public i(Context context) {
        this.f8685a = context;
    }

    public final synchronized String a() {
        String string = this.f8685a.getSharedPreferences("com.google.mlkit.internal", 0).getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        this.f8685a.getSharedPreferences("com.google.mlkit.internal", 0).edit().putString("ml_sdk_instance_id", string2).apply();
        return string2;
    }
}
