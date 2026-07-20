package wl;

import java.nio.ByteBuffer;
import kn.l0;
import pl.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final m f19728b = new m();

    @Override // pl.b0
    @os.m
    public ByteBuffer b(int i10, int i11) {
        return null;
    }

    @Override // pl.b0
    public void b0(int i10) {
        if (i10 > 0) {
            throw new IllegalStateException(k.b.a("Unable to mark ", i10, " bytes consumed for already terminated channel"));
        }
    }

    @Override // pl.d0
    @os.m
    public Object w(int i10, @os.l um.d<? super Boolean> dVar) {
        if (i10 < 0) {
            throw new IllegalArgumentException(l0.C("atLeast parameter shouldn't be negative: ", new Integer(i10)).toString());
        }
        if (i10 <= 4088) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException(l0.C("atLeast parameter shouldn't be larger than max buffer size of 4088: ", new Integer(i10)).toString());
    }
}
