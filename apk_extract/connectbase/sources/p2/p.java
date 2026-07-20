package p2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    @SerializedName("wallpaperName")
    private String mWallpaperName;

    public p(String str) {
        this.mWallpaperName = str;
    }

    public String a() {
        return this.mWallpaperName;
    }

    public void b(String str) {
        this.mWallpaperName = str;
    }
}
