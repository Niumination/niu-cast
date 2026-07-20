package z4;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    @SerializedName("scene")
    private final int scene;

    @SerializedName("videoPort")
    private final int videoPort;

    public l(int i10, int i11) {
        this.videoPort = i10;
        this.scene = i11;
    }

    public static l d(l lVar, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = lVar.videoPort;
        }
        if ((i12 & 2) != 0) {
            i11 = lVar.scene;
        }
        lVar.getClass();
        return new l(i10, i11);
    }

    public final int a() {
        return this.videoPort;
    }

    public final int b() {
        return this.scene;
    }

    @os.l
    public final l c(int i10, int i11) {
        return new l(i10, i11);
    }

    public final int e() {
        return this.scene;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.videoPort == lVar.videoPort && this.scene == lVar.scene;
    }

    public final int f() {
        return this.videoPort;
    }

    public int hashCode() {
        return Integer.hashCode(this.scene) + (Integer.hashCode(this.videoPort) * 31);
    }

    @os.l
    public String toString() {
        return "SceneChangeParam(videoPort=" + this.videoPort + ", scene=" + this.scene + ")";
    }
}
