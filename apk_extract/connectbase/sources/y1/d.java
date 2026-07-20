package y1;

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
import v1.a0;
import v1.u;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class d<T extends Date> extends z<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final b<T> dateType;

    public static abstract class b<T extends Date> {
        public static final b<Date> DATE = new a(Date.class);
        private final Class<T> dateClass;

        public class a extends b<Date> {
            public a(Class cls) {
                super(cls);
            }

            @Override // y1.d.b
            public Date deserialize(Date date) {
                return date;
            }
        }

        public b(Class<T> cls) {
            this.dateClass = cls;
        }

        private a0 createFactory(d<T> dVar) {
            return o.newFactory(this.dateClass, dVar);
        }

        public final a0 createAdapterFactory(String str) {
            return createFactory(new d<>(this, str));
        }

        public final a0 createDefaultsAdapterFactory() {
            int i10 = 2;
            return createFactory(new d<>(this, i10, i10));
        }

        public abstract T deserialize(Date date);

        public final a0 createAdapterFactory(int i10) {
            return createFactory(new d<>(this, i10));
        }

        public final a0 createAdapterFactory(int i10, int i11) {
            return createFactory(new d<>(this, i10, i11));
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

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // v1.z
    public T read(d2.a aVar) throws IOException {
        if (aVar.peek() == d2.c.NULL) {
            aVar.nextNull();
            return null;
        }
        return (T) this.dateType.deserialize(deserializeToDate(aVar));
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

    private d(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(bVar);
        this.dateType = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private d(b<T> bVar, int i10) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(bVar);
        this.dateType = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i10, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i10));
        }
        if (x1.f.isJava9OrLater()) {
            arrayList.add(x1.l.getUSDateFormat(i10));
        }
    }

    private d(b<T> bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(bVar);
        this.dateType = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (x1.f.isJava9OrLater()) {
            arrayList.add(x1.l.getUSDateTimeFormat(i10, i11));
        }
    }
}
