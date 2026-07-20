package zg;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11587b;

    public g(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.f11586a = content;
        int length = content.length();
        int lowerCase = 0;
        for (int i8 = 0; i8 < length; i8++) {
            lowerCase = (lowerCase * 31) + Character.toLowerCase(content.charAt(i8));
        }
        this.f11587b = lowerCase;
    }

    public final boolean equals(Object obj) {
        String str;
        g gVar = obj instanceof g ? (g) obj : null;
        return (gVar == null || (str = gVar.f11586a) == null || !StringsKt__StringsJVMKt.equals(str, this.f11586a, true)) ? false : true;
    }

    public final int hashCode() {
        return this.f11587b;
    }

    public final String toString() {
        return this.f11586a;
    }
}
