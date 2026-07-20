package en;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.InputStream;
import java.io.OutputStream;
import kn.l0;
import lm.f1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    @f
    @f1(version = "1.8")
    @l
    public static final InputStream a(@l InputStream inputStream, @l a aVar) {
        l0.p(inputStream, "<this>");
        l0.p(aVar, HttpHeaders.Values.BASE64);
        return new d(inputStream, aVar);
    }

    @f
    @f1(version = "1.8")
    @l
    public static final OutputStream b(@l OutputStream outputStream, @l a aVar) {
        l0.p(outputStream, "<this>");
        l0.p(aVar, HttpHeaders.Values.BASE64);
        return new e(outputStream, aVar);
    }
}
