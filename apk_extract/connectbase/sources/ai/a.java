package ai;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b.a({"StaticFieldLeak"})
    public static Context f211a;

    public static Context a() {
        Context context = f211a;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("u should init first");
    }

    public static void b(@NonNull Context context) {
        if (f211a != null) {
            return;
        }
        f211a = context.getApplicationContext();
    }
}
