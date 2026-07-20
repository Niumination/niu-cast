package io.netty.handler.codec;

/* JADX INFO: loaded from: classes3.dex */
public interface ValueConverter<T> {
    T convertBoolean(boolean z10);

    T convertByte(byte b10);

    T convertChar(char c10);

    T convertDouble(double d10);

    T convertFloat(float f10);

    T convertInt(int i10);

    T convertLong(long j10);

    T convertObject(Object obj);

    T convertShort(short s10);

    T convertTimeMillis(long j10);

    boolean convertToBoolean(T t10);

    byte convertToByte(T t10);

    char convertToChar(T t10);

    double convertToDouble(T t10);

    float convertToFloat(T t10);

    int convertToInt(T t10);

    long convertToLong(T t10);

    short convertToShort(T t10);

    long convertToTimeMillis(T t10);
}
