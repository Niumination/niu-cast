package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b9);

    void put(byte[] bArr, int i8, int i9);

    void putBoolean(boolean z2);

    void putDouble(double d7);

    void putFloat(float f);

    void putInt(int i8);

    void putLong(long j8);

    void putShort(short s2);

    boolean requestCapacity(int i8);

    void set(int i8, byte b9);

    void set(int i8, byte[] bArr, int i9, int i10);

    void setBoolean(int i8, boolean z2);

    void setDouble(int i8, double d7);

    void setFloat(int i8, float f);

    void setInt(int i8, int i9);

    void setLong(int i8, long j8);

    void setShort(int i8, short s2);

    int writePosition();
}
