package k5;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.transsion.streamServer.IServerConnectCallback;
import com.transsion.streamServer.IServerCreateCallback;
import com.transsion.streamServer.IServerDisconnectCallback;
import com.transsion.streamServer.IServerStreamClose;
import com.transsion.streamServer.IServerStreamData;
import com.transsion.streamServer.StreamServer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9017e = "ExtendScreenController";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StreamServer f9020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i6.a f9021d;

    public static class a extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<b> f9022f;

        public a(List<b> list) {
            super(list.get(0).f9026a, list.get(0).mAction, list.get(0).f9027b);
            this.f9022f = list;
        }

        @Override // k5.j.b
        public void i(int i10) {
            super.i(i10);
            List<b> list = this.f9022f;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<b> it = this.f9022f.iterator();
            while (it.hasNext()) {
                it.next().i(i10);
            }
        }

        @Override // k5.j.b
        public byte[] k() {
            List<b> list = this.f9022f;
            if (list == null || list.isEmpty()) {
                return new byte[0];
            }
            byte[] bArr = new byte[this.f9022f.size() * 33];
            for (int i10 = 0; i10 < this.f9022f.size(); i10++) {
                byte[] bArrK = this.f9022f.get(i10).k();
                System.arraycopy(bArrK, 0, bArr, i10 * 33, bArrK.length);
            }
            return bArr;
        }

        @Override // k5.j.b
        @NonNull
        public String toString() {
            return "ExtendEvent{events=" + this.f9022f + ", id=" + e() + ", timestamp=" + f() + ", action=" + d() + ", type=" + ((int) g()) + rs.f.f14860b;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final byte f9023c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final byte f9024d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte f9025e = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @w1.a(deserialize = false, serialize = false)
        public final long f9026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte f9027b;

        @SerializedName(k4.f.f8937e)
        private int mAction;

        @SerializedName(dc.d.f3692w)
        private int mId;

        public b(long j10, int i10, byte b10) {
            this.f9026a = j10;
            this.mAction = i10;
            this.f9027b = b10;
        }

        public int d() {
            return this.mAction;
        }

        public int e() {
            return this.mId;
        }

        public long f() {
            return this.f9026a;
        }

        public byte g() {
            return this.f9027b;
        }

        public void h(int i10) {
            this.mAction = i10;
        }

        public void i(int i10) {
            this.mId = i10;
        }

        public void j(byte b10) {
            this.f9027b = b10;
        }

        public abstract byte[] k();

        @NonNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder("InputEvent{id=");
            sb2.append(this.mId);
            sb2.append(", timestamp=");
            sb2.append(this.f9026a);
            sb2.append(", action=");
            sb2.append(this.mAction);
            sb2.append(", type=");
            return u.a.a(sb2, this.f9027b, rs.f.f14860b);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f9028a = new j();
    }

    public static class e extends b {

        @SerializedName("data")
        private final int mData;

        @SerializedName("pointer_id")
        private final int mPointerId;

        @SerializedName(k4.f.f8938f)
        private final double mXRatio;

        @SerializedName(k4.f.f8939g)
        private final double mYRatio;

        public e(long j10, int i10, double d10, double d11, int i11, int i12) {
            super(j10, i10, (byte) 2);
            this.mXRatio = d10;
            this.mYRatio = d11;
            this.mData = i11;
            m2.b.a("TouchEvent: pointerId:", i12, j.f9017e);
            this.mPointerId = i12;
        }

        @Override // k5.j.b
        public byte[] k() {
            byte[] bArr = new byte[33];
            byte[] bArrQ = k4.c.q(e());
            byte[] bArrQ2 = k4.c.q(d());
            byte[] bArrO = k4.c.o(this.mXRatio);
            byte[] bArrO2 = k4.c.o(this.mYRatio);
            byte[] bArrQ3 = k4.c.q(this.mData);
            byte[] bArrQ4 = k4.c.q(this.mPointerId);
            System.arraycopy(bArrQ, 0, bArr, 0, bArrQ.length);
            bArr[4] = 2;
            System.arraycopy(bArrQ2, 0, bArr, 5, bArrQ2.length);
            System.arraycopy(bArrO, 0, bArr, 9, bArrO.length);
            System.arraycopy(bArrO2, 0, bArr, 17, bArrO2.length);
            System.arraycopy(bArrQ3, 0, bArr, 25, bArrQ3.length);
            System.arraycopy(bArrQ4, 0, bArr, 29, bArrQ4.length);
            return bArr;
        }

        @Override // k5.j.b
        @NonNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder("TouchEvent{id=");
            sb2.append(e());
            sb2.append(", timestamp=");
            sb2.append(f());
            sb2.append(", action=");
            sb2.append(d());
            sb2.append(", xRatio=");
            sb2.append(this.mXRatio);
            sb2.append(", yRatio=");
            sb2.append(this.mYRatio);
            sb2.append(", data=");
            sb2.append(this.mData);
            sb2.append(", pointerId=");
            return u.a.a(sb2, this.mPointerId, rs.f.f14860b);
        }
    }

    public static /* synthetic */ void e(int i10, String str) {
    }

    public static /* synthetic */ void f(long j10, byte[] bArr) {
    }

    public static j k() {
        return c.f9028a;
    }

    public static /* synthetic */ void m(long j10, byte[] bArr) {
    }

    public static /* synthetic */ void o() {
        k4.m.e(f9017e, "[EXTEND] control service  created");
        v4.g.e().o(o2.a.f12066a);
    }

    public static /* synthetic */ void q(IServerStreamData iServerStreamData, IServerStreamClose iServerStreamClose, IServerCreateCallback iServerCreateCallback, IServerConnectCallback iServerConnectCallback) {
        StreamServer.getInstance().createWaitConnect(o2.a.f12066a, 1000.0f, iServerStreamData, iServerStreamClose, iServerCreateCallback, iServerConnectCallback);
    }

    public static /* synthetic */ void r(int i10, String str) {
        k4.m.e(f9017e, "[EXTEND] control servicerelease->disconnect:code:" + i10 + ",info:" + str);
    }

    public static /* synthetic */ void t(int i10, String str) {
    }

    public void i() {
        k4.m.b(f9017e, "[EXTEND] connectToControl: ");
        if (this.f9018a) {
            k4.m.e(f9017e, "[EXTEND] control connect:already connected");
            return;
        }
        final k5.c cVar = new k5.c();
        final IServerStreamClose iServerStreamClose = new IServerStreamClose() { // from class: k5.d
            @Override // com.transsion.streamServer.IServerStreamClose
            public final void closeListener(long j10) {
                this.f8990a.n(j10);
            }
        };
        final k5.e eVar = new k5.e();
        final IServerConnectCallback iServerConnectCallback = new IServerConnectCallback() { // from class: k5.f
            @Override // com.transsion.streamServer.IServerConnectCallback
            public final void onSuccess(int i10, long j10, String str) {
                this.f9010a.p(i10, j10, str);
            }
        };
        this.f9021d.a(new Runnable() { // from class: k5.g
            @Override // java.lang.Runnable
            public final void run() {
                j.q(cVar, iServerStreamClose, eVar, iServerConnectCallback);
            }
        });
    }

    public void j() {
        k4.m.e(f9017e, "[EXTEND] control disconnect release:" + this.f9019b);
        this.f9018a = false;
        if (this.f9019b != -1) {
            final h hVar = new h();
            this.f9021d.a(new Runnable() { // from class: k5.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9015a.s(hVar);
                }
            });
        }
    }

    public void l(@NonNull b bVar) {
        k4.m.b(f9017e, "[EXTEND] injectInputEvent:" + bVar);
        if (this.f9018a) {
            long j10 = this.f9019b;
            if (j10 > 0) {
                this.f9020c.sendBuffer(j10, bVar.k(), new k5.b());
                return;
            }
        }
        k4.m.e(f9017e, "[EXTEND] injectInputEvent:control port not connected");
    }

    public final /* synthetic */ void n(long j10) {
        this.f9018a = false;
        this.f9019b = -1L;
        k4.m.e(f9017e, "[EXTEND] control ServerStream closed serviceId: " + j10);
    }

    public final /* synthetic */ void p(int i10, long j10, String str) {
        k4.m.e(f9017e, "[EXTEND] control service connectToControl: serviceId: " + j10 + "  info: " + str + " code:" + i10);
        if (i10 == 0) {
            this.f9018a = true;
            this.f9019b = j10;
        } else {
            this.f9018a = false;
            this.f9019b = -1L;
        }
    }

    public final /* synthetic */ void s(IServerDisconnectCallback iServerDisconnectCallback) {
        StreamServer.getInstance().disconnect(this.f9019b, iServerDisconnectCallback);
        this.f9019b = -1L;
    }

    public j() {
        this.f9018a = false;
        this.f9019b = -1L;
        this.f9020c = StreamServer.getInstance();
        this.f9021d = i6.a.b.f7724a;
    }

    public static class d extends b {

        @SerializedName("data")
        private int mData;

        @SerializedName(k4.f.f8938f)
        private final double mXRatio;

        @SerializedName(k4.f.f8939g)
        private final double mYRatio;

        public d(long j10, int i10, double d10, double d11) {
            super(j10, i10, (byte) 0);
            this.mXRatio = d10;
            this.mYRatio = d11;
        }

        @Override // k5.j.b
        public byte[] k() {
            byte[] bArr = new byte[29];
            byte[] bArrQ = k4.c.q(e());
            byte[] bArrQ2 = k4.c.q(d());
            byte[] bArrO = k4.c.o(this.mXRatio);
            byte[] bArrO2 = k4.c.o(this.mYRatio);
            byte[] bArrQ3 = k4.c.q(this.mData);
            System.arraycopy(bArrQ, 0, bArr, 0, bArrQ.length);
            bArr[4] = 0;
            System.arraycopy(bArrQ2, 0, bArr, 5, bArrQ2.length);
            System.arraycopy(bArrO, 0, bArr, 9, bArrO.length);
            System.arraycopy(bArrO2, 0, bArr, 17, bArrO2.length);
            System.arraycopy(bArrQ3, 0, bArr, 25, bArrQ3.length);
            return bArr;
        }

        @Override // k5.j.b
        public String toString() {
            StringBuilder sb2 = new StringBuilder("MouseEvent{id=");
            sb2.append(e());
            sb2.append(", timestamp=");
            sb2.append(f());
            sb2.append(", action=");
            sb2.append(d());
            sb2.append(", xRatio=");
            sb2.append(this.mXRatio);
            sb2.append(", yRatio=");
            sb2.append(this.mYRatio);
            sb2.append(",data=");
            return u.a.a(sb2, this.mData, rs.f.f14860b);
        }

        public d(long j10, int i10, double d10, double d11, int i11) {
            super(j10, i10, (byte) 0);
            this.mXRatio = d10;
            this.mYRatio = d11;
            this.mData = i11;
        }

        public d(int i10, long j10, int i11, double d10, double d11) {
            super(j10, i11, (byte) 0);
            this.mXRatio = d10;
            this.mYRatio = d11;
            i(i10);
        }
    }
}
