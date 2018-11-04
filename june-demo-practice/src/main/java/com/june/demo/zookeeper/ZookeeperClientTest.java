package com.june.demo.zookeeper;

import com.june.demo.constant.ZookeeperConstant;
import com.june.demo.util.CmdUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * zk 基本
 * <P>reference dubbo注册相关知识：dubbo-registry，ZkAutoRegisterBean, curator
 *
 * @author think
 */
public class ZookeeperClientTest {

    private static final String PATH = "/kl-tomcat/kaola-mykaola-web";

    private static final String LOCAL_PATH = "/";

    /**
     * 应用分组
     */
    private static final String APPLICATION_GROUP = "zktest";

    /**
     * zk client基本操作：获取/打印节点信息
     * <ol>
     * zkClient获取zk节点信息，以dubbo注册为例
     * <li>查看dubbo.properties文件中的zookeeper配置，获取ip:port，eg.kaola-test-dubbozk01.v1.kaola.jdb.vpc:2181</li>
     * <li>cmd上输入指令:<h4>zkCli -server kaola-test-dubbozk01.v1.kaola.jdb.vpc:2181</h4></li>
     * <li>查看节点信息：get / (tab键查看目录信息)</li>
     * <li>查看节点具体信息</li>
     * </ol>
     * <p>返回信息如下, get /kl-tomcat/kaola-mykaola-web/10.177.9.230:9204#31d936e8-2fd2-4b40-b06f-7fb2c677714b
     * <pre>
     *  获取信息
     *      {
     *          "id":"10.177.9.230:9204#31d936e8-2fd2-4b40-b06f-7fb2c677714b",
     *          "name":"kaola-mykaola-web","host":"10.177.9.230","port":9204,"secure":false,
     *          "metadata":{"idc":"hz","pid":"83749","env":"user_test19jd"},
     *          "timestamp":1540964631367
     *      }
     *      cZxid = 0x105ec5cc8
     *      ctime = Wed Oct 31 13:43:51 CST 2018
     *      mZxid = 0x105ec5cc8
     *      mtime = Wed Oct 31 13:43:51 CST 2018
     *      pZxid = 0x105ec5cc8
     *      cversion = 0
     *      dataVersion = 0
     *      aclVersion = 0
     *      ephemeralOwner = 0xb64abad8cf35c10
     *      dataLength = 225
     *      numChildren = 0
     * </pre>
     */
    public static void printChildren() throws KeeperException, InterruptedException {
        ZooKeeper zk = ZookeeperClient.getInstance();
        List<String> childrenNames = zk.getChildren(LOCAL_PATH, false);
        for (int i = 0; i < childrenNames.size(); i++) {
            System.out.println("name:" + childrenNames.get(i));
            byte[] childrenByte = new byte[0];
            try {
                childrenByte = zk.getData("/" + childrenNames.get(i), false, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = new String(childrenByte);
            System.out.println(str);
        }
    }

    /**
     * zk curator 基本操作：create(), setData(), delete()
     */
    public static void curatorTest() throws Exception {
        try {
            CuratorFramework client = CuratorFrameworkFactory.newClient(
                    ZookeeperConstant.ZK_SERVER,
                    new RetryNTimes(10, 5000));
            client.start();
            CmdUtil.printCmd("create", LOCAL_PATH + APPLICATION_GROUP, "hello");
            // zk create
            client.create().creatingParentsIfNeeded().forPath(LOCAL_PATH + APPLICATION_GROUP, "hello".getBytes());
            // 打印操作结果
            printResult(client);
            // 修改数据
            client.setData().forPath(LOCAL_PATH + APPLICATION_GROUP, "world".getBytes());
            printResult(client);
            // 删除
            client.delete().forPath(LOCAL_PATH + APPLICATION_GROUP);
            printResult(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printResult(CuratorFramework client) throws Exception {
        CmdUtil.printResult(client.getChildren().forPath(LOCAL_PATH));
        CmdUtil.printResult(client.getData().forPath(LOCAL_PATH + APPLICATION_GROUP));
    }

    public static void main(String[] args) throws Exception {
        curatorTest();

        // 打印节点信息
        printChildren();

    }
}
