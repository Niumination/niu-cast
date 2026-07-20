package b2;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import v1.a0;
import v1.e;
import v1.u;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class a extends z<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f715b = new C0026a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateFormat f716a;

    /* JADX INFO: renamed from: b2.a$a, reason: collision with other inner class name */
    public class C0026a implements a0 {
        @Override // v1.a0
        public <T> z<T> create(e eVar, c2.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new a();
            }
            return null;
        }
    }

    public /* synthetic */ a(C0026a c0026a) {
        this();
    }

    @Override // v1.z
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date read(d2.a aVar) throws IOException {
        java.util.Date date;
        if (aVar.peek() == d2.c.NULL) {
            aVar.nextNull();
            return null;
        }
        String strNextString = aVar.nextString();
        try {
            synchronized (this) {
                date = this.f716a.parse(strNextString);
            }
            return new Date(date.getTime());
        } catch (ParseException e10) {
            StringBuilder sbA = e.a.a("Failed parsing '", strNextString, "' as SQL Date; at path ");
            sbA.append(aVar.getPreviousPath());
            throw new u(sbA.toString(), e10);
        }
    }

    @Override // v1.z
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(d2.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.nullValue();
            return;
        }
        synchronized (this) {
            str = this.f716a.format((java.util.Date) date);
        }
        dVar.value(str);
    }

    public a() {
        this.f716a = new SimpleDateFormat("MMM d, yyyy");
    }
}
