package f3;

import kn.l0;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nBaseTransmissionChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseTransmissionChannel.kt\ncom/transsion/airtransfer/filetransfer/transmission/base/BaseTransmissionChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
public abstract class c<T> implements z2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z2.b<T> f5843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z2.a<T> f5844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5845c = true;

    @l
    public abstract z2.a<T> a();

    @l
    public abstract z2.b<T> b();

    public final boolean c() {
        return this.f5845c;
    }

    @Override // z2.c
    public void start() {
        this.f5845c = false;
        z2.b<T> bVarB = b();
        bVarB.start();
        this.f5843a = bVarB;
        z2.a<T> aVarA = a();
        aVarA.start();
        this.f5844b = aVarA;
    }

    @Override // z2.c
    public void stop() {
        this.f5845c = true;
        try {
            z2.b<T> bVar = this.f5843a;
            z2.a<T> aVar = null;
            if (bVar == null) {
                l0.S("sender");
                bVar = null;
            }
            bVar.stop();
            z2.a<T> aVar2 = this.f5844b;
            if (aVar2 == null) {
                l0.S("receiver");
            } else {
                aVar = aVar2;
            }
            aVar.stop();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
