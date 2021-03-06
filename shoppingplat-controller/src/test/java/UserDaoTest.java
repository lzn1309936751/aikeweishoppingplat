import com.config.ServiceConfig;
import com.dao.fe.FatherCateDao;
import com.entity.fe.FatherCateEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class UserDaoTest {
    @Autowired
    private FatherCateDao fatherCateDao;
    @Test
    public void userDaoTest(){
        List<FatherCateEntity> lists = fatherCateDao.getAll();
        for (FatherCateEntity list : lists) {
            System.out.println(list);
        }
    }
}
