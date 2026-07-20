package c3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements y2.a<r2.i, ByteBuf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final k f1308a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final byte[] f1309b = {65, 73, 82, 84};

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y2.a
    @os.m
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public r2.i a(@os.l ByteBuf byteBuf) {
        l0.p(byteBuf, "data");
        byte[] bArr = null;
        if (byteBuf.readableBytes() < 32) {
            return null;
        }
        byteBuf.markReaderIndex();
        byte[] bArr2 = f1309b;
        byte[] bArr3 = new byte[bArr2.length];
        byteBuf.readBytes(bArr3);
        if (!Arrays.equals(bArr3, bArr2)) {
            return null;
        }
        long j10 = byteBuf.readLong();
        byte b10 = byteBuf.readByte();
        byte b11 = byteBuf.readByte();
        int i10 = byteBuf.readShort();
        if (byteBuf.readableBytes() < i10 + 16) {
            byteBuf.resetReaderIndex();
            return null;
        }
        if (i10 > 0) {
            bArr = new byte[i10];
            byteBuf.readBytes(bArr);
        }
        return new r2.i(null, j10, b10, b11, i10, bArr, byteBuf.readLong(), byteBuf.readLong(), 1, null);
    }

    @Override // y2.a
    @os.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ByteBuf b(@os.l r2.i iVar) {
        l0.p(iVar, "data");
        ByteBuf byteBufBuffer = Unpooled.buffer();
        byteBufBuffer.writeBytes(iVar.f14168a);
        byteBufBuffer.writeLong(iVar.f14169b);
        byteBufBuffer.writeByte(iVar.f14170c);
        byteBufBuffer.writeByte(iVar.f14171d);
        byteBufBuffer.writeShort(iVar.f14172e);
        byte[] bArr = iVar.f14173f;
        if (bArr != null) {
            byteBufBuffer.writeBytes(bArr);
        }
        byteBufBuffer.writeLong(iVar.f14174g);
        byteBufBuffer.writeLong(iVar.f14175h);
        l0.m(byteBufBuffer);
        return byteBufBuffer;
    }
}
