package leetcode

import java.util.PriorityQueue

fun main() {
//    val t = Twitter()
//    t.postTweet(1,5)
//    println(t.getNewsFeed(1))
//    t.follow(1,2)
//    t.postTweet(2, 6)
//    println(t.getNewsFeed(1))
//    t.unfollow(1,2)
//    println(t.getNewsFeed(1))

    val t2 = Twitter()
    t2.postTweet(1, 5)
    t2.postTweet(2, 3)
    t2.postTweet(1, 101)
    t2.postTweet(2, 13)
    t2.postTweet(2, 10)
    t2.postTweet(1, 2)
    t2.postTweet(1, 94)
    t2.postTweet(2, 505)
    t2.postTweet(1, 333)
    t2.postTweet(2, 22)
    t2.postTweet(1, 11)
    t2.postTweet(1, 205)
    t2.postTweet(2, 203)
    t2.postTweet(1, 201)
    t2.postTweet(2, 213)
    t2.postTweet(1, 200)
    t2.postTweet(2, 202)
    t2.postTweet(1, 204)
    t2.postTweet(2, 208)
    t2.postTweet(2, 233)
    t2.postTweet(1, 222)
    t2.postTweet(2, 211)
    println(t2.getNewsFeed(1))
    t2.follow(1, 2)
    println(t2.getNewsFeed(1))
    t2.unfollow(1, 2)
    println(t2.getNewsFeed(1))

    val t3 = Twitter()
    t3.postTweet(1, 5)
    t3.postTweet(1, 3)
    t3.postTweet(1, 101)
    t3.postTweet(1, 13)
    t3.postTweet(1, 10)
    t3.postTweet(1, 2)
    t3.postTweet(1, 94)
    t3.postTweet(1, 505)
    t3.postTweet(1, 333)
    println(t3.getNewsFeed(1))
}

class Twitter() {
    class Tweet(val id: Int, val timestamp: Int)

    class User(val id: Int) {
        val follows = mutableSetOf<User>()
        val tweets = mutableListOf<Tweet>()

        fun tweet(tweetId: Int, timestamp: Int) {
            tweets.add(Tweet(tweetId, timestamp))
        }

        fun getTweetsForNewsfeed(): List<Tweet> {
            return tweets.takeLast(10)
        }

        fun getNewsfeed(): List<Int> {
            val queue = PriorityQueue<Tweet>(compareByDescending { it.timestamp })
            getTweetsForNewsfeed().forEach { queue.add(it) }
            follows.forEach { f -> f.getTweetsForNewsfeed().forEach { queue.add(it) } }
            val result = mutableListOf<Int>()
            var id = 0
            while (id < 10 && queue.isNotEmpty()) {
                result.add(queue.poll().id)
                id++
            }
            return result
        }
    }
    var globalTimestamp = 0

    val users = mutableMapOf<Int, User>()

    fun postTweet(userId: Int, tweetId: Int) {
        getUser(userId).tweet(tweetId, globalTimestamp++)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        return getUser(userId).getNewsfeed()
    }

    fun follow(followerId: Int, followeeId: Int) {
        getUser(followerId).follows.add(getUser(followeeId))
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        getUser(followerId).follows.remove(getUser(followeeId))
    }

    private fun getUser(userId: Int): User {
        return users.getOrPut(userId) { User(userId)}
    }
}