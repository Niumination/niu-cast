package jq;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "CharsetsKt")
public final class g {
    @an.f
    public static final Charset a(String str) {
        kn.l0.p(str, "charsetName");
        Charset charsetForName = Charset.forName(str);
        kn.l0.o(charsetForName, "forName(...)");
        return charsetForName;
    }
}
