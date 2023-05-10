class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        private var current = start
        override fun hasNext() = current <= end

        override fun next(): MyDate {
            val tmp = current
            current = current.followingDate()
            return tmp
        }

    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}