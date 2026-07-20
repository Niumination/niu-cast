package tl;

import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    public static final class a extends kn.n0 implements jn.l<ByteBuffer, l2> {
        final /* synthetic */ byte[] $array;
        final /* synthetic */ jn.l<byte[], l2> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jn.l<? super byte[], l2> lVar, byte[] bArr) {
            super(1);
            this.$block = lVar;
            this.$array = bArr;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(ByteBuffer byteBuffer) {
            invoke2(byteBuffer);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l ByteBuffer byteBuffer) {
            kn.l0.p(byteBuffer, "it");
            this.$block.invoke(this.$array);
        }
    }

    public static final class b extends kn.n0 implements jn.l<ByteBuffer, l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
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
    public static final v a(@os.l ByteBuffer byteBuffer, @os.l jn.l<? super ByteBuffer, l2> lVar) {
        kn.l0.p(byteBuffer, "bb");
        kn.l0.p(lVar, "release");
        b1 b1Var = new b1(byteBuffer, lVar);
        ul.b bVarW0 = b1Var.W0();
        bVarW0.u0();
        return new v(bVarW0, b1Var);
    }

    @os.l
    public static final v b(@os.l byte[] bArr, int i10, int i11, @os.l jn.l<? super byte[], l2> lVar) {
        kn.l0.p(bArr, dc.d.f3685p);
        kn.l0.p(lVar, "block");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i10, i11);
        kn.l0.o(byteBufferWrap, "wrap(array, offset, length)");
        return a(byteBufferWrap, new a(lVar, bArr));
    }

    public static /* synthetic */ v c(ByteBuffer byteBuffer, jn.l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = b.INSTANCE;
        }
        return a(byteBuffer, lVar);
    }

    public static /* synthetic */ v d(byte[] bArr, int i10, int i11, jn.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        kn.l0.p(bArr, dc.d.f3685p);
        kn.l0.p(lVar, "block");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i10, i11);
        kn.l0.o(byteBufferWrap, "wrap(array, offset, length)");
        return a(byteBufferWrap, new a(lVar, bArr));
    }

    public static final bm.h<ul.b> e(ByteBuffer byteBuffer, jn.l<? super ByteBuffer, l2> lVar) {
        return new b1(byteBuffer, lVar);
    }
}
