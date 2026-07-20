package e4;

import com.transsion.backup.model.AlbumFile;
import java.util.List;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final List<AlbumFile> f4064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public final String f4065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4066c;

    public d(@l List<AlbumFile> list, @m String str, int i10) {
        l0.p(list, "files");
        this.f4064a = list;
        this.f4065b = str;
        this.f4066c = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ d e(d dVar, List list, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = dVar.f4064a;
        }
        if ((i11 & 2) != 0) {
            str = dVar.f4065b;
        }
        if ((i11 & 4) != 0) {
            i10 = dVar.f4066c;
        }
        return dVar.d(list, str, i10);
    }

    @l
    public final List<AlbumFile> a() {
        return this.f4064a;
    }

    @m
    public final String b() {
        return this.f4065b;
    }

    public final int c() {
        return this.f4066c;
    }

    @l
    public final d d(@l List<AlbumFile> list, @m String str, int i10) {
        l0.p(list, "files");
        return new d(list, str, i10);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return l0.g(this.f4064a, dVar.f4064a) && l0.g(this.f4065b, dVar.f4065b) && this.f4066c == dVar.f4066c;
    }

    public final int f() {
        return this.f4066c;
    }

    @l
    public final List<AlbumFile> g() {
        return this.f4064a;
    }

    @m
    public final String h() {
        return this.f4065b;
    }

    public int hashCode() {
        int iHashCode = this.f4064a.hashCode() * 31;
        String str = this.f4065b;
        return Integer.hashCode(this.f4066c) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    @l
    public String toString() {
        List<AlbumFile> list = this.f4064a;
        String str = this.f4065b;
        int i10 = this.f4066c;
        StringBuilder sb2 = new StringBuilder("SendFilesTask(files=");
        sb2.append(list);
        sb2.append(", ip=");
        sb2.append(str);
        sb2.append(", backupType=");
        return c.a.a(sb2, i10, ")");
    }

    public /* synthetic */ d(List list, String str, int i10, int i11, w wVar) {
        this(list, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? 0 : i10);
    }
}
