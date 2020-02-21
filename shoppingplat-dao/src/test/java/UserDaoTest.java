import com.config.DaoConfig;
import com.dao.fe.CouponDao;
import com.dao.fe.FatherCateDao;
import com.entity.fe.CouponEntity;
import com.entity.fe.FatherCateEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class UserDaoTest {
    @Autowired
    private FatherCateDao fatherCateDao;

    @Autowired
    private CouponDao couponDao;

    @Test
    public void couponDaoTest(){
        CouponEntity getCouponName=couponDao.getByMoney(1002);
    }

    @Test
    public void userDaoTest(){
        List<FatherCateEntity> lists = fatherCateDao.getAll();
        for (FatherCateEntity list : lists) {
            System.out.println(list);
        }
    }
}
