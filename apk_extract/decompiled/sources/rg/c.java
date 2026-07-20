package rg;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9437a;

    static {
        String property = System.getProperty("os.name", "");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        String lowerCase = property.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        f9437a = lowerCase;
    }
}
