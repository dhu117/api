package com.dhu.gene;

import com.dhu.api.model.ApiConfig;
import com.dhu.gene.ApiConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    long countByExample(ApiConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int deleteByExample(ApiConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int insert(ApiConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int insertSelective(ApiConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    List<ApiConfig> selectByExampleWithBLOBs(ApiConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    List<ApiConfig> selectByExample(ApiConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    ApiConfig selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int updateByExampleSelective(@Param("record") ApiConfig record, @Param("example") ApiConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") ApiConfig record, @Param("example") ApiConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int updateByExample(@Param("record") ApiConfig record, @Param("example") ApiConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int updateByPrimaryKeySelective(ApiConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(ApiConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_api_config
     *
     * @mbg.generated Mon Oct 03 21:48:46 CST 2016
     */
    int updateByPrimaryKey(ApiConfig record);
}