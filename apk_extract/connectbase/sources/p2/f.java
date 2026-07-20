package p2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Serializable {

    @SerializedName("height")
    private int mHeight;

    @SerializedName(dc.d.f3692w)
    private int mId;

    @SerializedName("resolutionLevel")
    private int mResolutionLevel;

    @SerializedName("width")
    private int mWidth;

    public int getHeight() {
        return this.mHeight;
    }

    public int getId() {
        return this.mId;
    }

    public int getResolutionLevel() {
        return this.mResolutionLevel;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setHeight(int i10) {
        this.mHeight = i10;
    }

    public void setId(int i10) {
        this.mId = i10;
    }

    public void setResolutionLevel(int i10) {
        this.mResolutionLevel = i10;
    }

    public void setWidth(int i10) {
        this.mWidth = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ExtendScreenCreatedResponse{id=");
        sb2.append(this.mId);
        sb2.append(", resolutionLevel=");
        sb2.append(this.mResolutionLevel);
        sb2.append(", width=");
        sb2.append(this.mWidth);
        sb2.append(", height=");
        return u.a.a(sb2, this.mHeight, rs.f.f14860b);
    }
}
