package q7;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import com.transsion.message.bank.MessageBank;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lq7/d;", "", "", "pid", "Ljava/lang/String;", "b", "()Ljava/lang/String;", MessageBank.KEY_TYPE, "c", "name", "a", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class d {

    @SerializedName("name")
    private final String name;

    @SerializedName("pid")
    private final String pid;

    @SerializedName(MessageBank.KEY_TYPE)
    private final String type;

    public d() {
        this("", "", "");
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getPid() {
        return this.pid;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.pid, dVar.pid) && Intrinsics.areEqual(this.type, dVar.type) && Intrinsics.areEqual(this.name, dVar.name);
    }

    public final int hashCode() {
        return this.name.hashCode() + a1.a.e(this.pid.hashCode() * 31, 31, this.type);
    }

    public final String toString() {
        return this.pid + "," + this.type + "," + this.name;
    }

    public d(String pid, String type, String name) {
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        this.pid = pid;
        this.type = type;
        this.name = name;
    }
}
