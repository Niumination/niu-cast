package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    @SerializedName("path")
    private String mPath;

    @SerializedName("thumbnail")
    private String mThumbnail;

    public n() {
    }

    public String a() {
        return this.mPath;
    }

    public String b() {
        return this.mThumbnail;
    }

    public void c(String str) {
        this.mPath = str;
    }

    public void d(String str) {
        this.mThumbnail = str;
    }

    public n(String str, String str2) {
        this.mPath = str;
        this.mThumbnail = str2;
    }
}
