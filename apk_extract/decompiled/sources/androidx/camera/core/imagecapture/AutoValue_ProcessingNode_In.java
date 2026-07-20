package androidx.camera.core.imagecapture;

import androidx.camera.core.processing.Edge;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_ProcessingNode_In extends ProcessingNode.In {
    private final Edge<ProcessingNode.InputPacket> edge;
    private final int format;

    public AutoValue_ProcessingNode_In(Edge<ProcessingNode.InputPacket> edge, int i8) {
        if (edge == null) {
            throw new NullPointerException("Null edge");
        }
        this.edge = edge;
        this.format = i8;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProcessingNode.In)) {
            return false;
        }
        ProcessingNode.In in = (ProcessingNode.In) obj;
        return this.edge.equals(in.getEdge()) && this.format == in.getFormat();
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public Edge<ProcessingNode.InputPacket> getEdge() {
        return this.edge;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public int getFormat() {
        return this.format;
    }

    public int hashCode() {
        return this.format ^ ((this.edge.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("In{edge=");
        sb2.append(this.edge);
        sb2.append(", format=");
        return h0.a.m(sb2, "}", this.format);
    }
}
