package w5;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.mirror.source.bean.PadMotionEventBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k4.m;
import z4.k;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f18173f = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MotionEvent.PointerProperties[] f18175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MotionEvent.PointerCoords[] f18176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f18177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m4.c f18178e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f18179a = new h();
    }

    public static h h() {
        return a.f18179a;
    }

    public MotionEvent a(byte[] bArr, k kVar) {
        return k(PadMotionEventBean.CREATOR.a(bArr), kVar);
    }

    public x5.a b(byte[] bArr, k kVar) {
        if (kVar == null) {
            m.c(f18173f, "bytes2GameKeymapEvent: display  error");
            return null;
        }
        r4.d dVarB = kVar.f().b();
        int iA = kVar.h() ? 0 : kVar.a();
        int iH = k4.c.h(Arrays.copyOfRange(bArr, 0, 4));
        double dE = k4.c.e(Arrays.copyOfRange(bArr, 4, 12));
        double dE2 = k4.c.e(Arrays.copyOfRange(bArr, 12, 20));
        x5.a aVar = new x5.a(iH, (float) (dE * ((double) (iA == 0 ? w4.c.j(SourceApplication.b()) : w4.c.k(dVarB)))), iA == 0 ? (float) (dE2 * ((double) w4.c.c(SourceApplication.b()))) : ((float) dE2) * w4.c.d(dVarB), iA, k4.c.h(Arrays.copyOfRange(bArr, 22, 26)), k4.c.m(Arrays.copyOfRange(bArr, 20, 22)));
        m.b(f18173f, "bytes2GameKeymapEvent" + aVar);
        return aVar;
    }

    public List<KeyEvent> c(byte[] bArr, k kVar) {
        long j10 = k4.c.j(Arrays.copyOfRange(bArr, 0, 8));
        long j11 = k4.c.j(Arrays.copyOfRange(bArr, 8, 16));
        int iH = k4.c.h(Arrays.copyOfRange(bArr, 16, 20));
        int iH2 = k4.c.h(Arrays.copyOfRange(bArr, 20, 24));
        int iH3 = k4.c.h(Arrays.copyOfRange(bArr, 24, 28));
        int iH4 = k4.c.h(Arrays.copyOfRange(bArr, 28, 32));
        String str = f18173f;
        StringBuilder sbA = j.b.a("handleKeyEvent: down:", j10, ",eve:");
        sbA.append(j11);
        sbA.append(",action:");
        sbA.append(iH);
        sbA.append(",key:");
        sbA.append(iH2);
        sbA.append("repeatCount:");
        sbA.append(iH3);
        sbA.append(",metaState:");
        sbA.append(iH4);
        m.b(str, sbA.toString());
        return i(iH2, iH4, kVar);
    }

    @Nullable
    public MotionEvent d(byte[] bArr, k kVar) {
        if (kVar == null) {
            m.c(f18173f, "onUibcData: display  error");
            return null;
        }
        String str = f18173f;
        m.e(str, "handle uibc with:" + kVar.a());
        r4.d dVarB = kVar.f().b();
        int iA = kVar.a();
        if (kVar.h()) {
            iA = 0;
        }
        long jK = k4.c.k(Arrays.copyOfRange(bArr, 0, 8));
        long jK2 = k4.c.k(Arrays.copyOfRange(bArr, 8, 16));
        int iH = k4.c.h(Arrays.copyOfRange(bArr, 16, 20));
        int iH2 = k4.c.h(Arrays.copyOfRange(bArr, 20, 24));
        int iH3 = k4.c.h(Arrays.copyOfRange(bArr, 24, 28));
        float fG = k4.c.g(Arrays.copyOfRange(bArr, 28, 32));
        float fG2 = k4.c.g(Arrays.copyOfRange(bArr, 32, 36));
        int iH4 = k4.c.h(Arrays.copyOfRange(bArr, 36, 40));
        int iH5 = k4.c.h(Arrays.copyOfRange(bArr, 40, 44));
        int iH6 = k4.c.h(Arrays.copyOfRange(bArr, 44, 48));
        int iH7 = k4.c.h(Arrays.copyOfRange(bArr, 52, 56));
        byte b10 = bArr[56];
        int i10 = iA;
        double dE = k4.c.e(Arrays.copyOfRange(bArr, 57, 65));
        double dE2 = k4.c.e(Arrays.copyOfRange(bArr, 65, 73));
        short sM = k4.c.m(Arrays.copyOfRange(bArr, 73, 75));
        StringBuilder sbA = j.b.a("handleMotionEvent: downTime:", jK, ",eventTime:");
        sbA.append(jK2);
        sbA.append(",action:");
        sbA.append(iH);
        sbA.append(",metaState:");
        sbA.append(iH2);
        sbA.append(",buttonState:");
        sbA.append(iH3);
        sbA.append(",xPrecision:");
        sbA.append(fG);
        sbA.append(",yPrecision:");
        sbA.append(fG2);
        sbA.append(",deviceId:");
        sbA.append(iH4);
        sbA.append(",edgeFlags:");
        sbA.append(iH5);
        sbA.append(",source:");
        sbA.append(iH6);
        sbA.append(",displayId:");
        sbA.append(i10);
        sbA.append(",flags:");
        sbA.append(iH7);
        sbA.append(",pointCounts:");
        sbA.append((int) b10);
        sbA.append(",xRatio:");
        sbA.append(dE);
        sbA.append(",yRatio:");
        sbA.append(dE2);
        sbA.append(",zDelta:");
        sbA.append((int) sM);
        m.e(str, sbA.toString());
        if (iH == 8) {
            return m(new x5.d(jK, SystemClock.uptimeMillis(), iH, iH2, iH3, fG, fG2, iH4, iH5, iH6, i10, iH7, ((float) dE) * w4.c.k(dVarB), ((float) dE2) * w4.c.d(dVarB), kVar.h(), sM));
        }
        if (iH == 0) {
            this.f18174a = SystemClock.uptimeMillis();
        }
        return l(new x5.c(this.f18174a, SystemClock.uptimeMillis(), iH, (float) (dE * ((double) (i10 == 0 ? w4.c.j(SourceApplication.b()) : w4.c.k(dVarB)))), i10 == 0 ? (float) (dE2 * ((double) w4.c.c(SourceApplication.b()))) : ((float) dE2) * w4.c.d(dVarB), i10, kVar.h()));
    }

    public boolean e(KeyEvent keyEvent) {
        if ((keyEvent.getMetaState() & 4096) != 0) {
            return keyEvent.getKeyCode() == 29 || keyEvent.getKeyCode() == 31 || keyEvent.getKeyCode() == 52 || keyEvent.getKeyCode() == 50;
        }
        return keyEvent.getKeyCode() == 67 || keyEvent.getKeyCode() == 124 || keyEvent.getKeyCode() == 21 || keyEvent.getKeyCode() == 22 || keyEvent.getKeyCode() == 19 || keyEvent.getKeyCode() == 20 || keyEvent.getKeyCode() == 92 || keyEvent.getKeyCode() == 93 || keyEvent.getKeyCode() == 122 || keyEvent.getKeyCode() == 123 || keyEvent.getKeyCode() == 112 || keyEvent.getKeyCode() == 66;
    }

    public boolean f(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 82 || keyEvent.getKeyCode() == 3 || keyEvent.getKeyCode() == 187 || keyEvent.getKeyCode() == 4;
    }

    public void g() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent.PointerProperties[] pointerPropertiesArr = {new MotionEvent.PointerProperties()};
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[0];
        pointerCoords.x = 0.0f;
        pointerCoords.y = 0.0f;
        MotionEvent.PointerProperties pointerProperties = pointerPropertiesArr[0];
        pointerProperties.id = 0;
        pointerProperties.toolType = 1;
        f fVar = f.a.f18172a;
        fVar.f(this.f18178e.s(jUptimeMillis, SystemClock.uptimeMillis(), 0, 1, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0, m4.a.C0275a.f10375a.q()));
        fVar.f(this.f18178e.s(jUptimeMillis, SystemClock.uptimeMillis(), 1, 1, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0, m4.a.C0275a.f10375a.q()));
    }

    public List<KeyEvent> i(int i10, int i11, k kVar) {
        String str = f18173f;
        m.b(str, "getKeyEvent: keyCode:" + i10 + ",metaState:" + i11);
        if (kVar == null) {
            return null;
        }
        int iA = kVar.a();
        if (kVar.h()) {
            iA = 0;
        }
        x5.b bVar = new x5.b(this.f18177d.a(i10), 0, i11, iA);
        x5.b bVar2 = new x5.b(this.f18177d.a(i10), 1, i11, iA);
        ArrayList arrayList = new ArrayList();
        arrayList.add(j(bVar));
        arrayList.add(j(bVar2));
        m.b(str, "downEventBean: " + bVar);
        m.b(str, "upEventBean: " + bVar2);
        return arrayList;
    }

    public final KeyEvent j(x5.b bVar) {
        KeyEvent keyEvent = new KeyEvent(bVar.b(), bVar.c());
        if (bVar.e() == -1) {
            bVar.i(keyEvent.getMetaState());
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        return this.f18178e.o(jUptimeMillis - 50, jUptimeMillis, bVar.b(), bVar.c(), keyEvent.getRepeatCount(), bVar.e(), keyEvent.getDeviceId(), keyEvent.getScanCode(), keyEvent.getFlags(), keyEvent.getSource(), bVar.d(), keyEvent.getCharacters());
    }

    public final MotionEvent k(PadMotionEventBean padMotionEventBean, k kVar) {
        if (kVar == null || kVar.g() == null) {
            return null;
        }
        return padMotionEventBean.p(kVar.g(), kVar.h());
    }

    public final MotionEvent l(x5.c cVar) {
        m.b(f18173f, " double x :" + cVar.e() + " double y :" + cVar.f());
        MotionEvent.PointerProperties[] pointerPropertiesArr = {new MotionEvent.PointerProperties()};
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        pointerCoordsArr[0].x = cVar.e();
        pointerCoordsArr[0].y = cVar.f();
        MotionEvent.PointerProperties pointerProperties = pointerPropertiesArr[0];
        pointerProperties.id = 0;
        pointerProperties.toolType = 1;
        MotionEvent motionEventS = this.f18178e.s(cVar.c(), cVar.d(), cVar.a(), 1, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, m4.a.C0275a.f10375a.A(4098), 0, 4098, cVar.b(), 0);
        this.f18178e.C(motionEventS);
        return motionEventS;
    }

    public final MotionEvent m(x5.d dVar) {
        m.b(f18173f, " mouseWheelEvent: double x :" + dVar.k() + " double y :" + dVar.m());
        MotionEvent.PointerProperties[] pointerPropertiesArr = {new MotionEvent.PointerProperties()};
        pointerPropertiesArr[0].clear();
        MotionEvent.PointerProperties pointerProperties = pointerPropertiesArr[0];
        pointerProperties.id = 0;
        pointerProperties.toolType = 3;
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        pointerCoordsArr[0].setAxisValue(9, dVar.o() > 0 ? 1.0f : -1.0f);
        pointerCoordsArr[0].x = dVar.k();
        pointerCoordsArr[0].y = dVar.m();
        MotionEvent motionEventS = this.f18178e.s(dVar.e(), dVar.g(), dVar.a(), 1, pointerPropertiesArr, pointerCoordsArr, dVar.i(), dVar.b(), dVar.l(), dVar.n(), dVar.c(), dVar.f(), 8194, dVar.d(), dVar.h());
        this.f18178e.C(motionEventS);
        return motionEventS;
    }

    public h() {
        this.f18174a = 0L;
        MotionEvent.PointerProperties[] pointerPropertiesArr = {new MotionEvent.PointerProperties()};
        this.f18175b = pointerPropertiesArr;
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        this.f18176c = pointerCoordsArr;
        this.f18177d = new w5.a();
        this.f18178e = m4.a.C0275a.f10375a;
        pointerPropertiesArr[0].toolType = 1;
        MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[0];
        pointerCoords.orientation = 0.0f;
        pointerCoords.size = 0.0f;
    }
}
