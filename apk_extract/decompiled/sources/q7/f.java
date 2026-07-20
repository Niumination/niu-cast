package q7;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lq7/f;", "", "", "isRemoteClose", "Z", "()Z", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class f {

    @SerializedName("isRemoteClose")
    private final boolean isRemoteClose;

    public f() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.isRemoteClose == ((f) obj).isRemoteClose;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.isRemoteClose);
    }

    public final String toString() {
        return "DisconnectInfoBean(isRemoteClose=" + this.isRemoteClose + ")";
    }

    public f(int i8) {
        this.isRemoteClose = true;
    }
}
