package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    @SerializedName("totalSize")
    private long mTotalStorage;

    @SerializedName("usedSize")
    private long mUsedStorage;

    public i0(long j10, long j11) {
        this.mUsedStorage = j10;
        this.mTotalStorage = j11;
    }

    public long a() {
        return this.mTotalStorage;
    }

    public long b() {
        return this.mUsedStorage;
    }

    public void c(long j10) {
        this.mTotalStorage = j10;
    }

    public void d(long j10) {
        this.mUsedStorage = j10;
    }
}
