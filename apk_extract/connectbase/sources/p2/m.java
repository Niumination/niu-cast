package p2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    @SerializedName("notificationList")
    private List<a> mNotificationList;

    public static class a {

        @SerializedName(t2.a.f15437d)
        private String mContent;

        @SerializedName("icon")
        private String mIcon;

        @SerializedName(dc.d.f3692w)
        private String mId;

        @SerializedName("largeIcon")
        private String mLargeIcon;

        @SerializedName(RtspHeaders.Values.TIME)
        private String mTime;

        @SerializedName("title")
        private String mTitle;

        public a() {
        }

        public String a() {
            return this.mContent;
        }

        public String b() {
            return this.mIcon;
        }

        public String c() {
            return this.mId;
        }

        public String d() {
            return this.mLargeIcon;
        }

        public String e() {
            return this.mTime;
        }

        public String f() {
            return this.mTitle;
        }

        public void g(String str) {
            this.mContent = str;
        }

        public void h(String str) {
            this.mIcon = str;
        }

        public void i(String str) {
            this.mId = str;
        }

        public void j(String str) {
            this.mLargeIcon = str;
        }

        public void k(String str) {
            this.mTime = str;
        }

        public void l(String str) {
            this.mTitle = str;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Notification{title='");
            sb2.append(this.mTitle);
            sb2.append("', content='");
            sb2.append(this.mContent);
            sb2.append("', icon='");
            sb2.append(this.mIcon);
            sb2.append("', id='");
            sb2.append(this.mId);
            sb2.append("', time='");
            sb2.append(this.mTime);
            sb2.append("', largeIcon='");
            return j.c.a(sb2, this.mLargeIcon, "'}");
        }

        public a(String str, String str2, String str3, String str4, String str5, String str6) {
            this.mTitle = str;
            this.mContent = str2;
            this.mIcon = str3;
            this.mId = str4;
            this.mTime = str5;
            this.mLargeIcon = str6;
        }
    }

    public m() {
    }

    public List<a> a() {
        return this.mNotificationList;
    }

    public void b(List<a> list) {
        this.mNotificationList = list;
    }

    public String toString() {
        return "QueryNotificationResponse{notificationList=" + this.mNotificationList + rs.f.f14860b;
    }

    public m(List<a> list) {
        this.mNotificationList = list;
    }
}
