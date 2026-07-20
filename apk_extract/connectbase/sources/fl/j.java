package fl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    public static final class a extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6056b;

        public a(int i10, int i11) {
            this.f6055a = i10;
            this.f6056b = i11;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("size " + this.f6055a + " is greater than buffer's remaining capacity " + this.f6056b);
        }
    }

    @t0
    public static final int a(@os.l ReadableByteChannel readableByteChannel, @os.l tl.o0 o0Var) throws IOException {
        kn.l0.p(readableByteChannel, "<this>");
        kn.l0.p(o0Var, "buffer");
        tl.m mVar = o0Var.f15821b;
        int i10 = mVar.f15872a;
        int i11 = mVar.f15874c;
        if (i10 - i11 == 0) {
            return 0;
        }
        int i12 = i10 - i11;
        if (!(1 <= i12)) {
            new a(1, i12).a();
            throw new lm.y();
        }
        ByteBuffer byteBufferDuplicate = o0Var.f15820a.duplicate();
        kn.l0.m(byteBufferDuplicate);
        tl.m mVar2 = o0Var.f15821b;
        int i13 = mVar2.f15874c;
        byteBufferDuplicate.limit(mVar2.f15872a);
        byteBufferDuplicate.position(i13);
        int i14 = readableByteChannel.read(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() - i13;
        if (iPosition < 0 || iPosition > i12) {
            xl.a.c(iPosition, 1);
            throw new lm.y();
        }
        o0Var.b(iPosition);
        return i14;
    }

    @t0
    public static final int b(@os.l WritableByteChannel writableByteChannel, @os.l tl.o0 o0Var) throws IOException {
        kn.l0.p(writableByteChannel, "<this>");
        kn.l0.p(o0Var, "buffer");
        tl.m mVar = o0Var.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        ByteBuffer byteBufferDuplicate = o0Var.f15820a.duplicate();
        kn.l0.m(byteBufferDuplicate);
        byteBufferDuplicate.limit(i11);
        byteBufferDuplicate.position(i10);
        int iWrite = writableByteChannel.write(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() - i10;
        if (iPosition < 0) {
            xl.a.b(iPosition);
            throw new lm.y();
        }
        if (byteBufferDuplicate.limit() == i11) {
            o0Var.d(iPosition);
            return iWrite;
        }
        xl.a.a();
        throw new lm.y();
    }
}
