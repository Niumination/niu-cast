package zf;

import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f11551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f11552b;

    static {
        String[] strArr = {"Transfer-Encoding", "Upgrade"};
        f11551a = strArr;
        f11552b = ArraysKt.asList(strArr);
    }

    public static void a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int i8 = 0;
        int i9 = 0;
        while (i8 < name.length()) {
            char cCharAt = name.charAt(i8);
            int i10 = i9 + 1;
            if (Intrinsics.compare((int) cCharAt, 32) <= 0 || StringsKt__StringsKt.contains$default("\"(),/:;<=>?@[\\]{}", cCharAt, false, 2, (Object) null)) {
                throw new a0(name, i9);
            }
            i8++;
            i9 = i10;
        }
    }

    public static void b(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int i8 = 0;
        int i9 = 0;
        while (i8 < value.length()) {
            char cCharAt = value.charAt(i8);
            int i10 = i9 + 1;
            if (Intrinsics.compare((int) cCharAt, 32) < 0 && cCharAt != '\t') {
                throw new b0(value, i9);
            }
            i8++;
            i9 = i10;
        }
    }
}
