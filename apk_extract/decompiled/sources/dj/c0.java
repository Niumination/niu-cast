package dj;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {
    public static d0 a(String protocol) throws IOException {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        d0 d0Var = d0.HTTP_1_0;
        if (!Intrinsics.areEqual(protocol, d0Var.protocol)) {
            d0Var = d0.HTTP_1_1;
            if (!Intrinsics.areEqual(protocol, d0Var.protocol)) {
                d0Var = d0.H2_PRIOR_KNOWLEDGE;
                if (!Intrinsics.areEqual(protocol, d0Var.protocol)) {
                    d0Var = d0.HTTP_2;
                    if (!Intrinsics.areEqual(protocol, d0Var.protocol)) {
                        d0Var = d0.SPDY_3;
                        if (!Intrinsics.areEqual(protocol, d0Var.protocol)) {
                            d0Var = d0.QUIC;
                            if (!Intrinsics.areEqual(protocol, d0Var.protocol)) {
                                throw new IOException(h0.a.i("Unexpected protocol: ", protocol));
                            }
                        }
                    }
                }
            }
        }
        return d0Var;
    }
}
