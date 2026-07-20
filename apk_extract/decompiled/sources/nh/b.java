package nh;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f8278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8279i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i8, int i9, int i10) {
        super(i8);
        this.f8278h = i10;
        this.f8279i = i9;
    }

    @Override // nh.c
    public final Object a(Object obj) {
        switch (this.f8278h) {
            case 0:
                ByteBuffer instance = (ByteBuffer) obj;
                Intrinsics.checkNotNullParameter(instance, "instance");
                instance.clear();
                instance.order(ByteOrder.BIG_ENDIAN);
                return instance;
            default:
                ByteBuffer instance2 = (ByteBuffer) obj;
                Intrinsics.checkNotNullParameter(instance2, "instance");
                instance2.clear();
                instance2.order(ByteOrder.BIG_ENDIAN);
                return instance2;
        }
    }

    @Override // nh.c
    public final Object c() {
        switch (this.f8278h) {
            case 0:
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f8279i);
                Intrinsics.checkNotNull(byteBufferAllocate);
                return byteBufferAllocate;
            default:
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.f8279i);
                Intrinsics.checkNotNull(byteBufferAllocateDirect);
                return byteBufferAllocateDirect;
        }
    }

    @Override // nh.c
    public final void h(Object obj) {
        switch (this.f8278h) {
            case 0:
                ByteBuffer instance = (ByteBuffer) obj;
                Intrinsics.checkNotNullParameter(instance, "instance");
                if (instance.capacity() != this.f8279i) {
                    throw new IllegalStateException("Check failed.");
                }
                if (instance.isDirect()) {
                    throw new IllegalStateException("Check failed.");
                }
                return;
            default:
                ByteBuffer instance2 = (ByteBuffer) obj;
                Intrinsics.checkNotNullParameter(instance2, "instance");
                if (instance2.capacity() != this.f8279i) {
                    throw new IllegalStateException("Check failed.");
                }
                if (!instance2.isDirect()) {
                    throw new IllegalStateException("Check failed.");
                }
                return;
        }
    }
}
