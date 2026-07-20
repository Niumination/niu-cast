package y4;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 extends v4.p0 {
    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        bVar.beginObject();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (bVar.peek() != d5.c.END_OBJECT) {
            String strNextName = bVar.nextName();
            int iNextInt = bVar.nextInt();
            strNextName.getClass();
            switch (strNextName) {
                case "dayOfMonth":
                    i10 = iNextInt;
                    break;
                case "minute":
                    i12 = iNextInt;
                    break;
                case "second":
                    i13 = iNextInt;
                    break;
                case "year":
                    i8 = iNextInt;
                    break;
                case "month":
                    i9 = iNextInt;
                    break;
                case "hourOfDay":
                    i11 = iNextInt;
                    break;
            }
        }
        bVar.endObject();
        return new GregorianCalendar(i8, i9, i10, i11, i12, i13);
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (calendar == null) {
            dVar.nullValue();
            return;
        }
        dVar.beginObject();
        dVar.name("year");
        dVar.value(calendar.get(1));
        dVar.name("month");
        dVar.value(calendar.get(2));
        dVar.name("dayOfMonth");
        dVar.value(calendar.get(5));
        dVar.name("hourOfDay");
        dVar.value(calendar.get(11));
        dVar.name("minute");
        dVar.value(calendar.get(12));
        dVar.name("second");
        dVar.value(calendar.get(13));
        dVar.endObject();
    }
}
