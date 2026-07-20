package df;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageResponse;
import com.transsion.iotservice.multiscreen.pc.http.RequestCallback;
import dj.d0;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import k3.ad;
import k3.fe;
import k3.ma;
import k3.vb;
import k3.y0;
import k3.zc;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements k2.b, RequestCallback, b8.f, sk.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4460d;

    public /* synthetic */ m(int i8) {
        this.f4457a = i8;
    }

    public static m g(String str) throws ProtocolException {
        l lVar;
        int i8;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i8 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                lVar = l.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                lVar = l.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            lVar = l.HTTP_1_0;
            i8 = 4;
        }
        int i9 = i8 + 3;
        if (str.length() < i9) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i10 = Integer.parseInt(str.substring(i8, i9));
            if (str.length() <= i9) {
                strSubstring = "";
            } else {
                if (str.charAt(i9) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i8 + 4);
            }
            return new m(lVar, i10, strSubstring, 0);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    @Override // sk.d
    public boolean a(MotionEvent motionEvent) {
        z1OoOnew z1ooonew = (z1OoOnew) this.f4458b;
        int[] iArr = new int[2];
        z1ooonew.f11239b.getView().getLocationOnScreen(iArr);
        int x2 = (int) (motionEvent.getX(0) + iArr[0] + 0.5f);
        z1ooonew.f11250r = x2;
        z1ooonew.p = x2;
        int y3 = (int) (motionEvent.getY(0) + iArr[1] + 0.5f);
        z1ooonew.f11251s = y3;
        z1ooonew.q = y3;
        Log.d("BounceEffect", "touch down overscroll");
        VelocityTracker velocityTracker = z1ooonew.f11253v;
        if (velocityTracker == null) {
            z1ooonew.f11253v = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        z1ooonew.f11253v.addMovement(motionEvent);
        return true;
    }

    @Override // sk.d
    public int b() {
        return this.f4459c;
    }

    @Override // sk.d
    public boolean c(MotionEvent motionEvent) {
        z1OoOnew z1ooonew = (z1OoOnew) this.f4458b;
        sk.e eVar = z1ooonew.f11238a;
        if (eVar.f10151a != motionEvent.getPointerId(0)) {
            z1ooonew.o();
            z1ooonew.k(z1ooonew.e);
            return true;
        }
        if (z1ooonew.f11253v == null) {
            z1ooonew.f11253v = VelocityTracker.obtain();
        }
        z1ooonew.f11253v.addMovement(motionEvent);
        boolean z2 = z1ooonew.f11243i;
        tk.a aVar = z1ooonew.f11239b;
        if (z2 && !z1ooonew.f11244j && !z1ooonew.f11245k) {
            int[] iArr = new int[2];
            aVar.getView().getLocationOnScreen(iArr);
            z1ooonew.f11250r = (int) (motionEvent.getX(0) + iArr[0] + 0.5f);
            z1ooonew.f11251s = (int) (motionEvent.getY(0) + iArr[1] + 0.5f);
            return false;
        }
        View view = aVar.getView();
        sk.b bVar = (sk.b) this.f4460d;
        bVar.a(view, motionEvent, z1ooonew.f11241d);
        float f = 0.0f;
        float f4 = bVar.f10144a + (bVar.f10145b * z1ooonew.f(bVar.f10144a, bVar.f10145b, bVar.f10147d == eVar.f10152b, bVar.e > 0.0f));
        boolean z3 = eVar.f10152b;
        if ((!z3 || bVar.f10147d || f4 > 0.0f) && (z3 || !bVar.f10147d || f4 < 0.0f)) {
            f = f4;
        } else {
            z1ooonew.k(z1ooonew.f11240c);
        }
        z1ooonew.j(view, f);
        return true;
    }

    @Override // b8.f
    public void d(float f) {
        if (Float.compare(f, 0.0f) >= 0) {
            int i8 = this.f4459c + ((int) f);
            ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) this.f4460d;
            layoutParams.height = i8;
            ((AppBarLayout) this.f4458b).setLayoutParams(layoutParams);
        }
    }

    @Override // sk.d
    public void e(sk.d dVar) {
        this.f4459c = ((z1OoOnew) this.f4458b).f11238a.f10152b ? 1 : 2;
    }

    @Override // k2.b
    public Object execute() {
        ((i2.i) this.f4460d).f5552d.a((d2.d) this.f4458b, this.f4459c + 1, false);
        return null;
    }

    @Override // sk.d
    public boolean f(MotionEvent motionEvent) {
        z1OoOnew z1ooonew = (z1OoOnew) this.f4458b;
        z1ooonew.k(z1ooonew.e);
        VelocityTracker velocityTracker = z1ooonew.f11253v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            z1ooonew.f11253v = null;
        }
        Log.d("BounceEffect", "touch up overscroll");
        if (z1ooonew.f11243i && (z1ooonew.f11245k || z1ooonew.f11244j)) {
            return false;
        }
        tk.a aVar = z1ooonew.f11239b;
        if ((aVar.getView() instanceof ViewPager) || (aVar.getView() instanceof ViewPager2)) {
            return false;
        }
        if (!(aVar.getView() instanceof RecyclerView)) {
            return true;
        }
        ((RecyclerView) aVar.getView()).stopScroll();
        return true;
    }

    public byte[] h(int i8) {
        ((zc) this.f4458b).f6757h = Boolean.valueOf(1 == (i8 ^ 1));
        zc zcVar = (zc) this.f4458b;
        zcVar.f = Boolean.FALSE;
        ad adVar = new ad(zcVar);
        d2.a aVar = (d2.a) this.f4460d;
        aVar.f4257a = adVar;
        try {
            fe.b();
            fe feVar = fe.f6446c;
            if (i8 != 0) {
                ma maVar = new ma(aVar);
                u6.a aVar2 = new u6.a(8);
                feVar.a(aVar2);
                return new qf.c(new HashMap((HashMap) aVar2.f10378b), 9, new HashMap((HashMap) aVar2.f10379c), (y0) aVar2.f10380d).C(maVar);
            }
            ma maVar2 = new ma(aVar);
            s4.d dVar = new s4.d();
            feVar.a(dVar);
            dVar.f9505d = true;
            StringWriter stringWriter = new StringWriter();
            try {
                s4.e eVar = new s4.e(stringWriter, dVar.f9502a, dVar.f9503b, dVar.f9504c, dVar.f9505d);
                eVar.e(maVar2);
                eVar.g();
                eVar.f9507b.flush();
            } catch (IOException unused) {
            }
            return stringWriter.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    @Override // com.transsion.iotservice.multiscreen.pc.http.RequestCallback
    public void onResult(int i8, Object obj, String str) {
        SearchPageResponse searchPageResponse = (SearchPageResponse) obj;
        if (i8 != 0 || searchPageResponse == null) {
            Log.e("CacheDataSource", "checkFunctionGuideResourceUpdate failed, code: " + i8 + ", msg: " + str);
            return;
        }
        searchPageResponse.setLang((String) this.f4458b);
        jb.e eVar = (jb.e) this.f4460d;
        eVar.f6134b.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter("sp_search_check_update_time", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("sp_search_check_update_time", jCurrentTimeMillis);
        editorEdit.apply();
        Log.d("CacheDataSource", "checkFunctionGuideResourceUpdate success");
        l0.p(eVar, null, null, new jb.d(searchPageResponse, this.f4459c, eVar, null), 3);
    }

    public String toString() {
        switch (this.f4457a) {
            case 0:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(((l) this.f4460d) == l.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
                sb2.append(' ');
                sb2.append(this.f4459c);
                String str = (String) this.f4458b;
                if (str != null) {
                    sb2.append(' ');
                    sb2.append(str);
                }
                return sb2.toString();
            case 1:
                StringBuilder sb3 = new StringBuilder();
                sb3.append((String) this.f4458b);
                sb3.append("://");
                int i8 = -1;
                if (((String) this.f4460d).indexOf(58) != -1) {
                    sb3.append('[');
                    sb3.append((String) this.f4460d);
                    sb3.append(']');
                } else {
                    sb3.append((String) this.f4460d);
                }
                int i9 = this.f4459c;
                if (i9 == -1) {
                    String str2 = (String) this.f4458b;
                    if (str2.equals("http")) {
                        i9 = 80;
                    } else {
                        i9 = str2.equals("https") ? 443 : -1;
                    }
                }
                String str3 = (String) this.f4458b;
                if (str3.equals("http")) {
                    i8 = 80;
                } else if (str3.equals("https")) {
                    i8 = 443;
                }
                if (i9 != i8) {
                    sb3.append(':');
                    sb3.append(i9);
                }
                return sb3.toString();
            case 2:
            default:
                return super.toString();
            case 3:
                StringBuilder sb4 = new StringBuilder();
                if (((d0) this.f4460d) == d0.HTTP_1_0) {
                    sb4.append("HTTP/1.0");
                } else {
                    sb4.append("HTTP/1.1");
                }
                sb4.append(' ');
                sb4.append(this.f4459c);
                sb4.append(' ');
                sb4.append((String) this.f4458b);
                String string = sb4.toString();
                Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
                return string;
        }
    }

    public m(i2.i iVar, d2.d dVar, int i8) {
        this.f4457a = 2;
        this.f4460d = iVar;
        this.f4458b = dVar;
        this.f4459c = i8;
    }

    public /* synthetic */ m(Object obj, int i8, Object obj2, int i9) {
        this.f4457a = i9;
        this.f4460d = obj;
        this.f4459c = i8;
        this.f4458b = obj2;
    }

    public m(z1OoOnew z1ooonew) {
        this.f4457a = 9;
        this.f4458b = z1ooonew;
        this.f4460d = z1ooonew.l();
    }

    public m(d2.a aVar, int i8) {
        this.f4457a = 5;
        this.f4458b = new zc();
        this.f4460d = aVar;
        fe.b();
        this.f4459c = i8;
    }

    public m() {
        this.f4457a = 7;
        this.f4458b = ByteBuffer.allocate(4);
    }

    public m(d0 protocol, int i8, String message) {
        this.f4457a = 3;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        this.f4460d = protocol;
        this.f4459c = i8;
        this.f4458b = message;
    }

    public m(String str, jb.e eVar, int i8) {
        this.f4457a = 4;
        this.f4458b = str;
        this.f4460d = eVar;
        this.f4459c = i8;
    }
}
