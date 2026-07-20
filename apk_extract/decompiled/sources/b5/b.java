package b5;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import v4.a0;
import v4.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1205b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f1206a;

    public /* synthetic */ b(int i8) {
        this();
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        Date date;
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        String strNextString = bVar.nextString();
        synchronized (this) {
            TimeZone timeZone = this.f1206a.getTimeZone();
            try {
                try {
                    date = new Date(this.f1206a.parse(strNextString).getTime());
                    this.f1206a.setTimeZone(timeZone);
                } catch (ParseException e) {
                    throw new a0("Failed parsing '" + strNextString + "' as SQL Date; at path " + bVar.getPreviousPath(), e);
                }
            } catch (Throwable th2) {
                this.f1206a.setTimeZone(timeZone);
                throw th2;
            }
        }
        return date;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            dVar.nullValue();
            return;
        }
        synchronized (this) {
            str = this.f1206a.format((java.util.Date) date);
        }
        dVar.value(str);
    }

    private b() {
        this.f1206a = new SimpleDateFormat("MMM d, yyyy");
    }
}
