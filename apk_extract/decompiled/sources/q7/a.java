package q7;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lq7/a;", "", "", "protocolVersion", "I", "getProtocolVersion", "()I", "abilityVersion", "getAbilityVersion", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class a {

    @SerializedName("abilityVersion")
    private final int abilityVersion;

    @SerializedName("protocolVersion")
    private final int protocolVersion = 0;

    public a(int i8) {
        this.abilityVersion = i8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.protocolVersion == aVar.protocolVersion && this.abilityVersion == aVar.abilityVersion;
    }

    public final int hashCode() {
        return Integer.hashCode(this.abilityVersion) + (Integer.hashCode(this.protocolVersion) * 31);
    }

    public final String toString() {
        return o.d.g(this.protocolVersion, this.abilityVersion, "CapabilityInitBean(protocolVersion=", ", abilityVersion=", ")");
    }
}
