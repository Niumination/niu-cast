package c3;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import kn.h0;
import kn.l0;
import lm.o1;
import nm.y;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends x2.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Context f1319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Uri f1320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public String f1321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final InputStream f1323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final ArrayList<jn.a<Long>> f1324g;

    public /* synthetic */ class a extends h0 implements jn.a<Long> {
        public a(Object obj) {
            super(0, obj, o.class, "getFileSizeFromFileDescriptor", "getFileSizeFromFileDescriptor()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Long invoke() {
            return Long.valueOf(((o) this.receiver).n());
        }
    }

    public /* synthetic */ class b extends h0 implements jn.a<Long> {
        public b(Object obj) {
            super(0, obj, o.class, "getFileSizeFromInputStream", "getFileSizeFromInputStream()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Long invoke() {
            return Long.valueOf(((o) this.receiver).o());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@os.l Context context, @os.l Uri uri) throws IllegalAccessException, IOException, InvocationTargetException {
        super(null, 1, null);
        l0.p(context, "context");
        l0.p(uri, "uri");
        this.f1319b = context;
        this.f1320c = uri;
        this.f1321d = "UNKNOWN";
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        this.f1323f = inputStreamOpenInputStream == null ? new ByteArrayInputStream(new byte[0]) : inputStreamOpenInputStream;
        this.f1324g = y.s(new a(this), new b(this));
        if (l0.g(uri.getScheme(), t2.a.f15437d)) {
            o1<String, Long, String> o1VarA = j3.a.f8552a.a(context, uri);
            String strComponent1 = o1VarA.component1();
            Long lComponent2 = o1VarA.component2();
            o1VarA.component3();
            this.f1321d = strComponent1 != null ? strComponent1 : "UNKNOWN";
            this.f1322e = lComponent2 != null ? lComponent2.longValue() : 0L;
        }
        k();
    }

    @Override // x2.a
    @os.l
    public InputStream I() {
        return this.f1323f;
    }

    @Override // x2.a
    public long N1() {
        return this.f1322e;
    }

    @Override // x2.c
    @os.l
    public String c() {
        return this.f1321d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1323f.close();
    }

    public final void k() {
        if (this.f1322e <= 0) {
            Iterator<jn.a<Long>> it = this.f1324g.iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().invoke().longValue();
                if (jLongValue > 0) {
                    this.f1322e = jLongValue;
                    return;
                }
            }
        }
    }

    public final long n() throws IllegalAccessException, IOException, InvocationTargetException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.f1319b.getContentResolver().openFileDescriptor(this.f1320c, "r");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            return 0L;
        }
        try {
            long statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
            dn.c.a(parcelFileDescriptorOpenFileDescriptor, null);
            return statSize;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                dn.c.a(parcelFileDescriptorOpenFileDescriptor, th2);
                throw th3;
            }
        }
    }

    public final long o() {
        return this.f1323f.available();
    }
}
