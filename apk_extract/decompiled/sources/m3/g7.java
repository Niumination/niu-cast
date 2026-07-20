package m3;

/* JADX INFO: loaded from: classes.dex */
public enum g7 implements d {
    SOURCE_UNKNOWN(0),
    BITMAP(1),
    BYTEARRAY(2),
    BYTEBUFFER(3),
    FILEPATH(4),
    ANDROID_MEDIA_IMAGE(5);

    private final int zzh;

    g7(int i8) {
        this.zzh = i8;
    }

    @Override // m3.d
    public final int zza() {
        return this.zzh;
    }
}
