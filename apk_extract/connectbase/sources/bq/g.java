package bq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import eo.m;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface g {

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f1060a = new a();

        @Override // bq.g
        public boolean a(@os.l m mVar, @os.l m mVar2) {
            l0.p(mVar, "what");
            l0.p(mVar2, TypedValues.TransitionType.S_FROM);
            return true;
        }
    }

    boolean a(@os.l m mVar, @os.l m mVar2);
}
