package com.solphire.echart.demo.service;

import com.solphire.echart.demo.util.PrestoConnection;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by junhongchen on 2019/6/30.
 */

@Service
public class PrestoQueryService {
    static Logger LOG = Logger.getLogger(PrestoQueryService.class);
    private static String QUERY_FORMAT = "select ds,count(1) as cnt from test.nginx_log_test where ds>20190601 group by ds order by ds";
    private PrestoConnection prestoConnect = PrestoConnection.getConnection();


    public Map<String, Object> getQueryRet() {
        LOG.info("-- start getQueryRet --");
//        String sql = String.format(QUERY_FORMAT, routeId, fromDate, toDate, advertiserId);
        try {
            Map<String, Object> retMap = new LinkedHashMap<>();
            List<String> dsList = new LinkedList<>();
            List<Integer> cntList = new LinkedList<>();
            long start = System.currentTimeMillis();
            Connection sqlConn = prestoConnect.getSqlConn();
            Statement statement = sqlConn.createStatement();
            ResultSet rs = statement.executeQuery(QUERY_FORMAT);
            LOG.info("sql=\n" + QUERY_FORMAT);
            while (rs.next()) {
                dsList.add(rs.getString("ds"));
                cntList.add(rs.getInt("cnt"));
            }
            retMap.put("dsList", dsList);
            retMap.put("cntList", cntList);
            System.out.println("Presto查詢数据集大小：" + dsList.size() + "");
            System.out.println("Presto查詢耗時：" + (System.currentTimeMillis() - start) / 1000 + " s");
            return retMap;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
