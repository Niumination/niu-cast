package ik;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s implements ck.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5906b;

    static {
        fk.d dVar = fk.d.f5057a;
        f5905a = 128;
        if (q.f5903b) {
            f5905a = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                f5905a = Integer.parseInt(property);
            } catch (Exception e) {
                PrintStream printStream = System.err;
                StringBuilder sbY = a1.a.y("Failed to set 'rx.buffer.size' with value ", property, " => ");
                sbY.append(e.getMessage());
                printStream.println(sbY.toString());
            }
        }
        f5906b = f5905a;
        new r(0);
        new r(1);
    }
}
