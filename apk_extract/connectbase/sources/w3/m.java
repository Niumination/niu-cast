package w3;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f17931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Integer> f17933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f17934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f17935f;

    public m(String str, byte[] bArr, int i10, List<Integer> list, String str2, String str3) {
        this.f17930a = str;
        this.f17931b = bArr;
        this.f17932c = i10;
        this.f17933d = list;
        this.f17934e = str2;
        this.f17935f = str3;
    }

    public static m a(String str, byte[] bArr, int i10, List<Integer> list, String str2, String str3) {
        return new m(str, bArr, i10, list, str2, str3);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("UploadEventsRequest{host='");
        sb2.append(this.f17930a);
        sb2.append("', data=");
        sb2.append(Arrays.toString(this.f17931b));
        sb2.append(", lineNumber=");
        sb2.append(this.f17932c);
        sb2.append(", appidList=");
        sb2.append(this.f17933d);
        sb2.append(", packetUid='");
        sb2.append(this.f17934e);
        sb2.append("', dupid='");
        return j.c.a(sb2, this.f17935f, "'}");
    }
}
