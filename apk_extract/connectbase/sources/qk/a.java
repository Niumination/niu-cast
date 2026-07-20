package qk;

import fl.a0;
import fl.h;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import jq.h0;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final String f14041a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    @l
    public static final String a(@l String str) {
        l0.p(str, "nonce");
        String strC = l0.C(h0.C5(str).toString(), "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        Charset charsetForName = Charset.forName("ISO_8859_1");
        l0.o(charsetForName, "forName(\"ISO_8859_1\")");
        CharsetEncoder charsetEncoderNewEncoder = charsetForName.newEncoder();
        l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        return h.i(a0.h(rl.a.j(charsetEncoderNewEncoder, strC, 0, strC.length())));
    }
}
