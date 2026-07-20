package h5;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    @SerializedName("activityList")
    private List<String> mActivityList;

    @SerializedName("packageName")
    private String mPackageName;

    public g(String str, List<String> list) {
        this.mPackageName = str;
        this.mActivityList = list;
    }

    public List<String> a() {
        return this.mActivityList;
    }

    public String b() {
        return this.mPackageName;
    }

    public void c(List<String> list) {
        this.mActivityList = list;
    }

    public void d(String str) {
        this.mPackageName = str;
    }

    public String toString() {
        return "SecurePage{packageName='" + this.mPackageName + "', activityList=" + this.mActivityList + rs.f.f14860b;
    }
}
