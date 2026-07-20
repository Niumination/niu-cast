package ik;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {
    @os.m
    public static final Date a(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        String str = b0VarB.get(j0.f8092w);
        if (str == null) {
            return null;
        }
        return i(str);
    }

    @os.m
    public static final Date b(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        String str = b0VarB.get(j0.C);
        if (str == null) {
            return null;
        }
        return i(str);
    }

    @os.m
    public static final Date c(@os.l m0 m0Var) {
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        String strL = c0VarB.l(j0.C);
        if (strL == null) {
            return null;
        }
        return i(strL);
    }

    public static final String d(Date date) {
        String str = e().format(date);
        kn.l0.o(str, "HTTP_DATE_FORMAT.format(date)");
        return str;
    }

    public static final SimpleDateFormat e() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static final void f(@os.l m0 m0Var, @os.l Date date) {
        kn.l0.p(m0Var, "<this>");
        kn.l0.p(date, "date");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        c0VarB.v(j0.J, d(date));
    }

    @os.m
    public static final Date g(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "<this>");
        b0 b0VarB = l0Var.b();
        j0.f8048a.getClass();
        String str = b0VarB.get(j0.O);
        if (str == null) {
            return null;
        }
        return i(str);
    }

    @os.m
    public static final Date h(@os.l m0 m0Var) {
        kn.l0.p(m0Var, "<this>");
        c0 c0VarB = m0Var.b();
        j0.f8048a.getClass();
        String strL = c0VarB.l(j0.O);
        if (strL == null) {
            return null;
        }
        return i(strL);
    }

    public static final Date i(String str) throws ParseException {
        Date date = e().parse(str);
        kn.l0.o(date, "HTTP_DATE_FORMAT.parse(date)");
        return date;
    }
}
