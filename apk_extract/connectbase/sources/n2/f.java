package n2;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    @SerializedName("controlPort")
    private int mControlPort;

    @SerializedName(n4.a.F)
    private int mFilePort;

    @SerializedName(RtspHeaders.Values.PORT)
    private int mPort;

    @SerializedName("supportVersions")
    private List<Integer> mVersion;

    public f() {
    }

    public int a() {
        return this.mControlPort;
    }

    public int b() {
        return this.mFilePort;
    }

    public int c() {
        return this.mPort;
    }

    public List<Integer> d() {
        return this.mVersion;
    }

    public void e(int i10) {
        this.mControlPort = i10;
    }

    public void f(int i10) {
        this.mFilePort = i10;
    }

    public void g(int i10) {
        this.mPort = i10;
    }

    public void h(List<Integer> list) {
        this.mVersion = list;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ConnectFileServerRequest{port=");
        sb2.append(this.mPort);
        sb2.append(", filePort=");
        sb2.append(this.mFilePort);
        sb2.append(", controlPort=");
        return u.a.a(sb2, this.mControlPort, rs.f.f14860b);
    }

    public f(int i10, int i11, int i12, List<Integer> list) {
        this.mPort = i10;
        this.mFilePort = i11;
        this.mControlPort = i12;
        this.mVersion = list;
    }
}
