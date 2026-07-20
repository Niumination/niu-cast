package n2;

import com.google.gson.annotations.SerializedName;
import ik.y0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11310a = 1;

    @SerializedName("contents")
    private List<a> mContents;

    @SerializedName("freeSize")
    private long mFreeSize;

    @SerializedName(dc.d.f3692w)
    private String mId;

    @SerializedName("packageName")
    private String mPackageName;

    @SerializedName("savePath")
    private String mSavePath;

    @SerializedName(y0.a.f8215h)
    private int mType;

    public l0() {
        this.mId = "";
        this.mType = 1;
        this.mPackageName = "";
        this.mSavePath = "";
        this.mFreeSize = 0L;
    }

    public List<a> a() {
        return this.mContents;
    }

    public long b() {
        return this.mFreeSize;
    }

    public String c() {
        return this.mId;
    }

    public String d() {
        return this.mPackageName;
    }

    public String e() {
        return this.mSavePath;
    }

    public int f() {
        return this.mType;
    }

    public void g(List<a> list) {
        this.mContents = list;
    }

    public void h(long j10) {
        this.mFreeSize = j10;
    }

    public void i(String str) {
        this.mId = str;
    }

    public void j(String str) {
        this.mPackageName = str;
    }

    public void k(String str) {
        this.mSavePath = str;
    }

    public void l(int i10) {
        this.mType = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TransferFileRequest{id=");
        sb2.append(this.mId);
        sb2.append(", type=");
        sb2.append(this.mType);
        sb2.append(", packageName='");
        sb2.append(this.mPackageName);
        sb2.append("', savePath='");
        sb2.append(this.mSavePath);
        sb2.append("', contents=");
        sb2.append(this.mContents);
        sb2.append(", freeSize=");
        return k0.a(sb2, this.mFreeSize, rs.f.f14860b);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f11311a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f11312b = 1;

        @SerializedName("fileSize")
        private long mFileSize;

        @SerializedName("format")
        private String mFormat;

        @SerializedName(dc.d.f3692w)
        private String mId;

        @SerializedName("name")
        private String mName;

        @SerializedName("thumbnail")
        private String mThumbnail;

        @SerializedName(y0.a.f8215h)
        private int mType;

        @SerializedName("uri")
        private String mUri;

        public a() {
            this.mId = "";
        }

        public long a() {
            return this.mFileSize;
        }

        public String b() {
            return this.mFormat;
        }

        public String c() {
            return this.mId;
        }

        public String d() {
            return this.mName;
        }

        public String e() {
            return this.mThumbnail;
        }

        public int f() {
            return this.mType;
        }

        public String g() {
            return this.mUri;
        }

        public void h(long j10) {
            this.mFileSize = j10;
        }

        public void i(String str) {
            this.mFormat = str;
        }

        public void j(String str) {
            this.mId = str;
        }

        public void k(String str) {
            this.mName = str;
        }

        public void l(String str) {
            this.mThumbnail = str;
        }

        public void m(int i10) {
            this.mType = i10;
        }

        public void n(String str) {
            this.mUri = str;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Resource{id='");
            sb2.append(this.mId);
            sb2.append("', uri='");
            sb2.append(this.mUri);
            sb2.append("', name='");
            sb2.append(this.mName);
            sb2.append("', format='");
            sb2.append(this.mFormat);
            sb2.append("', type=");
            sb2.append(this.mType);
            sb2.append(", fileSize=");
            return k0.a(sb2, this.mFileSize, rs.f.f14860b);
        }

        public a(String str, String str2, String str3, String str4, String str5, int i10, long j10) {
            this.mId = str;
            this.mUri = str2;
            this.mThumbnail = str3;
            this.mName = str4;
            this.mFormat = str5;
            this.mType = i10;
            this.mFileSize = j10;
        }
    }

    public l0(int i10, String str, List<a> list) {
        this.mId = "";
        this.mSavePath = "";
        this.mFreeSize = 0L;
        this.mType = i10;
        this.mContents = list;
        this.mPackageName = str;
    }
}
