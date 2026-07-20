package w3;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class r extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f17945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s3.c f17946e;

    public r(long j10, File file, s3.c cVar) {
        this.f17944c = j10;
        this.f17945d = file;
        this.f17946e = cVar;
    }

    @Override // w3.c
    public void a() {
        String strA;
        int length;
        File file = this.f17945d;
        if (file != null && file.exists() && this.f17945d.isFile() && this.f17945d.getName().contains("upload")) {
            File file2 = this.f17945d;
            try {
                strA = !file2.exists() ? "" : new q3.a(file2.getPath()).a();
            } catch (Exception unused) {
            }
            length = strA.split("\n").length;
        } else {
            strA = null;
            length = 0;
        }
        if (TextUtils.isEmpty(strA) || length <= 0) {
            return;
        }
        if (d.b(this.f17944c, strA.getBytes(), length, this.f17946e).f17928a != 0) {
            y3.b.d("PostEventFileTask requestByPost error");
        } else if (this.f17945d != null) {
            y3.b.g("PostEventFileTask lines : %d, deleteFile : %s", Long.valueOf(this.f17944c), Integer.valueOf(length), Boolean.valueOf(y3.e.m(k6.g.h0(), this.f17945d)));
        }
    }

    @Override // w3.c
    public String c() {
        return "Upload-File";
    }
}
