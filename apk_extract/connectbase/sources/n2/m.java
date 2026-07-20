package n2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    @SerializedName(t2.a.f15437d)
    private Boolean mInputShown;

    public m() {
    }

    public Boolean a() {
        return this.mInputShown;
    }

    public void b(Boolean bool) {
        this.mInputShown = bool;
    }

    public String toString() {
        return "InputShowChangedRequest{inputShown='" + this.mInputShown + "'}";
    }

    public m(Boolean bool) {
        this.mInputShown = bool;
    }
}
