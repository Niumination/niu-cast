package eg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4954b;

    public /* synthetic */ a(int i8, String str) {
        this.f4953a = i8;
        this.f4954b = str;
    }

    public /* synthetic */ a(String str, int i8, int i9) {
        this(str, (i9 & 2) != 0 ? 0 : i8, false);
    }

    public a(String regexRaw, int i8, boolean z2) {
        Intrinsics.checkNotNullParameter(regexRaw, "regexRaw");
        if (z2) {
            regexRaw = "(" + regexRaw + ')';
        }
        this.f4954b = regexRaw;
        this.f4953a = z2 ? i8 + 1 : i8;
    }
}
