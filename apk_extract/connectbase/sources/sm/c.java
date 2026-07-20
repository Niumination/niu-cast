package sm;

import an.f;
import in.i;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import jn.l;
import kn.l0;
import kn.r1;
import lm.l2;
import lm.z0;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "TimersKt")
public final class c {

    @r1({"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n*L\n1#1,148:1\n*E\n"})
    public static final class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l<TimerTask, l2> f15173a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super TimerTask, l2> lVar) {
            this.f15173a = lVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f15173a.invoke(this);
        }
    }

    @f
    public static final Timer a(String str, boolean z10, long j10, long j11, l<? super TimerTask, l2> lVar) {
        l0.p(lVar, k4.f.f8937e);
        Timer timerK = k(str, z10);
        timerK.scheduleAtFixedRate(new a(lVar), j10, j11);
        return timerK;
    }

    @f
    public static final Timer b(String str, boolean z10, Date date, long j10, l<? super TimerTask, l2> lVar) {
        l0.p(date, "startAt");
        l0.p(lVar, k4.f.f8937e);
        Timer timerK = k(str, z10);
        timerK.scheduleAtFixedRate(new a(lVar), date, j10);
        return timerK;
    }

    public static /* synthetic */ Timer c(String str, boolean z10, long j10, long j11, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            j10 = 0;
        }
        l0.p(lVar, k4.f.f8937e);
        Timer timerK = k(str, z10);
        timerK.scheduleAtFixedRate(new a(lVar), j10, j11);
        return timerK;
    }

    public static /* synthetic */ Timer d(String str, boolean z10, Date date, long j10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        l0.p(date, "startAt");
        l0.p(lVar, k4.f.f8937e);
        Timer timerK = k(str, z10);
        timerK.scheduleAtFixedRate(new a(lVar), date, j10);
        return timerK;
    }

    @f
    public static final TimerTask e(Timer timer, long j10, long j11, l<? super TimerTask, l2> lVar) {
        l0.p(timer, "<this>");
        l0.p(lVar, k4.f.f8937e);
        a aVar = new a(lVar);
        timer.schedule(aVar, j10, j11);
        return aVar;
    }

    @f
    public static final TimerTask f(Timer timer, long j10, l<? super TimerTask, l2> lVar) {
        l0.p(timer, "<this>");
        l0.p(lVar, k4.f.f8937e);
        a aVar = new a(lVar);
        timer.schedule(aVar, j10);
        return aVar;
    }

    @f
    public static final TimerTask g(Timer timer, Date date, long j10, l<? super TimerTask, l2> lVar) {
        l0.p(timer, "<this>");
        l0.p(date, RtspHeaders.Values.TIME);
        l0.p(lVar, k4.f.f8937e);
        a aVar = new a(lVar);
        timer.schedule(aVar, date, j10);
        return aVar;
    }

    @f
    public static final TimerTask h(Timer timer, Date date, l<? super TimerTask, l2> lVar) {
        l0.p(timer, "<this>");
        l0.p(date, RtspHeaders.Values.TIME);
        l0.p(lVar, k4.f.f8937e);
        a aVar = new a(lVar);
        timer.schedule(aVar, date);
        return aVar;
    }

    @f
    public static final TimerTask i(Timer timer, long j10, long j11, l<? super TimerTask, l2> lVar) {
        l0.p(timer, "<this>");
        l0.p(lVar, k4.f.f8937e);
        a aVar = new a(lVar);
        timer.scheduleAtFixedRate(aVar, j10, j11);
        return aVar;
    }

    @f
    public static final TimerTask j(Timer timer, Date date, long j10, l<? super TimerTask, l2> lVar) {
        l0.p(timer, "<this>");
        l0.p(date, RtspHeaders.Values.TIME);
        l0.p(lVar, k4.f.f8937e);
        a aVar = new a(lVar);
        timer.scheduleAtFixedRate(aVar, date, j10);
        return aVar;
    }

    @z0
    @os.l
    public static final Timer k(@m String str, boolean z10) {
        return str == null ? new Timer(z10) : new Timer(str, z10);
    }

    @f
    public static final Timer l(String str, boolean z10, long j10, long j11, l<? super TimerTask, l2> lVar) {
        l0.p(lVar, k4.f.f8937e);
        Timer timerK = k(str, z10);
        timerK.schedule(new a(lVar), j10, j11);
        return timerK;
    }

    @f
    public static final Timer m(String str, boolean z10, Date date, long j10, l<? super TimerTask, l2> lVar) {
        l0.p(date, "startAt");
        l0.p(lVar, k4.f.f8937e);
        Timer timerK = k(str, z10);
        timerK.schedule(new a(lVar), date, j10);
        return timerK;
    }

    public static /* synthetic */ Timer n(String str, boolean z10, long j10, long j11, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            j10 = 0;
        }
        l0.p(lVar, k4.f.f8937e);
        Timer timerK = k(str, z10);
        timerK.schedule(new a(lVar), j10, j11);
        return timerK;
    }

    public static /* synthetic */ Timer o(String str, boolean z10, Date date, long j10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        l0.p(date, "startAt");
        l0.p(lVar, k4.f.f8937e);
        Timer timerK = k(str, z10);
        timerK.schedule(new a(lVar), date, j10);
        return timerK;
    }

    @f
    public static final TimerTask p(l<? super TimerTask, l2> lVar) {
        l0.p(lVar, k4.f.f8937e);
        return new a(lVar);
    }
}
