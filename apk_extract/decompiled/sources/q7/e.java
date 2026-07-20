package q7;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lq7/e;", "", "", "port", "I", "a", "()I", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class e {

    @SerializedName("port")
    private final int port;

    public e(int i8) {
        this.port = i8;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.port == ((e) obj).port;
    }

    public final int hashCode() {
        return Integer.hashCode(this.port);
    }

    public final String toString() {
        return h0.a.h(this.port, "ConnectResponseBean(port=", ")");
    }
}
