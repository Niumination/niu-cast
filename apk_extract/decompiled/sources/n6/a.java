package n6;

import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.AbsListView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBSContainerFrameLayout;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseBottomSheetDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSPageView;
import df.m;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Stack;
import k3.dd;
import k3.z8;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sk.b;
import sk.d;
import sk.e;
import tj.w;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements fd.a, d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f8120d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f8123c;

    public /* synthetic */ a(int i8) {
        this.f8121a = i8;
    }

    @Override // sk.d
    public boolean a(MotionEvent motionEvent) {
        z1OoOnew z1ooonew = (z1OoOnew) this.f8123c;
        int[] iArr = new int[2];
        z1ooonew.f11239b.getView().getLocationOnScreen(iArr);
        int x2 = (int) (motionEvent.getX(0) + iArr[0] + 0.5f);
        z1ooonew.f11250r = x2;
        z1ooonew.p = x2;
        int y3 = (int) (motionEvent.getY(0) + iArr[1] + 0.5f);
        z1ooonew.f11251s = y3;
        z1ooonew.q = y3;
        VelocityTracker velocityTracker = z1ooonew.f11253v;
        if (velocityTracker == null) {
            z1ooonew.f11253v = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        z1ooonew.f11253v.addMovement(motionEvent);
        return false;
    }

    @Override // sk.d
    public int b() {
        return 0;
    }

    @Override // sk.d
    public boolean c(MotionEvent motionEvent) {
        sk.a aVar;
        z1OoOnew z1ooonew = (z1OoOnew) this.f8123c;
        boolean z2 = z1ooonew.f11243i;
        tk.a aVar2 = z1ooonew.f11239b;
        if (z2 && !z1ooonew.f11244j && !z1ooonew.f11245k) {
            int[] iArr = new int[2];
            aVar2.getView().getLocationOnScreen(iArr);
            z1ooonew.f11250r = (int) (motionEvent.getX(0) + iArr[0] + 0.5f);
            z1ooonew.f11251s = (int) (motionEvent.getY(0) + iArr[1] + 0.5f);
            return false;
        }
        if (z1ooonew.f11246l || z1ooonew.f11247m) {
            z1ooonew.p = z1ooonew.f11250r;
            z1ooonew.q = z1ooonew.f11251s;
            z1ooonew.f11246l = false;
            z1ooonew.f11247m = false;
        }
        View view = aVar2.getView();
        b bVar = (b) this.f8122b;
        boolean zA = bVar.a(view, motionEvent, z1ooonew.f11240c);
        if (z1ooonew.f11253v == null) {
            z1ooonew.f11253v = VelocityTracker.obtain();
        }
        z1ooonew.f11253v.addMovement(motionEvent);
        boolean z3 = z1ooonew.B;
        if (z3 && z1ooonew.f11243i && z1ooonew.f11244j && z1ooonew.C) {
            z1ooonew.C = false;
            return true;
        }
        m mVar = z1ooonew.f11241d;
        e eVar = z1ooonew.f11238a;
        if (z3 && z1ooonew.f11243i && z1ooonew.f11244j && !bVar.f10147d && ((aVar2.b() || aVar2.a()) && (aVar = z1ooonew.f11257z) != null)) {
            aVar.b();
            z1ooonew.B = false;
            z1ooonew.C = true;
            eVar.f10151a = motionEvent.getPointerId(0);
            eVar.f10152b = !bVar.f10147d;
            z1ooonew.k(mVar);
            float f = bVar.f10144a + (bVar.f10145b * z1ooonew.f(bVar.f10144a, bVar.f10145b, bVar.f10147d == eVar.f10152b, bVar.e > 0.0f));
            z1ooonew.j(view, f);
            if (f > 40.0f && (view instanceof RecyclerView)) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                view.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0));
                Log.d("BounceEffect", "Send action down event");
            }
            return true;
        }
        if (!bVar.f10146c || zA) {
            return false;
        }
        if (z1ooonew.f11243i && ((z1ooonew.f11244j && !bVar.f10147d) || (z1ooonew.f11245k && bVar.f10147d))) {
            return false;
        }
        if (!(aVar2.b() && bVar.f10147d) && (!aVar2.a() || bVar.f10147d)) {
            return false;
        }
        eVar.f10151a = motionEvent.getPointerId(0);
        eVar.f10152b = bVar.f10147d;
        Log.d("BounceEffect", "about to switch to overscroll mode, start mDir:" + eVar.f10152b + "mAbsOffset:0.0");
        sk.a aVar3 = z1ooonew.f11257z;
        if (aVar3 != null) {
            aVar3.b();
            z1ooonew.B = false;
            z1ooonew.C = true;
        }
        z1ooonew.k(mVar);
        z1ooonew.j(view, bVar.f10144a + (bVar.f10145b * z1ooonew.f(bVar.f10144a, bVar.f10145b, bVar.f10147d == eVar.f10152b, bVar.e > 0.0f)));
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            for (int i8 = 0; i8 < absListView.getChildCount(); i8++) {
                View childAt = absListView.getChildAt(i8);
                if (childAt != null) {
                    childAt.setPressed(false);
                    childAt.setSelected(false);
                }
            }
        }
        view.cancelPendingInputEvents();
        view.setPressed(false);
        view.setSelected(false);
        boolean z5 = z1ooonew.f11243i;
        if ((z5 && z1ooonew.f11244j && (view instanceof RecyclerView)) || !z5 || (!z1ooonew.f11245k && !z1ooonew.f11244j)) {
            return true;
        }
        Log.d("BounceEffect", "report move to super");
        return false;
    }

    @Override // fd.a
    public void d() {
        OSBaseBottomSheetDialog oSBaseBottomSheetDialog = (OSBaseBottomSheetDialog) this.f8122b;
        int size = oSBaseBottomSheetDialog.f2989d.size();
        oSBaseBottomSheetDialog.getClass();
        if (size < 5) {
            Stack stack = oSBaseBottomSheetDialog.f2989d;
            OSPageView oSPageView = (OSPageView) this.f8123c;
            if (stack.contains(oSPageView)) {
                return;
            }
            oSBaseBottomSheetDialog.f2989d.push(oSPageView);
            OSBSContainerFrameLayout oSBSContainerFrameLayout = oSBaseBottomSheetDialog.o().e;
            Intrinsics.checkNotNullExpressionValue(oSBSContainerFrameLayout, "mContainerViewBinding.panelContent");
            int childCount = oSBSContainerFrameLayout.getChildCount();
            int size2 = oSBaseBottomSheetDialog.f2988c.size();
            int iHashCode = oSPageView.hashCode();
            StringBuilder sbR = o.d.r(childCount, size2, "popPage:onAnimEnd mRealContainer.size = ", " mPageContainerStack.size = ", " osPageView = ");
            sbR.append(iHashCode);
            z8.f("OSBaseBottomSheetDialog", sbR.toString());
        }
    }

    @Override // sk.d
    public void e(d dVar) {
    }

    @Override // sk.d
    public boolean f(MotionEvent motionEvent) {
        z1OoOnew z1ooonew = (z1OoOnew) this.f8123c;
        VelocityTracker velocityTracker = z1ooonew.f11253v;
        if (velocityTracker == null) {
            return false;
        }
        velocityTracker.recycle();
        z1ooonew.f11253v = null;
        return false;
    }

    public ze.b g() {
        if (((IdentityHashMap) this.f8123c) != null) {
            for (Map.Entry entry : ((ze.b) this.f8122b).f11322a.entrySet()) {
                if (!((IdentityHashMap) this.f8123c).containsKey(entry.getKey())) {
                    ((IdentityHashMap) this.f8123c).put((ze.a) entry.getKey(), entry.getValue());
                }
            }
            this.f8122b = new ze.b((IdentityHashMap) this.f8123c);
            this.f8123c = null;
        }
        return (ze.b) this.f8122b;
    }

    public void h() {
        String str;
        o6.a aVar = (o6.a) this.f8122b;
        try {
            aVar.getClass();
            byte[] bArrH = dd.h("63D4BEBEBC7ABCA4BC6A796B6AB06B766A6C7D706B6B756F70B07B6F71A4A5AEBCB2D4BEBEBC6A69BCA4BC7A6B69B16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6A7BBCA4BC7A6B7BB16A796B6AB06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F69BCA4BC7A6B69B06B767D72726A6C65B07B6F71BCB2D4BEBEBC6F7BBCA4BC7A6B7BB06B767D72726A6C65B07B6F71BCB2D4BEBEBC7BBCA4BCAF726F777B6F7078AF68A8AF696E726F7D7A7B6F7078BCB2D4BEBEBC77BCA4BCAF726F777B6F7078AF68ADAF6B797B6C796ABCB2D4BEBEBC69BCA4BCAF7D6A7679707DAF7B76797B736E6F75706AAF68ACAF696E726F7D7ABCB2D4BEBEBC787BBCA4BC68AEAC7BBCB2D4BEBEBC787ABCA4BC68AEAC7ABCB2D4BEBEBC7879BCA4BC68AEAC79BCB2D4BEBEBC7568BCA4BC7D7C7B7A79787776757473AD71706F6EBCB2D4BEBEBC67BCA4BCABA7ADA899A99B9CAD9CA5A6AC9BAEABA9AEADAB99A9ACADA8A79D9D98A9AA9DBCD461D4D4");
            if (bArrH == null) {
                str = "";
            } else {
                for (int i8 = 0; i8 < bArrH.length; i8++) {
                    bArrH[i8] = (byte) (222 - ((char) bArrH[i8]));
                }
                str = new String(bArrH);
            }
            s6.d.c(str);
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            e8.d.a("initSDKConfig", e);
        } finally {
            aVar.a(s6.d.f9545j);
            aVar.f8409d = s6.d.f9548m;
        }
    }

    public Pair i() {
        ArrayList arrayList = ((s6.e) ((i1.b) this.f8123c).f5527a).f9568l;
        if (!dd.i(arrayList)) {
            return new Pair(0, s6.d.f9549n);
        }
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() % ((long) arrayList.size()));
        return new Pair(Integer.valueOf(iCurrentTimeMillis), (byte[]) arrayList.get(iCurrentTimeMillis));
    }

    public void j(ze.a aVar, Object obj) {
        if (((IdentityHashMap) this.f8123c) == null) {
            this.f8123c = new IdentityHashMap(1);
        }
        ((IdentityHashMap) this.f8123c).put(aVar, obj);
    }

    public String toString() {
        String str;
        switch (this.f8121a) {
            case 4:
                StringBuilder sb2 = new StringBuilder();
                sb2.append((String) this.f8122b);
                sb2.append(' ');
                ArrayList arrayList = (ArrayList) this.f8123c;
                if (arrayList.isEmpty()) {
                    str = "";
                } else {
                    str = ", " + CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
                }
                sb2.append(str);
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(int i8, Object obj, Object obj2) {
        this.f8121a = i8;
        this.f8122b = obj;
        this.f8123c = obj2;
    }

    public a(z1OoOnew z1ooonew) {
        this.f8121a = 5;
        this.f8123c = z1ooonew;
        this.f8122b = z1ooonew.l();
    }

    public a(String name, ArrayList parameters) {
        this.f8121a = 4;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.f8122b = name;
        this.f8123c = parameters;
    }

    public a(w wVar, i5.a aVar, i5.b bVar) {
        this.f8121a = 3;
        dj.m mVar = new dj.m(aVar, bVar, new j5.a());
        this.f8122b = wVar;
        this.f8123c = mVar;
    }
}
