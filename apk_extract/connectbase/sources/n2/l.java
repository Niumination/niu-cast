package n2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11305a = "android";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11306b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11307c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11308d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11309e = 1;

    @SerializedName("be_control")
    private int mBeControl;

    @SerializedName("colorFormats")
    private List<String> mColorFormats;

    @SerializedName("control")
    private int mControl;

    @SerializedName("height")
    private int mHeight;

    @SerializedName("iFrameInterval")
    private float mIFrameInterval;

    @SerializedName("maxBitRate")
    private long mMaxBitRate;

    @SerializedName("maxFps")
    private int mMaxFps;

    @SerializedName("height_max")
    private int mMaxHeight;

    @SerializedName("width_max")
    private int mMaxWidth;

    @SerializedName("platform")
    private String mPlatform;

    @SerializedName("audio_formats")
    private List<String> mSupportAudioFormats;

    @SerializedName("video_formats")
    private List<String> mSupportVideoFormats;

    @SerializedName("width")
    private int mWidth;

    public l() {
    }

    public int a() {
        return this.mBeControl;
    }

    public List<String> b() {
        return this.mColorFormats;
    }

    public int c() {
        return this.mControl;
    }

    public int d() {
        return this.mHeight;
    }

    public long e() {
        return this.mMaxBitRate;
    }

    public int f() {
        return this.mMaxFps;
    }

    public int g() {
        return this.mMaxHeight;
    }

    public int h() {
        return this.mMaxWidth;
    }

    public String i() {
        return this.mPlatform;
    }

    public List<String> j() {
        return this.mSupportAudioFormats;
    }

    public List<String> k() {
        return this.mSupportVideoFormats;
    }

    public int l() {
        return this.mWidth;
    }

    public float m() {
        return this.mIFrameInterval;
    }

    public void n(int i10) {
        this.mBeControl = i10;
    }

    public void o(List<String> list) {
        this.mColorFormats = list;
    }

    public void p(int i10) {
        this.mControl = i10;
    }

    public void q(int i10) {
        this.mHeight = i10;
    }

    public void r(long j10) {
        this.mMaxBitRate = j10;
    }

    public void s(int i10) {
        this.mMaxFps = i10;
    }

    public void t(int i10) {
        this.mMaxHeight = i10;
    }

    public void u(int i10) {
        this.mMaxWidth = i10;
    }

    public void v(String str) {
        this.mPlatform = str;
    }

    public void w(List<String> list) {
        this.mSupportAudioFormats = list;
    }

    public void x(List<String> list) {
        this.mSupportVideoFormats = list;
    }

    public void y(int i10) {
        this.mWidth = i10;
    }

    public void z(float f10) {
        this.mIFrameInterval = f10;
    }

    public l(String str, List<String> list, List<String> list2, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, float f10, List<String> list3) {
        this.mPlatform = str;
        this.mSupportVideoFormats = list;
        this.mSupportAudioFormats = list2;
        this.mHeight = i10;
        this.mWidth = i11;
        this.mMaxHeight = i12;
        this.mMaxWidth = i13;
        this.mControl = i14;
        this.mBeControl = i15;
        this.mMaxBitRate = j10;
        this.mMaxFps = i16;
        this.mIFrameInterval = f10;
        this.mColorFormats = list3;
    }
}
