package c3;

import android.net.Uri;
import el.b0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import jq.h0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends x2.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Uri f1327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final byte[] f1328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public InputStream f1329d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@os.l Uri uri) {
        byte[] bytes;
        super(null, 1, null);
        l0.p(uri, "uri");
        this.f1327b = uri;
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (schemeSpecificPart == null) {
            bytes = new byte[0];
        } else {
            l0.m(schemeSpecificPart);
            bytes = h0.a4(schemeSpecificPart, "//" + uri.getHost() + b0.f4502a).getBytes(jq.f.f8800b);
            l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        }
        this.f1328c = bytes;
    }

    @Override // x2.a
    @os.l
    public InputStream I() {
        s2.b.c(this.f1329d);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f1328c);
        this.f1329d = byteArrayInputStream;
        return byteArrayInputStream;
    }

    @Override // x2.a
    public long N1() {
        return this.f1328c.length;
    }

    @Override // x2.c
    @os.l
    public String c() {
        String host = this.f1327b.getHost();
        if (host != null) {
            return host;
        }
        return "text_" + System.currentTimeMillis() + ".txt";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f1329d;
        if (inputStream != null) {
            inputStream.close();
        }
    }
}
