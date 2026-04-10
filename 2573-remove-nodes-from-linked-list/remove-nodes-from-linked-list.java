class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;

        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }

        // rebuild linked list from stack
        ListNode newHead = null;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }
}