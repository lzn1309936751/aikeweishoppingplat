package com.dao.fe;

import com.entity.fe.AddressEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface AddressDao {
    List<AddressEntity> getProvince(@Param("province") String parent_id);

    List<AddressEntity> getCity(@Param("city") String parent_id);

    List<AddressEntity> getCount(@Param("count")String parent_id);

    AddressEntity getAddressName(@Param("address_id") String address_id);

}
