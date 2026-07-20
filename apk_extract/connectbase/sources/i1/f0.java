package i1;

/* JADX INFO: loaded from: classes.dex */
@w
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7535a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7536b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7537c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f7538d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7539e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7540f = "Node %s is not an element of this graph.";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7541g = "Edge %s is not an element of this graph.";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7542h = "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7543i = "Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f7544j = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f7545k = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f7546l = "Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7547m = "Edge %s already exists in the graph.";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7548n = "Mismatch: endpoints' ordering is not compatible with directionality of the graph";

    public enum a {
        EDGE_EXISTS;

        public static /* synthetic */ a[] a() {
            return new a[]{EDGE_EXISTS};
        }
    }
}
