package wl;

import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f19721a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final ByteBuffer f19722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final j f19723c;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        l0.o(byteBufferAllocate, "allocate(0)");
        f19722b = byteBufferAllocate;
        f19723c = new j(0);
    }

    @os.l
    public static final ByteBuffer a() {
        return f19722b;
    }

    @os.l
    public static final j b() {
        return f19723c;
    }
}
