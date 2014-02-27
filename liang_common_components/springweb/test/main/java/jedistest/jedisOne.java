package jedistest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import liang.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:SpringConfig/applicationContext.xml" })
public class jedisOne {
	// 操作redis客户端
	private static ShardedJedis jedis;
	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate<Serializable, Serializable> redisTemplate;
	@Autowired
	@Qualifier("shardedJedisPool")
	private ShardedJedisPool sharedPool;

	@Test
	public void jedisTest() {
		final User user1 = new User();
		user1.setId(1);
		user1.setPassword("lwl130kobe");
		user1.setUserName("kokokobe");
		final User user2=new User();
		final User user3=new User();
		user2.setUserName("wenliang");
		user2.setPassword("jsljdof");
		user3.setUserName("中文测试");
		user3.setPassword("lwl13sdf2k");
		//list机构的redis存储
		List<User> listUser=new ArrayList<User>();
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);
		
		jedis = sharedPool.getResource();
		jedis.set("liang", "234235");
		System.out.println(jedis.exists("liang"));
		System.out.println(jedis.del("liang"));
		jedis.sadd("setLiang", "jedis");
		// String 字符串的值减一
		System.out.println(jedis.decr("liang"));
		jedis.hset("key", "field", "value");
		// 返回hash表中所有域的值
		System.out.println(jedis.hvals("key"));
		HashOperations<?, Object, Object> HashOperation = redisTemplate
				.opsForHash();
		ListOperations<?, ?> ListOperation = redisTemplate.opsForList();
		SetOperations<?, ?> SetOperation = redisTemplate.opsForSet();
		ZSetOperations<?, ?> ZSetOperation = redisTemplate.opsForZSet();
		// ValueOperations<String,byte[]> valueops=redisTemplate.opsForValue();
		// JacksonJsonRedisSerializer serializer=new
		// JacksonJsonRedisSerializer<User>(User.class);
		setCache(user1);
		//deleteCache(user.getUserName());
		User cacheUser=getCacheValue(user1.getUserName());
		System.out.println(cacheUser.getUserName());
		//这是一个list
		jedis.lpush("你好", "臻甜");
		jedis.lpush("你好", "文华");
		jedis.lpush("你好", "桂明");
		//索引查询
		System.out.println(jedis.lindex("你好", 0));
		System.out.println(jedis.lindex("你好", 1));
		System.out.println(jedis.lindex("你好", 2));
		//堆栈弹出
		System.out.println(jedis.lpop("你好"));
		System.out.println(jedis.lpop("你好"));
		System.out.println(jedis.lpop("你好"));
		
	}
	/**
	 * 
	* @Title: jedisHash
	* @Description: TODO(redis Hash操作)
	* @return 返回类型  void    
	 */
	@Test
	public void jedisHash(){
		jedis = sharedPool.getResource();
		jedis.hset("person", "name","wenliang");
		jedis.hset("person", "age","18");
		jedis.hset("person", "sex","male");
		jedis.hincrBy("person", "height", 180);
		//获取key中所有域对应的value
		System.out.println(jedis.hgetAll("person"));
		System.out.println(jedis.hget("person","name"));
		//返回对应key中域的数量
		System.out.println(jedis.hlen("person"));
		//返回获取field的所有value值
		System.out.println(jedis.hvals("person"));
		//是否存在
		System.out.println(jedis.hexists("person","name"));
		//删除指定key和field是的值
		//jedis.hdel("person", "age");
		System.out.println(redisTemplate.opsForHash().get("person", "age"));
		//redisTemplate 的方式
		redisTemplate.opsForHash().put("person", "weight", "60KG");
		Map<String, String> map=new HashMap<String,String>();
		map.put("lover","babies");
		redisTemplate.opsForHash().putAll("person", map);
		System.out.println(jedis.hvals("person"));
	}
	@Test
	public void jedisSet(){
		redisTemplate.opsForSet().add("setKey1","1");
		redisTemplate.opsForSet().add("setKey1","setKey1");
		redisTemplate.opsForSet().add("setKey2","2");
		redisTemplate.opsForSet().add("setKey3","3");
		redisTemplate.opsForSet().add("setKey4","4");
		//获取对应KEY 的值
		System.out.println(redisTemplate.opsForSet().members("setKey1"));
		redisTemplate.opsForSet().pop("setKey4");
		System.out.println(redisTemplate.opsForSet().size("setKey4"));
	}
	@Test
	public void jedisZSet(){
		redisTemplate.opsForZSet().add("ZSet1","1", 1);
		redisTemplate.opsForZSet().add("ZSet1","2", 2);
		redisTemplate.opsForZSet().add("ZSet1","3", 3);
		redisTemplate.opsForZSet().add("ZSet1","4", 4);
		redisTemplate.opsForZSet().add("ZSet1","5", 5);
		redisTemplate.opsForZSet().add("ZSet2","2", 1);
		//输出对应可以的值按照score的值范围,从0开始计算
		System.out.println(redisTemplate.opsForZSet().range("ZSet2", 0, 0));
	}
	private void setCache(final User user) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(
						redisTemplate.getStringSerializer().serialize(
								user.getUserName()),
						redisTemplate.getStringSerializer().serialize(
								user.getPassword()));
				return null;
			}
		});
	}

	private User getCacheValue(final String userName) {
		return redisTemplate.execute(new RedisCallback<User>() {
			@Override
			public User doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key = redisTemplate.getStringSerializer().serialize(
						userName);
				if (connection.exists(key)) {
					byte[] value = connection.get(key);
					String password = redisTemplate.getStringSerializer()
							.deserialize(value);
					User user = new User();
					user.setPassword(password);
					user.setUserName(userName);
					return user;
				}
				return null;
			}
		});
	}

	private void deleteCache(final String userName) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) {
				connection.del(redisTemplate.getStringSerializer().serialize( userName));
				return null;
			}
		});
	}
}
