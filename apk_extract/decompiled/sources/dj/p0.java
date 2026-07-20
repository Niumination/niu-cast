package dj;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public enum p0 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    public static final o0 Companion = new o0();
    private final String javaName;

    p0(String str) {
        this.javaName = str;
    }

    @JvmStatic
    public static final p0 forJavaName(String str) {
        Companion.getClass();
        return o0.a(str);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}))
    @JvmName(name = "-deprecated_javaName")
    /* JADX INFO: renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m142deprecated_javaName() {
        return this.javaName;
    }

    @JvmName(name = "javaName")
    public final String javaName() {
        return this.javaName;
    }
}
