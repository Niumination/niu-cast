package androidx.emoji2.text.flatbuffer;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    private final ReadWriteBuf f1139bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    public static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        public Value(int i8, int i9, int i10, long j8) {
            this.key = i8;
            this.type = i9;
            this.minBitWidth = i10;
            this.iValue = j8;
            this.dValue = Double.MIN_VALUE;
        }

        public static Value blob(int i8, int i9, int i10, int i11) {
            return new Value(i8, i10, i11, i9);
        }

        public static Value bool(int i8, boolean z2) {
            return new Value(i8, 26, 0, z2 ? 1L : 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int elemWidth(int i8, int i9) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, i8, i9);
        }

        public static Value float32(int i8, float f) {
            return new Value(i8, 3, 2, f);
        }

        public static Value float64(int i8, double d7) {
            return new Value(i8, 3, 3, d7);
        }

        public static Value int16(int i8, int i9) {
            return new Value(i8, 1, 1, i9);
        }

        public static Value int32(int i8, int i9) {
            return new Value(i8, 1, 2, i9);
        }

        public static Value int64(int i8, long j8) {
            return new Value(i8, 1, 3, j8);
        }

        public static Value int8(int i8, int i9) {
            return new Value(i8, 1, 0, i9);
        }

        private static byte packedType(int i8, int i9) {
            return (byte) (i8 | (i9 << 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int paddingBytes(int i8, int i9) {
            return ((~i8) + 1) & (i9 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        private int storedWidth(int i8) {
            return FlexBuffers.isTypeInline(this.type) ? Math.max(this.minBitWidth, i8) : this.minBitWidth;
        }

        public static Value uInt16(int i8, int i9) {
            return new Value(i8, 2, 1, i9);
        }

        public static Value uInt32(int i8, int i9) {
            return new Value(i8, 2, 2, i9);
        }

        public static Value uInt64(int i8, long j8) {
            return new Value(i8, 2, 3, j8);
        }

        public static Value uInt8(int i8, int i9) {
            return new Value(i8, 2, 0, i9);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int elemWidth(int i8, int i9, long j8, int i10, int i11) {
            if (FlexBuffers.isTypeInline(i8)) {
                return i9;
            }
            for (int i12 = 1; i12 <= 32; i12 *= 2) {
                int iWidthUInBits = FlexBuffersBuilder.widthUInBits((int) (((long) ((i11 * i12) + (paddingBytes(i10, i12) + i10))) - j8));
                if ((1 << iWidthUInBits) == i12) {
                    return iWidthUInBits;
                }
            }
            return 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType(int i8) {
            return packedType(storedWidth(i8), this.type);
        }

        public Value(int i8, int i9, int i10, double d7) {
            this.key = i8;
            this.type = i9;
            this.minBitWidth = i10;
            this.dValue = d7;
            this.iValue = Long.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder(int i8) {
        this(new ArrayReadWriteBuf(i8), 1);
    }

    private int align(int i8) {
        int i9 = 1 << i8;
        int iPaddingBytes = Value.paddingBytes(this.f1139bb.writePosition(), i9);
        while (true) {
            int i10 = iPaddingBytes - 1;
            if (iPaddingBytes == 0) {
                return i9;
            }
            this.f1139bb.put((byte) 0);
            iPaddingBytes = i10;
        }
    }

    private Value createKeyVector(int i8, int i9) {
        long j8 = i9;
        int iMax = Math.max(0, widthUInBits(j8));
        int i10 = i8;
        while (i10 < this.stack.size()) {
            i10++;
            iMax = Math.max(iMax, Value.elemWidth(4, 0, this.stack.get(i10).key, this.f1139bb.writePosition(), i10));
        }
        int iAlign = align(iMax);
        writeInt(j8, iAlign);
        int iWritePosition = this.f1139bb.writePosition();
        while (i8 < this.stack.size()) {
            int i11 = this.stack.get(i8).key;
            writeOffset(this.stack.get(i8).key, iAlign);
            i8++;
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), iMax, iWritePosition);
    }

    private Value createVector(int i8, int i9, int i10, boolean z2, boolean z3, Value value) {
        int i11;
        int typedVector;
        int i12 = i10;
        long j8 = i12;
        int iMax = Math.max(0, widthUInBits(j8));
        if (value != null) {
            iMax = Math.max(iMax, value.elemWidth(this.f1139bb.writePosition(), 0));
            i11 = 3;
        } else {
            i11 = 1;
        }
        int i13 = 4;
        int iMax2 = iMax;
        for (int i14 = i9; i14 < this.stack.size(); i14++) {
            iMax2 = Math.max(iMax2, this.stack.get(i14).elemWidth(this.f1139bb.writePosition(), i14 + i11));
            if (z2 && i14 == i9) {
                i13 = this.stack.get(i14).type;
                if (!FlexBuffers.isTypedVectorElementType(i13)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i15 = i9;
        int iAlign = align(iMax2);
        if (value != null) {
            writeOffset(value.iValue, iAlign);
            writeInt(1 << value.minBitWidth, iAlign);
        }
        if (!z3) {
            writeInt(j8, iAlign);
        }
        int iWritePosition = this.f1139bb.writePosition();
        for (int i16 = i15; i16 < this.stack.size(); i16++) {
            writeAny(this.stack.get(i16), iAlign);
        }
        if (!z2) {
            while (i15 < this.stack.size()) {
                this.f1139bb.put(this.stack.get(i15).storedPackedType(iMax2));
                i15++;
            }
        }
        if (value != null) {
            typedVector = 9;
        } else if (z2) {
            if (!z3) {
                i12 = 0;
            }
            typedVector = FlexBuffers.toTypedVector(i13, i12);
        } else {
            typedVector = 10;
        }
        return new Value(i8, typedVector, iMax2, iWritePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int iWritePosition = this.f1139bb.writePosition();
        if ((this.flags & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.f1139bb.put(bytes, 0, bytes.length);
            this.f1139bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(iWritePosition));
            return iWritePosition;
        }
        Integer num = this.keyPool.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.f1139bb.put(bytes2, 0, bytes2.length);
        this.f1139bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(iWritePosition));
        return iWritePosition;
    }

    public static int widthUInBits(long j8) {
        if (j8 <= FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) {
            return 0;
        }
        if (j8 <= FlexBuffers.Unsigned.shortToUnsignedInt((short) -1)) {
            return 1;
        }
        return j8 <= FlexBuffers.Unsigned.intToUnsignedLong(-1) ? 2 : 3;
    }

    private void writeAny(Value value, int i8) {
        int i9 = value.type;
        if (i9 != 0 && i9 != 1 && i9 != 2) {
            if (i9 == 3) {
                writeDouble(value.dValue, i8);
                return;
            } else if (i9 != 26) {
                writeOffset(value.iValue, i8);
                return;
            }
        }
        writeInt(value.iValue, i8);
    }

    private Value writeBlob(int i8, byte[] bArr, int i9, boolean z2) {
        int iWidthUInBits = widthUInBits(bArr.length);
        writeInt(bArr.length, align(iWidthUInBits));
        int iWritePosition = this.f1139bb.writePosition();
        this.f1139bb.put(bArr, 0, bArr.length);
        if (z2) {
            this.f1139bb.put((byte) 0);
        }
        return Value.blob(i8, iWritePosition, i9, iWidthUInBits);
    }

    private void writeDouble(double d7, int i8) {
        if (i8 == 4) {
            this.f1139bb.putFloat((float) d7);
        } else if (i8 == 8) {
            this.f1139bb.putDouble(d7);
        }
    }

    private void writeInt(long j8, int i8) {
        if (i8 == 1) {
            this.f1139bb.put((byte) j8);
            return;
        }
        if (i8 == 2) {
            this.f1139bb.putShort((short) j8);
        } else if (i8 == 4) {
            this.f1139bb.putInt((int) j8);
        } else {
            if (i8 != 8) {
                return;
            }
            this.f1139bb.putLong(j8);
        }
    }

    private void writeOffset(long j8, int i8) {
        writeInt((int) (((long) this.f1139bb.writePosition()) - j8), i8);
    }

    private Value writeString(int i8, String str) {
        return writeBlob(i8, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String str, int i8) {
        int iPutKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i8, arrayList.size()), this.keyComparator);
        Value valueCreateVector = createVector(iPutKey, i8, this.stack.size() - i8, false, false, createKeyVector(i8, this.stack.size() - i8));
        while (this.stack.size() > i8) {
            ArrayList<Value> arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.stack.add(valueCreateVector);
        return (int) valueCreateVector.iValue;
    }

    public int endVector(String str, int i8, boolean z2, boolean z3) {
        Value valueCreateVector = createVector(putKey(str), i8, this.stack.size() - i8, z2, z3, null);
        while (this.stack.size() > i8) {
            ArrayList<Value> arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }
        this.stack.add(valueCreateVector);
        return (int) valueCreateVector.iValue;
    }

    public ByteBuffer finish() {
        int iAlign = align(this.stack.get(0).elemWidth(this.f1139bb.writePosition(), 0));
        writeAny(this.stack.get(0), iAlign);
        this.f1139bb.put(this.stack.get(0).storedPackedType());
        this.f1139bb.put((byte) iAlign);
        this.finished = true;
        return ByteBuffer.wrap(this.f1139bb.data(), 0, this.f1139bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.f1139bb;
    }

    public int putBlob(byte[] bArr) {
        return putBlob(null, bArr);
    }

    public void putBoolean(boolean z2) {
        putBoolean(null, z2);
    }

    public void putFloat(float f) {
        putFloat((String) null, f);
    }

    public void putInt(int i8) {
        putInt((String) null, i8);
    }

    public int putString(String str) {
        return putString(null, str);
    }

    public void putUInt(int i8) {
        putUInt(null, i8);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64(null, bigInteger.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void putUInt64(String str, long j8) {
        this.stack.add(Value.uInt64(putKey(str), j8));
    }

    public int putBlob(String str, byte[] bArr) {
        Value valueWriteBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(valueWriteBlob);
        return (int) valueWriteBlob.iValue;
    }

    public void putBoolean(String str, boolean z2) {
        this.stack.add(Value.bool(putKey(str), z2));
    }

    public void putFloat(String str, float f) {
        this.stack.add(Value.float32(putKey(str), f));
    }

    public void putInt(String str, int i8) {
        putInt(str, i8);
    }

    public int putString(String str, String str2) {
        int iPutKey = putKey(str);
        if ((this.flags & 2) == 0) {
            Value valueWriteString = writeString(iPutKey, str2);
            this.stack.add(valueWriteString);
            return (int) valueWriteString.iValue;
        }
        Integer num = this.stringPool.get(str2);
        if (num != null) {
            this.stack.add(Value.blob(iPutKey, num.intValue(), 5, widthUInBits(str2.length())));
            return num.intValue();
        }
        Value valueWriteString2 = writeString(iPutKey, str2);
        this.stringPool.put(str2, Integer.valueOf((int) valueWriteString2.iValue));
        this.stack.add(valueWriteString2);
        return (int) valueWriteString2.iValue;
    }

    public void putUInt(long j8) {
        putUInt(null, j8);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i8) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), i8);
    }

    private void putUInt(String str, long j8) {
        Value valueUInt64;
        int iPutKey = putKey(str);
        int iWidthUInBits = widthUInBits(j8);
        if (iWidthUInBits == 0) {
            valueUInt64 = Value.uInt8(iPutKey, (int) j8);
        } else if (iWidthUInBits == 1) {
            valueUInt64 = Value.uInt16(iPutKey, (int) j8);
        } else if (iWidthUInBits == 2) {
            valueUInt64 = Value.uInt32(iPutKey, (int) j8);
        } else {
            valueUInt64 = Value.uInt64(iPutKey, j8);
        }
        this.stack.add(valueUInt64);
    }

    public void putFloat(double d7) {
        putFloat((String) null, d7);
    }

    public void putInt(String str, long j8) {
        int iPutKey = putKey(str);
        if (-128 <= j8 && j8 <= 127) {
            this.stack.add(Value.int8(iPutKey, (int) j8));
            return;
        }
        if (-32768 <= j8 && j8 <= 32767) {
            this.stack.add(Value.int16(iPutKey, (int) j8));
        } else if (-2147483648L <= j8 && j8 <= 2147483647L) {
            this.stack.add(Value.int32(iPutKey, (int) j8));
        } else {
            this.stack.add(Value.int64(iPutKey, j8));
        }
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i8) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            @Override // java.util.Comparator
            public int compare(Value value, Value value2) {
                byte b9;
                byte b10;
                int i9 = value.key;
                int i10 = value2.key;
                do {
                    b9 = FlexBuffersBuilder.this.f1139bb.get(i9);
                    b10 = FlexBuffersBuilder.this.f1139bb.get(i10);
                    if (b9 == 0) {
                        return b9 - b10;
                    }
                    i9++;
                    i10++;
                } while (b9 == b10);
                return b9 - b10;
            }
        };
        this.f1139bb = readWriteBuf;
        this.flags = i8;
    }

    public void putFloat(String str, double d7) {
        this.stack.add(Value.float64(putKey(str), d7));
    }

    public void putInt(long j8) {
        putInt((String) null, j8);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
