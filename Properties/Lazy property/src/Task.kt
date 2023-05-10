class LazyProperty(val initializer: () -> Int) {
    private var lazy_ = 0
    val lazy: Int
        get() {
            if(lazy_ == 0) {
                lazy_ = initializer()
            }
            return lazy_
        }
}
