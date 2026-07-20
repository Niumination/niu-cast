package tl;

import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    public static final class a extends kn.n0 implements jn.l<ByteBuffer, l2> {
        final /* synthetic */ byte[] $array;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(byte[] bArr) {
            super(1);
            this.$array = bArr;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l ByteBuffer byteBuffer) {
            kn.l0.p(byteBuffer, "it");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(ByteBuffer byteBuffer) {
            invoke2(byteBuffer);
            return l2.f10208a;
        }
    }

    @os.l
    public static final v a(@os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, dc.d.f3685p);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i10, i11);
        kn.l0.o(byteBufferWrap, "wrap(array, offset, length)");
        return x.a(byteBufferWrap, new a(bArr));
    }

    public static /* synthetic */ v b(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        kn.l0.p(bArr, dc.d.f3685p);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i10, i11);
        kn.l0.o(byteBufferWrap, "wrap(array, offset, length)");
        return x.a(byteBufferWrap, new a(bArr));
    }
}
