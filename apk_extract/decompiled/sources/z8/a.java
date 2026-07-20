package z8;

import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.Field;
import k3.o9;
import l9.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UserHandle f11265a;

    static {
        UserHandle userHandle;
        Object obj;
        Object obj2;
        if (b.a(l9.a.f7343b)) {
            f11265a = s9.b.b();
        } else {
            try {
                Field fieldC = o9.c(n8.b.f8130a, "CURRENT");
                userHandle = (fieldC == null || (obj = fieldC.get(null)) == null || !(obj instanceof UserHandle)) ? null : (UserHandle) obj;
            } catch (IllegalAccessException e) {
                boolean z2 = j9.a.f6132a;
                Log.e("b", "getCurrent fail:" + e);
            }
            f11265a = userHandle;
        }
        if (b.a(l9.a.f)) {
            s9.b.a();
            return;
        }
        try {
            Field fieldC2 = o9.c(n8.b.f8130a, "ALL");
            if (fieldC2 == null || (obj2 = fieldC2.get(null)) == null || !(obj2 instanceof UserHandle)) {
                return;
            }
        } catch (IllegalAccessException e4) {
            boolean z3 = j9.a.f6132a;
            Log.e("b", "getAll fail:" + e4);
        }
    }
}
