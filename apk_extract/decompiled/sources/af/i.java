package af;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.io.EOFException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements j2.f, q3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f315b;

    public i(long j8, d2.d dVar) {
        this.f314a = j8;
        this.f315b = dVar;
    }

    public dj.s a() throws EOFException {
        dj.r rVar = new dj.r(0);
        while (true) {
            String line = ((qj.t) this.f315b).l(this.f314a);
            this.f314a -= (long) line.length();
            if (line.length() == 0) {
                return rVar.c();
            }
            Intrinsics.checkNotNullParameter(line, "line");
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) line, ':', 1, false, 4, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = line.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                rVar.b(strSubstring, strSubstring2);
            } else if (line.charAt(0) == ':') {
                String strSubstring3 = line.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                rVar.b("", strSubstring3);
            } else {
                rVar.b("", line);
            }
        }
    }

    @Override // j2.f
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        a2.b bVar = j2.h.e;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f314a));
        d2.d dVar = (d2.d) this.f315b;
        a2.c cVar = dVar.f4271c;
        String strValueOf = String.valueOf(m2.a.a(cVar));
        String str = dVar.f4269a;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, strValueOf}) < 1) {
            contentValues.put("backend_name", str);
            contentValues.put("priority", Integer.valueOf(m2.a.a(cVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    @Override // q3.c
    public void b(Exception exc) {
        ((AtomicLong) ((u6.c) this.f315b).f10387b).set(this.f314a);
    }

    public /* synthetic */ i(Object obj, long j8) {
        this.f315b = obj;
        this.f314a = j8;
    }

    public i(qj.t source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f315b = source;
        this.f314a = 262144;
    }
}
