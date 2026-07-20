package e8;

import android.os.Bundle;
import android.os.RemoteCallback;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4123a = "TranAospRemoteCallbackExt";

    public interface a {
        void a(Bundle bundle);
    }

    public static /* synthetic */ void c(a aVar, Bundle bundle) {
        if (aVar != null) {
            aVar.a(bundle);
        }
    }

    public void b(Object obj, String str, String str2, int i10, int i11, final a aVar) {
        try {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("addRoleHolderAsUser", String.class, String.class, cls2, cls2, RemoteCallback.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, str, str2, Integer.valueOf(i10), Integer.valueOf(i11), new RemoteCallback(new RemoteCallback.OnResultListener() { // from class: e8.l
                public final void a(Bundle bundle) {
                    m.c(aVar, bundle);
                }
            }));
        } catch (Exception e10) {
            dc.e.a(f4123a, "addRoleHolderAsUserExt fail :" + e10);
        }
    }
}
