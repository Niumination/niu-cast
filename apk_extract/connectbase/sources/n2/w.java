package n2;

import androidx.constraintlayout.motion.widget.Key;
import com.google.gson.annotations.SerializedName;
import ik.y0;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11321a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11322b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11323c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11324d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11325e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11326f = 2;

    @SerializedName("funcType")
    private String mFuncType;

    @SerializedName(cb.b.c.f1411r)
    private b mPayload;

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    @SerializedName("protocol")
    private int mProtocol;

    @SerializedName("transmit")
    private int mTransmit;

    @SerializedName(y0.a.f8215h)
    private int mType;

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f11327a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f11328b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11329c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11330d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f11331e = 2;

        @SerializedName("audioBits")
        private int mAudioBits;

        @SerializedName("channelConfig")
        private int mChannelConfig;

        @SerializedName("encodeType")
        private int mEncodeType;

        @SerializedName("sampleRate")
        private int mSampleRate;

        public a() {
        }

        public int a() {
            return this.mAudioBits;
        }

        public int b() {
            return this.mChannelConfig;
        }

        public int c() {
            return this.mEncodeType;
        }

        public int d() {
            return this.mSampleRate;
        }

        public void e(int i10) {
            this.mAudioBits = i10;
        }

        public void f(int i10) {
            this.mChannelConfig = i10;
        }

        public void g(int i10) {
            this.mEncodeType = i10;
        }

        public void h(int i10) {
            this.mSampleRate = i10;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("AudioPayload{encodeType=");
            sb2.append(this.mEncodeType);
            sb2.append(", sampleRate=");
            sb2.append(this.mSampleRate);
            sb2.append(", channelConfig=");
            sb2.append(this.mChannelConfig);
            sb2.append(", audioBits=");
            return u.a.a(sb2, this.mAudioBits, rs.f.f14860b);
        }

        public a(int i10, int i11, int i12, int i13) {
            this.mEncodeType = i10;
            this.mSampleRate = i11;
            this.mChannelConfig = i12;
            this.mAudioBits = i13;
        }
    }

    public static class b {
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f11332a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f11333b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11334c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11335d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f11336e = 3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f11337f = 4;

        @SerializedName("currentNavMode")
        private int mCurrentNavMode;

        @SerializedName("dpi")
        private int mDpi;

        @SerializedName("encodeType")
        private int mEncodeType;

        @SerializedName("extra")
        private String mExtra;

        @SerializedName("frameRate")
        private int mFrameRate;

        @SerializedName("height")
        private int mHeight;

        @SerializedName("iFrameInterval")
        private float mIFrameInterval;

        @SerializedName(Key.ROTATION)
        private int mRotation;

        @SerializedName(y0.a.f8215h)
        private int mType;

        @SerializedName("wallpaperId")
        private String mWallpaperId;

        @SerializedName("width")
        private int mWidth;

        public c() {
        }

        public int a() {
            return this.mCurrentNavMode;
        }

        public int b() {
            return this.mDpi;
        }

        public int c() {
            return this.mEncodeType;
        }

        public String d() {
            return this.mExtra;
        }

        public int e() {
            return this.mFrameRate;
        }

        public int f() {
            return this.mHeight;
        }

        public float g() {
            return this.mIFrameInterval;
        }

        public int h() {
            return this.mRotation;
        }

        public int i() {
            return this.mType;
        }

        public int j() {
            return this.mWidth;
        }

        public void k(int i10) {
            this.mDpi = i10;
        }

        public void l(int i10) {
            this.mEncodeType = i10;
        }

        public void m(String str) {
            this.mExtra = str;
        }

        public void n(int i10) {
            this.mFrameRate = i10;
        }

        public void o(int i10) {
            this.mCurrentNavMode = i10;
        }

        public void p(int i10) {
            this.mHeight = i10;
        }

        public void q(float f10) {
            this.mIFrameInterval = f10;
        }

        public void r(int i10) {
            this.mRotation = i10;
        }

        public void s(int i10) {
            this.mType = i10;
        }

        public void t(int i10) {
            this.mWidth = i10;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("VideoPayload{encodeType=");
            sb2.append(this.mEncodeType);
            sb2.append(", width=");
            sb2.append(this.mWidth);
            sb2.append(", height=");
            sb2.append(this.mHeight);
            sb2.append(", dpi=");
            sb2.append(this.mDpi);
            sb2.append(", iFrameInterval=");
            sb2.append(this.mIFrameInterval);
            sb2.append(", frameRate=");
            sb2.append(this.mFrameRate);
            sb2.append(", extra='");
            sb2.append(this.mExtra);
            sb2.append("', wallpaperId='");
            sb2.append(this.mWallpaperId);
            sb2.append("', type=");
            sb2.append(this.mType);
            sb2.append(", rotation=");
            sb2.append(this.mRotation);
            sb2.append(", currentNavMode=");
            return u.a.a(sb2, this.mCurrentNavMode, rs.f.f14860b);
        }

        public c(int i10, int i11, int i12, int i13, float f10, int i14, int i15, String str, int i16, int i17, String str2) {
            this.mEncodeType = i10;
            this.mWidth = i11;
            this.mHeight = i12;
            this.mDpi = i13;
            this.mIFrameInterval = f10;
            this.mFrameRate = i14;
            this.mExtra = str;
            this.mType = i15;
            this.mRotation = i16;
            this.mCurrentNavMode = i17;
            this.mWallpaperId = str2;
        }
    }

    public w() {
    }

    public String a() {
        return this.mFuncType;
    }

    public int b() {
        return this.mPort;
    }

    public int c() {
        return this.mProtocol;
    }

    public int d() {
        return this.mTransmit;
    }

    public int e() {
        return this.mType;
    }

    public b f() {
        return this.mPayload;
    }

    public void g(String str) {
        this.mFuncType = str;
    }

    public void h(int i10) {
        this.mPort = i10;
    }

    public void i(int i10) {
        this.mProtocol = i10;
    }

    public void j(int i10) {
        this.mTransmit = i10;
    }

    public void k(int i10) {
        this.mType = i10;
    }

    public void l(b bVar) {
        this.mPayload = bVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PlayRequest{type=");
        sb2.append(this.mType);
        sb2.append(", transmit=");
        sb2.append(this.mTransmit);
        sb2.append(", protocol=");
        sb2.append(this.mProtocol);
        sb2.append(", port=");
        sb2.append(this.mPort);
        sb2.append(", payload=");
        sb2.append(this.mPayload);
        sb2.append(", funcType=");
        return l.a.a(sb2, this.mFuncType, rs.f.f14860b);
    }

    public w(int i10, int i11, int i12, int i13, b bVar) {
        this.mType = i10;
        this.mTransmit = i11;
        this.mProtocol = i12;
        this.mPort = i13;
        this.mPayload = bVar;
    }
}
