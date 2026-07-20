package na;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v4.a0;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f8132a = new q();

    public static Object a(String str, Class cls) {
        try {
            return f8132a.fromJson(str, cls);
        } catch (a0 e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(Object obj) {
        String json = f8132a.toJson(obj);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public static List c(Class clazz, String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object[] objArr = (Object[]) f8132a.fromJson(str, clazz);
        return objArr == null ? new ArrayList() : CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length));
    }
}
