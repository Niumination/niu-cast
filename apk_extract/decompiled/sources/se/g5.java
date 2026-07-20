package se;

import com.welink.protocol.nfbd.NearDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9749d;
    public final String e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NearDevice f9750g;

    public g5(String selectedMac, String fileName, int i8, long j8, String fileType, int i9, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(selectedMac, "selectedMac");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        this.f9746a = selectedMac;
        this.f9747b = fileName;
        this.f9748c = i8;
        this.f9749d = j8;
        this.e = fileType;
        this.f = i9;
        this.f9750g = nearDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g5)) {
            return false;
        }
        g5 g5Var = (g5) obj;
        return Intrinsics.areEqual(this.f9746a, g5Var.f9746a) && Intrinsics.areEqual(this.f9747b, g5Var.f9747b) && this.f9748c == g5Var.f9748c && this.f9749d == g5Var.f9749d && Intrinsics.areEqual(this.e, g5Var.e) && this.f == g5Var.f && Intrinsics.areEqual(this.f9750g, g5Var.f9750g);
    }

    public final int hashCode() {
        int iC = a1.a.c(this.f, a1.a.e(a1.a.f(this.f9749d, a1.a.c(this.f9748c, a1.a.e(this.f9746a.hashCode() * 31, 31, this.f9747b), 31), 31), 31, this.e), 31);
        NearDevice nearDevice = this.f9750g;
        return iC + (nearDevice == null ? 0 : nearDevice.hashCode());
    }

    public final String toString() {
        return "SendFileInfo(selectedMac=" + this.f9746a + ", fileName=" + this.f9747b + ", fileCount=" + this.f9748c + ", fileSize=" + this.f9749d + ", fileType=" + this.e + ", p2pPort=" + this.f + ", nearDevice=" + this.f9750g + ")";
    }
}
