package q7;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.EnvironmentCompat;
import com.google.gson.annotations.SerializedName;
import com.transsion.message.bank.MessageBank;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lq7/g;", "", "", "errorCode", "I", "getErrorCode", "()I", "", MessageBank.KEY_MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "capability_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class g {

    @SerializedName("errorCode")
    private final int errorCode;

    @SerializedName(MessageBank.KEY_MESSAGE)
    private final String message;

    public g() {
        this(0, 3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.errorCode == gVar.errorCode && Intrinsics.areEqual(this.message, gVar.message);
    }

    public final int hashCode() {
        return this.message.hashCode() + (Integer.hashCode(this.errorCode) * 31);
    }

    public final String toString() {
        return "ErrorInfoBean(errorCode=" + this.errorCode + ", message=" + this.message + ")";
    }

    public g(int i8, int i9) {
        i8 = (i9 & 1) != 0 ? 0 : i8;
        Intrinsics.checkNotNullParameter(EnvironmentCompat.MEDIA_UNKNOWN, MessageBank.KEY_MESSAGE);
        this.errorCode = i8;
        this.message = EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
