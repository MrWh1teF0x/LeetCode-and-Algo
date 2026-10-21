class ListNode(var `val`: Int = 0, var next: ListNode? = null)

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current: ListNode? = dummy
    var carry = 0
    var a = l1
    var b = l2

    while (a != null || b != null || carry != 0) {
        var sum = carry

        a?.let {
            sum += it.`val`
            a = it.next
        }
        b?.let {
            sum += it.`val`
            b = it.next
        }

        carry = sum / 10
        current?.next = ListNode(sum % 10)
        current = current?.next
    }

    return dummy.next
}
