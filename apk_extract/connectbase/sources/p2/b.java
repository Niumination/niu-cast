package p2;

import com.google.gson.annotations.SerializedName;
import n2.l0;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12761a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12762b = 2;

    @SerializedName("taskInfo")
    private l0 mInfo;

    @SerializedName("responseCode")
    private int mResponseCode;

    public l0 a() {
        return this.mInfo;
    }

    public int b() {
        return this.mResponseCode;
    }

    public void c(l0 l0Var) {
        this.mInfo = l0Var;
    }

    public void d(int i10) {
        this.mResponseCode = i10;
    }

    public String toString() {
        return "ConfirmFileTaskResponse{responseCode=" + this.mResponseCode + ", info=" + this.mInfo + rs.f.f14860b;
    }
}
