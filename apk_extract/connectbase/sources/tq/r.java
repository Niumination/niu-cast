package tq;

import nq.g2;

/* JADX INFO: loaded from: classes3.dex */
@g2
public interface r<T> extends sq.i<T> {

    public static final class a {
        public static /* synthetic */ sq.i a(r rVar, um.g gVar, int i10, pq.i iVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i11 & 1) != 0) {
                gVar = um.i.INSTANCE;
            }
            if ((i11 & 2) != 0) {
                i10 = -3;
            }
            if ((i11 & 4) != 0) {
                iVar = pq.i.SUSPEND;
            }
            return rVar.c(gVar, i10, iVar);
        }
    }

    @os.l
    sq.i<T> c(@os.l um.g gVar, int i10, @os.l pq.i iVar);
}
