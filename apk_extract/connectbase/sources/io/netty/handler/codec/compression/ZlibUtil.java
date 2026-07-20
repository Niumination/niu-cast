package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;

/* JADX INFO: loaded from: classes3.dex */
final class ZlibUtil {

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.ZlibUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper;

        static {
            int[] iArr = new int[ZlibWrapper.values().length];
            $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper = iArr;
            try {
                iArr[ZlibWrapper.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.GZIP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[ZlibWrapper.ZLIB_OR_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private ZlibUtil() {
    }

    public static JZlib.WrapperType convertWrapperType(ZlibWrapper zlibWrapper) {
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i10 == 1) {
            return JZlib.W_NONE;
        }
        if (i10 == 2) {
            return JZlib.W_ZLIB;
        }
        if (i10 == 3) {
            return JZlib.W_GZIP;
        }
        if (i10 == 4) {
            return JZlib.W_ANY;
        }
        throw new Error();
    }

    public static CompressionException deflaterException(Deflater deflater, String str, int i10) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" (");
        sb2.append(i10);
        sb2.append(')');
        if (deflater.msg != null) {
            str2 = ": " + deflater.msg;
        } else {
            str2 = "";
        }
        sb2.append(str2);
        return new CompressionException(sb2.toString());
    }

    public static void fail(Inflater inflater, String str, int i10) {
        throw inflaterException(inflater, str, i10);
    }

    public static DecompressionException inflaterException(Inflater inflater, String str, int i10) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" (");
        sb2.append(i10);
        sb2.append(')');
        if (inflater.msg != null) {
            str2 = ": " + inflater.msg;
        } else {
            str2 = "";
        }
        sb2.append(str2);
        return new DecompressionException(sb2.toString());
    }

    public static int wrapperOverhead(ZlibWrapper zlibWrapper) {
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[zlibWrapper.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 2;
        }
        if (i10 == 3) {
            return 10;
        }
        if (i10 == 4) {
            return 2;
        }
        throw new Error();
    }

    public static void fail(Deflater deflater, String str, int i10) {
        throw deflaterException(deflater, str, i10);
    }
}
