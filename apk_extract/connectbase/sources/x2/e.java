package x2;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.List;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e eVar, boolean z10, long j10, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: accept");
            }
            if ((i10 & 4) != 0) {
                str = null;
            }
            eVar.b(z10, j10, str);
        }

        public static /* synthetic */ void b(e eVar, long j10, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            eVar.d(j10, z10);
        }

        public static /* synthetic */ void c(e eVar, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelAll");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            eVar.e(z10);
        }

        public static /* synthetic */ long d(e eVar, List list, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendData");
            }
            if ((i10 & 2) != 0) {
                str = null;
            }
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return eVar.g(list, str, z10);
        }

        public static /* synthetic */ long e(e eVar, c cVar, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendData");
            }
            if ((i10 & 2) != 0) {
                str = null;
            }
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return eVar.p(cVar, str, z10);
        }

        public static /* synthetic */ long f(e eVar, File file, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFile");
            }
            if ((i10 & 2) != 0) {
                str = null;
            }
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return eVar.f(file, str, z10);
        }

        public static /* synthetic */ long g(e eVar, Context context, Uri uri, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFileWithUri");
            }
            if ((i10 & 4) != 0) {
                str = null;
            }
            if ((i10 & 8) != 0) {
                z10 = false;
            }
            return eVar.l(context, uri, str, z10);
        }

        public static /* synthetic */ long h(e eVar, Context context, List list, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFileWithUris");
            }
            if ((i10 & 4) != 0) {
                str = null;
            }
            if ((i10 & 8) != 0) {
                z10 = false;
            }
            return eVar.q(context, list, str, z10);
        }

        public static /* synthetic */ long i(e eVar, List list, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFiles");
            }
            if ((i10 & 2) != 0) {
                str = null;
            }
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            return eVar.i(list, str, z10);
        }
    }

    void b(boolean z10, long j10, @m String str);

    @m
    Object c(@l String str, @l um.d<? super Boolean> dVar);

    void d(long j10, boolean z10);

    void e(boolean z10);

    long f(@l File file, @m String str, boolean z10);

    long g(@l List<? extends c> list, @m String str, boolean z10);

    void h(@l g gVar);

    long i(@l List<? extends File> list, @m String str, boolean z10);

    void j(@l f fVar);

    void k(@l String str);

    long l(@l Context context, @l Uri uri, @m String str, boolean z10);

    void m(long j10);

    boolean n(@l String str);

    void o(@l String str);

    long p(@l c cVar, @m String str, boolean z10);

    long q(@l Context context, @l List<? extends Uri> list, @m String str, boolean z10);

    void release();
}
