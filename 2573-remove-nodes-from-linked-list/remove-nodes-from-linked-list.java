class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        // Step 1: reverse
        head = reverse(head);

        int maxSoFar = head.val;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.val < maxSoFar) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                maxSoFar = curr.val;
            }
        }

        // Step 2: reverse again
        return reverse(head);
    }
}