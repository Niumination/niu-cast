package y6;

import java.util.Arrays;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f11100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkedList f11102d;
    public String e;
    public String f;

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("UploadEventsRequest{host='");
        sb2.append(this.f11099a);
        sb2.append("', data=");
        sb2.append(Arrays.toString(this.f11100b));
        sb2.append(", lineNumber=");
        sb2.append(this.f11101c);
        sb2.append(", appidList=");
        sb2.append(this.f11102d);
        sb2.append(", packetUid='");
        sb2.append(this.e);
        sb2.append("', dupid='");
        return h0.a.n(sb2, this.f, "'}");
    }
}
