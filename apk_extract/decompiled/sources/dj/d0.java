package dj;

import java.io.IOException;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public enum d0 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final c0 Companion = new c0();
    private final String protocol;

    d0(String str) {
        this.protocol = str;
    }

    @JvmStatic
    public static final d0 get(String str) throws IOException {
        Companion.getClass();
        return c0.a(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
