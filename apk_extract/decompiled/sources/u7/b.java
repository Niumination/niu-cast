package u7;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lu7/b;", "", "", "ip", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "name", "b", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class b {

    @SerializedName("ip")
    private final String ip;

    @SerializedName("name")
    private final String name;

    public b() {
        this("", "");
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getIp() {
        return this.ip;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.ip, bVar.ip) && Intrinsics.areEqual(this.name, bVar.name);
    }

    public final int hashCode() {
        return this.name.hashCode() + (this.ip.hashCode() * 31);
    }

    public final String toString() {
        return h0.a.l("NetworkInfo(ip=", this.ip, ", name=", this.name, ")");
    }

    public b(String ip, String name) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(name, "name");
        this.ip = ip;
        this.name = name;
    }
}
