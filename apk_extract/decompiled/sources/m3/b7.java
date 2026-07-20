package m3;

/* JADX INFO: loaded from: classes.dex */
public enum b7 implements d {
    UNKNOWN_FORMAT(0),
    NV16(1),
    NV21(2),
    YV12(3),
    YUV_420_888(7),
    JPEG(8),
    BITMAP(4),
    CM_SAMPLE_BUFFER_REF(5),
    UI_IMAGE(6),
    CV_PIXEL_BUFFER_REF(9);

    private final int zzl;

    b7(int i8) {
        this.zzl = i8;
    }

    @Override // m3.d
    public final int zza() {
        return this.zzl;
    }
}
