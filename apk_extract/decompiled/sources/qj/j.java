package qj;

import com.transsion.core.utils.EncoderUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import k3.qc;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public class j implements Serializable, Comparable {
    public static final i Companion = new i();

    @JvmField
    public static final j EMPTY = new j(new byte[0]);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f9196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f9197b;
    private final byte[] data;

    public j(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public static /* synthetic */ void copyInto$default(j jVar, int i8, byte[] bArr, int i9, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i11 & 1) != 0) {
            i8 = 0;
        }
        if ((i11 & 4) != 0) {
            i9 = 0;
        }
        jVar.copyInto(i8, bArr, i9, i10);
    }

    /* JADX WARN: Code duplicated, block: B:68:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    public static final j decodeBase64(String str) {
        int i8;
        char cCharAt;
        Companion.getClass();
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = a.f9177a;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i9 = (int) ((((long) length) * 6) / 8);
        byte[] bArrCopyOf = new byte[i9];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i10 >= length) {
                int i14 = i11 % 4;
                if (i14 != 1) {
                    if (i14 == 2) {
                        bArrCopyOf[i13] = (byte) ((i12 << 12) >> 16);
                        i13 = 1 + i13;
                    } else if (i14 == 3) {
                        int i15 = i12 << 6;
                        int i16 = 1 + i13;
                        bArrCopyOf[i13] = (byte) (i15 >> 16);
                        i13 += 2;
                        bArrCopyOf[i16] = (byte) (i15 >> 8);
                    }
                    if (i13 != i9) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i13);
                        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
                    }
                }
                if (bArrCopyOf != null) {
                    return new j(bArrCopyOf);
                }
                return null;
            }
            char cCharAt2 = str.charAt(i10);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i8 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                i8 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                i8 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i8 = 62;
            } else {
                if (cCharAt2 != '/' && cCharAt2 != '_') {
                    if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                        break;
                    }
                } else {
                    i8 = 63;
                }
                i10++;
            }
            int i17 = i8 | (i12 << 6);
            i11++;
            if (i11 % 4 == 0) {
                bArrCopyOf[i13] = (byte) (i17 >> 16);
                int i18 = i13 + 2;
                bArrCopyOf[i13 + 1] = (byte) (i17 >> 8);
                i13 += 3;
                bArrCopyOf[i18] = (byte) i17;
            }
            i12 = i17;
            i10++;
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new j(bArrCopyOf);
        }
        return null;
    }

    @JvmStatic
    public static final j decodeHex(String str) {
        Companion.getClass();
        return i.a(str);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    public static final j encodeString(String str, Charset charset) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return new j(bytes);
    }

    @JvmStatic
    public static final j encodeUtf8(String str) {
        Companion.getClass();
        return i.b(str);
    }

    public static /* synthetic */ int indexOf$default(j jVar, j jVar2, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return jVar.indexOf(jVar2, i8);
    }

    public static /* synthetic */ int lastIndexOf$default(j jVar, j jVar2, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i9 & 2) != 0) {
            i8 = -1234567890;
        }
        return jVar.lastIndexOf(jVar2, i8);
    }

    @JvmStatic
    @JvmName(name = "of")
    public static final j of(ByteBuffer byteBuffer) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new j(bArr);
    }

    @JvmStatic
    @JvmName(name = "read")
    public static final j read(InputStream inputStream, int i8) throws IOException {
        Companion.getClass();
        return i.d(inputStream, i8);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        int i8 = objectInputStream.readInt();
        Companion.getClass();
        j jVarD = i.d(objectInputStream, i8);
        Field declaredField = j.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, jVarD.data);
    }

    public static /* synthetic */ j substring$default(j jVar, int i8, int i9, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = -1234567890;
        }
        return jVar.substring(i8, i9);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m1634deprecated_getByte(int i8) {
        return getByte(i8);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m1635deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    public String base64() {
        return a.a(getData$okio(), a.f9177a);
    }

    public String base64Url() {
        return a.a(getData$okio(), a.f9178b);
    }

    public void copyInto(int i8, byte[] target, int i9, int i10) {
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt.copyInto(getData$okio(), target, i9, i8, i10 + i8);
    }

    public j digest$okio(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, size());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new j(digestBytes);
    }

    public final boolean endsWith(j suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (jVar.size() == getData$okio().length && jVar.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int i8) {
        return internalGet$okio(i8);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.f9196a;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.f9197b;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i8 = 0;
        for (byte b9 : getData$okio()) {
            int i9 = i8 + 1;
            char[] cArr2 = rj.b.f9441a;
            cArr[i8] = cArr2[(b9 >> 4) & 15];
            i8 += 2;
            cArr[i9] = cArr2[b9 & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public j hmac$okio(String algorithm, j key) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "mac.doFinal(data)");
            return new j(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public j hmacSha1(j key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public j hmacSha256(j key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public j hmacSha512(j key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    @JvmOverloads
    public final int indexOf(j other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i8) {
        return getData$okio()[i8];
    }

    @JvmOverloads
    public final int lastIndexOf(j other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public final j md5() {
        return digest$okio(EncoderUtil.ALGORITHM_MD5);
    }

    public boolean rangeEquals(int i8, j other, int i9, int i10) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(i9, getData$okio(), i8, i10);
    }

    public final void setHashCode$okio(int i8) {
        this.f9196a = i8;
    }

    public final void setUtf8$okio(String str) {
        this.f9197b = str;
    }

    public final j sha1() {
        return digest$okio(EncoderUtil.ALGORITHM_SHA_1);
    }

    public final j sha256() {
        return digest$okio(EncoderUtil.ALGORITHM_SHA_256);
    }

    public final j sha512() {
        return digest$okio(EncoderUtil.ALGORITHM_SHA_512);
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(j prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public String string(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(this.data, charset);
    }

    @JvmOverloads
    public final j substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public j toAsciiLowercase() {
        for (int i8 = 0; i8 < getData$okio().length; i8++) {
            byte b9 = getData$okio()[i8];
            if (b9 >= 65 && b9 <= 90) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i8] = (byte) (b9 + 32);
                for (int i9 = i8 + 1; i9 < bArrCopyOf.length; i9++) {
                    byte b10 = bArrCopyOf[i9];
                    if (b10 >= 65 && b10 <= 90) {
                        bArrCopyOf[i9] = (byte) (b10 + 32);
                    }
                }
                return new j(bArrCopyOf);
            }
        }
        return this;
    }

    public j toAsciiUppercase() {
        for (int i8 = 0; i8 < getData$okio().length; i8++) {
            byte b9 = getData$okio()[i8];
            if (b9 >= 97 && b9 <= 122) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i8] = (byte) (b9 - 32);
                for (int i9 = i8 + 1; i9 < bArrCopyOf.length; i9++) {
                    byte b10 = bArrCopyOf[i9];
                    if (b10 >= 97 && b10 <= 122) {
                        bArrCopyOf[i9] = (byte) (b10 - 32);
                    }
                }
                return new j(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0041 A[EDGE_INSN: B:22:0x0041->B:180:0x01b1 BREAK  A[LOOP:0: B:6:0x0014->B:238:0x0014]] */
    public String toString() {
        byte b9;
        int i8;
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        byte[] data$okio = getData$okio();
        int length = data$okio.length;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        loop0: while (i9 < length) {
            byte b10 = data$okio[i9];
            if (b10 < 0) {
                if ((b10 >> 5) != -2) {
                    if ((b10 >> 4) != -2) {
                        if ((b10 >> 3) != -2) {
                            if (i11 == 64) {
                                break;
                            }
                            i10 = -1;
                            break;
                        }
                        int i12 = i9 + 3;
                        if (length > i12) {
                            byte b11 = data$okio[i9 + 1];
                            if ((b11 & 192) != 128) {
                                if (i11 == 64) {
                                    break;
                                }
                                i10 = -1;
                                break;
                            }
                            byte b12 = data$okio[i9 + 2];
                            if ((b12 & 192) != 128) {
                                if (i11 == 64) {
                                    break;
                                }
                                i10 = -1;
                                break;
                            }
                            byte b13 = data$okio[i12];
                            if ((b13 & 192) != 128) {
                                if (i11 == 64) {
                                    break;
                                }
                                i10 = -1;
                                break;
                            }
                            int i13 = (((b13 ^ ByteCompanionObject.MIN_VALUE) ^ (b12 << 6)) ^ (b11 << 12)) ^ (b10 << 18);
                            if (i13 <= 1114111) {
                                if (55296 <= i13 && i13 < 57344) {
                                    if (i11 == 64) {
                                        break;
                                    }
                                    i10 = -1;
                                    break;
                                }
                                if (i13 >= 65536) {
                                    i8 = i11 + 1;
                                    if (i11 == 64) {
                                        break;
                                    }
                                    if ((i13 != 10 && i13 != 13 && ((i13 >= 0 && i13 < 32) || (127 <= i13 && i13 < 160))) || i13 == 65533) {
                                        i10 = -1;
                                        break;
                                    }
                                    i10 += i13 < 65536 ? 1 : 2;
                                    Unit unit = Unit.INSTANCE;
                                    i9 += 4;
                                    i11 = i8;
                                } else {
                                    if (i11 == 64) {
                                        break;
                                    }
                                    i10 = -1;
                                    break;
                                }
                            } else {
                                if (i11 == 64) {
                                    break;
                                }
                                i10 = -1;
                                break;
                            }
                        } else {
                            if (i11 == 64) {
                                break;
                            }
                            i10 = -1;
                            break;
                        }
                    } else {
                        int i14 = i9 + 2;
                        if (length > i14) {
                            byte b14 = data$okio[i9 + 1];
                            if ((b14 & 192) != 128) {
                                if (i11 == 64) {
                                    break;
                                }
                                i10 = -1;
                                break;
                            }
                            byte b15 = data$okio[i14];
                            if ((b15 & 192) != 128) {
                                if (i11 == 64) {
                                    break;
                                }
                                i10 = -1;
                                break;
                            }
                            int i15 = ((b14 << 6) ^ (b15 ^ ByteCompanionObject.MIN_VALUE)) ^ (b10 << 12);
                            if (i15 >= 2048) {
                                if (55296 <= i15 && i15 < 57344) {
                                    if (i11 == 64) {
                                        break;
                                    }
                                    i10 = -1;
                                    break;
                                }
                                i8 = i11 + 1;
                                if (i11 == 64) {
                                    break;
                                }
                                if ((i15 != 10 && i15 != 13 && ((i15 >= 0 && i15 < 32) || (127 <= i15 && i15 < 160))) || i15 == 65533) {
                                    i10 = -1;
                                    break;
                                }
                                i10 += i15 < 65536 ? 1 : 2;
                                Unit unit2 = Unit.INSTANCE;
                                i9 += 3;
                                i11 = i8;
                            } else {
                                if (i11 == 64) {
                                    break;
                                }
                                i10 = -1;
                                break;
                            }
                        } else {
                            if (i11 == 64) {
                                break;
                            }
                            i10 = -1;
                            break;
                        }
                    }
                } else {
                    int i16 = i9 + 1;
                    if (length > i16) {
                        byte b16 = data$okio[i16];
                        if ((b16 & 192) != 128) {
                            if (i11 == 64) {
                                break;
                            }
                            i10 = -1;
                            break;
                        }
                        int i17 = (b16 ^ ByteCompanionObject.MIN_VALUE) ^ (b10 << 6);
                        if (i17 >= 128) {
                            i8 = i11 + 1;
                            if (i11 == 64) {
                                break;
                            }
                            if ((i17 != 10 && i17 != 13 && ((i17 >= 0 && i17 < 32) || (127 <= i17 && i17 < 160))) || i17 == 65533) {
                                i10 = -1;
                                break;
                            }
                            i10 += i17 < 65536 ? 1 : 2;
                            Unit unit3 = Unit.INSTANCE;
                            i9 += 2;
                            i11 = i8;
                        } else {
                            if (i11 == 64) {
                                break;
                            }
                            i10 = -1;
                            break;
                        }
                    } else {
                        if (i11 == 64) {
                            break;
                        }
                        i10 = -1;
                        break;
                    }
                }
            } else {
                int i18 = i11 + 1;
                if (i11 == 64) {
                    break;
                }
                if ((b10 == 10 || b10 == 13 || ((b10 < 0 || b10 >= 32) && (127 > b10 || b10 >= 160))) && b10 != 65533) {
                    i10 += b10 < 65536 ? 1 : 2;
                    i9++;
                    while (true) {
                        i11 = i18;
                        if (i9 < length && (b9 = data$okio[i9]) >= 0) {
                            i9++;
                            i18 = i11 + 1;
                            if (i11 == 64) {
                                break loop0;
                            }
                            if ((b9 == 10 || b9 == 13 || ((b9 < 0 || b9 >= 32) && (127 > b9 || b9 >= 160))) && b9 != 65533) {
                                i10 += b9 < 65536 ? 1 : 2;
                            }
                        }
                    }
                }
                i10 = -1;
                break;
            }
        }
        if (i10 == -1) {
            if (getData$okio().length <= 64) {
                return "[hex=" + hex() + ']';
            }
            StringBuilder sb2 = new StringBuilder("[size=");
            sb2.append(getData$okio().length);
            sb2.append(" hex=");
            Intrinsics.checkNotNullParameter(this, "<this>");
            if (64 > getData$okio().length) {
                throw new IllegalArgumentException(a1.a.r(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
            }
            sb2.append((64 == getData$okio().length ? this : new j(ArraysKt.copyOfRange(getData$okio(), 0, 64))).hex());
            sb2.append("…]");
            return sb2.toString();
        }
        String strUtf8 = utf8();
        String strSubstring = strUtf8.substring(0, i10);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strReplace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (i10 >= strUtf8.length()) {
            return "[text=" + strReplace$default + ']';
        }
        return "[size=" + getData$okio().length + " text=" + strReplace$default + "…]";
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        byte[] bArrInternalArray$okio = internalArray$okio();
        Intrinsics.checkNotNullParameter(bArrInternalArray$okio, "<this>");
        String str = new String(bArrInternalArray$okio, Charsets.UTF_8);
        setUtf8$okio(str);
        return str;
    }

    public void write(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        out.write(this.data);
    }

    public void write$okio(f buffer, int i8, int i9) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.L(getData$okio(), i8, i9);
    }

    public static /* synthetic */ int indexOf$default(j jVar, byte[] bArr, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return jVar.indexOf(bArr, i8);
    }

    public static /* synthetic */ int lastIndexOf$default(j jVar, byte[] bArr, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i9 & 2) != 0) {
            i8 = -1234567890;
        }
        return jVar.lastIndexOf(bArr, i8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(qj.j r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = r5
            goto L34
        L2c:
            r3 = r6
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: qj.j.compareTo(qj.j):int");
    }

    public final boolean endsWith(byte[] suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    @JvmOverloads
    public final int indexOf(byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int i8, byte[] other, int i9, int i10) {
        Intrinsics.checkNotNullParameter(other, "other");
        return i8 >= 0 && i8 <= getData$okio().length - i10 && i9 >= 0 && i9 <= other.length - i10 && qc.a(getData$okio(), i8, other, i9, i10);
    }

    public final boolean startsWith(byte[] prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    @JvmOverloads
    public final j substring(int i8) {
        return substring$default(this, i8, 0, 2, null);
    }

    @JvmOverloads
    public final int indexOf(j other, int i8) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf(other.internalArray$okio(), i8);
    }

    @JvmOverloads
    public int lastIndexOf(byte[] other, int i8) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (i8 == -1234567890) {
            i8 = size();
        }
        for (int iMin = Math.min(i8, getData$okio().length - other.length); -1 < iMin; iMin--) {
            if (qc.a(getData$okio(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    @JvmOverloads
    public j substring(int i8, int i9) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (i9 == -1234567890) {
            i9 = size();
        }
        if (i8 >= 0) {
            if (i9 > getData$okio().length) {
                throw new IllegalArgumentException(a1.a.r(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
            }
            if (i9 - i8 >= 0) {
                return (i8 == 0 && i9 == getData$okio().length) ? this : new j(ArraysKt.copyOfRange(getData$okio(), i8, i9));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @JvmOverloads
    public int indexOf(byte[] other, int i8) {
        Intrinsics.checkNotNullParameter(other, "other");
        int length = getData$okio().length - other.length;
        int iMax = Math.max(i8, 0);
        if (iMax <= length) {
            while (!qc.a(getData$okio(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    @JvmStatic
    public static final j of(byte... data) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return new j(bArrCopyOf);
    }

    @JvmStatic
    @JvmName(name = "of")
    public static final j of(byte[] bArr, int i8, int i9) {
        Companion.getClass();
        return i.c(bArr, i8, i9);
    }

    @JvmOverloads
    public final int lastIndexOf(j other, int i8) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf(other.internalArray$okio(), i8);
    }
}
