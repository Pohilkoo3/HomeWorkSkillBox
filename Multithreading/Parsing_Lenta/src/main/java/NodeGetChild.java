import java.util.*;
import java.util.concurrent.RecursiveTask;

public class NodeGetChild extends RecursiveTask<Set<String>> {
    private Node node;

    public NodeGetChild(String path) {
        this.node = new Node(path);
        node.makeChildren();

    }

    @Override
    protected Set<String> compute() {
        TreeSet<String> result = new TreeSet<>();
        result.addAll(node.getNodesChild());
        List<NodeGetChild> nodeGetChildren = new ArrayList<>();
        for (String element : node.getNodesChild()) {
            NodeGetChild task = new NodeGetChild(element);
            task.fork();
            nodeGetChildren.add(task);
        }
        for (NodeGetChild task : nodeGetChildren) {
            result.addAll(task.join());
        }
        return result;
    }
}


