package t5;

import a6.r;
import android.os.SystemClock;
import android.util.Pair;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.aiotlink.IStreamDataListener;
import com.transsion.aiotlink.NativeLinkManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import k4.j;
import k4.m;
import n2.w;
import v4.g;
import v4.k;
import w4.o1;

/* JADX INFO: loaded from: classes2.dex */
public class d extends t5.b<r4.c> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f15494u = "VideoSender";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f15495v = 12000;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f15496w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f15497x = 6;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f15498y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final List<Pair<Integer, Integer>> f15499z;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f15500o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public w f15501p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ScheduledExecutorService f15502q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f15503r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f15504s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f15505t;

    public class a implements IStreamDataListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r4.d f15507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f15508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15509d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f15510e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f15511f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f15512g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f15513h;

        public a(int i10, r4.d dVar, int i11, String str, int i12, int i13, String str2, boolean z10) {
            this.f15506a = i10;
            this.f15507b = dVar;
            this.f15508c = i11;
            this.f15509d = str;
            this.f15510e = i12;
            this.f15511f = i13;
            this.f15512g = str2;
            this.f15513h = z10;
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
            m.e(d.f15494u, "video closed");
            d.this.f15487c.i(this.f15506a);
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
            m.e(d.f15494u, "on video onConnect:  success");
            d dVar = d.this;
            dVar.f15489e = true;
            t5.b.C0402b c0402b = dVar.f15490f;
            if (c0402b != null) {
                c0402b.a();
            }
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(byte[] bArr, int i10, int i11) {
            k.a.f16583a.o();
            d.this.f15500o.a(i11);
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
            d.this.f15501p = new w(2, 1, 1, this.f15506a, new w.c(2, this.f15507b.j(), this.f15507b.f(), this.f15507b.c(), this.f15507b.g(), this.f15507b.e(), this.f15508c, this.f15509d, this.f15510e, this.f15511f, r.a()));
            d.this.f15501p.g(this.f15512g);
            NativeLinkManager.a().sendTccpRequest(g.f16533e, j.a.f8962a.g(d.this.f15501p));
            o1.a.f18113a.u(this.f15513h);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15515a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15516b = 0;

        public void a(int i10) {
            if (i10 <= 0) {
                return;
            }
            this.f15516b += i10;
            this.f15515a++;
        }

        public int b() {
            int i10 = this.f15515a;
            if (i10 > 0) {
                return this.f15516b / i10;
            }
            return -1;
        }

        public void c() {
            this.f15515a = 0;
            this.f15516b = 0;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f15499z = arrayList;
        arrayList.add(new Pair(33, 60));
        arrayList.add(new Pair(36, 55));
        arrayList.add(new Pair(40, 50));
        arrayList.add(new Pair(45, 45));
        arrayList.add(new Pair(50, 40));
        arrayList.add(new Pair(58, 35));
        arrayList.add(new Pair(66, 30));
        arrayList.add(new Pair(80, 25));
        arrayList.add(new Pair(100, 20));
        arrayList.add(new Pair(Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION), 15));
        arrayList.add(new Pair(Integer.MAX_VALUE, 10));
    }

    public d(r4.c cVar, v4.d dVar) {
        super(cVar, dVar);
        this.f15504s = 1;
        int i10 = 0;
        this.f15505t = 0;
        while (true) {
            List<Pair<Integer, Integer>> list = f15499z;
            if (i10 >= list.size()) {
                this.f15503r = this.f15504s;
                this.f15500o = new b();
                p();
                return;
            } else {
                if (cVar.b().e() >= ((Integer) list.get(i10).second).intValue()) {
                    this.f15504s = i10;
                }
                i10++;
            }
        }
    }

    @Override // t5.b
    public void d(byte[] bArr) {
        SystemClock.uptimeMillis();
        if (this.f15486b == -1) {
            m.c(f15494u, "sendData:video port not set");
        }
        if (this.f15488d != 3) {
            m.b(f15494u, "sendData: not running");
        } else {
            this.f15487c.g(this.f15486b, bArr);
        }
    }

    @Override // t5.b
    public void g() {
        super.g();
        this.f15487c.i(this.f15486b);
        q();
        m.e(f15494u, "stopped");
    }

    public final int l(int i10) {
        if (i10 < 0) {
            return this.f15503r;
        }
        int i11 = 0;
        while (true) {
            List<Pair<Integer, Integer>> list = f15499z;
            if (i11 >= list.size()) {
                return this.f15503r;
            }
            if (i10 <= ((Integer) list.get(i11).first).intValue()) {
                return i11;
            }
            i11++;
        }
    }

    public w m() {
        return this.f15501p;
    }

    public void n(int i10, String str, int i11, int i12, int i13, boolean z10, String str2) {
        this.f15486b = i11;
        this.f15487c.d(i11, new a(i11, ((r4.c) this.f15485a).b(), i10, str, i12, i13, str2, z10));
        this.f15488d = 1;
    }

    public final /* synthetic */ void o() {
        int iL;
        int iB = this.f15500o.b();
        this.f15500o.c();
        m.b(f15494u, "monitor network latency: " + iB);
        if (iB >= 0 && this.f15504s != (iL = l(iB)) && iL >= 0) {
            List<Pair<Integer, Integer>> list = f15499z;
            if (iL <= list.size() - 1) {
                if (iL >= 6) {
                    int i10 = this.f15505t + 1;
                    this.f15505t = i10;
                    if (i10 >= 3) {
                        this.f15505t = 0;
                    }
                } else {
                    this.f15505t = 0;
                }
                ((r4.c) this.f15485a).d(((Integer) list.get(iL).second).intValue());
                this.f15504s = iL;
            }
        }
    }

    public final void p() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f15502q = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: t5.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f15493a.o();
            }
        }, 2L, 2L, TimeUnit.SECONDS);
    }

    public final void q() {
        ScheduledExecutorService scheduledExecutorService = this.f15502q;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            m.e(f15494u, "stopMonitorLatency");
        }
    }
}
