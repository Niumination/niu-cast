package p2;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Serializable {
    public static final int ORIENTATION_LANDSCAPE = 0;
    public static final int ORIENTATION_LANDSCAPE_FLIPPED = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    public static final int ORIENTATION_PORTRAIT_FLIPPED = 3;

    @SerializedName("height")
    private int height;

    @SerializedName("isExtendMode")
    private boolean isExtendMode;

    @SerializedName("orientation")
    private int orientation;

    @SerializedName("width")
    private int width;

    public g(int i10, boolean z10, int i11, int i12) {
        this.orientation = i10;
        this.isExtendMode = z10;
        this.width = i11;
        this.height = i12;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getIsExtendMode() {
        return this.isExtendMode;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setIsExtendMode(boolean z10) {
        this.isExtendMode = z10;
    }

    public void setOrientation(int i10) {
        this.orientation = i10;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("ExtendScreenDisplayInfoResponse{orientation=");
        sb2.append(this.orientation);
        sb2.append(", isExtendMode=");
        sb2.append(this.isExtendMode);
        sb2.append(", width=");
        sb2.append(this.width);
        sb2.append(", height=");
        return u.a.a(sb2, this.height, rs.f.f14860b);
    }

    public g(int i10, boolean z10) {
        this.orientation = i10;
        this.isExtendMode = z10;
    }

    public g() {
    }
}
