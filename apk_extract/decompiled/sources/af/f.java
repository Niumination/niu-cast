package af;

import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.transsion.widgetslib.view.OSRadioButton;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetslib.widget.seekbar.OSMultiSeekBar;
import com.transsion.widgetslib.widget.seekbar.OSWideSeekbar;
import com.transsion.widgetslib.widget.tablayout.OSTabLayout;
import com.transsion.widgetslistitemlayout.OSListItemView;
import com.transsion.widgetslistitemlayout.OSSmoothRoundCorner;
import com.transsion.widgetslistitemlayout.R$id;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import k3.z8;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f253b;

    public /* synthetic */ f() {
        this.f252a = 16;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gj.a aVarC;
        long jNanoTime;
        int marginStart;
        int i8 = 0;
        switch (this.f252a) {
            case 0:
                ((cf.a0) this.f253b).p(ze.q2.e);
                return;
            case 1:
                ((q0) this.f253b).f522a.j();
                return;
            case 2:
                ((d0) ((w0) this.f253b).f641b).q();
                return;
            case 3:
                f2 f2Var = (f2) ((e) this.f253b).f225c;
                r3 r3Var = f2Var.q;
                f2Var.p = null;
                f2Var.q = null;
                r3Var.c(ze.q2.f11411n.h("InternalSubchannel closed transport due to address change"));
                return;
            case 4:
                ((j3) ((k0) this.f253b).f375b).m();
                return;
            case 5:
                j3 j3Var = ((a3) this.f253b).f141b;
                j3Var.f357m.d();
                if (j3Var.f363v) {
                    j3Var.u.n();
                    return;
                }
                return;
            case 6:
                f2 f2Var2 = ((i3) this.f253b).f328i;
                ze.q2 q2Var = j3.g0;
                f2Var2.getClass();
                f2Var2.f267j.execute(new x1(f2Var2, q2Var, i8));
                return;
            case 7:
                ((f4) this.f253b).f282a.o();
                return;
            case 8:
                x2 x2Var = (x2) this.f253b;
                if (x2Var.f703z) {
                    return;
                }
                x2Var.u.q();
                return;
            case 9:
                c5 c5Var = (c5) this.f253b;
                x2 x2Var2 = (x2) c5Var.f206c.f447c;
                e5 e5Var = c5Var.f205b;
                ze.k1 k1Var = x2.E;
                x2Var2.q(e5Var);
                return;
            case 10:
                ((j5) this.f253b).n();
                return;
            case 11:
                cf.h0 h0Var = (cf.h0) ((qf.c) this.f253b).f9047b;
                ze.q2 q2VarH = ze.q2.f.h("Handshake timeout exceeded");
                synchronized (h0Var.f1546n) {
                    try {
                        if (h0Var.f1548r != null) {
                            h0Var.h(ef.a.NO_ERROR, "", q2VarH, true);
                            return;
                        } else {
                            h0Var.q = true;
                            l1.b(h0Var.e);
                            return;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            case 12:
                cf.c cVar = (cf.c) this.f253b;
                try {
                    qj.c cVar2 = cVar.f1498k;
                    if (cVar2 != null) {
                        qj.f fVar = cVar.f1492b;
                        long j8 = fVar.f9195b;
                        if (j8 > 0) {
                            cVar2.k0(fVar, j8);
                        }
                    }
                } catch (IOException e) {
                    cVar.f1494d.b(e);
                }
                qj.f fVar2 = cVar.f1492b;
                cf.d dVar = cVar.f1494d;
                try {
                    qj.c cVar3 = cVar.f1498k;
                    if (cVar3 != null) {
                        cVar3.close();
                    }
                } catch (IOException e4) {
                    dVar.b(e4);
                }
                try {
                    Socket socket = cVar.f1499l;
                    if (socket != null) {
                        socket.close();
                        return;
                    }
                    return;
                } catch (IOException e10) {
                    dVar.b(e10);
                    return;
                }
            case 13:
                i iVar = (i) this.f253b;
                long j10 = iVar.f314a;
                long jMax = Math.max(2 * j10, j10);
                j jVar = (j) iVar.f315b;
                if (jVar.f340b.compareAndSet(j10, jMax)) {
                    j.f338c.log(Level.WARNING, "Increased {0} to {1}", new Object[]{jVar.f339a, Long.valueOf(jMax)});
                    return;
                }
                return;
            case 14:
                ((cf.q) this.f253b).getClass();
                cf.q qVar = (cf.q) this.f253b;
                qVar.f1623o.execute(qVar.f1626t);
                synchronized (((cf.q) this.f253b).f1619k) {
                    cf.q qVar2 = (cf.q) this.f253b;
                    qVar2.C = Integer.MAX_VALUE;
                    qVar2.s();
                    break;
                }
                ((cf.q) this.f253b).getClass();
                return;
            case 15:
                try {
                    ((Runnable) this.f253b).run();
                    return;
                } catch (Exception e11) {
                    Log.e("TransportRuntime.".concat("Executor"), "Background execution failure.", e11);
                    return;
                }
            case 16:
                boolean zEquals = TextUtils.equals(s6.d.q, "test");
                c6.a aVar = (c6.a) this.f253b;
                if (zEquals) {
                    z6.b.e("Athena is in Test mode，should not release this APK（测试模式）[" + e8.b.f4712i.getPackageName() + "]");
                    aVar.a(60000L, this);
                    return;
                }
                if (TextUtils.equals(s6.d.q, "online") && s6.d.p) {
                    z6.b.e("  - Athena is in Release mode with log enabled. Please set AthenaAnalytics.setDebug(false) to release this APK （Debug模式）[" + e8.b.f4712i.getPackageName() + "]");
                    aVar.a(60000L, this);
                    return;
                }
                return;
            case 17:
                e8.f fVar3 = (e8.f) this.f253b;
                try {
                    fVar3.f4732k = 0;
                    fVar3.f4733l.clear();
                    fVar3.f4727c = true;
                    fVar3.e = 0L;
                    s6.d.f9552s = "";
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 18:
                ((OSMultiSeekBar) this.f253b).requestLayout();
                return;
            case 19:
                ((OSWideSeekbar) this.f253b).requestLayout();
                return;
            case 20:
                int i9 = OSTabLayout.p;
                ((OSTabLayout) this.f253b).a();
                return;
            case 21:
                break;
            case 22:
                hk.b bVar = (hk.b) this.f253b;
                ConcurrentLinkedQueue<hk.e> concurrentLinkedQueue = bVar.f5481c;
                if (concurrentLinkedQueue.isEmpty()) {
                    return;
                }
                long jNanoTime2 = System.nanoTime();
                for (hk.e eVar : concurrentLinkedQueue) {
                    if (eVar.f5490l > jNanoTime2) {
                        return;
                    }
                    if (concurrentLinkedQueue.remove(eVar)) {
                        bVar.f5482d.b(eVar);
                    }
                }
                return;
            case 23:
                i2.j jVar2 = (i2.j) this.f253b;
                ((j2.h) jVar2.f5557d).h(new se.e(jVar2, 11));
                return;
            case 24:
                kd.d dVar2 = (kd.d) this.f253b;
                if (dVar2.f6830g != null) {
                    z8.b("d", "viewTreeObserver, onGlobalLayout, runnable delayed remove");
                    dVar2.f();
                    dVar2.e.getViewTreeObserver().removeOnGlobalLayoutListener(dVar2.f6830g);
                    return;
                }
                return;
            case 25:
                OSListItemView oSListItemView = (OSListItemView) this.f253b;
                TextView textView = oSListItemView.D;
                if (textView == null || oSListItemView.V == null || oSListItemView.f3810z == null || oSListItemView.U == null) {
                    return;
                }
                if (textView != null) {
                    textView.setMaxWidth(Integer.MAX_VALUE);
                }
                int width = oSListItemView.getWidth();
                if (width <= 0) {
                    return;
                }
                OSSmoothRoundCorner oSSmoothRoundCorner = oSListItemView.O;
                if (oSSmoothRoundCorner != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) oSSmoothRoundCorner.getLayoutParams();
                    marginStart = marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd() + oSListItemView.O.getWidth();
                } else {
                    marginStart = 0;
                }
                float f = width;
                int paddingStart = (int) (((0.65f * f) - oSListItemView.getPaddingStart()) - marginStart);
                int paddingEnd = (int) ((f * 0.35f) - oSListItemView.getPaddingEnd());
                z8.f("OSListItemView", "itemWidth, paddingStart: " + oSListItemView.getPaddingStart() + ", paddingEnd: " + oSListItemView.getPaddingEnd() + ", titleLayoutSpace: " + paddingStart + ", rightLayoutSpace: " + paddingEnd + ", itemWidth: " + width);
                float fMeasureText = oSListItemView.f3810z.getPaint().measureText(oSListItemView.f3810z.getText().toString());
                TextView textView2 = oSListItemView.A;
                float fMeasureText2 = textView2 == null ? 0.0f : textView2.getPaint().measureText(oSListItemView.A.getText().toString());
                float fMeasureText3 = oSListItemView.D.getPaint().measureText(oSListItemView.D.getText().toString());
                z8.b("OSListItemView", "titleWidth: " + fMeasureText + ", subtitleWidth: " + fMeasureText2 + ", describeTitleWidth: " + fMeasureText3);
                int iMax = (int) Math.max(fMeasureText, fMeasureText2);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) oSListItemView.V.getLayoutParams();
                int marginEnd = marginLayoutParams2.getMarginEnd() + marginLayoutParams2.getMarginStart() + oSListItemView.U.getPaddingEnd() + oSListItemView.U.getPaddingStart();
                OSIconTextView oSIconTextView = oSListItemView.F;
                if (oSIconTextView != null) {
                    marginEnd += oSIconTextView.getWidth();
                }
                if (fMeasureText3 >= paddingEnd) {
                    oSListItemView.D.setMaxWidth(((((width - iMax) - oSListItemView.getPaddingStart()) - oSListItemView.getPaddingEnd()) - marginEnd) - marginStart);
                }
                int paddingStart2 = (((width - oSListItemView.getPaddingStart()) - oSListItemView.getPaddingEnd()) - marginStart) - marginEnd;
                if (oSListItemView.f3796i0) {
                    if (iMax >= paddingStart) {
                        oSListItemView.D.setMaxWidth(paddingEnd - marginEnd);
                        return;
                    }
                    return;
                }
                if (fMeasureText + fMeasureText3 <= paddingStart2 && oSListItemView.f3810z.getLineCount() <= 1 && oSListItemView.D.getLineCount() <= 1) {
                    oSListItemView.D.setVisibility(0);
                    TextView textView3 = oSListItemView.A;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                        return;
                    }
                    return;
                }
                oSListItemView.D.setVisibility(8);
                if (oSListItemView.A == null) {
                    ViewStub viewStub = (ViewStub) oSListItemView.T.findViewById(R$id.lil_stub_subtitle);
                    if (viewStub != null) {
                        oSListItemView.A = (TextView) viewStub.inflate();
                    } else {
                        oSListItemView.A = (TextView) oSListItemView.T.findViewById(R$id.lil_subtitle);
                    }
                }
                TextView textView4 = oSListItemView.A;
                if (textView4 != null) {
                    textView4.setText(oSListItemView.D.getText());
                    oSListItemView.A.setVisibility(0);
                    return;
                }
                return;
            case 26:
                ((OSRadioButton) this.f253b).getClass();
                return;
            case 27:
                ((r2.l) this.f253b).f();
                return;
            case 28:
                q2.c cVar4 = ((r2.l) ((se.e) this.f253b).f9720b).f9341c;
                cVar4.disconnect(cVar4.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            default:
                ((r2.t) this.f253b).f9370i.b(new ConnectionResult(4));
                return;
        }
        while (true) {
            synchronized (((gj.d) this.f253b)) {
                aVarC = ((gj.d) this.f253b).c();
            }
            if (aVarC == null) {
                return;
            }
            gj.c cVar5 = aVarC.f5211a;
            Intrinsics.checkNotNull(cVar5);
            boolean zIsLoggable = gj.d.f5220i.isLoggable(Level.FINE);
            if (zIsLoggable) {
                a8.a aVar2 = cVar5.e.f5225g;
                jNanoTime = System.nanoTime();
                k3.i2.a(aVarC, cVar5, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                gj.d.a((gj.d) this.f253b, aVarC);
                try {
                    Unit unit = Unit.INSTANCE;
                    if (zIsLoggable) {
                        a8.a aVar3 = cVar5.e.f5225g;
                        k3.i2.a(aVarC, cVar5, "finished run in ".concat(k3.i2.b(System.nanoTime() - jNanoTime)));
                    }
                } catch (Throwable th3) {
                    if (zIsLoggable) {
                        a8.a aVar4 = cVar5.e.f5225g;
                        k3.i2.a(aVarC, cVar5, "failed a run in ".concat(k3.i2.b(System.nanoTime() - jNanoTime)));
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                a8.a aVar5 = ((gj.d) this.f253b).f5225g;
                Intrinsics.checkNotNullParameter(this, "runnable");
                ((ThreadPoolExecutor) aVar5.f44b).execute(this);
                throw th4;
            }
        }
    }

    public /* synthetic */ f(Object obj, int i8) {
        this.f252a = i8;
        this.f253b = obj;
    }
}
