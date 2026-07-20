package b2;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import v1.a0;
import v1.e;
import v1.u;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class b extends z<Time> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f717b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f718a;

    public class a implements a0 {
        @Override // v1.a0
        public <T> z<T> create(e eVar, c2.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new b();
            }
            return null;
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    @Override // v1.z
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Time read(d2.a aVar) throws IOException {
        Time time;
        if (aVar.peek() == d2.c.NULL) {
            aVar.nextNull();
            return null;
        }
        String strNextString = aVar.nextString();
        try {
            synchronized (this) {
                time = new Time(this.f718a.parse(strNextString).getTime());
            }
            return time;
        } catch (ParseException e10) {
            StringBuilder sbA = e.a.a("Failed parsing '", strNextString, "' as SQL Time; at path ");
            sbA.append(aVar.getPreviousPath());
            throw new u(sbA.toString(), e10);
        }
    }

    @Override // v1.z
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(d2.d dVar, Time time) throws IOException {
        String str;
        if (time == null) {
            dVar.nullValue();
            return;
        }
        synchronized (this) {
            str = this.f718a.format((Date) time);
        }
        dVar.value(str);
    }

    public b() {
        this.f718a = new SimpleDateFormat("hh:mm:ss a");
    }
}
