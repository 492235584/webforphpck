package xie.shu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xie.shu.po.History;
import xie.shu.po.HistoryExample;

public interface HistoryMapper {
    int countByExample(HistoryExample example);

    int deleteByExample(HistoryExample example);

    int insert(History record);

    int insertSelective(History record);

    List<History> selectByExample(HistoryExample example);
    
    List<History> selectbylimitnum(int num);

    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);
}