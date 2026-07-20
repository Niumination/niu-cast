package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i8) {
        return this.buffer[i8];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i8) {
        return this.buffer[i8] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i8) {
        return Double.longBitsToDouble(getLong(i8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i8) {
        return Float.intBitsToFloat(getInt(i8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i8) {
        byte[] bArr = this.buffer;
        return (bArr[i8] & UByte.MAX_VALUE) | (bArr[i8 + 3] << 24) | ((bArr[i8 + 2] & UByte.MAX_VALUE) << 16) | ((bArr[i8 + 1] & UByte.MAX_VALUE) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i8) {
        byte[] bArr = this.buffer;
        long j8 = (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40);
        return (((long) bArr[i8 + 7]) << 56) | j8 | ((((long) bArr[i8 + 6]) & 255) << 48);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i8) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i8] & UByte.MAX_VALUE) | (bArr[i8 + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i8, int i9) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i8, i9);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i8, int i9) {
        set(this.writePos, bArr, i8, i9);
        this.writePos += i9;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z2) {
        setBoolean(this.writePos, z2);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d7) {
        setDouble(this.writePos, d7);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f) {
        setFloat(this.writePos, f);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i8) {
        setInt(this.writePos, i8);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j8) {
        setLong(this.writePos, j8);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s2) {
        setShort(this.writePos, s2);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i8) {
        byte[] bArr = this.buffer;
        if (bArr.length > i8) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i8, byte b9) {
        requestCapacity(i8 + 1);
        this.buffer[i8] = b9;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i8, boolean z2) {
        set(i8, z2 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i8, double d7) {
        requestCapacity(i8 + 8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d7);
        int i9 = (int) jDoubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i8] = (byte) (i9 & 255);
        bArr[i8 + 1] = (byte) ((i9 >> 8) & 255);
        bArr[i8 + 2] = (byte) ((i9 >> 16) & 255);
        bArr[i8 + 3] = (byte) ((i9 >> 24) & 255);
        int i10 = (int) (jDoubleToRawLongBits >> 32);
        bArr[i8 + 4] = (byte) (i10 & 255);
        bArr[i8 + 5] = (byte) ((i10 >> 8) & 255);
        bArr[i8 + 6] = (byte) ((i10 >> 16) & 255);
        bArr[i8 + 7] = (byte) ((i10 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i8, float f) {
        requestCapacity(i8 + 4);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        byte[] bArr = this.buffer;
        bArr[i8] = (byte) (iFloatToRawIntBits & 255);
        bArr[i8 + 1] = (byte) ((iFloatToRawIntBits >> 8) & 255);
        bArr[i8 + 2] = (byte) ((iFloatToRawIntBits >> 16) & 255);
        bArr[i8 + 3] = (byte) ((iFloatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i8, int i9) {
        requestCapacity(i8 + 4);
        byte[] bArr = this.buffer;
        bArr[i8] = (byte) (i9 & 255);
        bArr[i8 + 1] = (byte) ((i9 >> 8) & 255);
        bArr[i8 + 2] = (byte) ((i9 >> 16) & 255);
        bArr[i8 + 3] = (byte) ((i9 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i8, long j8) {
        requestCapacity(i8 + 8);
        int i9 = (int) j8;
        byte[] bArr = this.buffer;
        bArr[i8] = (byte) (i9 & 255);
        bArr[i8 + 1] = (byte) ((i9 >> 8) & 255);
        bArr[i8 + 2] = (byte) ((i9 >> 16) & 255);
        bArr[i8 + 3] = (byte) ((i9 >> 24) & 255);
        int i10 = (int) (j8 >> 32);
        bArr[i8 + 4] = (byte) (i10 & 255);
        bArr[i8 + 5] = (byte) ((i10 >> 8) & 255);
        bArr[i8 + 6] = (byte) ((i10 >> 16) & 255);
        bArr[i8 + 7] = (byte) ((i10 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i8, short s2) {
        requestCapacity(i8 + 2);
        byte[] bArr = this.buffer;
        bArr[i8] = (byte) (s2 & 255);
        bArr[i8 + 1] = (byte) ((s2 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i8) {
        this(new byte[i8]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b9) {
        set(this.writePos, b9);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i8, byte[] bArr, int i9, int i10) {
        requestCapacity((i10 - i9) + i8);
        System.arraycopy(bArr, i9, this.buffer, i8, i10);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i8) {
        this.buffer = bArr;
        this.writePos = i8;
    }
}
