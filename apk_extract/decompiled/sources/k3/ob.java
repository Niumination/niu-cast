package k3;

import android.util.Log;
import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ob {
    public static void a(Closeable... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        for (Closeable closeable : args) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    Intrinsics.checkNotNullParameter("CloseableUtils", "tag");
                    Intrinsics.checkNotNullParameter(e, "e");
                    Log.e(gc.f6463b.concat("CloseableUtils"), e.getMessage(), e);
                }
            }
        }
    }
}
