package login.dao;

import login.model.LoginDetails;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

/**
 * Created by vijay on 28/9/17.
 */
@Transactional
public interface LoginDetailsDao extends CrudRepository<LoginDetails,Long>{

    LoginDetails findByUserName(String userName);

}
