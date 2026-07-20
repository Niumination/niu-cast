package jg;

import com.transsion.core.utils.EncoderUtil;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum b {
    NONE((byte) 0, "", ""),
    MD5((byte) 1, EncoderUtil.ALGORITHM_MD5, "HmacMD5"),
    SHA1((byte) 2, EncoderUtil.ALGORITHM_SHA_1, "HmacSHA1"),
    SHA224((byte) 3, "SHA-224", "HmacSHA224"),
    SHA256((byte) 4, EncoderUtil.ALGORITHM_SHA_256, "HmacSHA256"),
    SHA384((byte) 5, EncoderUtil.ALGORITHM__SHA_384, "HmacSHA384"),
    SHA512((byte) 6, EncoderUtil.ALGORITHM_SHA_512, "HmacSHA512"),
    INTRINSIC((byte) 8, "INTRINSIC", "Intrinsic");

    private final byte code;
    private final String macName;
    private final String openSSLName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final a Companion = new a();

    b(byte b9, String str, String str2) {
        this.code = b9;
        this.openSSLName = str;
        this.macName = str2;
    }

    public static EnumEntries<b> getEntries() {
        return $ENTRIES;
    }

    public final byte getCode() {
        return this.code;
    }

    public final String getMacName() {
        return this.macName;
    }

    public final String getOpenSSLName() {
        return this.openSSLName;
    }
}
