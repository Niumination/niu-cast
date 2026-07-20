package com.transsion.connectx.mirror.source.receiver;

import android.content.Context;
import android.content.IntentFilter;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import k4.h;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ScreenActionReceiver.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f2168d = "ScreenActionManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScreenActionReceiver f2169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h.f f2170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f2171c;

    /* JADX INFO: renamed from: com.transsion.connectx.mirror.source.receiver.a$a, reason: collision with other inner class name */
    public static final class C0076a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2172a = new a();
    }

    public interface b {
        void a(boolean z10);
    }

    public static a c() {
        return C0076a.f2172a;
    }

    @Override // com.transsion.connectx.mirror.source.receiver.ScreenActionReceiver.a
    public void a(boolean z10, String str) {
        m.e(f2168d, "updateScreenStatus isLock : " + z10 + ", reason : " + str);
        Iterator<b> it = this.f2171c.iterator();
        while (it.hasNext()) {
            it.next().a(z10);
        }
    }

    public final /* synthetic */ void d(boolean z10) {
        m.e(f2168d, "onLockWindowVisible isLock : " + z10);
        k(z10);
    }

    public void e() {
        m.e(f2168d, "registerLockWindowVisibleEvent");
        this.f2170b = new h.f() { // from class: s5.a
            @Override // k4.h.f
            public final void a(boolean z10) {
                this.f15010a.d(z10);
            }
        };
        h.a.f8959a.m(this.f2170b);
    }

    public void f(b bVar) {
        this.f2171c.add(bVar);
    }

    public void g(Context context) {
        ScreenActionReceiver screenActionReceiver = new ScreenActionReceiver();
        this.f2169a = screenActionReceiver;
        screenActionReceiver.a(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        l5.a.a(context, this.f2169a, intentFilter, Boolean.TRUE);
    }

    public void h(Context context) {
        ScreenActionReceiver screenActionReceiver = this.f2169a;
        if (screenActionReceiver != null) {
            context.unregisterReceiver(screenActionReceiver);
        }
    }

    public void i() {
        m.e(f2168d, "unregisterLockWindowVisibleEvent");
        h.a.f8959a.r(this.f2170b);
    }

    public void j(b bVar) {
        this.f2171c.remove(bVar);
    }

    public void k(boolean z10) {
        m.e(f2168d, "updateScreenStatusByHook isLock : " + z10);
        Iterator<b> it = this.f2171c.iterator();
        while (it.hasNext()) {
            it.next().a(z10);
        }
    }

    public a() {
        this.f2171c = new ConcurrentLinkedQueue<>();
    }
}
