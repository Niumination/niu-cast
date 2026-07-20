package b5;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import v4.a0;
import v4.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f1207b = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f1208a;

    public /* synthetic */ d(int i8) {
        this();
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        Time time;
        if (bVar.peek() == d5.c.NULL) {
            bVar.nextNull();
            return null;
        }
        String strNextString = bVar.nextString();
        synchronized (this) {
            TimeZone timeZone = this.f1208a.getTimeZone();
            try {
                try {
                    time = new Time(this.f1208a.parse(strNextString).getTime());
                    this.f1208a.setTimeZone(timeZone);
                } catch (ParseException e) {
                    throw new a0("Failed parsing '" + strNextString + "' as SQL Time; at path " + bVar.getPreviousPath(), e);
                }
            } catch (Throwable th2) {
                this.f1208a.setTimeZone(timeZone);
                throw th2;
            }
        }
        return time;
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            dVar.nullValue();
            return;
        }
        synchronized (this) {
            str = this.f1208a.format((Date) time);
        }
        dVar.value(str);
    }

    private d() {
        this.f1208a = new SimpleDateFormat("hh:mm:ss a");
    }
}
