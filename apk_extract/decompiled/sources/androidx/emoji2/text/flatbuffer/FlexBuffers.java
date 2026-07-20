package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.EMPTY_BB, 1, 1);

        public Blob(ReadBuf readBuf, int i8, int i9) {
            super(readBuf, i8, i9);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f1137bb.data());
            byteBufferWrap.position(this.end);
            byteBufferWrap.limit(size() + this.end);
            return byteBufferWrap.asReadOnlyBuffer().slice();
        }

        public byte get(int i8) {
            return this.f1137bb.get(this.end + i8);
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i8 = 0; i8 < size; i8++) {
                bArr[i8] = this.f1137bb.get(this.end + i8);
            }
            return bArr;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.f1137bb.getString(this.end, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append(Typography.quote);
            sb2.append(this.f1137bb.getString(this.end, size()));
            sb2.append(Typography.quote);
            return sb2;
        }
    }

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String str) {
            super(str);
        }
    }

    public static class Key extends Object {
        private static final Key EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);

        public Key(ReadBuf readBuf, int i8, int i9) {
            super(readBuf, i8, i9);
        }

        public static Key empty() {
            return EMPTY;
        }

        public int compareTo(byte[] bArr) {
            byte b9;
            byte b10;
            int i8 = this.end;
            int i9 = 0;
            do {
                b9 = this.f1137bb.get(i8);
                b10 = bArr[i9];
                if (b9 == 0) {
                    return b9 - b10;
                }
                i8++;
                i9++;
                if (i9 == bArr.length) {
                    return b9 - b10;
                }
            } while (b9 == b10);
            return b9 - b10;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return key.end == this.end && key.byteWidth == this.byteWidth;
        }

        public int hashCode() {
            return this.byteWidth ^ this.end;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append(toString());
            return sb2;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int i8 = this.end;
            while (this.f1137bb.get(i8) != 0) {
                i8++;
            }
            int i9 = this.end;
            return this.f1137bb.getString(i9, i8 - i9);
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        public KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i8) {
            if (i8 >= size()) {
                return Key.EMPTY;
            }
            TypedVector typedVector = this.vec;
            int i9 = (i8 * typedVector.byteWidth) + typedVector.end;
            TypedVector typedVector2 = this.vec;
            ReadBuf readBuf = typedVector2.f1137bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, i9, typedVector2.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (int i8 = 0; i8 < this.vec.size(); i8++) {
                this.vec.get(i8).toString(sb2);
                if (i8 != this.vec.size() - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);

        public Map(ReadBuf readBuf, int i8, int i9) {
            super(readBuf, i8, i9);
        }

        private int binarySearch(KeyVector keyVector, byte[] bArr) {
            int size = keyVector.size() - 1;
            int i8 = 0;
            while (i8 <= size) {
                int i9 = (i8 + size) >>> 1;
                int iCompareTo = keyVector.get(i9).compareTo(bArr);
                if (iCompareTo < 0) {
                    i8 = i9 + 1;
                } else {
                    if (iCompareTo <= 0) {
                        return i9;
                    }
                    size = i9 - 1;
                }
            }
            return -(i8 + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String str) {
            return get(str.getBytes(StandardCharsets.UTF_8));
        }

        public KeyVector keys() {
            int i8 = this.end - (this.byteWidth * 3);
            ReadBuf readBuf = this.f1137bb;
            int iIndirect = FlexBuffers.indirect(readBuf, i8, this.byteWidth);
            ReadBuf readBuf2 = this.f1137bb;
            int i9 = this.byteWidth;
            return new KeyVector(new TypedVector(readBuf, iIndirect, FlexBuffers.readInt(readBuf2, i8 + i9, i9), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("{ ");
            KeyVector keyVectorKeys = keys();
            int size = size();
            Vector vectorValues = values();
            for (int i8 = 0; i8 < size; i8++) {
                sb2.append(Typography.quote);
                sb2.append(keyVectorKeys.get(i8).toString());
                sb2.append("\" : ");
                sb2.append(vectorValues.get(i8).toString());
                if (i8 != size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" }");
            return sb2;
        }

        public Vector values() {
            return new Vector(this.f1137bb, this.end, this.byteWidth);
        }

        public Reference get(byte[] bArr) {
            KeyVector keyVectorKeys = keys();
            int size = keyVectorKeys.size();
            int iBinarySearch = binarySearch(keyVectorKeys, bArr);
            return (iBinarySearch < 0 || iBinarySearch >= size) ? Reference.NULL_REFERENCE : get(iBinarySearch);
        }
    }

    public static abstract class Object {

        /* JADX INFO: renamed from: bb, reason: collision with root package name */
        ReadBuf f1137bb;
        int byteWidth;
        int end;

        public Object(ReadBuf readBuf, int i8, int i9) {
            this.f1137bb = readBuf;
            this.end = i8;
            this.byteWidth = i9;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder sb2);
    }

    public static class Reference {
        private static final Reference NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);

        /* JADX INFO: renamed from: bb, reason: collision with root package name */
        private ReadBuf f1138bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        public Reference(ReadBuf readBuf, int i8, int i9, int i10) {
            this(readBuf, i8, i9, 1 << (i10 & 3), i10 >> 2);
        }

        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            ReadBuf readBuf = this.f1138bb;
            return new Blob(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            if (isBoolean()) {
                return this.f1138bb.get(this.end) != 0;
            }
            return asUInt() != 0;
        }

        public double asFloat() {
            int i8 = this.type;
            if (i8 == 3) {
                return FlexBuffers.readDouble(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 1) {
                return FlexBuffers.readInt(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 != 2) {
                if (i8 == 5) {
                    return Double.parseDouble(asString());
                }
                if (i8 == 6) {
                    ReadBuf readBuf = this.f1138bb;
                    return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                }
                if (i8 == 7) {
                    ReadBuf readBuf2 = this.f1138bb;
                    return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                }
                if (i8 == 8) {
                    ReadBuf readBuf3 = this.f1138bb;
                    return FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
                }
                if (i8 == 10) {
                    return asVector().size();
                }
                if (i8 != 26) {
                    return 0.0d;
                }
            }
            return FlexBuffers.readUInt(this.f1138bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int i8 = this.type;
            if (i8 == 1) {
                return FlexBuffers.readInt(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 2) {
                return (int) FlexBuffers.readUInt(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 3) {
                return (int) FlexBuffers.readDouble(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 5) {
                return Integer.parseInt(asString());
            }
            if (i8 == 6) {
                ReadBuf readBuf = this.f1138bb;
                return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i8 == 7) {
                ReadBuf readBuf2 = this.f1138bb;
                return (int) FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i8 == 8) {
                ReadBuf readBuf3 = this.f1138bb;
                return (int) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i8 == 10) {
                return asVector().size();
            }
            if (i8 != 26) {
                return 0;
            }
            return FlexBuffers.readInt(this.f1138bb, this.end, this.parentWidth);
        }

        public Key asKey() {
            if (!isKey()) {
                return Key.empty();
            }
            ReadBuf readBuf = this.f1138bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public long asLong() {
            int i8 = this.type;
            if (i8 == 1) {
                return FlexBuffers.readLong(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 2) {
                return FlexBuffers.readUInt(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 3) {
                return (long) FlexBuffers.readDouble(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 5) {
                try {
                    return Long.parseLong(asString());
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            }
            if (i8 == 6) {
                ReadBuf readBuf = this.f1138bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i8 == 7) {
                ReadBuf readBuf2 = this.f1138bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            }
            if (i8 == 8) {
                ReadBuf readBuf3 = this.f1138bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            }
            if (i8 == 10) {
                return asVector().size();
            }
            if (i8 != 26) {
                return 0L;
            }
            return FlexBuffers.readInt(this.f1138bb, this.end, this.parentWidth);
        }

        public Map asMap() {
            if (!isMap()) {
                return Map.empty();
            }
            ReadBuf readBuf = this.f1138bb;
            return new Map(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public String asString() {
            if (isString()) {
                int iIndirect = FlexBuffers.indirect(this.f1138bb, this.end, this.parentWidth);
                ReadBuf readBuf = this.f1138bb;
                int i8 = this.byteWidth;
                return this.f1138bb.getString(iIndirect, (int) FlexBuffers.readUInt(readBuf, iIndirect - i8, i8));
            }
            if (!isKey()) {
                return "";
            }
            int iIndirect2 = FlexBuffers.indirect(this.f1138bb, this.end, this.byteWidth);
            int i9 = iIndirect2;
            while (this.f1138bb.get(i9) != 0) {
                i9++;
            }
            return this.f1138bb.getString(iIndirect2, i9 - iIndirect2);
        }

        public long asUInt() {
            int i8 = this.type;
            if (i8 == 2) {
                return FlexBuffers.readUInt(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 1) {
                return FlexBuffers.readLong(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 3) {
                return (long) FlexBuffers.readDouble(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 10) {
                return asVector().size();
            }
            if (i8 == 26) {
                return FlexBuffers.readInt(this.f1138bb, this.end, this.parentWidth);
            }
            if (i8 == 5) {
                return Long.parseLong(asString());
            }
            if (i8 == 6) {
                ReadBuf readBuf = this.f1138bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            if (i8 == 7) {
                ReadBuf readBuf2 = this.f1138bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
            }
            if (i8 != 8) {
                return 0L;
            }
            ReadBuf readBuf3 = this.f1138bb;
            return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
        }

        public Vector asVector() {
            if (isVector()) {
                ReadBuf readBuf = this.f1138bb;
                return new Vector(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            int i8 = this.type;
            if (i8 == 15) {
                ReadBuf readBuf2 = this.f1138bb;
                return new TypedVector(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth, 4);
            }
            if (!FlexBuffers.isTypedVector(i8)) {
                return Vector.empty();
            }
            ReadBuf readBuf3 = this.f1138bb;
            return new TypedVector(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isFloat() {
            int i8 = this.type;
            return i8 == 3 || i8 == 8;
        }

        public boolean isInt() {
            int i8 = this.type;
            return i8 == 1 || i8 == 6;
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int i8 = this.type;
            return i8 == 2 || i8 == 7;
        }

        public boolean isVector() {
            int i8 = this.type;
            return i8 == 10 || i8 == 9;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public Reference(ReadBuf readBuf, int i8, int i9, int i10, int i11) {
            this.f1138bb = readBuf;
            this.end = i8;
            this.parentWidth = i9;
            this.byteWidth = i10;
            this.type = i11;
        }

        public StringBuilder toString(StringBuilder sb2) {
            int i8 = this.type;
            if (i8 != 36) {
                switch (i8) {
                    case 0:
                        sb2.append("null");
                        return sb2;
                    case 1:
                    case 6:
                        sb2.append(asLong());
                        return sb2;
                    case 2:
                    case 7:
                        sb2.append(asUInt());
                        return sb2;
                    case 3:
                    case 8:
                        sb2.append(asFloat());
                        return sb2;
                    case 4:
                        Key keyAsKey = asKey();
                        sb2.append(Typography.quote);
                        StringBuilder string = keyAsKey.toString(sb2);
                        string.append(Typography.quote);
                        return string;
                    case 5:
                        sb2.append(Typography.quote);
                        sb2.append(asString());
                        sb2.append(Typography.quote);
                        return sb2;
                    case 9:
                        return asMap().toString(sb2);
                    case 10:
                        return asVector().toString(sb2);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb2);
                    case 26:
                        sb2.append(asBoolean());
                        return sb2;
                    default:
                        return sb2;
                }
            }
            sb2.append(asVector());
            return sb2;
        }
    }

    public static abstract class Sized extends Object {
        protected final int size;

        public Sized(ReadBuf readBuf, int i8, int i9) {
            super(readBuf, i8, i9);
            this.size = FlexBuffers.readInt(this.f1137bb, i8 - i9, i9);
        }

        public int size() {
            return this.size;
        }
    }

    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        public TypedVector(ReadBuf readBuf, int i8, int i9, int i10) {
            super(readBuf, i8, i9);
            this.elemType = i10;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int i8) {
            if (i8 >= size()) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.f1137bb, (i8 * this.byteWidth) + this.end, this.byteWidth, 1, this.elemType);
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }
    }

    public static class Unsigned {
        public static int byteToUnsignedInt(byte b9) {
            return b9 & UByte.MAX_VALUE;
        }

        public static long intToUnsignedLong(int i8) {
            return ((long) i8) & 4294967295L;
        }

        public static int shortToUnsignedInt(short s2) {
            return s2 & UShort.MAX_VALUE;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);

        public Vector(ReadBuf readBuf, int i8, int i9) {
            super(readBuf, i8, i9);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int i8) {
            long size = size();
            long j8 = i8;
            if (j8 >= size) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.f1137bb, (i8 * this.byteWidth) + this.end, this.byteWidth, Unsigned.byteToUnsignedInt(this.f1137bb.get((int) ((size * ((long) this.byteWidth)) + ((long) this.end) + j8))));
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder sb2) {
            sb2.append("[ ");
            int size = size();
            for (int i8 = 0; i8 < size; i8++) {
                get(i8).toString(sb2);
                if (i8 != size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append(" ]");
            return sb2;
        }
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indirect(ReadBuf readBuf, int i8, int i9) {
        return (int) (((long) i8) - readUInt(readBuf, i8, i9));
    }

    public static boolean isTypeInline(int i8) {
        return i8 <= 3 || i8 == 26;
    }

    public static boolean isTypedVector(int i8) {
        return (i8 >= 11 && i8 <= 15) || i8 == 36;
    }

    public static boolean isTypedVectorElementType(int i8) {
        return (i8 >= 1 && i8 <= 4) || i8 == 26;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double readDouble(ReadBuf readBuf, int i8, int i9) {
        if (i9 == 4) {
            return readBuf.getFloat(i8);
        }
        if (i9 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int readInt(ReadBuf readBuf, int i8, int i9) {
        return (int) readLong(readBuf, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readLong(ReadBuf readBuf, int i8, int i9) {
        int i10;
        if (i9 == 1) {
            i10 = readBuf.get(i8);
        } else if (i9 == 2) {
            i10 = readBuf.getShort(i8);
        } else {
            if (i9 != 4) {
                if (i9 != 8) {
                    return -1L;
                }
                return readBuf.getLong(i8);
            }
            i10 = readBuf.getInt(i8);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long readUInt(ReadBuf readBuf, int i8, int i9) {
        if (i9 == 1) {
            return Unsigned.byteToUnsignedInt(readBuf.get(i8));
        }
        if (i9 == 2) {
            return Unsigned.shortToUnsignedInt(readBuf.getShort(i8));
        }
        if (i9 == 4) {
            return Unsigned.intToUnsignedLong(readBuf.getInt(i8));
        }
        if (i9 != 8) {
            return -1L;
        }
        return readBuf.getLong(i8);
    }

    public static int toTypedVector(int i8, int i9) {
        if (i9 == 0) {
            return i8 + 10;
        }
        if (i9 == 2) {
            return i8 + 15;
        }
        if (i9 == 3) {
            return i8 + 18;
        }
        if (i9 != 4) {
            return 0;
        }
        return i8 + 21;
    }

    public static int toTypedVectorElementType(int i8) {
        return i8 - 10;
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int iLimit = readBuf.limit();
        byte b9 = readBuf.get(iLimit - 1);
        int i8 = iLimit - 2;
        return new Reference(readBuf, i8 - b9, b9, Unsigned.byteToUnsignedInt(readBuf.get(i8)));
    }
}
