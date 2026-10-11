class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while (fast != null) {
        slow = slow?.next
        fast = fast.next
        if (fast == null) return false
        fast = fast.next

        if (slow == fast) return true
    }

    return false
}
