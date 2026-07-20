package k3;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j3.w f6433a;

    public static final String a(Context context, int i8, String... params) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayList arrayList = new ArrayList(params.length);
        for (String str : params) {
            arrayList.add(str);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(i8);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        return o.d.q(objArrCopyOf, objArrCopyOf.length, string, "format(...)");
    }

    public static synchronized be b(String str) {
        be beVar;
        byte b9 = (byte) (((byte) (0 | 1)) | 2);
        if (b9 != 3) {
            StringBuilder sb2 = new StringBuilder();
            if ((b9 & 1) == 0) {
                sb2.append(" enableFirelog");
            }
            if ((b9 & 2) == 0) {
                sb2.append(" firelogEventType");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
        }
        vd vdVar = new vd(1, str, true);
        synchronized (ee.class) {
            try {
                if (f6433a == null) {
                    f6433a = new j3.w(1);
                }
                beVar = (be) f6433a.b(vdVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return beVar;
        return beVar;
    }
}
