package one;

import java.util.Objects;

/**
 * 节点
 * @author hph
 */
public class Node {

    private String name;

    private Boolean isProcessed;

    public Node(String name) {
        this.name = name;
        this.isProcessed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public void setProcessed(Boolean processed) {
        isProcessed = processed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(name, node.name) &&
                Objects.equals(isProcessed, node.isProcessed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isProcessed);
    }
}
