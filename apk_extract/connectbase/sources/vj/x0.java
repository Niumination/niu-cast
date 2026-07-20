package vj;

import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes2.dex */
@t0
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vj.a.c<x0> f17506a = new vj.a.c<>("internal:io.grpc.config-selector");

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y2 f17507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.j
        public l f17509c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f17510a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public l f17511b;

            public a() {
            }

            public b a() {
                c1.h0.h0(this.f17510a != null, "config is not set");
                return new b(y2.f17548e, this.f17510a, this.f17511b);
            }

            public a b(Object obj) {
                this.f17510a = c1.h0.F(obj, "config");
                return this;
            }

            public a c(l lVar) {
                this.f17511b = (l) c1.h0.F(lVar, "interceptor");
                return this;
            }

            public a(a aVar) {
            }
        }

        public static b a(y2 y2Var) {
            c1.h0.e(!y2Var.r(), "status is OK");
            return new b(y2Var, null, null);
        }

        public static a e() {
            return new a();
        }

        public Object b() {
            return this.f17508b;
        }

        @gm.j
        public l c() {
            return this.f17509c;
        }

        public y2 d() {
            return this.f17507a;
        }

        public b(y2 y2Var, Object obj, l lVar) {
            this.f17507a = (y2) c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS);
            this.f17508b = obj;
            this.f17509c = lVar;
        }
    }

    public abstract b a(o1.h hVar);
}
