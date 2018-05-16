//package com.holddie.springboot.freemarker.config;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.cluster.node.DiscoveryNode;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//public class EsClientConfig {
//
//    @Value("${elasticsearch.cluster.name:''}")
//    private String clusterName;
//
//    @Value("${elasticsearch.esNodes:''}")
//    private String nodeIpInfo;
//
//    @Bean
//    Client esClient() {
//        // 设置集群的名字
//        Settings settings = Settings.builder()
//                .put("cluster.name", clusterName).build();
//        TransportClient client = new PreBuiltTransportClient(settings);
//        Map<String, Integer> nodeMap = parseNodeIpInfo();
//        for (Map.Entry<String, Integer> entry : nodeMap.entrySet()) {
//            try {
//                client.addTransportAddress(
//                        new InetSocketTransportAddress(InetAddress.getByName(entry.getKey()), entry.getValue()));
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//        }
//        List<DiscoveryNode> list = client.connectedNodes();
//        for (DiscoveryNode node : list) {
//            System.out.println(node.getName());
//        }
//        return client;
//    }
//
//    /**
//     * 解析节点IP信息,多个节点用逗号隔开,IP和端口用冒号隔开
//     * @return
//     */
//    private Map<String, Integer> parseNodeIpInfo() {
//        String[] nodeIpInfoArr = nodeIpInfo.split(",");
//        Map<String, Integer> map = new HashMap<String, Integer>(nodeIpInfoArr.length);
//        for (String ipInfo : nodeIpInfoArr) {
//            String[] ipInfoArr = ipInfo.split(":");
//            map.put(ipInfoArr[0], Integer.parseInt(ipInfoArr[1]));
//        }
//        return map;
//    }
//}