import kotlin.math.min

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
  if (list1 == null && list2 == null) return null
  val merged = ListNode()

  var list1Next = list1
  var list2Next = list2
  var lastNode = merged

  val minValue = min(list1?.`val` ?: Int.MAX_VALUE, list2?.`val` ?: Int.MAX_VALUE)
  merged.`val` = minValue
  if (minValue == (list1?.`val` ?: Int.MAX_VALUE)) list1Next = list1Next!!.next
  else list2Next = list2Next!!.next

  while (list1Next != null || list2Next != null) {
    if (list1Next == null || (list2Next != null && list2Next.`val` <= list1Next.`val`)) {
      lastNode.next = list2Next
      lastNode = lastNode.next!!
      list2Next = list2Next!!.next
    } else {
      lastNode.next = list1Next
      lastNode = lastNode.next!!
      list1Next = list1Next.next
    }
  }

  return merged
}

fun main() {
  val list1 = ListNode(1)
  val list2 = ListNode(1)
  list1.next = ListNode(2)
  list1.next!!.next = ListNode(4)
  list2.next = ListNode(3)
  list2.next!!.next = ListNode(4)

  var lastNode = mergeTwoLists(list1, list2)
  while (lastNode != null) {
    print("${lastNode.`val`} ")
    lastNode = lastNode.next
  }
}