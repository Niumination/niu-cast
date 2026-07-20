package n2;

import com.google.gson.annotations.SerializedName;
import ik.y0;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {

    @SerializedName("config")
    private a mConfig;

    @SerializedName(y0.a.f8215h)
    private String mType;

    public static class a {

        @SerializedName("interval")
        private int mInterval;

        @SerializedName("max_retry")
        private int mMaxRetry;

        public a() {
        }

        public int a() {
            return this.mInterval;
        }

        public int b() {
            return this.mMaxRetry;
        }

        public void c(int i10) {
            this.mInterval = i10;
        }

        public void d(int i10) {
            this.mMaxRetry = i10;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Config{maxRetry=");
            sb2.append(this.mMaxRetry);
            sb2.append(", interval=");
            return u.a.a(sb2, this.mInterval, rs.f.f14860b);
        }

        public a(int i10, int i11) {
            this.mMaxRetry = i10;
            this.mInterval = i11;
        }
    }

    public d0() {
    }

    public a a() {
        return this.mConfig;
    }

    public String b() {
        return this.mType;
    }

    public void c(a aVar) {
        this.mConfig = aVar;
    }

    public void d(String str) {
        this.mType = str;
    }

    public String toString() {
        return "SetupDto{type='" + this.mType + "', config=" + this.mConfig + rs.f.f14860b;
    }

    public d0(String str, a aVar) {
        this.mType = str;
        this.mConfig = aVar;
    }
}
