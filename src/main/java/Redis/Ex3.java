package Redis;

import redis.clients.jedis.Jedis;

public class Ex3 {

  public static void main(String[] args) throws InterruptedException {
    String cacheKey = "cachekey";
    Jedis jedis = new Jedis("localhost");
    // adding a new key
    jedis.set(cacheKey, "cached value");
    // setting the TTL in seconds
    jedis.expire(cacheKey, 15);
    // Getting the remaining ttl
    System.out.println("TTL:" + jedis.ttl(cacheKey));
    Thread.sleep(1000);
    System.out.println("TTL:" + jedis.ttl(cacheKey));
    // Getting the cache value
    System.out.println("Cached Value:" + jedis.get(cacheKey));

    // Wait for the TTL finishs
    Thread.sleep(15000);

    // trying to get the expired key
    System.out.println("Expired Key:" + jedis.get(cacheKey));
  }


}
