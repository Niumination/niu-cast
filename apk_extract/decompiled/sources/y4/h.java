package y4;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends v4.p0 {
    public static final v4.q0 DEFAULT_STYLE_FACTORY = new e();
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final g dateType;

    public /* synthetic */ h(g gVar, int i8, int i9, int i10) {
        this(gVar, i8, i9);
    }

    private Date deserializeToDate(d5.b bVar) throws IOException {
        String strNextString = bVar.nextString();
        synchronized (this.dateFormats) {
            try {
                Iterator<DateFormat> it = this.dateFormats.iterator();
                while (it.hasNext()) {
                    DateFormat next = it.next();
                    TimeZone timeZone = next.getTimeZone();
                    try {
                        try {
                            Date date = next.parse(strNextString);
                            next.setTimeZone(timeZone);
                            return date;
                        } catch (Throwable th2) {
                            next.setTimeZone(timeZone);
                            throw th2;
                        }
                    } catch (ParseException unused) {
                        next.setTimeZone(timeZone);
                    }
                }
                try {
                    return z4.a.parse(strNextString, new ParsePosition(0));
                } catch (ParseException e) {
                    StringBuilder sbY = a1.a.y("Failed parsing '", strNextString, "' as Date; at path ");
                    sbY.append(bVar.getPreviousPath());
                    throw new v4.a0(sbY.toString(), e);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public /* synthetic */ h(g gVar, String str, int i8) {
        this(gVar, str);
    }

    @Override // v4.p0
    public Date read(d5.b bVar) throws IOException {
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        return this.dateType.deserialize(deserializeToDate(bVar));
    }

    @Override // v4.p0
    public void write(d5.d dVar, Date date) throws IOException {
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

    private h(g gVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(gVar);
        this.dateType = gVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private h(g gVar, int i8, int i9) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(gVar);
        this.dateType = gVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i8, i9, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i8, i9));
        }
        if (x4.j.isJava9OrLater()) {
            arrayList.add(x4.u.getUsDateTimeFormat(i8, i9));
        }
    }
}
