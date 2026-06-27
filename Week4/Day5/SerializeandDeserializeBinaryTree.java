public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        build(root, result);
        return result.toString();
    }

    private void build(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("null,");
            return;
        }

        result.append(node.val).append(",");
        build(node.left, result);
        build(node.right, result);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return create(queue);
    }

    private TreeNode create(Queue<String> queue) {
        String value = queue.poll();

        if (value.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = create(queue);
        node.right = create(queue);

        return node;
    }
}