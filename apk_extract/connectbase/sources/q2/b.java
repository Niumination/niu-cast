package q2;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.r1;
import nm.y;
import nm.z;
import os.l;
import os.m;
import r2.n;
import r2.p;
import r2.r;
import um.d;
import x2.e;
import x2.f;
import x2.g;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileTransferManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTransferManager.kt\ncom/transsion/airtransfer/filetransfer/FileTransferManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1549#2:154\n1620#2,3:155\n1549#2:158\n1620#2,3:159\n*S KotlinDebug\n*F\n+ 1 FileTransferManager.kt\ncom/transsion/airtransfer/filetransfer/FileTransferManager\n*L\n80#1:154\n80#1:155,3\n93#1:158\n93#1:159,3\n*E\n"})
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final b f13800a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f13801b = "FileTransferManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Application f13802c;

    public static /* synthetic */ void s(b bVar, Application application, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "FileTransfer-";
        }
        if ((i11 & 4) != 0) {
            i10 = 3;
        }
        bVar.r(application, str, i10);
    }

    @l
    public final Application a() {
        Application application = f13802c;
        if (application != null) {
            return application;
        }
        l0.S("context");
        return null;
    }

    @Override // x2.e
    public void b(boolean z10, long j10, @m String str) {
        c3.m.f1313a.b(z10, j10, str);
    }

    @Override // x2.e
    @m
    public Object c(@l String str, @l d<? super Boolean> dVar) {
        b bVar = f13800a;
        synchronized (bVar) {
            if (bVar.n(str)) {
                return Boolean.TRUE;
            }
            u2.b.f16175b.f();
            e3.a.f4044a.c(str);
            a3.a.f42a.b();
            c cVar = c.f13803b;
            cVar.p(str);
            return cVar.f(dVar);
        }
    }

    @Override // x2.e
    public void d(long j10, boolean z10) {
        c3.m.f1313a.i(j10);
    }

    @Override // x2.e
    public void e(boolean z10) {
        c3.m.f1313a.a();
    }

    @Override // x2.e
    public long f(@l File file, @m String str, boolean z10) {
        l0.p(file, "file");
        return p(new c3.d(file), str, z10);
    }

    @Override // x2.e
    public long g(@l List<? extends x2.c> list, @m String str, boolean z10) {
        l0.p(list, "data");
        return c3.m.f1313a.c(list, str);
    }

    @Override // x2.e
    public void h(@l g gVar) {
        l0.p(gVar, "listener");
        c.f13803b.m(gVar);
    }

    @Override // x2.e
    public long i(@l List<? extends File> list, @m String str, boolean z10) {
        l0.p(list, "files");
        List<? extends File> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new c3.d((File) it.next()));
        }
        return g(arrayList, str, z10);
    }

    @Override // x2.e
    public void j(@l f fVar) {
        l0.p(fVar, "listener");
        c.f13803b.l(fVar);
    }

    @Override // x2.e
    public void k(@l String str) {
        l0.p(str, "data");
        j3.b.f8554a.e("FileTransferManager", "handshake: " + str);
        p.b(u2.b.f16175b, new n(str), null, 2, null);
    }

    @Override // x2.e
    public long l(@l Context context, @l Uri uri, @m String str, boolean z10) {
        l0.p(context, "context");
        l0.p(uri, "uri");
        try {
            return p(c3.e.f1276a.a(context, uri), str, z10);
        } catch (Exception e10) {
            j3.b.f8554a.d("FileTransferManager", e10);
            return -1L;
        }
    }

    @Override // x2.e
    public void m(long j10) {
        p.b(u2.b.f16175b, new r(j10), null, 2, null);
    }

    @Override // x2.e
    public boolean n(@l String str) {
        l0.p(str, RtspHeaders.Values.URL);
        return c.f13803b.j(str);
    }

    @Override // x2.e
    public void o(@l String str) {
        l0.p(str, "path");
        a.f13797a.c(str);
    }

    @Override // x2.e
    public long p(@l x2.c cVar, @m String str, boolean z10) {
        l0.p(cVar, "data");
        return g(y.s(cVar), str, z10);
    }

    @Override // x2.e
    public long q(@l Context context, @l List<? extends Uri> list, @m String str, boolean z10) {
        l0.p(context, "context");
        l0.p(list, "uris");
        try {
            List<? extends Uri> list2 = list;
            ArrayList arrayList = new ArrayList(z.b0(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(c3.e.f1276a.a(context, (Uri) it.next()));
            }
            return g(arrayList, str, z10);
        } catch (Exception e10) {
            j3.b.f8554a.d("FileTransferManager", e10);
            return -1L;
        }
    }

    public final void r(@l Application application, @l String str, int i10) {
        l0.p(application, "context");
        l0.p(str, "logTag");
        t(application);
        j3.b.f8554a.f(str, i10);
        v2.a.f16499a.a();
    }

    @Override // x2.e
    public void release() {
        j3.b.f8554a.e("FileTransferManager", "release");
        e3.a.f4044a.d();
        a3.a.f42a.c();
        u2.b.f16175b.f();
        c.f13803b.k();
        c3.m.f1313a.clear();
    }

    public final void t(@l Application application) {
        l0.p(application, "<set-?>");
        f13802c = application;
    }
}
