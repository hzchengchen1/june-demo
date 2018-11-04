package com.june.demo.zookeeper;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * zookeeper client
 *
 * @author think
 */
public class ZookeeperClient {

    private static ZooKeeper zk = null;

    /**
     * kaola dubbo zk测试环境配置
     */
    private static final String KL_URL = "kaola-test-dubbozk01.v1.kaola.jdb.vpc:2181";

    /**
     * 本地zk服务
     */
    private static final String URL = "127.0.0.1:2181";

    public static ZooKeeper getInstance() {
        synchronized (ZookeeperClient.class) {
            if (zk == null) {
                try {
                    zk = new ZooKeeper(URL, 2000, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return zk;
    }
}
