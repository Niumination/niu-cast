package v4;

import com.transsion.aiotlink.IStreamDataListener;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    void a(ByteBuffer byteBuffer);

    void b(String str);

    void c(int i10);

    void d(int i10, IStreamDataListener iStreamDataListener);

    void e(int i10, ByteBuffer byteBuffer);

    void f(int i10, IStreamDataListener iStreamDataListener);

    int g(int i10, byte[] bArr);

    void h(int i10, Runnable runnable);

    void i(int i10);

    void j(int i10, e eVar);

    void k(e eVar);

    void l(m2.c cVar);

    void m(e eVar);

    void n(byte[] bArr);

    void o();

    void p(byte[] bArr);

    void stopTCCPServer();
}
