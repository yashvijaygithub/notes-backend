package login.dao;

import login.model.LoginDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by vijay on 28/9/17.
 */
@Transactional
public interface LoginDetailsDao extends MongoRepository<LoginDetails,Long> {

    LoginDetails findByUserName(String userName);

}
