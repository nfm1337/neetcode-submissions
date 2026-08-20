class TimeMap() {

    private val keyToValueTimestamp = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        keyToValueTimestamp[key] = (keyToValueTimestamp[key] ?: mutableListOf())
            .also { it.add(timestamp to value) }
    }

    fun get(key: String, timestamp: Int): String {
        val values = keyToValueTimestamp[key] ?: return ""
        var rangeStart = 0
        var rangeEnd = values.size - 1
        var result = ""

        while (rangeStart <= rangeEnd) {
            val midIndex = rangeStart + (rangeEnd - rangeStart) / 2
            if (values[midIndex].first == timestamp) {
                return values[midIndex].second
            } else if (values[midIndex].first < timestamp) {
                result = values[midIndex].second
                rangeStart = midIndex + 1
            } else {
                rangeEnd = midIndex - 1
            }
        }
        
        return result
    }
}