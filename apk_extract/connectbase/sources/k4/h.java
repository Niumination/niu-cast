package k4;

import android.os.Bundle;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f8950h = "hookKeyguardShowing";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f8951i = "showing";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<c> f8952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<d> f8953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<g> f8954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f8955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentLinkedQueue<e> f8956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f8957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentLinkedQueue<f> f8958g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f8959a = new h();
    }

    public interface b {
        void a(int i10, int i11);
    }

    public interface c {
        void a(int i10, int i11);
    }

    public interface d {
        void a(int i10, String str);
    }

    public interface e {
        void a(Boolean bool);
    }

    public interface f {
        void a(boolean z10);
    }

    public interface g {
        void a(int i10, boolean z10);
    }

    public static h a() {
        return a.f8959a;
    }

    public void b(int i10, int i11) {
        Iterator<b> it = this.f8957f.iterator();
        while (it.hasNext()) {
            it.next().a(i10, i11);
        }
    }

    public void c(int i10, String str) {
        Iterator<d> it = this.f8953b.iterator();
        while (it.hasNext()) {
            it.next().a(i10, str);
        }
    }

    public void d(int i10, int i11) {
        Iterator<c> it = this.f8952a.iterator();
        while (it.hasNext()) {
            it.next().a(i10, i11);
        }
    }

    public void e(boolean z10) {
        Iterator<e> it = this.f8956e.iterator();
        while (it.hasNext()) {
            it.next().a(Boolean.valueOf(z10));
        }
    }

    public void f(int i10, WindowManager.LayoutParams layoutParams) {
        g(i10, layoutParams != null);
    }

    public void g(int i10, boolean z10) {
        if (this.f8954c.isEmpty()) {
            m.e("onSecureWindowVisible", "mOnSecureWindowVisibleListener is empty");
            this.f8955d = Boolean.valueOf(z10);
        } else {
            Iterator<g> it = this.f8954c.iterator();
            while (it.hasNext()) {
                it.next().a(i10, z10);
            }
        }
    }

    public void h(String str, Bundle bundle) {
        if (f8950h.equals(str)) {
            boolean z10 = bundle.getBoolean(f8951i, false);
            Iterator<f> it = this.f8958g.iterator();
            while (it.hasNext()) {
                it.next().a(z10);
            }
        }
    }

    public void i(b bVar) {
        this.f8957f.add(bVar);
    }

    public void j(c cVar) {
        this.f8952a.add(cVar);
    }

    public void k(d dVar) {
        this.f8953b.add(dVar);
    }

    public void l(e eVar) {
        this.f8956e.add(eVar);
    }

    public void m(f fVar) {
        this.f8958g.add(fVar);
    }

    public void n(g gVar) {
        this.f8954c.add(gVar);
        g(0, this.f8955d.booleanValue());
    }

    public void o(b bVar) {
        this.f8957f.remove(bVar);
    }

    public void p(c cVar) {
        this.f8952a.remove(cVar);
    }

    public void q(d dVar) {
        this.f8953b.remove(dVar);
    }

    public void r(f fVar) {
        this.f8958g.remove(fVar);
    }

    public void s(g gVar) {
        this.f8954c.remove(gVar);
    }

    public h() {
        this.f8952a = new ConcurrentLinkedQueue<>();
        this.f8953b = new ConcurrentLinkedQueue<>();
        this.f8954c = new ConcurrentLinkedQueue<>();
        this.f8955d = Boolean.FALSE;
        this.f8956e = new ConcurrentLinkedQueue<>();
        this.f8957f = new ConcurrentLinkedQueue<>();
        this.f8958g = new ConcurrentLinkedQueue<>();
    }
}
