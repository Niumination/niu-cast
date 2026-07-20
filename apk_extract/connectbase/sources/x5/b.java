package x5;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20050d;

    public b(int i10, int i11, int i12, int i13) {
        this.f20047a = i10;
        this.f20048b = i11;
        this.f20049c = i12;
        this.f20050d = i13;
    }

    public static byte[] a(int i10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(32);
        byteBufferAllocate.putLong(System.currentTimeMillis());
        byteBufferAllocate.putLong(System.currentTimeMillis());
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i10);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.putInt(0);
        return byteBufferAllocate.array();
    }

    public int b() {
        return this.f20048b;
    }

    public int c() {
        return this.f20047a;
    }

    public int d() {
        return this.f20050d;
    }

    public int e() {
        return this.f20049c;
    }

    public void f(int i10) {
        this.f20048b = i10;
    }

    public void g(int i10) {
        this.f20047a = i10;
    }

    public void h(int i10) {
        this.f20050d = i10;
    }

    public void i(int i10) {
        this.f20049c = i10;
    }
}
