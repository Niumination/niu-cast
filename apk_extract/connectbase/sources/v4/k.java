package v4;

import com.transsion.aiotlink.IStreamDataListener;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class k implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f16582a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f16583a = new k();
    }

    public k() {
    }

    public static k q() {
        return a.f16583a;
    }

    @Override // v4.d
    public void a(ByteBuffer byteBuffer) {
        this.f16582a.a(byteBuffer);
    }

    @Override // v4.d
    public void b(String str) {
        this.f16582a.b(str);
    }

    @Override // v4.d
    public void c(int i10) {
        this.f16582a.c(i10);
    }

    @Override // v4.d
    public void d(int i10, IStreamDataListener iStreamDataListener) {
        this.f16582a.d(i10, iStreamDataListener);
    }

    @Override // v4.d
    public void e(int i10, ByteBuffer byteBuffer) {
        this.f16582a.e(i10, byteBuffer);
    }

    @Override // v4.d
    public void f(int i10, IStreamDataListener iStreamDataListener) {
        this.f16582a.f(i10, iStreamDataListener);
    }

    @Override // v4.d
    public int g(int i10, byte[] bArr) {
        return this.f16582a.g(i10, bArr);
    }

    @Override // v4.d
    public void h(int i10, Runnable runnable) {
        this.f16582a.h(i10, runnable);
    }

    @Override // v4.d
    public void i(int i10) {
        this.f16582a.i(i10);
    }

    @Override // v4.d
    public void j(int i10, e eVar) {
        this.f16582a.j(i10, eVar);
    }

    @Override // v4.d
    public void k(e eVar) {
        this.f16582a.k(eVar);
    }

    @Override // v4.d
    public void l(m2.c cVar) {
        this.f16582a.l(cVar);
    }

    @Override // v4.d
    public void m(e eVar) {
        this.f16582a.m(eVar);
    }

    @Override // v4.d
    public void n(byte[] bArr) {
        this.f16582a.n(bArr);
    }

    @Override // v4.d
    public void o() {
        this.f16582a.o();
    }

    @Override // v4.d
    public void p(byte[] bArr) {
        this.f16582a.p(bArr);
    }

    public void r(d dVar) {
        this.f16582a = dVar;
    }

    @Override // v4.d
    public void stopTCCPServer() {
        this.f16582a.stopTCCPServer();
    }

    public k(l lVar) {
    }
}
