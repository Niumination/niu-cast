package ch;

import java.util.Calendar;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f1686a = TimeZone.getTimeZone("GMT");

    public static final d a(Calendar calendar, Long l4) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        if (l4 != null) {
            calendar.setTimeInMillis(l4.longValue());
        }
        int i8 = calendar.get(16) + calendar.get(15);
        int i9 = calendar.get(13);
        int i10 = calendar.get(12);
        int i11 = calendar.get(11);
        int i12 = (calendar.get(7) + 5) % 7;
        h.Companion.getClass();
        h hVar = h.getEntries().get(i12);
        int i13 = calendar.get(5);
        int i14 = calendar.get(6);
        e eVar = f.Companion;
        int i15 = calendar.get(2);
        eVar.getClass();
        return new d(i9, i10, i11, hVar, i13, i14, f.getEntries().get(i15), calendar.get(1), calendar.getTimeInMillis() + ((long) i8));
    }
}
