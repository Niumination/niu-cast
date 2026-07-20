package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import h0.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class ExifAttribute {
    public static final long BYTES_OFFSET_UNKNOWN = -1;
    static final int IFD_FORMAT_BYTE = 1;
    static final int IFD_FORMAT_DOUBLE = 12;
    static final int IFD_FORMAT_SBYTE = 6;
    static final int IFD_FORMAT_SINGLE = 11;
    static final int IFD_FORMAT_SLONG = 9;
    static final int IFD_FORMAT_SRATIONAL = 10;
    static final int IFD_FORMAT_SSHORT = 8;
    static final int IFD_FORMAT_STRING = 2;
    static final int IFD_FORMAT_ULONG = 4;
    static final int IFD_FORMAT_UNDEFINED = 7;
    static final int IFD_FORMAT_URATIONAL = 5;
    static final int IFD_FORMAT_USHORT = 3;
    private static final String TAG = "ExifAttribute";
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;
    static final Charset ASCII = StandardCharsets.US_ASCII;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};

    public ExifAttribute(int i8, int i9, byte[] bArr) {
        this(i8, i9, -1L, bArr);
    }

    @NonNull
    public static ExifAttribute createByte(@NonNull String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }
        byte[] bytes = str.getBytes(ASCII);
        return new ExifAttribute(1, bytes.length, bytes);
    }

    @NonNull
    public static ExifAttribute createDouble(@NonNull double[] dArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length]);
        byteBufferWrap.order(byteOrder);
        for (double d7 : dArr) {
            byteBufferWrap.putDouble(d7);
        }
        return new ExifAttribute(12, dArr.length, byteBufferWrap.array());
    }

    @NonNull
    public static ExifAttribute createSLong(@NonNull int[] iArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i8 : iArr) {
            byteBufferWrap.putInt(i8);
        }
        return new ExifAttribute(9, iArr.length, byteBufferWrap.array());
    }

    @NonNull
    public static ExifAttribute createSRational(@NonNull LongRational[] longRationalArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[10] * longRationalArr.length]);
        byteBufferWrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            byteBufferWrap.putInt((int) longRational.getNumerator());
            byteBufferWrap.putInt((int) longRational.getDenominator());
        }
        return new ExifAttribute(10, longRationalArr.length, byteBufferWrap.array());
    }

    @NonNull
    public static ExifAttribute createString(@NonNull String str) {
        byte[] bytes = (str + (char) 0).getBytes(ASCII);
        return new ExifAttribute(2, bytes.length, bytes);
    }

    @NonNull
    public static ExifAttribute createULong(@NonNull long[] jArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j8 : jArr) {
            byteBufferWrap.putInt((int) j8);
        }
        return new ExifAttribute(4, jArr.length, byteBufferWrap.array());
    }

    @NonNull
    public static ExifAttribute createURational(@NonNull LongRational[] longRationalArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[5] * longRationalArr.length]);
        byteBufferWrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            byteBufferWrap.putInt((int) longRational.getNumerator());
            byteBufferWrap.putInt((int) longRational.getDenominator());
        }
        return new ExifAttribute(5, longRationalArr.length, byteBufferWrap.array());
    }

    @NonNull
    public static ExifAttribute createUShort(@NonNull int[] iArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i8 : iArr) {
            byteBufferWrap.putShort((short) i8);
        }
        return new ExifAttribute(3, iArr.length, byteBufferWrap.array());
    }

    public double getDoubleValue(@NonNull ByteOrder byteOrder) throws Throwable {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (value instanceof String) {
            return Double.parseDouble((String) value);
        }
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            if (jArr.length == 1) {
                return jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(value instanceof LongRational[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        LongRational[] longRationalArr = (LongRational[]) value;
        if (longRationalArr.length == 1) {
            return longRationalArr[0].toDouble();
        }
        throw new NumberFormatException("There are more than one component");
    }

    public int getIntValue(@NonNull ByteOrder byteOrder) throws Throwable {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(value instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) value;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    @Nullable
    public String getStringValue(@NonNull ByteOrder byteOrder) throws Throwable {
        Object value = getValue(byteOrder);
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        StringBuilder sb2 = new StringBuilder();
        int i8 = 0;
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            while (i8 < jArr.length) {
                sb2.append(jArr[i8]);
                i8++;
                if (i8 != jArr.length) {
                    sb2.append(",");
                }
            }
            return sb2.toString();
        }
        if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            while (i8 < iArr.length) {
                sb2.append(iArr[i8]);
                i8++;
                if (i8 != iArr.length) {
                    sb2.append(",");
                }
            }
            return sb2.toString();
        }
        if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            while (i8 < dArr.length) {
                sb2.append(dArr[i8]);
                i8++;
                if (i8 != dArr.length) {
                    sb2.append(",");
                }
            }
            return sb2.toString();
        }
        if (!(value instanceof LongRational[])) {
            return null;
        }
        LongRational[] longRationalArr = (LongRational[]) value;
        while (i8 < longRationalArr.length) {
            sb2.append(longRationalArr[i8].getNumerator());
            sb2.append('/');
            sb2.append(longRationalArr[i8].getDenominator());
            i8++;
            if (i8 != longRationalArr.length) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:162:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:17:0x0030 */
    public Object getValue(ByteOrder byteOrder) throws Throwable {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        InputStream inputStream;
        byte b9;
        byte b10;
        int length = 0;
        InputStream inputStream2 = null;
        try {
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(this.bytes);
                try {
                    byteOrderedDataInputStream.setByteOrder(byteOrder);
                    switch (this.format) {
                        case 1:
                        case 6:
                            byte[] bArr = this.bytes;
                            if (bArr.length != 1 || (b9 = bArr[0]) < 0 || b9 > 1) {
                                String str = new String(bArr, ASCII);
                                try {
                                    byteOrderedDataInputStream.close();
                                    break;
                                } catch (IOException e) {
                                    Logger.e(TAG, "IOException occurred while closing InputStream", e);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (b9 + 48)});
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e4) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e4);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.numberOfComponents >= EXIF_ASCII_PREFIX.length) {
                                int i8 = 0;
                                while (true) {
                                    byte[] bArr2 = EXIF_ASCII_PREFIX;
                                    if (i8 >= bArr2.length) {
                                        length = bArr2.length;
                                    } else if (this.bytes[i8] == bArr2[i8]) {
                                        i8++;
                                    }
                                }
                            }
                            StringBuilder sb2 = new StringBuilder();
                            while (length < this.numberOfComponents && (b10 = this.bytes[length]) != 0) {
                                if (b10 >= 32) {
                                    sb2.append((char) b10);
                                } else {
                                    sb2.append('?');
                                }
                                length++;
                            }
                            String string = sb2.toString();
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e10) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e10);
                            }
                            return string;
                        case 3:
                            int[] iArr = new int[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                iArr[length] = byteOrderedDataInputStream.readUnsignedShort();
                                length++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e11) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e11);
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                jArr[length] = byteOrderedDataInputStream.readUnsignedInt();
                                length++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e12) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e12);
                            }
                            return jArr;
                        case 5:
                            LongRational[] longRationalArr = new LongRational[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                longRationalArr[length] = new LongRational(byteOrderedDataInputStream.readUnsignedInt(), byteOrderedDataInputStream.readUnsignedInt());
                                length++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e13) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e13);
                            }
                            return longRationalArr;
                        case 8:
                            int[] iArr2 = new int[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                iArr2[length] = byteOrderedDataInputStream.readShort();
                                length++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e14) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e14);
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                iArr3[length] = byteOrderedDataInputStream.readInt();
                                length++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e15) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e15);
                            }
                            return iArr3;
                        case 10:
                            LongRational[] longRationalArr2 = new LongRational[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                longRationalArr2[length] = new LongRational(byteOrderedDataInputStream.readInt(), byteOrderedDataInputStream.readInt());
                                length++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e16) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e16);
                            }
                            return longRationalArr2;
                        case 11:
                            double[] dArr = new double[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                dArr[length] = byteOrderedDataInputStream.readFloat();
                                length++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e17) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e17);
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                dArr2[length] = byteOrderedDataInputStream.readDouble();
                                length++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e18) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e18);
                            }
                            return dArr2;
                        default:
                            try {
                                byteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e19) {
                                Logger.e(TAG, "IOException occurred while closing InputStream", e19);
                            }
                            return null;
                    }
                } catch (IOException e20) {
                    e = e20;
                    Logger.w(TAG, "IOException occurred during reading a value", e);
                    if (byteOrderedDataInputStream != null) {
                        try {
                            byteOrderedDataInputStream.close();
                        } catch (IOException e21) {
                            Logger.e(TAG, "IOException occurred while closing InputStream", e21);
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e22) {
                        Logger.e(TAG, "IOException occurred while closing InputStream", e22);
                    }
                }
                throw th;
            }
        } catch (IOException e23) {
            e = e23;
            byteOrderedDataInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    public int size() {
        return IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append(IFD_FORMAT_NAMES[this.format]);
        sb2.append(", data length:");
        return a.m(sb2, ")", this.bytes.length);
    }

    public ExifAttribute(int i8, int i9, long j8, byte[] bArr) {
        this.format = i8;
        this.numberOfComponents = i9;
        this.bytesOffset = j8;
        this.bytes = bArr;
    }

    @NonNull
    public static ExifAttribute createDouble(double d7, @NonNull ByteOrder byteOrder) {
        return createDouble(new double[]{d7}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createSLong(int i8, @NonNull ByteOrder byteOrder) {
        return createSLong(new int[]{i8}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createULong(long j8, @NonNull ByteOrder byteOrder) {
        return createULong(new long[]{j8}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createUShort(int i8, @NonNull ByteOrder byteOrder) {
        return createUShort(new int[]{i8}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createSRational(@NonNull LongRational longRational, @NonNull ByteOrder byteOrder) {
        return createSRational(new LongRational[]{longRational}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createURational(@NonNull LongRational longRational, @NonNull ByteOrder byteOrder) {
        return createURational(new LongRational[]{longRational}, byteOrder);
    }
}
