package t5;

import com.transsion.aiotlink.IStreamDataListener;
import com.transsion.aiotlink.NativeLinkManager;
import java.util.List;
import k4.j;
import k4.m;
import n2.w;
import q4.e;
import v4.g;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b<e> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f15475o = "AudioSender";

    /* JADX INFO: renamed from: t5.a$a, reason: collision with other inner class name */
    public class C0401a implements IStreamDataListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15476a;

        public C0401a(int i10) {
            this.f15476a = i10;
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onClose() {
            m.e(a.f15475o, "audio closed");
            a.this.f15487c.c(this.f15476a);
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onConnect(int i10) {
            m.e(a.f15475o, "on audio channel connected");
            a aVar = a.this;
            aVar.f15489e = true;
            aVar.f15488d = 1;
            b.C0402b c0402b = aVar.f15490f;
            if (c0402b != null) {
                c0402b.a();
            }
            a.this.f();
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onReceiveData(byte[] bArr, int i10, int i11) {
        }

        @Override // com.transsion.aiotlink.IStreamDataListener
        public void onStartServer() {
            m.e(a.f15475o, "audio onStartServer");
            NativeLinkManager.a().sendTccpRequest(g.f16533e, j.a.f8962a.g(new w(1, 1, 1, this.f15476a, new w.a(2, 44100, 2, 16))));
        }
    }

    public a(e eVar, v4.d dVar) {
        super(eVar, dVar);
    }

    @Override // t5.b
    public void d(byte[] bArr) {
        this.f15487c.n(bArr);
    }

    @Override // t5.b
    public void g() {
        super.g();
        this.f15487c.c(this.f15486b);
    }

    public void h(boolean z10) {
        ((e) this.f15485a).i(z10);
    }

    public void i(int i10) {
        this.f15486b = i10;
        this.f15487c.f(i10, new C0401a(i10));
    }

    public void j(List<String> list) {
        ((e) this.f15485a).e(list);
    }
}
