package y1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import v1.a0;
import v1.u;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class c extends z<Date> {
    public static final a0 FACTORY = new a();
    private final List<DateFormat> dateFormats;

    public class a implements a0 {
        @Override // v1.a0
        public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (x1.f.isJava9OrLater()) {
            arrayList.add(x1.l.getUSDateTimeFormat(2, 2));
        }
    }

    private Date deserializeToDate(d2.a aVar) throws IOException {
        String strNextString = aVar.nextString();
        synchronized (this.dateFormats) {
            try {
                Iterator<DateFormat> it = this.dateFormats.iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().parse(strNextString);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return z1.a.parse(strNextString, new ParsePosition(0));
                } catch (ParseException e10) {
                    StringBuilder sbA = e.a.a("Failed parsing '", strNextString, "' as Date; at path ");
                    sbA.append(aVar.getPreviousPath());
                    throw new u(sbA.toString(), e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // v1.z
    public Date read(d2.a aVar) throws IOException {
        if (aVar.peek() != d2.c.NULL) {
            return deserializeToDate(aVar);
        }
        aVar.nextNull();
        return null;
    }

    @Override // v1.z
    public void write(d2.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.nullValue();
            return;
        }
        DateFormat dateFormat = this.dateFormats.get(0);
        synchronized (this.dateFormats) {
            str = dateFormat.format(date);
        }
        dVar.value(str);
    }
}
