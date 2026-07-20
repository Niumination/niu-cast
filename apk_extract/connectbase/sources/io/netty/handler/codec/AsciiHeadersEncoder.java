package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AsciiHeadersEncoder {
    private final ByteBuf buf;
    private final NewlineType newlineType;
    private final SeparatorType separatorType;

    /* JADX INFO: renamed from: io.netty.handler.codec.AsciiHeadersEncoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType;

        static {
            int[] iArr = new int[NewlineType.values().length];
            $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType = iArr;
            try {
                iArr[NewlineType.LF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[NewlineType.CRLF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SeparatorType.values().length];
            $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType = iArr2;
            try {
                iArr2[SeparatorType.COLON.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[SeparatorType.COLON_SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum NewlineType {
        LF,
        CRLF
    }

    public enum SeparatorType {
        COLON,
        COLON_SPACE
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf) {
        this(byteBuf, SeparatorType.COLON_SPACE, NewlineType.CRLF);
    }

    private static void writeAscii(ByteBuf byteBuf, int i10, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i10, charSequence.length());
        } else {
            byteBuf.setCharSequence(i10, charSequence, CharsetUtil.US_ASCII);
        }
    }

    public void encode(Map.Entry<CharSequence, CharSequence> entry) {
        int i10;
        int i11;
        CharSequence key = entry.getKey();
        CharSequence value = entry.getValue();
        ByteBuf byteBuf = this.buf;
        int length = key.length();
        int length2 = value.length();
        int iWriterIndex = byteBuf.writerIndex();
        byteBuf.ensureWritable(length + length2 + 4);
        writeAscii(byteBuf, iWriterIndex, key);
        int i12 = iWriterIndex + length;
        int i13 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[this.separatorType.ordinal()];
        if (i13 == 1) {
            byteBuf.setByte(i12, 58);
            i10 = i12 + 1;
        } else {
            if (i13 != 2) {
                throw new Error();
            }
            int i14 = i12 + 1;
            byteBuf.setByte(i12, 58);
            i10 = i12 + 2;
            byteBuf.setByte(i14, 32);
        }
        writeAscii(byteBuf, i10, value);
        int i15 = i10 + length2;
        int i16 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[this.newlineType.ordinal()];
        if (i16 == 1) {
            byteBuf.setByte(i15, 10);
            i11 = i15 + 1;
        } else {
            if (i16 != 2) {
                throw new Error();
            }
            int i17 = i15 + 1;
            byteBuf.setByte(i15, 13);
            i11 = i15 + 2;
            byteBuf.setByte(i17, 10);
        }
        byteBuf.writerIndex(i11);
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf, SeparatorType separatorType, NewlineType newlineType) {
        this.buf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buf");
        this.separatorType = (SeparatorType) ObjectUtil.checkNotNull(separatorType, "separatorType");
        this.newlineType = (NewlineType) ObjectUtil.checkNotNull(newlineType, "newlineType");
    }
}
