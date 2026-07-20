package p2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    @SerializedName("appList")
    private List<a> mAppList;

    public static class a {

        @SerializedName("appName")
        private String mAppName;

        @SerializedName("icon")
        private String mIcon;

        @SerializedName("packageName")
        private String mPackageName;

        public a() {
        }

        public String a() {
            return this.mAppName;
        }

        public String b() {
            return this.mIcon;
        }

        public String c() {
            return this.mPackageName;
        }

        public void d(String str) {
            this.mAppName = str;
        }

        public void e(String str) {
            this.mIcon = str;
        }

        public void f(String str) {
            this.mPackageName = str;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Application{appName='");
            sb2.append(this.mAppName);
            sb2.append("', packageName='");
            sb2.append(this.mPackageName);
            sb2.append("', icon='");
            return j.c.a(sb2, this.mIcon, "'}");
        }

        public a(String str, String str2, String str3) {
            this.mAppName = str;
            this.mPackageName = str2;
            this.mIcon = str3;
        }
    }

    public l() {
    }

    public List<a> a() {
        return this.mAppList;
    }

    public void b(List<a> list) {
        this.mAppList = list;
    }

    public String toString() {
        return "QueryApplicationResponse{appList=" + this.mAppList + rs.f.f14860b;
    }

    public l(List<a> list) {
        this.mAppList = list;
    }
}
