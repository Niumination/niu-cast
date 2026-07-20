package ik;

/* JADX INFO: loaded from: classes2.dex */
public enum z1 {
    DEFAULT(true, true),
    KEY_ONLY(true, false),
    VALUE_ONLY(false, true),
    NO_ENCODING(false, false);

    private final boolean encodeKey;
    private final boolean encodeValue;

    z1(boolean z10, boolean z11) {
        this.encodeKey = z10;
        this.encodeValue = z11;
    }

    public final boolean getEncodeKey$ktor_http() {
        return this.encodeKey;
    }

    public final boolean getEncodeValue$ktor_http() {
        return this.encodeValue;
    }
}
